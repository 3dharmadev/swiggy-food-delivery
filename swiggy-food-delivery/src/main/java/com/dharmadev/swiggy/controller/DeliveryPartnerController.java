package com.dharmadev.swiggy.controller;

import com.dharmadev.swiggy.exception.DeliveryPartnerException;
import com.dharmadev.swiggy.model.DeliveryPartner;
import com.dharmadev.swiggy.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/deliverypartners")
public class DeliveryPartnerController {

    @Autowired
    private DeliveryService deliveryService;

    @PostMapping
    public ResponseEntity<DeliveryPartner> addDeliveryPartner(@RequestBody DeliveryPartner deliveryPartner) {
        try {
            DeliveryPartner addedDeliveryPartner = deliveryService.addDeliveryPartner(deliveryPartner);
            return new ResponseEntity<>(addedDeliveryPartner, HttpStatus.CREATED);
        } catch (DeliveryPartnerException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{deliveryId}")
    public ResponseEntity<DeliveryPartner> getDeliveryPartner(@PathVariable int deliveryId) {
        try {
            DeliveryPartner deliveryPartner = deliveryService.getDeliveryPartner(deliveryId);
            return new ResponseEntity<>(deliveryPartner, HttpStatus.OK);
        } catch (DeliveryPartnerException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{deliveryId}")
    public ResponseEntity<DeliveryPartner> updateDeliveryPartner(@PathVariable int deliveryId, @RequestBody DeliveryPartner updatedDeliveryPartner) {
        try {
            DeliveryPartner deliveryPartner = deliveryService.updateDeliveryPartner(deliveryId, updatedDeliveryPartner);
            return new ResponseEntity<>(deliveryPartner, HttpStatus.OK);
        } catch (DeliveryPartnerException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{deliveryId}")
    public ResponseEntity<DeliveryPartner> deleteDeliveryPartner(@PathVariable int deliveryId) {
        try {
            DeliveryPartner deletedDeliveryPartner = deliveryService.deleteDeliveryPartner(deliveryId);
            return new ResponseEntity<>(deletedDeliveryPartner, HttpStatus.OK);
        } catch (DeliveryPartnerException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
