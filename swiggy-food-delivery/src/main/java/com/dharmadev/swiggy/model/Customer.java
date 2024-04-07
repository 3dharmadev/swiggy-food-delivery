package com.dharmadev.swiggy.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer customerId;

    @NotBlank(message = "Username is mandatory")
    @NotNull(message = "Username is mandatory")
    @Column(nullable = false,length = 40)
     private String username;
    
     
    @NotBlank(message = "Email is mandatory")
    @Email(message = "Please provide a valid email")
    @NotNull(message = "Email is mandatory")
    @Column(nullable = false)
     private String email;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<OrderEntity> orders=new ArrayList<>();


}
