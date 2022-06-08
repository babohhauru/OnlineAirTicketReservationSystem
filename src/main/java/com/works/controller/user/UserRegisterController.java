package com.works.controller.user;


import com.works.domain.User;
import com.works.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
public class UserRegisterController {


    @Autowired
    private UserDao userDAO;

    @GetMapping("/register")
    public String Register(){
        return "user/register";
    }

    @PostMapping("/UserRegister")
    public String UserRegister(String username, String password, String phone, String email, RedirectAttributes attributes){
        if(userDAO.FindUserByUsername(username) != null ){
            attributes.addFlashAttribute("message","用户已被注册");
            return "redirect:/user/register";
        }
        if(userDAO.FindUserByPhone(phone) != null ){
            attributes.addFlashAttribute("message","该手机号码已被注册");
            return "redirect:/user/register";
        }
        if(userDAO.FindUserByEmail(email) != null ){
            attributes.addFlashAttribute("message","该邮箱已被注册");
            return "redirect:/user/register";
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setPhone(phone);
        user.setEmail(email);
        userDAO.saveUser(user);
        return "user/login";
    }
}
