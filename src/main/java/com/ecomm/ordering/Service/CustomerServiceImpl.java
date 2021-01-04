package com.ecomm.ordering.Service;

import com.ecomm.ordering.Entities.Customer;
import com.ecomm.ordering.Repository.CustomerRepository;
import java.util.Optional;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{

  @Resource
  private CustomerRepository customerRepository;

  @Override
  public Optional<Customer> findByCustomerId(Long id) {
    return customerRepository.findById(id);
  }
}
