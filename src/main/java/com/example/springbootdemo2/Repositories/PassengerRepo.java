package com.example.springbootdemo2.Repositories;

import com.example.springbootdemo2.Models.Passenger;
import com.example.springbootdemo2.Models.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PassengerRepo extends JpaRepository<Passenger,Integer> {


}
