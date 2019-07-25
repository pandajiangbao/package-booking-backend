package com.oocl.packagebooking.controller;

import com.oocl.packagebooking.repository.PackageOrderRepository;
import com.oocl.packagebooking.repository.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/packages")
public class PackageController {
    @Autowired
    private PackageRepository packageRepository;
    @GetMapping
    public ResponseEntity findAll(){
        return ResponseEntity.ok(packageRepository.findAll());
    }
}
