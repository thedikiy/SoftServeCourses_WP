package com.softserve.edu.controller;

import com.softserve.edu.entity.Driver;
import com.softserve.edu.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class DriverController {
    @Autowired
    DriverService driverService;
    @RequestMapping("/driver_list")
    public String getAllDrivers(Model model) {
        Set<Driver> drivers = new HashSet<Driver>(driverService.getAllElements());
        model.addAttribute(drivers);
        return "/drivers/driver_list";
    }

    @RequestMapping("/driver")
    public String showSelectedDriverInfo(
            @RequestParam("id") String driverID, Model model) {
        Driver currentDriver = (Driver) driverService.getElementByID(
                Integer.parseInt(driverID));
        model.addAttribute("driver", currentDriver);
        return "/drivers/driver";
    }

    @RequestMapping(value = "/driver/edit",method = RequestMethod.GET)
    public String showdriver(
            @RequestParam(value = "id",required = false) String driverID, Model
            model) {
        Driver driver = null;
        if (driverID == null) {
            driver = new Driver();
        } else {
            driver = (Driver) driverService.getElementByID(Integer.parseInt(driverID));
        }
        model.addAttribute("driver",driver);
        return "/drivers/driver_edit";
    }

    @RequestMapping(value = "/driver/edit",method = RequestMethod.POST)
    public String editOrCreatedriver(
            @ModelAttribute Driver driver, Model model) {
        if (driver.getDriverID() == 0) {
            driverService.addElement(driver);
        } else {
            driverService.updateElement(driver);
        }
        driver =(Driver) driverService.getElementByID(driver.getDriverID());
        model.addAttribute("driver",driver);
        return "/drivers/driver";
    }
}
