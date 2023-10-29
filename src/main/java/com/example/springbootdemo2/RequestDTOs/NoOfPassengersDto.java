package com.example.springbootdemo2.RequestDTOs;


import lombok.*;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NoOfPassengersDto
{
    private String source;
    private String destination;

    private Date date;
}
