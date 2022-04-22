package com.employee.CRUDRestApi.Employee;

import java.time.LocalDate;
import java.time.Period;

public class EmployeeResponse {
    private Long id;
    private String name;
    private LocalDate birth_date;
    private int age;
    private int join_year;
    private String address;

    public EmployeeResponse(
            long id,
            String name,
            LocalDate birth_date,
            int join_year,
            String address)
    {
        this.id = id;
        this.name = name;
        this.birth_date = birth_date;
        this.age = getAge();
        this.join_year = join_year;
        this.address = address;
    }

    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getAge(){
        return Period.between(this.birth_date, LocalDate.now()).getYears();
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getJoin_year(){
        return this.join_year;
    }
    public void setJoin_year(int join_year){
        this.join_year = join_year;
    }
    public String getAddress(){
        return this.address;
    }
    public void setAddress(String address){
        this.address = address;
    }

}
