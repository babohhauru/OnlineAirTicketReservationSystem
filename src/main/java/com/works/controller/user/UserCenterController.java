package com.works.controller.user;


import com.works.domain.Flight;
import com.works.domain.Order;
import com.works.dao.FlightDao;
import com.works.dao.OrderDao;
import com.works.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserCenterController {

    @Autowired
    private UserDao userDAO;

    @Autowired
    private OrderDao orderDAO;

    @Autowired
    private FlightDao flightDAO;

    @GetMapping("/UserCenter")
    public String Center(RedirectAttributes attributes, HttpSession session){
        String username = (String) session.getAttribute("username");
        if(username == null){
            attributes.addFlashAttribute("message","无权限访问，请先登录");
            return "redirect:/user";
        }
        else{
            session.setAttribute("user", userDAO.FindUserByUsername(username));
            return "user/user_center";
        }

    }

    @GetMapping("/UserInfo")
    public String Info(RedirectAttributes attributes,HttpSession session){
        String username = (String) session.getAttribute("username");
        if(username == null){
            attributes.addFlashAttribute("message","无权限访问，请先登录");
            return "redirect:/user";
        }
        else{
            return "user/user_info";
        }
    }

    @GetMapping("/getMyTicket")
    public String getMyTicket(HttpSession session, Model model, RedirectAttributes attributes) {
        String username = (String) session.getAttribute("username");
        if(username == null) {
            attributes.addFlashAttribute("message","无权限访问，请先登录");
            return "redirect:/user";
        }
        List<Order> list = orderDAO.findByUserName(username);
        for(int i=0;i<list.size();i++)
        {
            Flight flight = flightDAO.findAllById(list.get(i).getFlightID());
            list.get(i).setDeparture(flight.getDeparture());
            list.get(i).setDestination(flight.getDestination());

        }
        model.addAttribute("userFlightList", list);
        return "user/order_list";
    }

    @PostMapping("/refundTicket/{orderId}")
    public String retundTicket(@PathVariable("orderId") Integer orderId, RedirectAttributes attributes, Model model, HttpSession session){
        String username = (String) session.getAttribute("username");
        if(username == null) {
            attributes.addFlashAttribute("message","无权限访问，请先登录");
            return "redirect:/user";
        }

        Order byUserOrderId = orderDAO.findByUserOrderId(orderId);
        String flightClass = byUserOrderId.getFlightClass();
        Flight flight = flightDAO.findAllByFlightNum(byUserOrderId.getFlightNum());

        if(flightClass.equals("头等舱")){
            flight.setFirstClassNum(flight.getFirstClassNum()+1);
        }
        else if(flightClass.equals("商务舱")){
            flight.setBusinessClassNum(flight.getBusinessClassNum()+1);
        }
        else{
            flight.setEconomyClassNum(flight.getEconomyClassNum()+1);
        }
        flightDAO.updateByflightClass(flight);
        //退票处理
        int i = orderDAO.returnFlight(orderId);

        model.addAttribute("userFlightList", orderDAO.findByUserName(username));
        return "user/order_list";
    }

    @PostMapping("/buyOneTicket")
    public String buyOneTicket(HttpSession session,Model model,RedirectAttributes attributes,
                               String flightID,String date,String grade,
                               String passenger_id,String contact_phone) {

        String username = (String) session.getAttribute("username");
        if(username == null) {
            attributes.addFlashAttribute("message","无权限访问，请先登录");
            return "redirect:/user";
        }


        Flight flight = flightDAO.findAllByFlightNum(flightID);
        Order order = new Order();
        order.setFlightNum(flightID);
        order.setUsername(username);
        order.setUserID(passenger_id);
        order.setOrderDate(date);
        order.setFlightClass(grade);
        order.setPhone(contact_phone);
        order.setFlightID(flight.getFlightID());
        order.setId(userDAO.FindUserByUsername(username).getId());

        if(grade.equals("头等舱")){
            order.setFlightPrice(flight.getFirstClassPrice());
            flight.setFirstClassNum(flight.getFirstClassNum()-1);
        }
        else if(grade.equals("商务舱")){
            order.setFlightPrice(flight.getBusinessClassPrice());
            flight.setBusinessClassNum(flight.getBusinessClassNum()-1);
        }
        else{
            order.setFlightPrice(flight.getEconomyClassPrice());
            flight.setEconomyClassNum(flight.getEconomyClassNum()-1);
        }

        if(orderDAO.saveOrder(order)!=0) {

            flightDAO.updateByflightClass(flight);
            model.addAttribute("flightList", flightDAO.findAll());
            return "redirect:/";
        }
        else {
            return "redirect:/";
        }
    }
}
