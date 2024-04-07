package com.dharmadev.swiggy.service;

import com.dharmadev.swiggy.exception.DeliveryPartnerException;
import com.dharmadev.swiggy.model.DeliveryPartner;

public interface DeliveryService {
    DeliveryPartner addDeliveryPartner(DeliveryPartner deliveryPartner) throws DeliveryPartnerException;
    DeliveryPartner getDeliveryPartner(int deliveryId) throws DeliveryPartnerException;
    DeliveryPartner updateDeliveryPartner(int deliveryId, DeliveryPartner updatedDeliveryPartner) throws DeliveryPartnerException;
    DeliveryPartner deleteDeliveryPartner(int deliveryId) throws DeliveryPartnerException;
}
