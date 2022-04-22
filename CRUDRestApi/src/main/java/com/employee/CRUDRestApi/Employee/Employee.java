package com.employee.CRUDRestApi.Employee;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Employee {

    @Id
    @SequenceGenerator(
            name = "employee_sequence",
            sequenceName = "employee_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employee_sequence"
    )

    @Column(name = "employee_id")
    private long id;
    private String name;
    private LocalDate birth_date;

    @Transient
    private int age;

    private int join_year;
    private String email;
    private String address;

    public Employee() {

    }

    public Employee(
            long id,
            String name,
            LocalDate birth_date,
            int age,
            int admit_year,
            String email,
            String address
    ) {
        this.id = id;
        this.name = name;
        this.birth_date = birth_date;
        this.age = age;
        this.join_year = join_year;
        this.email = email;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(LocalDate birth_date) {
        this.birth_date = birth_date;
    }

    public int getAge() {
        return Period.between(this.birth_date, LocalDate.now()).getYears();
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getJoin_year() {
        return join_year;
    }

    public void setJoin_year(int join_year) {
        this.join_year = join_year;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
