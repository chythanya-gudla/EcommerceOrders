package com.ecomm.ordering.Service;

import com.ecomm.ordering.Entities.Customer;
import java.util.Optional;

public interface CustomerService {

  Optional<Customer> findByCustomerId(Long id);
}
