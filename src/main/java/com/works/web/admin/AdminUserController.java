package com.works.web.admin;

import com.works.mapper.UserMapper;
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
    private UserMapper userMapper;

    @GetMapping("/users")
    public String UserList(Model model){
        model.addAttribute("user_list", userMapper.findAll());
        return "admin/user_list";
    }

    @PostMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") Integer Id,Model model){
        int i = userMapper.deleteUserById(Id);
        model.addAttribute("user_list", userMapper.findAll());
        return "admin/user_list";
    }

}
