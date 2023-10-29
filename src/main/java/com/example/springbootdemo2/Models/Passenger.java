package com.example.springbootdemo2.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Passenger
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer passengerId;

    private String ticketId;
    private Date date;
    private int age;
    private String gender;

    @ManyToOne
    @JoinColumn(name = "trainId")
    private Train train;

    @OneToMany(mappedBy = "passenger",cascade = CascadeType.ALL)
    List<FoodOrder> orderList = new ArrayList<>();
}
