package com.works.controller.admin;

import com.works.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminUserController {

    @Autowired
    private UserDao userDAO;

    @GetMapping("/users")
    public String UserList(Model model){
        model.addAttribute("user_list", userDAO.findAll());
        return "admin/user_list";
    }

    @PostMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") Integer Id,Model model){
        int i = userDAO.deleteUserById(Id);
        model.addAttribute("user_list", userDAO.findAll());
        return "admin/user_list";
    }

}
