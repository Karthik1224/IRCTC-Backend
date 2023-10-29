package com.example.springbootdemo2.Services;

import com.example.springbootdemo2.Models.Passenger;
import com.example.springbootdemo2.Models.Train;
import com.example.springbootdemo2.Repositories.PassengerRepo;
import com.example.springbootdemo2.RequestDTOs.NoOfFemalePassByAgeAndDateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Service
public class PassengerService {

    @Autowired
    private PassengerRepo passengerRepo;
    public String addPassenger(Passenger passenger)
    {
        passengerRepo.save(passenger);
        return "added successfully";
    }

    public int NoOfFemalePassByAgeAndDate(NoOfFemalePassByAgeAndDateDto noOfFemalePassByAgeAndDateDto)
    {
        int start = noOfFemalePassByAgeAndDateDto.getStartAge();
        int end = noOfFemalePassByAgeAndDateDto.getEndAge();
        String dest = noOfFemalePassByAgeAndDateDto.getDestination();
        List<Passenger>passengerList = passengerRepo.findAll();
        int count=0;
        for(Passenger p : passengerList)
        {
            int age = p.getAge();
            Train t = p.getTrain();
            if(age > start && age <= end && t.getDestination().equals(dest))
            {
                count++;
            }
        }
        return count;
    }

}
