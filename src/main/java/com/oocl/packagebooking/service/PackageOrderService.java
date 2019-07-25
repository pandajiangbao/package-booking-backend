package com.oocl.packagebooking.service;

import com.oocl.packagebooking.entity.PackageOrder;
import com.oocl.packagebooking.repository.PackageOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PackageOrderService {
    @Autowired
    private PackageOrderRepository packageOrderRepository;

    public List<PackageOrder> findAllPackageOrders() {
        return packageOrderRepository.findAll();
    }

    public Optional<PackageOrder> findPackageOrderById(Integer id) {
        return packageOrderRepository.findById(id);
    }

    public Boolean createPackageOrder(PackageOrder packageOrder){
        packageOrder.setStatus("未预约");
        try{
            packageOrderRepository.saveAndFlush(packageOrder);
            return true;
        }catch (Exception e){
            throw new RuntimeException("PackageOrder不能重复");
        }
    }
    public PackageOrder updatePackageOrder(Integer id,PackageOrder packageOrder) {
        packageOrder.setId(id);
        return packageOrderRepository.saveAndFlush(packageOrder);
    }

    public PackageOrder updateBookingTime(PackageOrder packageOrder) {
        PackageOrder result = packageOrderRepository.findByOrderNumber(packageOrder.getOrderNumber());
        result.setBookingTime(packageOrder.getBookingTime());
        result.setStatus("已预约");
        return packageOrderRepository.saveAndFlush(result);
    }

    public Boolean deletePackageOrderById(Integer id) {
        packageOrderRepository.deleteById(id);
        return !packageOrderRepository.findById(id).isPresent();
    }
}
