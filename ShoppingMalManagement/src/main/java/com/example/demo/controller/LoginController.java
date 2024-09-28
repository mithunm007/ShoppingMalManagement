package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.Login;
import com.example.demo.service.LoginService;
import java.util.List;

@RestController // Marks the class as a REST controller, meaning it will handle HTTP requests and responses in a RESTful way.
@RequestMapping("/logins") // Base URL for all endpoints in this controller. All requests starting with "/logins" will be handled here.
public class LoginController {

    @Autowired // Automatically injects an instance of LoginService. This allows us to use the service layer methods without manually instantiating it.
    private LoginService loginService;

    /**
     * GET /logins
     * Retrieves a list of all logins.
     *
     * @return a list of Login entities.
     */
    @GetMapping
    public List<Login> getAllLogins() {
        return loginService.getAllLogins(); // Calls the service layer to retrieve all Login records from the database.
    }

    /**
     * GET /logins/{id}
     * Retrieves a specific login by its ID.
     *
     * @param id the ID of the login to retrieve.
     * @return the Login entity with the specified ID, wrapped in a ResponseEntity.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Login> getLoginById(@PathVariable Long id) {
        Login login = loginService.getLoginById(id); // Calls the service layer to retrieve a Login record by its ID.
        return ResponseEntity.ok(login); // Returns the found Login entity with a status code of 200 (OK).
    }

    /**
     * POST /logins
     * Creates a new login record.
     *
     * @param login the Login entity to be created, provided in the request body.
     * @return the created Login entity wrapped in a ResponseEntity.
     */
    @PostMapping
    public ResponseEntity<Login> createLogin(@RequestBody Login login) {
        Login createdLogin = loginService.createLogin(login); // Calls the service layer to create a new Login record.
        return ResponseEntity.ok(createdLogin); // Returns the created Login entity with a status code of 200 (OK).
    }

    /**
     * PUT /logins/{id}
     * Updates an existing login record.
     *
     * @param id the ID of the login to update.
     * @param login the updated Login entity provided in the request body.
     * @return the updated Login entity wrapped in a ResponseEntity.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Login> updateLogin(@PathVariable Long id, @RequestBody Login login) {
        Login updatedLogin = loginService.updateLogin(id, login); // Calls the service layer to update the Login record with the given ID.
        return ResponseEntity.ok(updatedLogin); // Returns the updated Login entity with a status code of 200 (OK).
    }

    /**
     * DELETE /logins/{id}
     * Deletes an existing login record.
     *
     * @param id the ID of the login to delete.
     * @return a ResponseEntity with no content and a status code of 204 (No Content).
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLogin(@PathVariable Long id) {
        loginService.deleteLogin(id); // Calls the service layer to delete the Login record with the given ID.
        return ResponseEntity.noContent().build(); // Returns a response with no content and a status code of 204 (No Content).
    }
}
