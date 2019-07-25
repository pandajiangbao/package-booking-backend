package com.oocl.packagebooking.controller;

import com.oocl.packagebooking.entity.PackageOrder;
import com.oocl.packagebooking.repository.PackageOrderRepository;
import com.oocl.packagebooking.service.PackageOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/package-orders")
@CrossOrigin(value = "*")
public class PackageOrderController {
    @Autowired
    private PackageOrderService packageOrderService;
    @GetMapping
    public ResponseEntity findAll(){
        return ResponseEntity.ok(packageOrderService.findAllPackageOrders());
    }
    @PostMapping
    public ResponseEntity createPackageOrder(@RequestBody PackageOrder packageOrder){
        return packageOrderService.createPackageOrder(packageOrder)?ResponseEntity.ok().build():ResponseEntity.badRequest().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity updateStatus(@PathVariable Integer id,@RequestBody PackageOrder packageOrder){
        return ResponseEntity.ok(packageOrderService.updatePackageOrder(id,packageOrder));
    }

    @PatchMapping()
    public ResponseEntity updateBookingTime(@RequestBody PackageOrder packageOrder){
        return ResponseEntity.ok(packageOrderService.updateBookingTime(packageOrder));
    }
}
