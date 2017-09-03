package com.tcs.rems.controllers;

import com.tcs.rems.DAO.DAO;
import com.tcs.rems.DAO.SolarPlantDAO;
import com.tcs.rems.DAO.WindPlantDAO;
import com.tcs.rems.DAO.WindTurbineDAO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tcs.rems.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("userDetails")
@CrossOrigin
public class PlantController {

    private final ApplicationContext context;

    @Autowired
    public PlantController(ApplicationContext context) {
        this.context = context;
    }

    @RequestMapping(value = "/plant/solar/{id}/addPanel/", method = RequestMethod.GET)
    public ModelAndView displayAddPanel() {
        return new ModelAndView("AddSolarPanel", "panel", new SolarPlate());
    }

    @RequestMapping(value = "/plant/solar/{id}/addPanel/", method = RequestMethod.POST)
    public String addPanel(@ModelAttribute("panel") SolarPlate plate, @PathVariable("id") int id) {
        DAO dao = (DAO) context.getBean("edao");
        plate.setPlant_id(id);
        boolean status = dao.addSolarPlate(plate);
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("plate", plate);
//        mav.setViewName("AddSolarPanel");
//        if (status) {
//            mav.addObject("Status", "Solar Panel Successfully added");
//        }
        return "redirect:../";
    }

    @RequestMapping(value = "/plant/solar/{pid}/editPanel/{id}/", method = RequestMethod.GET)
    public ModelAndView displayEditPanel(@PathVariable("id") int id, @PathVariable("pid") int pid) {
        DAO dao = (DAO) context.getBean("edao");
        List<SolarPlate> plates = dao.getPlateByPlateId(id);
        SolarPlate plate = plates.get(0);
        ModelAndView mav = new ModelAndView();
        mav.addObject("panel", plate);
        mav.setViewName("AddSolarPanel");
        return mav;
    }

    @RequestMapping(value = "/plant/solar/{pid}/editPanel/{plateid}/", method = RequestMethod.POST)
    public String editPanel(@ModelAttribute("plate") SolarPlate plate, @PathVariable("plateid") int plateid, @PathVariable("pid") int pid) {
        DAO dao = (DAO) context.getBean("edao");
        plate.setPlate_name(plate.getPlate_name());
        plate.setPlate_area(plate.getPlate_area());
        plate.setPlate_efficiency(plate.getPlate_efficiency());
        plate.setPlate_perf_ratio(plate.getPlate_perf_ratio());
        plate.setQty(plate.getQty());
        int status = dao.editSolarPlate(plateid, plate);
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("EditSolarPlate");
//        if (status > 0) {
//            mav.addObject("status", "Successfullly edited");
//        }
        return "redirect:../../";
    }

//    @RequestMapping(value = "/viewPlates", method = RequestMethod.GET)
//    public ModelAndView viewSolarPlates() {
//        DAO dao = (DAO) context.getBean("edao");
//        List<SolarPlate> plates = dao.viewPlates();
//        return new ModelAndView("SolarPlates", "plates", plates);
//    }

    @RequestMapping(value = "/plant/solar/{pid}/deletePlate/{id}/")
    public String deletePanel(@PathVariable("id") int id, @PathVariable("pid") int pid) {
        DAO dao = (DAO) context.getBean("edao");
        int status = dao.deletePlate(id);
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("map");
//        if (status > 0) {
//            mav.addObject("stat", "Successfully deleted");
//        }
//        return mav;
        return "redirect:../../";
    }
    //End of Solar Plate CRUD

    @RequestMapping(value = "/plant/wind/{id}/addTurbine/", method = RequestMethod.GET)
    public ModelAndView renderWindTurbine(@PathVariable("id") int id) {
        return new ModelAndView("AddWindTurbine", "turbine", new WindTurbine());
    }

    @RequestMapping(value = "/plant/wind/{id}/addTurbine/", method = RequestMethod.POST)
    public String AddWindTurbine(@ModelAttribute("turbine") WindTurbine turbine, @PathVariable("id") int id) {
        WindTurbineDAO dao = (WindTurbineDAO) context.getBean("windTurbinedao");
        turbine.setPlant_id(id);
        boolean status = dao.addWindTurbine(turbine);
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("turbine",turbine);
//        mav.setViewName("AddWindTurbine");
//        if (status) {
//            mav.addObject("TurbineStatus", "Wind Turbine Successfully added");
//        }
        return "redirect:../";
    }

    @RequestMapping(value = "/plant/wind/{id}/editTurbine/{id}/", method = RequestMethod.GET)
    public ModelAndView renderEditWindTurbine(@PathVariable("id") int id) {
        WindTurbineDAO dao = (WindTurbineDAO) context.getBean("windTurbinedao");
        List<WindTurbine> turbines = dao.getTurbineById(id);
        WindTurbine turbine = turbines.get(0);
        ModelAndView mav = new ModelAndView();
        mav.addObject("turbine", turbine);
        mav.setViewName("AddWindTurbine");
        return mav;
    }

