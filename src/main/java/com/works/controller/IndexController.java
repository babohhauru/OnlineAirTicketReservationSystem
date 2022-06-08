package com.works.controller;

import com.works.domain.Flight;
import com.works.dao.FlightDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {

    @Autowired
    private FlightDao flightDAO;

    /**
     * http://localhost:8080/
     */
    @GetMapping("/")
    public String loginPage(Model model){
        model.addAttribute("flightList", flightDAO.findAll());
        return "default/index";
    }

    @GetMapping("/buy/{id}")
    public String buyId(@PathVariable("id") Integer id, Model model){
        Flight flight = flightDAO.findAllById(id);

        model.addAttribute("flight",flight);
        return "default/showFlight";
    }
}
