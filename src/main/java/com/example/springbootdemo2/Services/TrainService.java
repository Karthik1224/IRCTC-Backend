package com.example.springbootdemo2.Services;

import com.example.springbootdemo2.Models.Passenger;
import com.example.springbootdemo2.Models.Train;
import com.example.springbootdemo2.Repositories.PassengerRepo;
import com.example.springbootdemo2.Repositories.TrainRepo;
import com.example.springbootdemo2.RequestDTOs.NoOfPassengersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class TrainService
{


    @Autowired
    private TrainRepo trainRepo;
    @Autowired
    private PassengerRepo passengerRepo;
    public String addTrain(Train train)
    {
        trainRepo.save(train);
        return "added successfully";
    }

    public int NoOfPassengers(NoOfPassengersDto noOfPassengersDto)
    {
        String source = noOfPassengersDto.getSource();
        String destination = noOfPassengersDto.getDestination();
        List<Train> trainsList= trainRepo.findAllTrainsBySourceAndDestination(source,destination);

        if(trainsList.isEmpty()) return 0;
        int count=0;
        for(Train t:trainsList)
        {
             List<Passenger>passengerList = t.getPassengerList();
             for(Passenger p:passengerList)
             {
                 if(p.getDate().compareTo(noOfPassengersDto.getDate())==0)
                 {
                     count++;
                 }
             }
        }
        return count;

    }

    public String TrainAndPass(Integer trainId, Integer passId)
    {
        Optional<Train>optionalTrain = trainRepo.findById(trainId);
        if(optionalTrain.isEmpty()) return "invalid trainId";

        Optional<Passenger>optionalPassenger = passengerRepo.findById(passId);
        if(optionalPassenger.isEmpty()) return "invalid passengerId";

        Train t = optionalTrain.get();
        Passenger p = optionalPassenger.get();
        List<Passenger>list = t.getPassengerList();
        list.add(p);
        p.setTrain(t);

        trainRepo.save(t);
        return "mapped";
    }
}
