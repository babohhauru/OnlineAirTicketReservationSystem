package com.works.web.admin;

import com.works.domain.Flight;
import com.works.mapper.FlightMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminFlightController {

    @Autowired
    private FlightMapper flightMapper;

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

        flightMapper.saveFlight(flight);
        model.addAttribute("flight_list", flightMapper.findAll());
        return "admin/flight_list";
    }

    @GetMapping("/flights")
    public String FlightList(Model model){
        model.addAttribute("flight_list", flightMapper.findAll());
        return "admin/flight_list";
    }

    @GetMapping("/deleteFlight/{id}")
    public String deleteFlight(@PathVariable("id") Integer Id, Model model){
        flightMapper.deleteFlight(Id);
        model.addAttribute("flight_list", flightMapper.findAll());
        return "admin/flight_list";
    }
}
