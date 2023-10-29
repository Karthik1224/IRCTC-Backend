package com.example.springbootdemo2.Controllers;


import com.example.springbootdemo2.RequestDTOs.NoOfFemalePassByAgeAndDateDto;
import com.example.springbootdemo2.Services.PassengerService;
import com.example.springbootdemo2.Models.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/passenger")
public class PassengerController
{
    @Autowired
    private PassengerService passengerService;

    @PostMapping("/addPassenger")
     public String addPassenger(@RequestBody Passenger passenger)
     {
         return passengerService.addPassenger(passenger);
     }


     @GetMapping("/NoOfFemalePassByAgeAndDate")
     public int NoOfFemalePassByAgeAndDate(@RequestBody NoOfFemalePassByAgeAndDateDto noOfFemalePassByAgeAndDateDto)
     {
         return passengerService.NoOfFemalePassByAgeAndDate(noOfFemalePassByAgeAndDateDto);
     }

}
