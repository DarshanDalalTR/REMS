package com.tcs.rems.controllers;

import com.tcs.rems.DAO.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("userDetails")
@CrossOrigin
public class NotificationController {

    private final ApplicationContext context;

    @Autowired
    public NotificationController(ApplicationContext context) {
        this.context = context;
    }

    @RequestMapping(value = "/notifications/")
    public ModelAndView displayNotification() {
        DAO dao = (DAO) context.getBean("edao");
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Notifications");
        mav.addObject("notifications", dao.getAllNotifications());
        return mav;
    }


}
