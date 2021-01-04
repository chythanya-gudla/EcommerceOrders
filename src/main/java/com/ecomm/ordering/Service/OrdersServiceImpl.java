package com.ecomm.ordering.Service;

import com.ecomm.ordering.BulkStatusUpdateDTO;
import com.ecomm.ordering.CartItemDTO;
import com.ecomm.ordering.Entities.CartItem;
import com.ecomm.ordering.Entities.Order;
import com.ecomm.ordering.Entities.PaymentDetails;
import com.ecomm.ordering.Entities.Product;
import com.ecomm.ordering.OrderStatus;
import com.ecomm.ordering.OrderSummaryDTO;
import com.ecomm.ordering.OrderUtils;
import com.ecomm.ordering.Repository.OrderRepository;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrdersServiceImpl implements OrdersService {

  @Resource private OrderRepository orderRepository;

  @Resource private ProductService productService;

  @Resource private CustomerService customerService;

  @Override
  public Optional<Order> findByOrderId(Long id) {
    return orderRepository.findById(id);
  }

  @Override
  @Transactional
  public Iterable<Order> saveOrders(List<OrderSummaryDTO> orderSummaryDTOs) {

    List<Order> orders = new ArrayList<>();
    for (OrderSummaryDTO orderSummaryDTO : orderSummaryDTOs) {
      Order order = new Order();
      Order updatedOrder = saveOrUpdateOrder(order, orderSummaryDTO);
      orders.add(updatedOrder);
    }
    return orderRepository.saveAll(orders);
  }

  @Override
  public OrderStatus getOrderStatus(Long id) {
    Optional<Order> order = orderRepository.findById(id);
    return order.get().getStatus();
  }

  @Override
  public OrderStatus cancelOrder(Long id) {
    Order order = orderRepository.findById(id).get();
    if (order.getStatus() != OrderStatus.CANCELLED) {
      order.setStatus(OrderStatus.CANCELLED);
    }
    orderRepository.save(order);
    return order.getStatus();
  }

  @Override
  public String updateBulkOrderStatus(BulkStatusUpdateDTO bulkStatusUpdateDTO) {
    List<Order> updatedStatus = new ArrayList<>();
    for (Long id : bulkStatusUpdateDTO.getIds()){
      Order order = orderRepository.findById(id).get();
      order.setStatus(bulkStatusUpdateDTO.getOrderStatus());
      updatedStatus.add(order);
    }
    orderRepository.saveAll(updatedStatus);
    return "Successfully updated status of all orders to " + bulkStatusUpdateDTO.getOrderStatus();
  }

  public Order saveOrUpdateOrder(Order order, OrderSummaryDTO orderSummaryDTO) {
    Double shippingCharge = OrderUtils.shippingChargeMap.get(orderSummaryDTO.getShippingZip());
    Double tax = OrderUtils.taxMap.get(orderSummaryDTO.getShippingZip());
    Double totalPrice = 0.0;
    Set<CartItemDTO> cartItemsDTO = orderSummaryDTO.getCartItems();
    Set<CartItem> cartItems = new HashSet<>();
    Set<PaymentDetails> paymentDetails = new HashSet<>();

    order.setCustomer(customerService.findByCustomerId(orderSummaryDTO.getCustomerId()).get());
    for (PaymentDetails paymentDetail : orderSummaryDTO.getPaymentDetails()) {
      paymentDetails.add(
          new PaymentDetails(
              paymentDetail.getBillingAddressLine1(),
              paymentDetail.getBillingAddressLine2(),
              paymentDetail.getBillingCity(),
              paymentDetail.getBillingState(),
              paymentDetail.getBillingZip(),
              order));
    }
    order.setPaymentDetails(paymentDetails);
    for (CartItemDTO cartItemDTO : cartItemsDTO) {
      Optional<Product> product = productService.findByProductId(cartItemDTO.getProductId());
      totalPrice = totalPrice + (product.get().getPrice() * cartItemDTO.getQuantity());
      cartItems.add(new CartItem(cartItemDTO.getQuantity(), order, product.get()));
    }
    order.setCartItems(cartItems);
    order.setPaymentType(orderSummaryDTO.getPaymentType());
    order.setShippingType(orderSummaryDTO.getShippingType());
    order.setShippingAddressLine1(orderSummaryDTO.getShippingAddressLine1());
    order.setShippingAddressLine2(orderSummaryDTO.getShippingAddressLine2());
    order.setShippingCity(orderSummaryDTO.getShippingCity());
    order.setShippingState(orderSummaryDTO.getShippingState());
    order.setShippingZip(orderSummaryDTO.getShippingZip());
    order.setShippingCharge(shippingCharge);
    order.setTax(tax);
    order.setTotalAmount(tax + shippingCharge + totalPrice);
    order.setStatus(OrderStatus.COMPLETED);
    order.setPaymentConfirmationNumber(UUID.randomUUID());
    return order;
  }
}
