package com.example.springbootdemo2.Controllers;


import com.example.springbootdemo2.RequestDTOs.NoOfPassengersDto;
import com.example.springbootdemo2.Services.TrainService;
import com.example.springbootdemo2.Models.Train;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/train")
public class TrainController {

      @Autowired
      private TrainService trainService;
      @PostMapping("/addTrain")
      public String addTrain(@RequestBody Train train)
      {
          return trainService.addTrain(train);
      }

      @GetMapping("/NoOfPassengers")
      public int NoOfPassengers(@RequestBody NoOfPassengersDto noOfPassengersDto)
      {
            return trainService.NoOfPassengers(noOfPassengersDto);
      }

      @PostMapping("/mapTrainAndPass")
      public String TrainAndPass(@RequestParam Integer trainId, @RequestParam Integer passId)
      {
          return trainService.TrainAndPass(trainId,passId);
      }
}
