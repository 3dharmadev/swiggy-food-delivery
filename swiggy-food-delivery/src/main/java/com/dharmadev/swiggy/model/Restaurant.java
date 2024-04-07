package com.dharmadev.swiggy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer restaurantId;

    @NotNull(message = "Restaurant name is required")
    @NotBlank(message = "Restaurant name is required")
    @Size(min = 2, max = 100, message = "Restaurant name must be between 2 and 100 characters")
    private String restaurantName;
    @NotNull(message = "Address is required")
    @NotBlank(message = "Address is required")
    @Size(min = 5, max = 255, message = "Address must be between 5 and 255 characters")
    private String address;

    @OneToMany(mappedBy = "restaurant",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<OrderEntity> orders=new ArrayList<>() ;

    @ManyToMany(mappedBy = "restaurants")
    @JsonIgnore
    private List<DeliveryPartner> deliveryPartners=new ArrayList<>();
}
