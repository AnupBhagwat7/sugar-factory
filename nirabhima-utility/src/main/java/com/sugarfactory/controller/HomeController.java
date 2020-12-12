package com.sugarfactory.controller;

import com.sugarfactory.handler.RecordNotFoundException;
import com.sugarfactory.model.DistanceInfo;
import com.sugarfactory.repository.DistanceRepository;
import com.sugarfactory.service.DistanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/nirabhima")
public class HomeController {

    @Autowired
    private DistanceService distanceService;

    @Autowired
    private DistanceRepository distanceRepository;

    static Logger log = LoggerFactory.getLogger(HomeController.class);

    @Value("${spring.application.name}")
    String appName;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("appName", appName);
        model.addAttribute("distanceInfo", null);
        return "home";
    }

    @GetMapping(value = "/getSlipDistance")
    public String getBySlipNumber (@RequestParam(value = "slipNo", required = false) Integer slipNo, Model model)
    {
        //DistanceInfo distanceInfo = null;
        DistanceInfo distanceInfo = distanceService.getBySlipNumber(slipNo);

        if(distanceInfo == null) {
            log.debug("Invalid slip number : " + slipNo);
            throw new RecordNotFoundException("Invalid slip number : " + slipNo);
        }

        model.addAttribute("distanceInfo", distanceInfo);
        log.debug("Slip number : " + slipNo + " details fetched successfully ");
        return "update-distance";
    }

    @PostMapping("/updateDistance/{id}")
    public String updateDistance(@PathVariable("id") long id, DistanceInfo distanceInfo,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            distanceInfo.setActualDistance(distanceInfo.getActualDistance());
            return "update-distance";
        }

        distanceRepository.save(distanceInfo);
        model.addAttribute("users", distanceRepository.findAll());
        return "redirect:/index";
    }

    @RequestMapping(path = "/updateDistance", method = RequestMethod.POST)
    public String updateDistance(@PathVariable Integer slipNo, @PathVariable Integer distance)
    {
        distanceService.updateDistance(slipNo , distance);
        return "redirect:/";
    }
}