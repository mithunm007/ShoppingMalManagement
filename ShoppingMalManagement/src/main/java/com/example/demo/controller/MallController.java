package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Mall;
import com.example.demo.service.MallService;

import java.util.List;

@RestController
@RequestMapping("/malls")
public class MallController {

    @Autowired
    private MallService mallService;

    @GetMapping
    public List<Mall> getAllMalls() {
        return mallService.getAllMalls();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mall> getMallById(@PathVariable Long id) {
        Mall mall = mallService.getMallById(id);
        return ResponseEntity.ok(mall);
    }

    @PostMapping
    public ResponseEntity<Mall> createMall(@RequestBody Mall mall) {
        Mall createdMall = mallService.createMall(mall);
        return ResponseEntity.ok(createdMall);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mall> updateMall(@PathVariable Long id, @RequestBody Mall mall) {
        Mall updatedMall = mallService.updateMall(id, mall);
        return ResponseEntity.ok(updatedMall);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMall(@PathVariable Long id) {
        mallService.deleteMall(id);
        return ResponseEntity.noContent().build();
    }
}

