package com.barack.springbootdemo.service;

import com.barack.springbootdemo.error.EmployeeNotFoundException;
import com.barack.springbootdemo.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    List<Employee> employees = new ArrayList<>();
    /**
     * @return employee
     */
    @Override
    public Employee save(Employee employee) {
        if(employee.getEmployeeId() == null || employee.getEmailId().isEmpty()){
            employee.setEmployeeId(UUID.randomUUID().toString());
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Employee getEmployeeById(String id) {
        return employees
                .stream()
                .filter(employee -> Objects.equals(employee.getEmployeeId(), id))
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: "+ id));
//                .orElseThrow(() -> new RuntimeException("Employee not found with id: "+ id));
    }

    /**
     * @param id
     * @return
     */
    @Override
    public String deleteEmployeeById(String id) {
        Employee employee = employees.stream()
                .filter(e -> Objects.equals(e.getEmployeeId(), id))
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with Id: "+id));
        return employees.remove(employee) ? "Employee with Id: "+id+ " has been deleted" : " Employee with Id: "+id+ " has not been deleted";
    }
}
