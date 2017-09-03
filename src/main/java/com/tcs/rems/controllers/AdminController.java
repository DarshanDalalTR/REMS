package com.tcs.rems.controllers;

import com.tcs.rems.DAO.DAO;
import com.tcs.rems.DAO.SolarPlantDAO;
import com.tcs.rems.DAO.UserCredentialsDAO;
import com.tcs.rems.DAO.WindPlantDAO;
import com.tcs.rems.models.SolarPlantWithState;
import com.tcs.rems.models.UserCredentials;
import com.tcs.rems.models.WindPlantWithState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@SessionAttributes("userDetails")
@CrossOrigin
public class AdminController {

    private final ApplicationContext context;

    @Autowired
    public AdminController(ApplicationContext context) {
        this.context = context;
    }

    @RequestMapping(value = "/admin/")
    public String displayAdminPanel() {
        return "Admin";
    }

    @RequestMapping(value = "/admin/plant/solar/add/", method = RequestMethod.POST)
    public String addSolarPlant(@ModelAttribute("plant") SolarPlantWithState plant) {
        SolarPlantDAO dao = (SolarPlantDAO) context.getBean("solarplantdao");
        boolean status = dao.addSolarPlant(plant);
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("plant", plant);
//        mav.setViewName("AddSolarPlant");
//        if (status) {
//            mav.addObject("Status", "Solar Plant Successfully added");
//        }
//        return mav;
        return "redirect:../";
    }

    @RequestMapping(value = "/admin/plant/solar/{id}/edit/", method = RequestMethod.GET)
    public ModelAndView renderEditSolarPlant(@PathVariable("id") int id) {
        SolarPlantDAO dao = (SolarPlantDAO) context.getBean("solarplantdao");
        DAO dao2 = (DAO) context.getBean("edao");
        List<SolarPlantWithState> plants = dao.getPlantById(id);
        SolarPlantWithState plant = plants.get(0);
        ModelAndView mav = new ModelAndView();
        mav.addObject("plant", plant);
        mav.addObject("states", dao2.getAllStates());
        mav.setViewName("EditSolarPlant");
        return mav;
    }

    @RequestMapping(value = "/admin/plant/solar/{plantid}/edit/", method = RequestMethod.POST)
    public String editSolarPlant(@ModelAttribute("plant") SolarPlantWithState plant, @PathVariable("plantid") int plantid) {
        SolarPlantDAO dao = (SolarPlantDAO) context.getBean("solarplantdao");
        int status = dao.editSolarPlant(plantid, plant);
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("EditSolarPlant");
//        if (status > 0) {
//            mav.addObject("status", "Successfullly edited");
//        }
//        return mav;
        return "redirect:../../";
    }

    @RequestMapping(value = "/admin/plant/solar/{id}/delete/")
    public String deleteSolarPlant(@PathVariable("id") int id) {
        SolarPlantDAO dao = (SolarPlantDAO) context.getBean("solarplantdao");
        int status = dao.deletePlant(id);
//        ModelAndView mav=new ModelAndView();
//        mav.setViewName("map");
//        if(status>0)
//        {
//           mav.addObject("plantdelstat","Plant deleted");
//        }
//        return mav;
        return "redirect:../../";
    }

    @RequestMapping(value = "/admin/plant/solar/", method = RequestMethod.GET)
    public ModelAndView solarPlantManagedByAdmin() {
        SolarPlantDAO dao = (SolarPlantDAO) context.getBean("solarplantdao");
        DAO dao2 = (DAO) context.getBean("edao");
        List<SolarPlantWithState> plants = dao.viewPlants();
        ModelAndView mav = new ModelAndView();
        mav.addObject("plants", plants);
        mav.addObject("plant", new SolarPlantWithState());
        mav.addObject("states", dao2.getAllStates());
        mav.setViewName("SolarPlantManagement");
        return mav;
    }
    //End of Solar Plant CRUD

    //Begin WindPlant CRUD
//    @RequestMapping(value = "/admin/plant/wind/add/", method = RequestMethod.GET)
//    public ModelAndView renderAddWindPlant() {
//        return new ModelAndView("AddWindPlant", "windplant", new WindPlantWithState());
//    }

    @RequestMapping(value = "/admin/plant/wind/add/", method = RequestMethod.POST)
    public String AddWindPlant(@ModelAttribute("windplant") WindPlantWithState windPlant) {
        WindPlantDAO dao = (WindPlantDAO) context.getBean("windplantdao");
        Boolean windstat = dao.addWindPlant(windPlant);
//        ModelAndView mav=new ModelAndView();
//        mav.setViewName("AddWindPlant");
//        if(windstat)
//        {
//            mav.addObject("windstatus","Wind Plant added successfully");
//        }
//        return mav;
        return "redirect:../";
    }

