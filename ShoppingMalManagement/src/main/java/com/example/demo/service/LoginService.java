package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Login;
import com.example.demo.repository.LoginRepository;

/**
 * This class serves as a service component for managing login credentials.
 * It provides methods for retrieving, creating, updating, and deleting login information.
 */
@Service
public class LoginService {

    /**
     * Injects the LoginRepository bean for interacting with the login data store (likely a database).
     */
    @Autowired
    private LoginRepository loginRepository;

    /**
     * Retrieves a list of all login credentials from the repository.
     *
     * @return A list of all Login objects.
     */
    public List<Login> getAllLogins() {
        return loginRepository.findAll();
    }

    /**
     * Retrieves a login by its user ID from the repository.
     *
     * @param userId The ID of the user to retrieve the login for.
     * @return The Login object if found, or null if not found.
     */
    public Login getLoginById(Long userId) {
        return loginRepository.findById(userId).orElse(null);
    }

    /**
     * Creates a new login credential and saves it to the repository.
     *
     * @param login The Login object to create.
     * @return The created Login object.
     */
    public Login createLogin(Login login) {
        return loginRepository.save(login);
    }

    /**
     * Updates an existing login credential with the provided details.
     *
     * @param userId The ID of the user whose login needs to be updated.
     * @param login The updated Login object containing new details.
     * @return The updated Login object if successful, or null if the original login wasn't found.
     */
    public Login updateLogin(Long userId, Login login) {
        Login existingLogin = loginRepository.findById(userId).orElse(null);
        if (existingLogin != null) {
            // Update only the username from the provided Login object
            existingLogin.setUserName(login.getUserName());

            return loginRepository.save(existingLogin);
        }
        return null;
    }

    /**
     * Deletes a login credential from the repository based on the user's ID.
     *
     * @param userId The ID of the user whose login needs to be deleted.
     */
    public void deleteLogin(Long userId) {
        loginRepository.deleteById(userId);
    }
}