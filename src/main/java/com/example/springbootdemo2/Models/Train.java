package com.example.springbootdemo2.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TrainName")
public class Train
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer trainId;
    private String trainNo;

    private String source;
    private String destination;


    @OneToMany(mappedBy = "train",cascade = CascadeType.ALL)
    List<Passenger> passengerList = new ArrayList<>();

}
