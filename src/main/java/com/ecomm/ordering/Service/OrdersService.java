package com.ecomm.ordering.Service;

import com.ecomm.ordering.BulkStatusUpdateDTO;
import com.ecomm.ordering.Entities.Order;
import com.ecomm.ordering.OrderStatus;
import com.ecomm.ordering.OrderSummaryDTO;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public interface OrdersService {

  Optional<Order> findByOrderId(Long id);

  Iterable<Order> saveOrders(List<OrderSummaryDTO> orderSummaryDTO);

  OrderStatus getOrderStatus(Long id);

  OrderStatus cancelOrder(Long id);

  String updateBulkOrderStatus(BulkStatusUpdateDTO bulkStatusUpdateDTO);
}
