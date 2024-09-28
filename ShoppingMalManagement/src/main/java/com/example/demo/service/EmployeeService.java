package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

/**
 * This class serves as a service component for managing employee data.
 * It provides methods for retrieving, creating, updating, and deleting employee information.
 */
@Service
public class EmployeeService {

    /**
     * Injects the EmployeeRepository bean for interacting with the employee data store (likely a database).
     */
    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * Retrieves a list of all employees from the repository.
     *
     * @return A list of all Employee objects.
     */
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    /**
     * Retrieves an employee by its ID from the repository.
     *
     * @param empId The ID of the employee to retrieve.
     * @return The Employee object if found, or null if not found.
     */
    public Employee getEmployeeById(Long empId) {
        return employeeRepository.findById(empId).orElse(null);
    }

    /**
     * Creates a new employee and saves it to the repository.
     *
     * @param employee The Employee object to create.
     * @return The created Employee object.
     */
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    /**
     * Updates an existing employee with the provided details.
     *
     * @param empId The ID of the employee to update.
     * @param employee The updated Employee object containing new details.
     * @return The updated Employee object if successful, or null if the original employee wasn't found.
     */
    public Employee updateEmployee(Long empId, Employee employee) {
        Employee existingEmployee = employeeRepository.findById(empId).orElse(null);
        if (existingEmployee != null) {
            // Update individual fields of the existing employee object
            existingEmployee.setEmpName(employee.getEmpName());
            existingEmployee.setEmpRole(employee.getEmpRole());
            existingEmployee.setEmpSalary(employee.getEmpSalary());

            return employeeRepository.save(existingEmployee);
        }
        return null;
    }

    /**
     * Deletes an employee from the repository based on their ID.
     *
     * @param empId The ID of the employee to delete.
     */
    public void deleteEmployee(Long empId) {
        employeeRepository.deleteById(empId);
    }
}