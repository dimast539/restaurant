package com.vst.restaurant.services;

import com.vst.restaurant.entities.Restaurant;
import com.vst.restaurant.exceptions.RestaurantNotFoundException;
import com.vst.restaurant.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public List<Restaurant> findAll(){
        return restaurantRepository.findAll();
    }

    public Restaurant findById(Integer id){
      return  restaurantRepository.findById(id).orElseThrow(()->
                new RestaurantNotFoundException("Данный ресторан не найден."));
    }

    public Restaurant update(Integer id, Restaurant updatedRest){

        var existingRest = restaurantRepository.findById(id).orElseThrow(()->
                new RestaurantNotFoundException( "Данный ресторан не найден"));

        if (updatedRest.getName() != null){
            existingRest.setName(updatedRest.getName());
        }

        return restaurantRepository.save(existingRest);
    }

    public void deleteById(Integer id){
        var restaurant = restaurantRepository.findById(id).orElseThrow(()->
                new RestaurantNotFoundException( "Данный ресторан не найден"));

        restaurantRepository.delete(restaurant);
    }

    public Restaurant save(Restaurant newRest){
        return restaurantRepository.save(newRest);
    }


}
