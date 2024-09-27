package com.example.demo.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Login;
import com.example.demo.repository.LoginRepository;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

   
    public List<Login> getAllLogins() {
        return loginRepository.findAll();
    }

    
    public Login getLoginById(Long userId) {
        return loginRepository.findById(userId).orElse(null);
    }

    
    public Login createLogin(Login login) {
        return loginRepository.save(login);
    }

    
    public Login updateLogin(Long userId, Login login) {
        Login existingLogin = loginRepository.findById(userId).orElse(null);
        if (existingLogin != null) {
            existingLogin.setUserName(login.getUserName());
            return loginRepository.save(existingLogin);
        }
        return null;
    }

    
    public void deleteLogin(Long userId) {
        loginRepository.deleteById(userId);
    }
}

