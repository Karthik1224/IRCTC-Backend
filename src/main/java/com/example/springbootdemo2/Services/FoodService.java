package com.example.springbootdemo2.Services;


import com.example.springbootdemo2.Models.FoodOrder;
import com.example.springbootdemo2.Repositories.FoodRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodService {

    @Autowired
    private FoodRepo foodRepo;
    public String addFoodOrder(FoodOrder foodOrder)
    {
        foodRepo.save(foodOrder);
        return "added";
    }

}
