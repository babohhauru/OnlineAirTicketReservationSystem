package com.works.web.admin;

import com.works.domain.Flight;
import com.works.domain.Order;
import com.works.mapper.FlightMapper;
import com.works.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminOrderController {

    @Autowired
    private FlightMapper flightMapper;

    @Autowired
    private OrderMapper orderMapper;


    @GetMapping("/orders")
    public String OrderList(Model model){
        model.addAttribute("order_list", orderMapper.findAll());
        return "admin/order_list";
    }

    @GetMapping("/deleteOrder/{id}")
    public String deleteOrder(@PathVariable("id") Integer Id, Model model){
        Order byUserOrderId = orderMapper.findByUserOrderId(Id);
        String flightClass = byUserOrderId.getFlightClass();
        Flight flight = flightMapper.findAllByFlightNum(byUserOrderId.getFlightNum());

        if(flightClass.equals("头等舱")){
            flight.setFirstClassNum(flight.getFirstClassNum()+1);
        }
        else if(flightClass.equals("商务舱")){
            flight.setBusinessClassNum(flight.getBusinessClassNum()+1);
        }
        else{
            flight.setEconomyClassNum(flight.getEconomyClassNum()+1);
        }
        flightMapper.updateByFlightClass(flight);
        orderMapper.deleteOrder(Id);
        model.addAttribute("order_list", orderMapper.findAll());
        return "admin/order_list";
    }
}
