package com.employee.CRUDRestApi.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeUtilsFunction {
    public static EmployeeResponse singleIdFind(Employee employee){

        return new EmployeeResponse(
                employee.getId(),
                employee.getName(),
                employee.getBirth_date(),
                employee.getJoin_year(),
                employee.getAddress()
        );

    }

    public static List<EmployeeResponse> MultiObejectToJeson(List<Employee> employeelist){

        List<EmployeeResponse> returnEmployeeList = new ArrayList<>();

        for(Employee employeeform : employeelist){

            EmployeeResponse employeedata = new EmployeeResponse(
                    employeeform.getId(),
                    employeeform.getName(),
                    employeeform.getBirth_date(),
                    employeeform.getJoin_year(),
                    employeeform.getAddress()

            );
            returnEmployeeList.add(employeedata);

        }
        return returnEmployeeList;



    }
}