    @RequestMapping(value = "/admin/plant/wind/{plantid}/edit/", method = RequestMethod.GET)
    public ModelAndView renderEditWindPlant(@PathVariable("plantid") int id) {
        WindPlantDAO dao = (WindPlantDAO) context.getBean("windplantdao");
        DAO dao2 = (DAO) context.getBean("edao");
        List<WindPlantWithState> plants = dao.getPlantById(id);
        WindPlantWithState plant = plants.get(0);
        ModelAndView mav = new ModelAndView();
        mav.addObject("windplant", plant);
        mav.addObject("states", dao2.getAllStates());
        mav.setViewName("EditWindPlant");
        return mav;
    }

    @RequestMapping(value = "/admin/plant/wind/{plantid}/edit/", method = RequestMethod.POST)
    public String editWindPlant(@ModelAttribute("windplant") WindPlantWithState windPlant, @PathVariable("plantid") int id) {
        WindPlantDAO dao = (WindPlantDAO) context.getBean("windplantdao");
        int windeditstatus = dao.editWindPlant(id, windPlant);
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("windplant", windPlant);
//        mav.setViewName("EditWindPlant");
//        return mav;
        return "redirect:../../";
    }

    @RequestMapping(value = "/admin/plant/wind/{id}/delete/")
    public String deleteWindPlant(@PathVariable("id") int id) {
        WindPlantDAO dao = (WindPlantDAO) context.getBean("windplantdao");
        int status = dao.deletePlant(id);
//        ModelAndView mav=new ModelAndView();
//        mav.setViewName("map");
//        i1f(status>0)
//        {
//            mav.addObject("plantdelstat","Wind Plant deleted");
//        }
//        return mav;
        return "redirect:../../";
    }

    @RequestMapping(value = "/admin/plant/wind/", method = RequestMethod.GET)
    public ModelAndView windPlantsManagedNyAdmin() {
        WindPlantDAO dao = (WindPlantDAO) context.getBean("windplantdao");
        DAO dao2 = (DAO) context.getBean("edao");
        List<WindPlantWithState> plants = dao.viewPlants();
        ModelAndView mav = new ModelAndView();
        mav.addObject("plants", plants);
        mav.addObject("windplant", new WindPlantWithState());
        mav.addObject("states", dao2.getAllStates());
        mav.setViewName("WindPlantManagement");
        return mav;
    }

    //End of Wind Plant CRUD
    @RequestMapping(value = "/admin/user/add/", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") UserCredentials user) {
        UserCredentialsDAO dao = (UserCredentialsDAO) context.getBean("userdao");
        boolean status = dao.addUser(user);
//        ModelAndView mav=new ModelAndView();
//        mav.addObject("user",user);
//        mav.setViewName("UserManagement");
//        if(status)
//        {
//            mav.addObject("Status","User Successfully added");
//        }
//        return mav;
        return "redirect:../";
    }

    @RequestMapping(value = "/admin/user/{id}/edit/", method = RequestMethod.GET)
    public ModelAndView renderEditUser(@PathVariable("id") int id) {
        UserCredentialsDAO dao = (UserCredentialsDAO) context.getBean("userdao");
        List<UserCredentials> users = dao.getUserById(id);
        UserCredentials user = users.get(0);
        ModelAndView mav = new ModelAndView();
        mav.addObject("user", user);
        mav.setViewName("EditUser");
        return mav;
    }

    @RequestMapping(value = "/admin/user/{userid}/edit/", method = RequestMethod.POST)
    public String editUser(@PathVariable("userid") int userid, @ModelAttribute("user") UserCredentials user) {
        UserCredentialsDAO dao = (UserCredentialsDAO) context.getBean("userdao");
        user.setName(user.getName());
        user.setEmail(user.getEmail());
        user.setRole(user.getRole());
        int status = dao.editUser(userid, user);
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("OLD_EditUser");
//        if (status > 0) {
//            mav.addObject("status", "Successfullly edited");
//        }
//        return mav;
        return "redirect:../../";
    }

    @RequestMapping(value = "/admin/user/", method = RequestMethod.GET)
    public ModelAndView usersManagedByAdmin() {
        UserCredentialsDAO dao = (UserCredentialsDAO) context.getBean("userdao");
        List<UserCredentials> users = dao.viewUsers();
        UserCredentials userCredentials = new UserCredentials();
        ModelAndView mav = new ModelAndView();
        mav.addObject("user", userCredentials);
        mav.addObject("users", users);
        mav.setViewName("UserManagement");
        return mav;
    }

    @RequestMapping(value = "/admin/user/{id}/delete/", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("id") int id) {
        UserCredentialsDAO dao = (UserCredentialsDAO) context.getBean("userdao");
        int status = dao.deleteUser(id);
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("ViewUser");
//        if (status > 0) {
//            mav.addObject("stat", "Successfully deleted");
//        }
        return "redirect:../../";
    }
    //End of User CRUD
}
