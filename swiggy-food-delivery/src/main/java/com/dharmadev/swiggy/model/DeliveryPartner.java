package com.dharmadev.swiggy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "delivery_partner")
public class DeliveryPartner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer deliveryId;

    @NotBlank(message = "Delivery partner name is required")
    @NotNull(message = "Delivery partner name is required")
    @Size(min = 2, max = 100, message = "Delivery partner name must be between 2 and 100 characters")
    @Column(name = "delivery_partner_name")
    private String deliveryPartnerName;

    @NotBlank(message = "Address is required")
    @NotNull(message = "Address is required")
    @Size(min = 5, max = 255, message = "Address must be between 5 and 255 characters")
    private String address;
    @OneToMany(mappedBy = "deliveryPartner", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<OrderEntity> orders=new ArrayList<>();

    @ManyToMany

    @JsonIgnore
    private List<Restaurant> restaurants=new ArrayList<>();

}