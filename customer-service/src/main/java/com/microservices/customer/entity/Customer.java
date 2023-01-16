package com.microservices.customer.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long customerId;
    @Column(name = "first_name", nullable = false)
    private String customerName;
    @Column(name = "last_name", nullable = false)
    private String customerSurname;
    @Column(name = "email_address", nullable = false)
    private String customerAddress;

}
