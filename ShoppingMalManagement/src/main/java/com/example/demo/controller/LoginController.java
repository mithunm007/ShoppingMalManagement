package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.Login;
import com.example.demo.service.LoginService;
import java.util.List;

@RestController
@RequestMapping("/logins")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping
    public List<Login> getAllLogins() {
        return loginService.getAllLogins();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Login> getLoginById(@PathVariable Long id) {
        Login login = loginService.getLoginById(id);
        return ResponseEntity.ok(login);
    }

    @PostMapping
    public ResponseEntity<Login> createLogin(@RequestBody Login login) {
        Login createdLogin = loginService.createLogin(login);
        return ResponseEntity.ok(createdLogin);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Login> updateLogin(@PathVariable Long id, @RequestBody Login login) {
        Login updatedLogin = loginService.updateLogin(id, login);
        return ResponseEntity.ok(updatedLogin);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLogin(@PathVariable Long id) {
        loginService.deleteLogin(id);
        return ResponseEntity.noContent().build();
    }
}
