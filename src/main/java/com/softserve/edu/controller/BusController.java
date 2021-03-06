package com.softserve.edu.controller;

import com.softserve.edu.entity.Bus;
import com.softserve.edu.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
public class BusController extends AbstractController {

    private BusService busService;

    @Autowired
    public BusController(BusService busService) {
        this.busService = busService;
    }

    @RequestMapping(value = "/bus/list", method = RequestMethod.GET)
    public String getAllBuses(Model model) {
        List<Bus> buses = busService.getAllElements();
        model.addAttribute("buses", buses);
        return "buses/bus_list";
    }

    @RequestMapping(value = "/bus/list", method = RequestMethod.POST)
    public String findBuses(@RequestBody MultiValueMap<String, String> formData,
                            Model model) {
        Map<String, String> request = formData.toSingleValueMap();
        List<Bus> buses = busService.findByMapRequest(request);
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
    public String showBusEditForm(
            @RequestParam(value = "id", required = false) String busID, Model
            model) {
        Bus bus = null;
        if (busID == null || busID.equals("0")) {
            bus = new Bus();
        } else {
            bus = busService.getElementByID(Integer.parseInt(busID));
        }
        model.addAttribute("bus", bus);
        return "/buses/bus_edit";
    }

    @RequestMapping(value = "/bus/edit", method = RequestMethod.POST)
    public String editOrCreateBus(
            @ModelAttribute @Valid Bus bus, BindingResult result,
            Errors errors, Model model) {
        if (!result.hasErrors()) {
            if (bus.getBusID() == 0) {
                busService.addElement(bus);
            } else {
                busService.updateElement(bus);
            }
            bus = busService.getElementByID(bus.getBusID());
            model.addAttribute("bus", bus);
            return "/buses/bus";
        } else {
            model.addAttribute("errors", errors.getFieldErrors());
            return showBusEditForm(String.valueOf(bus.getBusID()), model);
        }
    }

    @RequestMapping(value = "/bus/delete")
    public String deleteDriver(
            @RequestParam(value = "id") int busID) {
        Bus bus = busService.getElementByID(busID);
        busService.deleteElement(bus);
        return "redirect:/bus/list";
    }


}