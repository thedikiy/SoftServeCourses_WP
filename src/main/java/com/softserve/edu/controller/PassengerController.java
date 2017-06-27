package com.softserve.edu.controller;

import com.softserve.edu.entity.Passenger;
import com.softserve.edu.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class PassengerController extends AbstractController {
    @Autowired
    private PassengerService passengerService;

    @RequestMapping("/passenger_list")
    public String getAllPassengers(Model model) {
       List<Passenger> passengers = passengerService.getAllElements();
        model.addAttribute("passengers", passengers);
        return "/passengers/passenger_list";
    }

    @RequestMapping("/passenger")
    public String showSelectedPassengerInfo(
            @RequestParam("id")int passengerID, Model model) {
        Passenger currentPassenger =
                (Passenger) passengerService.getElementByID(passengerID);
        model.addAttribute("passenger", currentPassenger);
        return "/passengers/passenger";
    }

    @RequestMapping(value = "/passenger/edit",method = RequestMethod.GET)
    public String showPassenger(
            @RequestParam(value = "id",required = false) String passengerID,
            Model model) {
        Passenger passenger = null;
        if (passengerID == null) {
            passenger = new Passenger();
        } else {
            passenger = (Passenger) passengerService.getElementByID(
                    Integer.parseInt(passengerID));
        }
        model.addAttribute("passenger",passenger);
        return "/passengers/passenger_edit";
    }

    @RequestMapping(value = "/passenger/edit",method = RequestMethod.POST)
    public String editOrCreatePassenger(
            @ModelAttribute Passenger passenger, Model model) {
        if (passenger.getPassengerID() == 0) {
            passengerService.addElement(passenger);
        } else {
            passengerService.updateElement(passenger);
        }
        passenger =(Passenger) passengerService.getElementByID(
                passenger.getPassengerID());
        model.addAttribute("passenger",passenger);
        return "/passengers/passenger";
    }
}
