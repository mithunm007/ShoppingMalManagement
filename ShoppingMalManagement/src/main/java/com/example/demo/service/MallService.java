package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Mall;
import com.example.demo.repository.MallRepository;

/**
 * This class serves as a service component for managing mall data.
 * It provides methods for retrieving, creating, updating, and deleting mall information.
 */
@Service
public class MallService {

    /**
     * Injects the MallRepository bean for interacting with the mall data store (likely a database).
     */
    @Autowired
    private MallRepository mallRepository;

    /**
     * Retrieves a list of all malls from the repository.
     *
     * @return A list of all Mall objects.
     */
    public List<Mall> getAllMalls() {
        return mallRepository.findAll();
    }

    /**
     * Retrieves a mall by its ID from the repository.
     *
     * @param mallId The ID of the mall to retrieve.
     * @return The Mall object if found, or null if not found.
     */
    public Mall getMallById(Long mallId) {
        return mallRepository.findById(mallId).orElse(null);
    }

    /**
     * Creates a new mall and saves it to the repository.
     *
     * @param mall The Mall object to create.
     * @return The created Mall object.
     */
    public Mall createMall(Mall mall) {
        return mallRepository.save(mall);
    }

    /**
     * Updates an existing mall with the provided details.
     *
     * @param mallId The ID of the mall to update.
     * @param mall The updated Mall object containing new details.
     * @return The updated Mall object if successful, or null if the original mall wasn't found.
     */
    public Mall updateMall(Long mallId, Mall mall) {
        Mall existingMall = mallRepository.findById(mallId).orElse(null);
        if (existingMall != null) {
            // Update both mall name and location from the provided Mall object
            existingMall.setMallName(mall.getMallName());
            existingMall.setMallLocation(mall.getMallLocation());

            return mallRepository.save(existingMall);
        }
        return null;
    }

    /**
     * Deletes a mall from the repository based on its ID.
     *
     * @param mallId The ID of the mall to delete.
     */
    public void deleteMall(Long mallId) {
        mallRepository.deleteById(mallId);
    }
}