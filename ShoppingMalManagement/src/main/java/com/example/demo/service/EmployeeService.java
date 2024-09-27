package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

     
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

     
    public Employee getEmployeeById(Long empId) {
        return employeeRepository.findById(empId).orElse(null);
    }

     
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

     
    public Employee updateEmployee(Long empId, Employee employee) {
        Employee existingEmployee = employeeRepository.findById(empId).orElse(null);
        if (existingEmployee != null) {
            existingEmployee.setEmpName(employee.getEmpName());
            existingEmployee.setEmpRole(employee.getEmpRole());
            existingEmployee.setEmpSalary(employee.getEmpSalary());
            return employeeRepository.save(existingEmployee);
        }
        return null;
    }

     
    public void deleteEmployee(Long empId) {
        employeeRepository.deleteById(empId);
    }
}
