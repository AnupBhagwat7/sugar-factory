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

    @Autowired
    private DistanceRepository distanceRepository;

    @GetMapping("/test")
    public String test() {
        return "hello";
    }

    @GetMapping(value = "/getSlipDistance/{slipNum}")
    public ResponseEntity<DistanceInfo> getEmployeeById (@PathVariable("slipNum") int slipNum)
    {
        DistanceInfo distanceInfo = distanceRepository.getDistanceBySlipNum(slipNum);

        if(distanceInfo == null) {
            throw new RecordNotFoundException("Invalid slip number : " + slipNum);
        }
        return new ResponseEntity<DistanceInfo>(distanceInfo, HttpStatus.OK);
    }

    @GetMapping("/getAllSlipDistanceData")
    public List<DistanceInfo> getSlipData() {

        List<DistanceInfo> list = distanceRepository.findAll();
        return list;
    }

    @PostMapping("/postSlipDistance/{year}/{slipNum}/{distance}")
        public String postSlipDistance(@PathVariable String year,@PathVariable int slipNum ,@PathVariable int distance) {

        DistanceInfoPK distanceInfoPK = new DistanceInfoPK(year.trim(), slipNum);

        Optional<DistanceInfo> distanceInfo = distanceRepository.findById(distanceInfoPK);

        if(!distanceInfo.isPresent()) {
            throw new RecordNotFoundException("Invalid slip number : " + slipNum);
        }
        distanceRepository.updateDistance(distanceInfoPK , distance , "DONE" );

        return "Slip number "+ slipNum +" is updated with distance "+ distance;
    }
}