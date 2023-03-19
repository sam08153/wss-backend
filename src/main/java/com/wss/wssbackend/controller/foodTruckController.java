package com.wss.wssbackend.controller;


import com.wss.wssbackend.model.orderFood;
import com.wss.wssbackend.model.foodTruck;
import com.wss.wssbackend.repository.FoodTruckRepository;
import com.wss.wssbackend.repository.OrderFoodReposiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class foodTruckController {

    @Autowired
    private FoodTruckRepository foodTruckRepository;

    @Autowired
    private OrderFoodReposiory orderFoodReposiory;

    @GetMapping("/foodTrucks")
    public ResponseEntity<List<foodTruck>> getAllFoodTruck(@RequestParam(required = false) String title) {
        try {
            List<foodTruck> foodTrucks = new ArrayList<foodTruck>();
            if (title == null)
                foodTruckRepository.findAll().forEach(foodTrucks::add);
            if (foodTrucks.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(foodTrucks, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/foodTruck")
    public ResponseEntity<foodTruck> createfoodTruck(@RequestBody foodTruck foodTruck) {
        try {

            foodTruck ft = foodTruckRepository.save(foodTruck);
            return new ResponseEntity<>(ft, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/orderFood")
    public ResponseEntity<orderFood> createfoodOrder(@RequestBody orderFood orderFood) {
        try {

            orderFood of = orderFoodReposiory.save(orderFood);
            return new ResponseEntity<>(of, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
