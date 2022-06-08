package com.works.controller.admin;

import com.works.domain.Admin;
import com.works.dao.AdminDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminLoginController {

    @Autowired
    private AdminDao adminDAO;

    @GetMapping
    public String loginPage(){
        return "admin/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String adminUsrName,
                        @RequestParam String password,
                        HttpSession session, RedirectAttributes attributes){
        Admin admin = adminDAO.FindAdminByName(adminUsrName);
        if(admin == null){
            attributes.addFlashAttribute("message","管理员不存在");
            return "redirect:/admin";
        }
        else if(admin.getPassword().equals(password)){
            session.setAttribute("loginAdmin",adminUsrName);
            return "admin/frame";
        }
        else{
            attributes.addFlashAttribute("message","用户名或密码不正确");
            return "redirect:/admin";
        }
    }
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("loginAdmin");
        return "redirect:/";
    }

    @GetMapping("/welcome")
    public String welcome(){
        return "admin/welcome";
    }

}
