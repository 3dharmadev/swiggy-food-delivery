package com.dharmadev.swiggy.service;

import com.dharmadev.swiggy.exception.DeliveryPartnerException;
import com.dharmadev.swiggy.model.DeliveryPartner;
import com.dharmadev.swiggy.repository.DeliveryPartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    @Autowired
    private DeliveryPartnerRepository deliveryPartnerRepository;
    @Override
    public DeliveryPartner addDeliveryPartner(DeliveryPartner deliveryPartner) throws DeliveryPartnerException {
        if(deliveryPartner==null){
            throw new DeliveryPartnerException("Delivery Partner details cannot be null");
        }
        if(deliveryPartnerRepository.existsById(deliveryPartner.getDeliveryId())){
            throw new DeliveryPartnerException("Delivery Partner with id " + deliveryPartner.getDeliveryId() + " already exists");
        }
        return deliveryPartnerRepository.save(deliveryPartner);
    }

    @Override
    public DeliveryPartner getDeliveryPartner(int deliveryId) throws DeliveryPartnerException {

        Optional<DeliveryPartner> optional =deliveryPartnerRepository.findById(deliveryId);
        if(optional.isEmpty()){
            throw new DeliveryPartnerException("Delivery Partner with id " + deliveryId + " not found");

        }
        else {
            return optional.get();
        }
    }

    @Override
    public DeliveryPartner updateDeliveryPartner(int deliveryId, DeliveryPartner updatedDeliveryPartner) throws DeliveryPartnerException {
        Optional<DeliveryPartner> optional    = deliveryPartnerRepository.findById(deliveryId);
                if(optional.isEmpty()){
                    throw new DeliveryPartnerException("Delivery Partner with id " + deliveryId + " not found");

                }
                else{
                    DeliveryPartner deliveryPartner=optional.get();
                    deliveryPartner.setDeliveryPartnerName(updatedDeliveryPartner.getDeliveryPartnerName());
                    deliveryPartner.setAddress(updatedDeliveryPartner.getAddress());

                    return deliveryPartnerRepository.save(deliveryPartner);
                }

    }

    @Override
    public DeliveryPartner deleteDeliveryPartner(int deliveryId) throws DeliveryPartnerException {
        Optional<DeliveryPartner> optionalDeliveryPartner = deliveryPartnerRepository.findById(deliveryId);
        if (optionalDeliveryPartner.isEmpty()) {
            throw new DeliveryPartnerException("Delivery Partner with id " + deliveryId + " not found");
        } else {
            DeliveryPartner deletedDeliveryPartner = optionalDeliveryPartner.get();
            deliveryPartnerRepository.deleteById(deliveryId);
            return deletedDeliveryPartner;
        }
    }
}