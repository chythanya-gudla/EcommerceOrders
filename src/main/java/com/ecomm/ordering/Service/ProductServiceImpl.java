package com.ecomm.ordering.Service;

import com.ecomm.ordering.Entities.Product;
import com.ecomm.ordering.Repository.ProductRepository;
import java.util.Optional;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

  @Resource
  private ProductRepository productRepository;

  @Override
  public Optional<Product> findByProductId(Long id) {
    return productRepository.findById(id);
  }
}
