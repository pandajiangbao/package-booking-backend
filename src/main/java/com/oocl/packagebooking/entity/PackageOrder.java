package com.oocl.packagebooking.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PackageOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String orderNumber;
    private String receiver;
    private String phoneNumber;
    private String status;
    private Double weight;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date bookingTime;

    public PackageOrder(String orderNumber, String receiver, String phoneNumber, String status, Double weight, Date bookingTime) {
        this.orderNumber = orderNumber;
        this.receiver = receiver;
        this.phoneNumber = phoneNumber;
        this.status = status;
        this.weight = weight;
        this.bookingTime = bookingTime;
    }
}
