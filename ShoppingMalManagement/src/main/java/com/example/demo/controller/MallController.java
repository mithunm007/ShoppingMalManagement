package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Mall;
import com.example.demo.service.MallService;

import java.util.List;

/**
 * This class serves as the RESTful API controller for managing mall data.
 * It provides endpoints for retrieving, creating, updating, and deleting mall information.
 */
@RestController
@RequestMapping("/malls")
public class MallController {

    /**
     * Injects the MallService bean into the controller for accessing mall-related services.
     */
    @Autowired
    private MallService mallService;

    /**
     * Handles GET requests to the root endpoint, returning a list of all malls.
     *
     * @return A list of all malls.
     */
    @GetMapping
    public List<Mall> getAllMalls() {
        return mallService.getAllMalls();
    }

    /**
     * Handles GET requests to the endpoint with a specified ID, returning a single mall.
     *
     * @param id The ID of the mall to retrieve.
     * @return The mall with the given ID, or a 404 Not Found response if not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Mall> getMallById(@PathVariable Long id) {
        Mall mall = mallService.getMallById(id);
        return ResponseEntity.ok(mall);
    }

    /**
     * Handles POST requests to the root endpoint, creating a new mall.
     *
     * @param mall The mall object to create.
     * @return The created mall object.
     */
    @PostMapping
    public ResponseEntity<Mall> createMall(@RequestBody Mall mall) {
        Mall createdMall = mallService.createMall(mall);
        return ResponseEntity.ok(createdMall);
    }

    /**
     * Handles PUT requests to the endpoint with a specified ID, updating an existing mall.
     *
     * @param id The ID of the mall to update.
     * @param mall The updated mall object.
     * @return The updated mall object.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Mall> updateMall(@PathVariable Long id, @RequestBody Mall mall) {
        Mall updatedMall = mallService.updateMall(id, mall);
        return ResponseEntity.ok(updatedMall);
    }

    /**
     * Handles DELETE requests to the endpoint with a specified ID, deleting a mall.
     *
     * @param id The ID of the mall to delete.
     * @return A 204 No Content response indicating successful deletion.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMall(@PathVariable Long id) {
        mallService.deleteMall(id);
        return ResponseEntity.noContent().build();
    }
}