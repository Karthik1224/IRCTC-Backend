package com.example.springbootdemo2.Controllers;


import com.example.springbootdemo2.Services.FoodService;
import com.example.springbootdemo2.Models.FoodOrder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/food order")
public class FoodOrderController
{

       private FoodService foodService = new FoodService();
       @PostMapping("/addFoodOrder")
       public String addFoodOrder(@RequestBody FoodOrder foodOrder) {

           return foodService.addFoodOrder(foodOrder);

       }
}
