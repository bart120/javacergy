package com.cergy.javaav.controllers;

import com.cergy.javaav.Services.UserDao;
import com.cergy.javaav.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UserDao userDao;

    //@GetMapping("")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model){
        List<User> list = userDao.listAll();
        model.addAttribute("users", list);
        return "users/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model){
        model.addAttribute("userForm", new User());
        return "users/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addPost(Model model, @ModelAttribute("userForm") User user){
        if (user.getFirstname() != null && user.getFirstname().length() > 0 //
                && user.getLastname() != null &&  user.getLastname().length() > 0) {
            userDao.add(user);
            return "redirect:/users";
        }
        model.addAttribute("errorMessage", "Nom et prénom obligatoire");
        return "users/add";
    }


}
