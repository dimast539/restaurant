package com.vst.restaurant.repositories;

import com.vst.restaurant.entities.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer> {


    @Query("select s from Staff s where s.staffName = :name")
    List<Staff> findByName(@Param("name") String name);
}
