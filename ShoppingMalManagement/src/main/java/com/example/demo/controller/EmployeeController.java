package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employees") // Base URL for all endpoints in this controller
public class EmployeeController {

    @Autowired // Automatically injects the EmployeeService dependency
    private EmployeeService employeeService;

    /**
     * GET /employees
     * Retrieves a list of all employees.
     *
     * @return a list of all Employee entities.
     */
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees(); // Calls the service to get all employees
    }

    /**
     * GET /employees/{id}
     * Retrieves a specific employee by its ID.
     *
     * @param id the ID of the employee to retrieve.
     * @return the Employee entity with the specified ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeService.getEmployeeById(id); // Calls the service to get an employee by ID
        return ResponseEntity.ok(employee); // Returns the employee in the response with a status code of 200 (OK)
    }

    /**
     * POST /employees
     * Creates a new employee.
     *
     * @param employee the Employee entity to be created.
     * @return the created Employee entity.
     */
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee createdEmployee = employeeService.createEmployee(employee); // Calls the service to create a new employee
        return ResponseEntity.ok(createdEmployee); // Returns the created employee with a status code of 200 (OK)
    }

    /**
     * PUT /employees/{id}
     * Updates an existing employee.
     *
     * @param id the ID of the employee to update.
     * @param employee the Employee entity containing the updated information.
     * @return the updated Employee entity.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        Employee updatedEmployee = employeeService.updateEmployee(id, employee); // Calls the service to update an existing employee
        return ResponseEntity.ok(updatedEmployee); // Returns the updated employee with a status code of 200 (OK)
    }

    /**
     * DELETE /employees/{id}
     * Deletes an existing employee.
     *
     * @param id the ID of the employee to delete.
     * @return a ResponseEntity with no content and a status code of 204 (No Content).
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id); // Calls the service to delete an employee by ID
        return ResponseEntity.noContent().build(); // Returns an empty response with a status code of 204 (No Content)
    }
}
