package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Mall;
import com.example.demo.repository.MallRepository;

@Service
public class  MallService {

    @Autowired
    private MallRepository mallRepository;

    
    public List<Mall> getAllMalls() {
        return mallRepository.findAll();
    }

    
    public Mall getMallById(Long mallId) {
        return mallRepository.findById(mallId).orElse(null);
    }

    
    public Mall createMall(Mall mall) {
        return mallRepository.save(mall);
    }

    
    public Mall updateMall(Long mallId, Mall mall) {
        Mall existingMall = mallRepository.findById(mallId).orElse(null);
        if (existingMall != null) {
            existingMall.setMallName(mall.getMallName());
            existingMall.setMallLocation(mall.getMallLocation());
            return mallRepository.save(existingMall);
        }
        return null;
    }

    
    public void deleteMall(Long mallId) {
        mallRepository.deleteById(mallId);
    }
}

