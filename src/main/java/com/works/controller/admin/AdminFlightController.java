package com.works.controller.admin;

import com.works.domain.Flight;
import com.works.dao.FlightDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * controller 类，就是控制页面跳转的类，可以理解为：中央处理机，它会接受前端发起的请求，并选择合适的
 *  方法或页面去执行或显示。
 *
 *  @Controller  该注解用于注解类，表示该类是一个Controller类
 * @RequestMapping("/admin") 该注解可以注解类，也可以注解方法
 *      1. 如果注解在类上，表示该中的  @GetMapping或 @PostMapping 后的括号中会加上一个前缀。
 *          例：方法 Flight() 上加了注解 @GetMapping("/flight")，它真正能处理的请求是："/admin/flight"
*       2. 如果注解在方法上，表示该方法能处理前端发起的哪些请求。
 *          @RequestMapping 又可细分为
 *              1）、@GetMapping：处理以Get方式发起的请求，一般请求下，前端的 <a></a> 即：超链接。发起的请求类型是Get类型
 *              2）、@PostMapping：处理以Post方式发起的请求，一般情况下，form表单如果传输的内容比较敏感，就使用Post 方式
 *              发起请求。
 *         @RequestMapping 即可处理 Get方式的请求，也可处理Post方式的请求
 */
@Controller
@RequestMapping("/admin")
public class AdminFlightController {

    @Autowired
    private FlightDao flightDAO;

    @GetMapping("/flight")
    public String Flight(){
        return "admin/flight_add";
    }

    @PostMapping("/AddFlight")
    public String AddFlight(String flightNum, String departure,
                            String destination, String departureTime, String arrivalTime, String firstClassPrice,
                            String businessClassPrice, String economyClassPrice, String firstClassNum, String businessClassNum, String economyClassNum,Model model){
        Integer first_class_num = Integer.valueOf(firstClassNum);
        Integer first_class_price = Integer.valueOf(firstClassPrice);
        Integer business_class_num = Integer.valueOf(businessClassNum);
        Integer business_class_price = Integer.valueOf(businessClassPrice);
        Integer economy_class_num = Integer.valueOf(economyClassNum);
        Integer economy_class_price = Integer.valueOf(economyClassPrice);

        Flight flight = new Flight();
        flight.setFlightNum(flightNum);
        flight.setDeparture(departure);
        flight.setDestination(destination);
        flight.setDepartureTime(departureTime);
        flight.setArrivalTime(arrivalTime);
        flight.setFirstClassPrice(first_class_price);
        flight.setBusinessClassPrice(business_class_price);
        flight.setEconomyClassPrice(economy_class_price);
        flight.setFirstClassNum(first_class_num);
        flight.setBusinessClassNum(business_class_num);
        flight.setEconomyClassNum(economy_class_num);

        flightDAO.saveFlight(flight);
        model.addAttribute("flight_list", flightDAO.findAll());
        return "admin/flight_list";
    }

    /**
     * 管理员点击 “航班信息列表" 发起：/admin/flights 请求，来到该方法
     * 作用：
     *      去数据库中查询出所有航班信息（使用flightMapper.findAll()方法查询），放进Model中去页面展示。
     * 结果：到航班信息列表页面展示当前所有的航班信息，
     *      即：resources-->templates-->admin--->flight_list.html
     * @param model
     * @return
     */
    @GetMapping("/flights")
    public String FlightList(Model model){
        model.addAttribute("flight_list", flightDAO.findAll());
        return "admin/flight_list";
    }

    @GetMapping("/deleteFlight/{id}")
    public String deleteFlight(@PathVariable("id") Integer Id, Model model){
        flightDAO.deleteFlight(Id);
        model.addAttribute("flight_list", flightDAO.findAll());
        return "admin/flight_list";
    }
}
