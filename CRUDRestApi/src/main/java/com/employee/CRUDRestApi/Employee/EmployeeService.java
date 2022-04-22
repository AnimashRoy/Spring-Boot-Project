package com.employee.CRUDRestApi.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final DataBaseRepository databaseRepository;

    @Autowired
    public EmployeeService(DataBaseRepository databaseRepository) {
        this.databaseRepository = databaseRepository;
    }

    //Frontpage or Homepage Message
    public String Start_Message() {
        return "Welcome To Our Office Management System.";
    }

    //Show all Employee Data
    public List<Employee> getAllEmployeesInfo(){

        return databaseRepository.findAll();

    }

    //Read Employee ID one by one
    public Employee readEmployeeId (long employeeId){

        Employee employee = databaseRepository.findById(employeeId)
                .orElseThrow(()-> new IllegalStateException(
                        "Student With id"+employeeId+"dose not exist"

                ));
        return employee;
    }

    //Create New Employee
    public void addNewEmployee(Employee employee) {

        // filter employee by email
        Optional<Employee> emp = databaseRepository.findByEmail(employee.getEmail());

        // if employee exist then return error message
        if (emp.isPresent()) {
            throw new IllegalStateException("Email already exist");
        }

        databaseRepository.save(employee);
    }

    //Update Employee Data or Id
    public void UpdateEmployeeId(
            Long employeeid,
            Employee updateEmployeeInfo
    )
    {
        Employee currentStudentId = databaseRepository.findById(employeeid)
                .orElseThrow(()-> new IllegalStateException(
                        "StudentFrom with id"+employeeid+"dose not exist")
                );

        //Name
        if(updateEmployeeInfo.getName()!=null){
            currentStudentId.setName(updateEmployeeInfo.getName());
        }
        //Birth_Date
        if(updateEmployeeInfo.getBirth_date() !=null){
            currentStudentId.setBirth_date(updateEmployeeInfo.getBirth_date());
        }
        //Join_Year
        if(updateEmployeeInfo.getJoin_year() != 0){
            currentStudentId.setJoin_year(updateEmployeeInfo.getJoin_year());
        }
        //Address
        if(updateEmployeeInfo.getAddress() != null){
            currentStudentId.setAddress(updateEmployeeInfo.getAddress());
        }
    }

    // Delete Employee Data
    public void deleteEmployeeId(Long id){

        boolean isExist = databaseRepository.existsById(id);

        if(!isExist){
            throw new IllegalStateException("Employee Not Found With This "+id);
        }
        databaseRepository.deleteById(id);


    }

}
