package com.softserve.edu.controller;

import com.softserve.edu.entity.Bus;
import com.softserve.edu.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Controller
public class BusController {
    @Autowired
    private BusService busService;

    @RequestMapping("/buslist")
    public String getAllBuses(Model model) {
        List<Bus> buses = busService.getAllElements();
        model.addAttribute("buses", buses);
        return "/buses/buslist";
    }

    @RequestMapping("/bus")
    public String showSelectedBusInfo(
            @RequestParam("id") String busID, Model model) {
        Bus currentBus = (Bus) busService.getElementByID(
                Integer.parseInt(busID));
        model.addAttribute("bus", currentBus);
        return "/buses/bus";
    }

    @RequestMapping(value = "/bus/edit",method = RequestMethod.GET)
    public String showBus(
            @RequestParam(value = "id",required = false) String busID, Model
            model) {
        Bus bus = null;
        if (busID == null) {
            bus = new Bus();
        } else {
            bus = (Bus) busService.getElementByID(Integer.parseInt(busID));
        }
        model.addAttribute("bus",bus);
        return "/buses/bus_edit";
    }

    @RequestMapping(value = "/bus/edit",method = RequestMethod.POST)
    public String editOrCreateBus(
            @ModelAttribute Bus bus, Model model) {
        if (bus.getBusID() == 0) {
            busService.addElement(bus);
        } else {
            busService.updateElement(bus);
        }
        bus =(Bus) busService.getElementByID(bus.getBusID());
        model.addAttribute("bus",bus);
        return "/buses/bus";
    }
}