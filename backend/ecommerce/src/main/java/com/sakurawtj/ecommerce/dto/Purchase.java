package com.sakurawtj.ecommerce.dto;

import com.sakurawtj.ecommerce.entity.Address;
import com.sakurawtj.ecommerce.entity.Customer;
import com.sakurawtj.ecommerce.entity.Order;
import com.sakurawtj.ecommerce.entity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {
    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;
}
