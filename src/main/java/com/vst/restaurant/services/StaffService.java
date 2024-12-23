package com.vst.restaurant.services;

import com.vst.restaurant.entities.Staff;
import com.vst.restaurant.exceptions.RestaurantNotFoundException;
import com.vst.restaurant.exceptions.StaffNotFoundException;
import com.vst.restaurant.repositories.RestaurantRepository;
import com.vst.restaurant.repositories.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {

    private final StaffRepository staffRepository;
    private final RestaurantRepository restaurantRepository;

    @Autowired
    public StaffService(StaffRepository staffRepository, RestaurantRepository restaurantRepository) {
        this.staffRepository = staffRepository;
        this.restaurantRepository = restaurantRepository;
    }


    public Staff save(Staff staff) {
        if (staff.getRestaurant() != null && staff.getRestaurant().getId() != null) {
            var rest = restaurantRepository.findById(staff.getRestaurant().getId()).orElseThrow(
                    ()-> new RestaurantNotFoundException("Ресторан не найден"));

            staff.setRestaurant(rest);
        }
        return staffRepository.save(staff);
    }


    public List<Staff> getStaffs() {
        return staffRepository.findAll();   // поиск всех сотрудников
    }


    public Staff findById(int id) {
        return staffRepository.findById(id)
                .orElseThrow(()
                        -> new StaffNotFoundException("Данный сотрудник не найден"));
    }

    public Staff updateStaff(int id, Staff updatedStaff) {

        var existingStaff = staffRepository.findById(id).orElseThrow(() ->
                new StaffNotFoundException("Данный сотрудник не найден"));


        if (updatedStaff.getStaffName() != null) {
            existingStaff.setStaffName(updatedStaff.getStaffName());
        }
        if (updatedStaff.getSurname() != null) {
            existingStaff.setSurname(updatedStaff.getSurname());
        }
        if (updatedStaff.getEmail() != null) {
            existingStaff.setEmail(updatedStaff.getEmail());
        }
        if (updatedStaff.getPost() != null) {
            existingStaff.setPost(updatedStaff.getPost());
        }
        if (updatedStaff.getSalary() != null) {
            existingStaff.setSalary(updatedStaff.getSalary());
        }
        if (updatedStaff.getHomeAddress() != null)
            existingStaff.setHomeAddress(updatedStaff.getHomeAddress());

        if(updatedStaff.getRestaurant() != null){
            existingStaff.setRestaurant(updatedStaff.getRestaurant());
        }
        return staffRepository.save(existingStaff);
    }

    public void deleteById(Integer id) {

        staffRepository.findById(id).orElseThrow(()->
                new StaffNotFoundException("Сотрудника с ID:" +id + " невозможно удалить."));

        staffRepository.deleteById(id);
    }

    public List<Staff> getStaffsByName(String name){
        return staffRepository.findByName(name);
    }


}
