package com.tcs.rems.controllers;

import com.tcs.rems.DAO.DAO;
import com.tcs.rems.models.UserCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;

@Controller
@SessionAttributes("userDetails")
@CrossOrigin
public class LoginController {

    private final ApplicationContext context;

    @Autowired
    public LoginController(ApplicationContext context) {
        this.context = context;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView displayLoginForm() {
        return new ModelAndView("login-v", "user", new UserCredentials());
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String validateUser(@ModelAttribute("user") UserCredentials user,
                               HttpServletRequest request,
                               Model model) {
        DAO dao = (DAO) context.getBean("edao");
        String error = "Incorrect username or password";

        if (dao.validateUser(user)) {
            model.addAttribute("userDetails", user);
            return "redirect:/map/";
        }
        request.setAttribute("error", error);
        return "login-v";
    }

    @RequestMapping(value = "/logout")
    public String logout(SessionStatus status) {
        status.setComplete();
        return "redirect:/";
    }

}
