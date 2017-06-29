package com.softserve.edu.controller;

import com.softserve.edu.entity.Bus;
import com.softserve.edu.service.impl.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BusController extends AbstractController {

    private BusService busService;

    @Autowired
    public void setBusService(BusService busService) {
        this.busService = busService;
    }

    @RequestMapping("/bus_list")
    public String getAllBuses(Model model) {
        List<Bus> buses = busService.getAllElements();
        model.addAttribute("buses", buses);
        return "buses/bus_list";
    }

    @RequestMapping("/bus")
    public String showSelectedBusInfo(
            @RequestParam("id") int busID, Model model) {
        Bus currentBus = busService.getElementByID(busID);
        model.addAttribute("bus", currentBus);
        return "/buses/bus";
    }

    @RequestMapping(value = "/bus/edit", method = RequestMethod.GET)
    public String showBus(
            @RequestParam(value = "id", required = false) String busID, Model
            model) {
        Bus bus = null;
        if (busID == null) {
            bus = new Bus();
        } else {
            bus = busService.getElementByID(Integer.parseInt(busID));
        }
        model.addAttribute("bus", bus);
        return "/buses/bus_edit";
    }

    @RequestMapping(value = "/bus/edit", method = RequestMethod.POST)
    public String editOrCreateBus(
            @ModelAttribute Bus bus, Model model) {
        if (bus.getBusID() == 0) {
            busService.addElement(bus);
        } else {
            busService.updateElement(bus);
        }
        bus = busService.getElementByID(bus.getBusID());
        model.addAttribute("bus", bus);
        return "/buses/bus";
    }

    @RequestMapping(value = "/bus/delete")
    public String deleteDriver(
            @RequestParam(value = "id") int busID) {
        Bus bus = busService.getElementByID(busID);
        busService.deleteElement(bus);
        return "redirect:/bus_list";
    }


}