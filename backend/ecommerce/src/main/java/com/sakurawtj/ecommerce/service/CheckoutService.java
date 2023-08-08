package com.sakurawtj.ecommerce.service;


import com.sakurawtj.ecommerce.dto.Purchase;
import com.sakurawtj.ecommerce.dto.PurchaseResponse;

public interface CheckoutService {
    PurchaseResponse placeOrder(Purchase purchase);
}
