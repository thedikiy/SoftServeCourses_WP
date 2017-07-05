package com.softserve.edu.controller;

import com.softserve.edu.controller.dto.JourneyDTO;
import com.softserve.edu.entity.Bus;
import com.softserve.edu.entity.Driver;
import com.softserve.edu.entity.Journey;
import com.softserve.edu.entity.Passenger;
import com.softserve.edu.service.BusService;
import com.softserve.edu.service.DriverService;
import com.softserve.edu.service.JourneyService;
import com.softserve.edu.service.PassengerService;
import org.modelmapper.ModelMapper;
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
public class JourneyController extends AbstractController {
    private JourneyService journeyService;
    private DriverService driverService;
    private BusService busService;
    private PassengerService passengerService;
    private ModelMapper mapper;

    @RequestMapping(value = "/journey/list", method = RequestMethod.GET)
    public String getAllJourneys(Model model) {
        List<Journey> journeys = journeyService.getAllElements();
        model.addAttribute("journeys", journeys);
        return "/journeys/journey_list";
    }

    @RequestMapping(value = "/journey/list", method = RequestMethod.POST)
    public String findJourneys(@RequestBody MultiValueMap<String, String> formData,
                               Model model) {
        Map<String, String> request = formData.toSingleValueMap();
        List<Journey> journeys = journeyService.findByMapRequest(request);
        model.addAttribute("journeys", journeys);
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
    public String showJourneyEditForm(
            @RequestParam(value = "id", required = false) String journeyID, Model
            model) {
        Journey journey = null;
        if (journeyID == null || journeyID.equals("0")) {
            journey = new Journey();
        } else {
            journey = journeyService.getElementByID(Integer
                    .parseInt(journeyID));
        }
        List<Driver> drivers = driverService.getAllElements();
        List<Bus> buses = busService.getAllElements();
        JourneyDTO journeyDTO = convertToDto(journey);
        List<Passenger> passengers = passengerService.getAllElements();
        model.addAttribute("drivers", drivers);
        model.addAttribute("buses", buses);
        model.addAttribute("journey", journeyDTO);
        model.addAttribute("passengers", passengers);
        return "/journeys/journey_edit";
    }

    @RequestMapping(value = "/journey/edit", method = RequestMethod.POST)
    public String editOrCreateJourney(@ModelAttribute("journey") JourneyDTO journeyDTO,
                                      BindingResult result, Model model) {
        if (!result.hasErrors()) {
            Journey journey = convertToEntity(journeyDTO);
            if (journey.getJourneyID() == 0) {
                journeyService.addElement(journey);
            } else {
                journeyService.updateElement(journey);
            }
            journey = journeyService.getElementByID(
                    journey.getJourneyID());
            model.addAttribute("journey", journey);
        }
        return "/journeys/journey";
    }

    @RequestMapping(value = "/journey/delete")
    public String deleteJourney(@RequestParam(value = "id") int journeyId) {
        Journey journey = journeyService.getElementByID(journeyId);
        journeyService.deleteElement(journey);
        return "redirect:/journey/list";
    }

    @RequestMapping(value = "/journey/buy_ticket", method = RequestMethod.GET)
    public String showBuyTicketForm(@RequestParam(value = "id") int journeyID, Model model) {
        model.addAttribute("journeyID", journeyID);
        model.addAttribute("action", "/journey/buy_ticket");
        model.addAttribute("passengers", passengerService.getAllElements());
        return "/journeys/buy_ticket";
    }

    @RequestMapping(value = "/journey/buy_ticket", method = RequestMethod.POST)
    public String buyTicket(@ModelAttribute("journeyID") int journeyID,
                            @ModelAttribute("passengerID") int passengerId,
                            @ModelAttribute("submit")String action,
                            @ModelAttribute @Valid Passenger passenger,
                            BindingResult result, Errors errors, Model model) {
        Journey journey =  journeyService.getElementByID(journeyID);
        journey.getPassengers().add(passengerService.getElementByID(passengerId));
        journeyService.updateElement(journey);
        return "redirect:/journey/list";
    }


    private JourneyDTO convertToDto(Journey journey) {
        return mapper.map(journey, JourneyDTO.class);
    }

    private Journey convertToEntity(JourneyDTO journeyDTO) {
        Journey journey = mapper.map(journeyDTO, Journey.class);
        if (journey.getBus().getBusID() != -1) {
            journey.setBus(busService.getElementByID(journey.getBus().getBusID()));
        } else {
            journey.setBus(null);
        }
        if (journey.getDriver().getDriverID() != -1) {
            journey.setDriver(
                    driverService.getElementByID(journey.getDriver().getDriverID()));
        } else {
            journey.setDriver(null);
        }
        return journey;
    }

    @Autowired
    public JourneyController(JourneyService journeyService,
                             DriverService driverService, BusService busService,
                             PassengerService passengerService,
                             ModelMapper mapper) {
        this.journeyService = journeyService;
        this.driverService = driverService;
        this.busService = busService;
        this.passengerService = passengerService;
        this.mapper = mapper;
    }
}
