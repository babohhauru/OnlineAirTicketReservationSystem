package com.works.controller.user;

import com.works.domain.User;
import com.works.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/user")
public class UserLoginController {

    @Autowired
    private UserDao userDAO;

    @GetMapping
    public String Login(){
        return "user/login";
    }


    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session, RedirectAttributes attributes){
        User user = userDAO.FindUserByUsername(username);
        if(user == null){
            attributes.addFlashAttribute("message","用户不存在");
            return "redirect:/user";
        }
        else if(user.getPassword().equals(password))
        {
            session.setAttribute("username",username);
            return "redirect:/";
        }
        else{
            attributes.addFlashAttribute("message","用户名或密码错误");
            return "redirect:/user";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("username");
        return "redirect:/";
    }
}
