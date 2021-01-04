package com.ecomm.ordering.Controllers;

import com.ecomm.ordering.BulkStatusUpdateDTO;
import com.ecomm.ordering.Entities.Order;
import com.ecomm.ordering.OrderStatus;
import com.ecomm.ordering.OrderSummaryDTO;
import com.ecomm.ordering.Service.OrdersService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

  @Resource private OrdersService ordersService;

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Optional<Order> fetchOrders(@PathVariable final Long id) {
    return ordersService.findByOrderId(id);
  }

  @RequestMapping(value = "/{id}/status", method = RequestMethod.GET)
  public OrderStatus getStatus(@PathVariable final Long id) {
    return ordersService.getOrderStatus(id);
  }

  @RequestMapping(method = RequestMethod.POST)
  public List<Long> placeOrders(@Valid @RequestBody List<OrderSummaryDTO> orderSummaryDTOs) {
    Iterable<Order> savedOrders = ordersService.saveOrders(orderSummaryDTOs);
    return StreamSupport.stream(savedOrders.spliterator(), false)
        .map(savedOrder -> savedOrder.getId())
        .collect(Collectors.toList());
  }

  @RequestMapping(value = "/{id}/cancelOrder", method = RequestMethod.PUT)
  public OrderStatus cancelOrder(@PathVariable final Long id) {
    return ordersService.cancelOrder(id);
  }

  @RequestMapping(value="/bulk/updateStatus", method = RequestMethod.PUT)
  public String updateOrderStatus(@RequestBody BulkStatusUpdateDTO bulkStatusUpdateDTO) {
    return ordersService.updateBulkOrderStatus(bulkStatusUpdateDTO);
  }
}
