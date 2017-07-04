package com.softserve.edu.controller;

import com.softserve.edu.entity.Driver;
import com.softserve.edu.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class DriverController extends AbstractController {

    private DriverService driverService;

    @Autowired
    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @RequestMapping("/driver/list")
    public String getAllDrivers(Model model) {
        List<Driver> drivers = driverService.getAllElements();
        model.addAttribute(drivers);
        return "/drivers/driver_list";
    }

    @RequestMapping("/driver")
    public String showSelectedDriverInfo(
            @RequestParam("id") String driverID, Model model) {
        Driver currentDriver = driverService.getElementByID(
                Integer.parseInt(driverID));
        model.addAttribute("driver", currentDriver);
        return "/drivers/driver";
    }

    @RequestMapping(value = "/driver/edit", method = RequestMethod.GET)
    public String showDriverEditForm(
            @RequestParam(value = "id", required = false) String driverID, Model
            model) {
        Driver driver = null;
        if (driverID == null||driverID.equals("0")) {
            driver = new Driver();
        } else {
            driver = driverService.getElementByID(Integer.parseInt(driverID));
        }
        model.addAttribute("driver", driver);
        return "/drivers/driver_edit";
    }

    @RequestMapping(value = "/driver/edit", method = RequestMethod.POST)
    public String editOrCreateDriver(@ModelAttribute @Valid Driver driver,
                                     BindingResult result, Errors errors, Model model) {
        if (!result.hasErrors()) {
            if (driver.getDriverID() == 0) {
                driverService.addElement(driver);
            } else {
                driverService.updateElement(driver);
            }
            driver = driverService.getElementByID(driver.getDriverID());
            model.addAttribute("driver", driver);
            return "/drivers/driver";
        } else {
            model.addAttribute("errors", errors.getFieldErrors());
            return showDriverEditForm(String.valueOf(driver.getDriverID()), model);
        }
    }

    @RequestMapping(value = "/driver/delete")
    public String deleteDriver(
            @RequestParam(value = "id") int driverID) {
        Driver driver = driverService.getElementByID(driverID);
        driverService.deleteElement(driver);
        return "redirect:/driver/list";
    }
}
