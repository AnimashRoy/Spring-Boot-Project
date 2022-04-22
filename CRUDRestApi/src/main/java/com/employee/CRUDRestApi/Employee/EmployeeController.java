package com.employee.CRUDRestApi.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController (EmployeeService studentService) {
            this.employeeService = studentService;
        }

        @GetMapping(path = "/home")
        public ResponseEntity<String> homePage() {
            return new ResponseEntity<>(
                    employeeService.Start_Message(),
                    HttpStatus.OK
            );
    }

    @GetMapping(path ="/showall")
    public ResponseEntity<List<EmployeeResponse>> getAllEmployeeId(){

        List<Employee> employeelist= employeeService.getAllEmployeesInfo();
        List<EmployeeResponse> returnEmployeeList = EmployeeUtilsFunction.MultiObejectToJeson(employeelist);

        return new ResponseEntity<>(
                returnEmployeeList,
                HttpStatus.OK
        );
    }

        @PostMapping(path = "/create")
        public ResponseEntity<String> registerNewStudent(@RequestBody Employee employee) {

            employeeService.addNewEmployee(employee);

            return new ResponseEntity<>(
                    "Successfully created",
                    HttpStatus.CREATED
            );
    }

    @GetMapping(path = "/read/{employeeId}")
    public ResponseEntity <EmployeeResponse> getEmployeeById(
            @PathVariable ("employeeId") Long employeeId
    ){
        Employee employee   = employeeService.readEmployeeId(employeeId);
        EmployeeResponse employeeResponse = EmployeeUtilsFunction.singleIdFind(employee);
        return new ResponseEntity<>(
                employeeResponse,
                HttpStatus.OK
        );
    }

    @PutMapping(path = "/update/{employeeId}")
    public ResponseEntity<String> employeeIdUpdate(@PathVariable ("employeeId") Long employeeId,
                                                   @RequestBody Employee employee){
        employeeService.UpdateEmployeeId(employeeId, employee);
        return new ResponseEntity<>(
                "Succesfully Updated",
                HttpStatus.OK
        );
    }

    @DeleteMapping(path ="/delete/{EmployeeId}")
    public ResponseEntity<String> employeeIdDelete(@PathVariable("EmployeeId") Long employeeid)
    {
        employeeService.deleteEmployeeId(employeeid);
        return new ResponseEntity<>(
                "Successfully Deleted",
                HttpStatus.OK

        );

    }
}
