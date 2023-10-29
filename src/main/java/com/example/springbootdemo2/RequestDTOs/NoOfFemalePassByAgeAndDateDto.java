package com.example.springbootdemo2.RequestDTOs;


import lombok.Data;

@Data
public class NoOfFemalePassByAgeAndDateDto
{
    private Integer startAge;
    private Integer endAge;
    private String destination;
}
