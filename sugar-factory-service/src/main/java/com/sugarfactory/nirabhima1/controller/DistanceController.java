package com.sugarfactory.nirabhima1.controller;

import com.sugarfactory.nirabhima1.handler.RecordNotFoundException;
import com.sugarfactory.nirabhima1.model.DistanceInfo;
import com.sugarfactory.nirabhima1.model.DistanceInfoPK;
import com.sugarfactory.nirabhima1.repository.DistanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/getSlipDistance/{slipNum}")
    public ResponseEntity<DistanceInfo> getEmployeeById (@PathVariable("slipNum") int slipNum)
    {/*
        DistanceInfo distanceInfo = distanceRepository.getDistanceBySlipNum(slipNum);

        if(distanceInfo == null) {
            throw new RecordNotFoundException("Invalid slip number : " + slipNum);
        }
        return new ResponseEntity<DistanceInfo>(distanceInfo, HttpStatus.OK);
    */
        return null;
    }

    @GetMapping("/getAllSlipDistanceData")
    public List<DistanceInfo> getSlipData() {

        //List<DistanceInfo> list = distanceRepository.findAll();
        //return list;
        return null;
    }

    @PostMapping("/postSlipDistance")
        public String postSlipDistance(String year, int slipNum , int distance) {

        //DistanceInfoPK distanceInfoPK = new DistanceInfoPK(year.trim(), slipNum);
        //distanceRepository.updateDistance(distanceInfoPK , distance , "DONE" );

        return "Slip number "+ slipNum +" is updated with distance "+ distance;
    }
}