    @RequestMapping(value = "/plant/wind/{id}/editTurbine/{id}/", method = RequestMethod.POST)
    public String editWindTurbine(@ModelAttribute("turbine") WindTurbine turbine, @PathVariable("id") int id) {
        WindTurbineDAO dao = (WindTurbineDAO) context.getBean("windTurbinedao");
        int status = dao.editWindTurbine(id, turbine);
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("EditWindTurbine");
//        if (status > 0) {
//            mav.addObject("status", "Successfullly edited");
//        }
//        return mav;
        return "redirect:../../";
    }

    /*
    @RequestMapping(value = "/viewTurbines", method = RequestMethod.GET)
    public ModelAndView viewWindTurbines()
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        WindTurbineDAO dao = (WindTurbineDAO) context.getBean("windTurbinedao");
        List<WindTurbine> turbines = dao.viewTurbines();
        return new ModelAndView("WindTurbines", "turbines",turbines);
    }
    */

    @RequestMapping(value = "/plant/wind/{id}/deleteTurbine/{id}/")
    public String deleteWindTurbine(@PathVariable("id") int id) {
        WindTurbineDAO dao = (WindTurbineDAO) context.getBean("windTurbinedao");
        int status = dao.deleteTurbine(id);
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("map");
//        if (status > 0) {
//            mav.addObject("turbinedelstat", "Successfully deleted");
//        }
//        return mav;
        return "redirect:../../";
    }
    //End of WindTurbine CRUD

    @RequestMapping(value = "/plant/solar/{plantid}/", method = RequestMethod.GET)
    public ModelAndView renderSolarPlantDashBoard(@PathVariable("plantid") int id) {
        DAO dao = (DAO) context.getBean("edao");
        ModelAndView mav = new ModelAndView();
        List<SolarPlate> plates = dao.getPlatesByPlantId(id);
        for (SolarPlate temp : plates) {
            temp.setNotifs((ArrayList<SolarNotification>) dao.getNotifications(temp.getPlate_id()));
        }
        mav.addObject("plates", plates);
        List<SolarPlantWithState> solar_plants_with_state = dao.getPlantDetails(id);
        SolarPlantWithState plant = solar_plants_with_state.get(0);
        double total = 0.0;
        for (SolarPlate p : plates) {
            total += p.getQty() * p.getPlate_area() * p.getPlate_efficiency() * p.getPlate_perf_ratio();
        }
        total *= plant.getAvg_radiation() / 1000000;
        mav.addObject("plant", plant);
        mav.addObject("type", "Solar");
        mav.addObject("plant_id", id);
        mav.addObject("total_energy", total);
        mav.setViewName("solarplantdashboard");
        return mav;
    }

    @RequestMapping(value = "/plant/solar/{plantId}/chart/")
    public ModelAndView displaySolarPlantChart(@PathVariable("plantId") int plantId) throws JsonProcessingException {
        ModelAndView mav = new ModelAndView();
        SolarPlantDAO dao = (SolarPlantDAO) context.getBean("solarplantdao");
        ObjectMapper m = new ObjectMapper();
        String resultJSON = m.writeValueAsString(dao.getRecentReadings(plantId));
        mav.addObject("readings", resultJSON);
        mav.setViewName("Chart");
        return mav;
    }

    @RequestMapping(value = "/plant/wind/{plantId}/")
    public ModelAndView renderWindPlantDashboard(@PathVariable("plantId") int id) {
        WindTurbineDAO dao = (WindTurbineDAO) context.getBean("windTurbinedao");
        List<WindTurbine> turbines = dao.getTurbinesByPlantId(id);
        WindPlantDAO dao2 = (WindPlantDAO) context.getBean("windplantdao");
        WindPlantWithState plant = dao2.getPlantById(id).get(0);
        double total_energy = 0.0;
        for (WindTurbine wt : turbines) {
            total_energy += wt.getBlade_length() * wt.getPower_coeff() * plant.getAir_density() * wt.getQty();
            wt.setNotif(dao.getNotifications(wt.getTurbine_id()));
        }
        total_energy /= 1000000;
        ModelAndView mav = new ModelAndView();
        mav.addObject("total_energy", total_energy);
        mav.addObject("turbines", turbines);
        mav.addObject("plant", plant);
        mav.addObject("type", "Wind");
        mav.setViewName("windplantdashboard");
        return mav;
    }

    @RequestMapping(value = "/plant/wind/{plantId}/chart/")
    public ModelAndView displayWindPlantChart(@PathVariable("plantId") int plantId) throws JsonProcessingException {
        ModelAndView mav = new ModelAndView();
        WindPlantDAO dao = (WindPlantDAO) context.getBean("windplantdao");
        ObjectMapper m = new ObjectMapper();
        String resultJSON = m.writeValueAsString(dao.getRecentReadings(plantId));
        mav.addObject("readings", resultJSON);
        mav.addObject("plantType", "Solar");
        mav.setViewName("Chart");
        return mav;
    }

}
