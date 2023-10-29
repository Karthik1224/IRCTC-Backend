package com.example.springbootdemo2.Repositories;

import com.example.springbootdemo2.Models.FoodOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FoodRepo extends JpaRepository<FoodOrder,Integer> {
}
