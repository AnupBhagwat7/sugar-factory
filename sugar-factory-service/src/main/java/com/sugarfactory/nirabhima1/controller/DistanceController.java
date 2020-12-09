package com.sugarfactory.nirabhima1.controller;

import com.sugarfactory.nirabhima1.model.DistanceInfo;
import com.sugarfactory.nirabhima1.model.DistanceInfoPK;
import com.sugarfactory.nirabhima1.repository.DistanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/nirabhima")
public class DistanceController {

    //@Autowired
    //private DistanceRepository distanceRepository;

    @GetMapping("/test")
    public String test() {
        return "hello";
    }

    @GetMapping("/getSlipData")
    public String getSlipData() {

        //List<DistanceInfo> list = distanceRepository.findAll();
        return "list";
    }

    @PostMapping("/postSlipDistance")
    public String postSlipDistance(String year, int slipNum , int distance) {

        //DistanceInfoPK distanceInfoPK = new DistanceInfoPK(year.trim(), slipNum);
        //distanceRepository.updateDistance(distanceInfoPK , distance , "DONE" );

        return "Slip number "+ slipNum +" is updated with distance "+ distance;
    }
}