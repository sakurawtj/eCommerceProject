package com.sakurawtj.ecommerce.dao;

import com.sakurawtj.ecommerce.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
