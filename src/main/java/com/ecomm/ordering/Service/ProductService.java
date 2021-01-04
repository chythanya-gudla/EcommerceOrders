package com.ecomm.ordering.Service;

import com.ecomm.ordering.Entities.Product;
import java.util.Optional;

public interface ProductService {

  Optional<Product> findByProductId(Long id);
}
