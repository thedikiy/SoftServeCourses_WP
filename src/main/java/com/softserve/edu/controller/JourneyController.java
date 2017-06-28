package com.softserve.edu.controller;

import com.softserve.edu.entity.Bus;
import com.softserve.edu.entity.Driver;
import com.softserve.edu.entity.Journey;
import com.softserve.edu.entity.Passenger;
import com.softserve.edu.service.BusService;
import com.softserve.edu.service.DriverService;
import com.softserve.edu.service.JourneyService;
import com.softserve.edu.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class JourneyController extends AbstractController {
    private JourneyService journeyService;
    private DriverService driverService;
    private BusService busService;
    private PassengerService passengerService;

    @Autowired
    public void setJourneyService(JourneyService journeyService) {
        this.journeyService = journeyService;
    }

    @Autowired
    public void setDriverService(DriverService driverService) {
        this.driverService = driverService;
    }

    @Autowired
    public void setBusService(BusService busService) {
        this.busService = busService;
    }

    @Autowired
    public void setPassengerService(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @RequestMapping("/journey_list")
    public String getAllJourneys(Model model) {
        List<Journey> journeys = journeyService.getAllElements();
        model.addAttribute(journeys);
        return "/journeys/journey_list";
    }

    @RequestMapping("/journey")
    public String showSelectedJourneyInfo(
            @RequestParam("id") String journeyID, Model model) {
        Journey currentJourney = journeyService.getElementByID(
                Integer.parseInt(journeyID));
        model.addAttribute("journey", currentJourney);
        return "/journeys/journey";
    }

    @RequestMapping(value = "/journey/edit", method = RequestMethod.GET)
    public String showJourney(
            @RequestParam(value = "id", required = false) String journeyID, Model
            model) {
        Journey journey = null;
        if (journeyID == null) {
            journey = new Journey();
        } else {
            journey = journeyService.getElementByID(Integer
                    .parseInt(journeyID));
        }
        List<Driver> drivers = driverService.getAllElements();
        List<Bus> buses = busService.getAllElements();
        List<Passenger> passengers = passengerService.getAllElements();
        model.addAttribute("drivers", drivers);
        model.addAttribute("buses", buses);
        model.addAttribute("journey", journey);
        model.addAttribute("passengers", passengers);
        return "/journeys/journey_edit";
    }

    @RequestMapping(value = "/journey/edit", method = RequestMethod.POST)
    public String editOrCreateJourney(@RequestParam("action") String action,
            @RequestBody MultiValueMap<String, String> formData,
            @ModelAttribute Journey journey, Model model) {
            Bus bus = busService.getElementByID(Integer.parseInt(formData.get
                    ("busID").get(0)));
            Driver driver = driverService.getElementByID(Integer.parseInt(
                    formData.get("driverID").get(0)));
            journey.setBus(bus);
            journey.setDriver(driver);
            if (journey.getJourneyID() == 0) {
                journeyService.addElement(journey);
            } else {
                journeyService.updateElement(journey);
            }
            journey = journeyService.getElementByID(
                    journey.getJourneyID());
            model.addAttribute("journey", journey);
            return "/journeys/journey";
    }

    @RequestMapping(value = "/journey/delete")
    public String deleteJourney(@RequestParam(value = "id") int journeyId) {
        Journey journey = journeyService.getElementByID(journeyId);
        journeyService.deleteElement(journey);
        return "redirect:/journey_list";
    }
}
