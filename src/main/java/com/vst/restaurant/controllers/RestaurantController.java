package com.vst.restaurant.controllers;

import com.vst.restaurant.entities.Restaurant;
import com.vst.restaurant.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping()
    public List<Restaurant> findAll(){
       return restaurantService.findAll();
    }

    @GetMapping("/{id}")
    public Restaurant findById(@PathVariable Integer id){
        return restaurantService.findById(id);
    }

    @PostMapping
    public Restaurant addRestaurant(@RequestBody Restaurant newRest){
        return restaurantService.save(newRest);
    }

    @PutMapping("/update/{id}")
    public Restaurant updateRest(@PathVariable Integer id,
                                 @RequestBody Restaurant updatedRest){

        return restaurantService.update(id, updatedRest);

    }

}
