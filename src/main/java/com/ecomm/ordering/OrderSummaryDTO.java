package com.ecomm.ordering;

import com.ecomm.ordering.Entities.PaymentDetails;
import java.util.Set;
import javax.validation.constraints.NotNull;

public class OrderSummaryDTO {

  @NotNull(message= "Shipping type must not be null")
  private ShippingType shippingType;

  @NotNull(message= "Payment type must not be null")
  private PaymentType paymentType;
  private Set<CartItemDTO> cartItems;
  private Long customerId;
  private Set<PaymentDetails> paymentDetails;
  private String shippingAddressLine1;
  private String shippingAddressLine2;
  private String shippingCity;
  private String shippingState;
  private String shippingZip;

  public ShippingType getShippingType() {
    return shippingType;
  }

  public void setShippingType(ShippingType shippingType) {
    this.shippingType = shippingType;
  }

  public PaymentType getPaymentType() {
    return paymentType;
  }

  public void setPaymentType(PaymentType paymentType) {
    this.paymentType = paymentType;
  }

  public Set<CartItemDTO> getCartItems() {
    return cartItems;
  }

  public void setCartItems(Set<CartItemDTO> cartItems) {
    this.cartItems = cartItems;
  }

  public Long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }

  public Set<PaymentDetails> getPaymentDetails() {
    return paymentDetails;
  }

  public void setPaymentDetails(Set<PaymentDetails> paymentDetails) {
    this.paymentDetails = paymentDetails;
  }

  public String getShippingAddressLine1() {
    return shippingAddressLine1;
  }

  public void setShippingAddressLine1(String shippingAddressLine1) {
    this.shippingAddressLine1 = shippingAddressLine1;
  }

  public String getShippingAddressLine2() {
    return shippingAddressLine2;
  }

  public void setShippingAddressLine2(String shippingAddressLine2) {
    this.shippingAddressLine2 = shippingAddressLine2;
  }

  public String getShippingCity() {
    return shippingCity;
  }

  public void setShippingCity(String shippingCity) {
    this.shippingCity = shippingCity;
  }

  public String getShippingState() {
    return shippingState;
  }

  public void setShippingState(String shippingState) {
    this.shippingState = shippingState;
  }

  public String getShippingZip() {
    return shippingZip;
  }

  public void setShippingZip(String shippingZip) {
    this.shippingZip = shippingZip;
  }
}
