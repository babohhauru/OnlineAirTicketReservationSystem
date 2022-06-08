package com.works.web;

import com.works.domain.Flight;
import com.works.mapper.FlightMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {

    @Autowired
    private FlightMapper flightMapper;

    /**
     * http://localhost:8080/
     */
    @GetMapping("/")
    public String loginPage(Model model){
        model.addAttribute("flightList", flightMapper.findAll());
        return "default/index";
    }

    @GetMapping("/buy/{id}")
    public String buyId(@PathVariable("id") Integer id, Model model){
        Flight flight = flightMapper.findAllById(id);

        model.addAttribute("flight",flight);
        return "default/showFlight";
    }
}
