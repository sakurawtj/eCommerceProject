package com.sakurawtj.ecommerce.service;

import com.sakurawtj.ecommerce.dao.CustomerRepository;
import com.sakurawtj.ecommerce.dto.Purchase;
import com.sakurawtj.ecommerce.dto.PurchaseResponse;
import com.sakurawtj.ecommerce.entity.Customer;
import com.sakurawtj.ecommerce.entity.Order;
import com.sakurawtj.ecommerce.entity.OrderItem;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;
@Service
public class CheckoutServiceImpl implements CheckoutService {
    private CustomerRepository customerRepository;

    public CheckoutServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
        // retrieve the order info from dto
        Order order = purchase.getOrder();
        // generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        // populate order with orderItems
        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(item -> order.add(item));
        // populate order with address
        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());
        // populate the customer with order
        Customer customer = purchase.getCustomer();
        customer.add(order);
        // save to db
        customerRepository.save(customer);
        // return a response
        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}
