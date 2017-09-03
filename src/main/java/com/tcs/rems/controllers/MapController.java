package com.tcs.rems.controllers;

import com.tcs.rems.DAO.DAO;
import com.tcs.rems.DAO.GeneralPlantDAO;
import com.tcs.rems.models.Plants;
import com.tcs.rems.models.Search;
import com.tcs.rems.models.SolarPlant;
import com.tcs.rems.models.State;
import com.tcs.rems.models.WindPlant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@SessionAttributes("userDetails")
@CrossOrigin
public class MapController {

    private final ApplicationContext context;

    @Autowired
    public MapController(ApplicationContext context) {
        this.context = context;
    }

    @CrossOrigin
    @RequestMapping(value = "/map/plant/{type}/", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<State> getStates(@PathVariable("type") String type) {
        DAO dao = (DAO) context.getBean("edao");
        return dao.getStatesByType(type);
    }

    @CrossOrigin
    @RequestMapping(value = "/map/plant/solar/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<SolarPlant> getSolarPlants(@PathVariable("id") int id) {
        DAO dao = (DAO) context.getBean("edao");
        return dao.getSolarPlantByState(id);
    }

    @CrossOrigin
    @RequestMapping(value = "/map/plant/wind/{stateid}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<WindPlant> getWindPlants(@PathVariable("stateid") int id) {
        DAO dao = (DAO) context.getBean("edao");
        return dao.getWindPlantByState(id);
    }

    @CrossOrigin
    @RequestMapping(value = "/map/all/", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Plants> getAllPlants() {
        GeneralPlantDAO dao = (GeneralPlantDAO) context.getBean("generalPlantdao");
        return dao.getAllPlants();
    }

    @RequestMapping(value = "/map/", method = RequestMethod.GET)
    public ModelAndView displayMap() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("search", new Search());
        mav.setViewName("map");
        return mav;
    }


    //search controller
    @RequestMapping(value = "/search/", method = RequestMethod.POST)
    public ModelAndView searchByKeyword(@ModelAttribute("search") Search search) {
        DAO dao = (DAO) context.getBean("edao");
        List<Plants> plants = dao.searchForPlants(search.getText());
        ModelAndView mav = new ModelAndView();
        mav.addObject("plants", plants);
        mav.addObject("query", search.getText());
        mav.setViewName("SearchResults");
        return mav;
    }

}
