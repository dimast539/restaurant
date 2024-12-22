package com.vst.restaurant.controllers;

import com.vst.restaurant.entities.Staff;
import com.vst.restaurant.services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {


    private final StaffService staffService;

    @Autowired
    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }




    @GetMapping("/test")
    public String test1() {
        return staffService != null ? "StaffService is initialized" : "StaffService is null";
    }


    @PostMapping
    public Staff addStaff(@RequestBody Staff staff) {
        System.out.println("Received staff: " + staff); // Лог
        return staffService.save(staff);
    }


    @GetMapping("/findAll")
    public List<Staff> getAllStaffs() {
        return staffService.getStaffs();
    }




    @GetMapping("/{id}")
    public Staff findById(@PathVariable int id){
        return staffService.findById(id);
    }

    @PutMapping("/update-staff/{id}")
    public Staff updateStaff(@PathVariable int id,@RequestBody Staff updateStaff){
        return staffService.updateStaff(id, updateStaff);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        staffService.deleteById(id);
    }





}
