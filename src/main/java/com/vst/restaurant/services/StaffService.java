package com.vst.restaurant.services;

import com.vst.restaurant.entities.Staff;
import com.vst.restaurant.exceptions.StaffNotFoundException;
import com.vst.restaurant.repositories.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {

    private final StaffRepository staffRepository;

    @Autowired
    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }


    public Staff save(Staff staff) {

        return staffRepository.save(staff);
    }


    public List<Staff> getStaffs() {
        return staffRepository.findAll();   // поиск всех сотрудников
    }


    public Staff findById(int id) {
        return staffRepository.findById(id)
                .orElseThrow(() -> new StaffNotFoundException("Данный сотрудник не найден"));
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
        if (updatedStaff.getSalary() != 0) {
            existingStaff.setSalary(updatedStaff.getSalary());
        }
        if (updatedStaff.getHomeAddress() != null)
            existingStaff.setHomeAddress(updatedStaff.getHomeAddress());


        return staffRepository.save(existingStaff);
    }

    public void deleteById(int id) {
        staffRepository.deleteById(id);
    }


}
