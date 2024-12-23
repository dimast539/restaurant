package com.vst.restaurant.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "staff")
public class Staff {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @JsonProperty("staff_name")
    @Column(name = "staff_name")
    private String staffName;

    @JsonProperty("staff_surname")
    @Column(name = "staff_surname")
    private String surname;

    @JsonProperty("staff_email")
    @Column(name = "staff_email")
    private String email;

    @JsonProperty("staff_post")
    @Column(name = "staff_post")
    private String post;    // должность

    @JsonProperty("staff_salary")
    @Column(name = "staff_salary")
    private Double salary;

    @JsonProperty("staff_address")
    @Column(name = "staff_address")
    private String homeAddress;


    @JoinColumn(name = "restaurant_id")
    @JsonProperty("restaurant")
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Restaurant restaurant;






    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
