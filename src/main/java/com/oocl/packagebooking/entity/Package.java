package com.oocl.packagebooking.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Package {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String receiver;
    private String orderNumber;
    private String phoneNumber;

    public Package(String receiver, String orderNumber, String phoneNumber) {
        this.receiver = receiver;
        this.orderNumber = orderNumber;
        this.phoneNumber = phoneNumber;
    }
}
