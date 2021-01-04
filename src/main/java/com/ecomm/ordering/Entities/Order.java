package com.ecomm.ordering.Entities;

import com.ecomm.ordering.OrderStatus;
import com.ecomm.ordering.PaymentType;
import com.ecomm.ordering.ShippingType;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column
  @Enumerated(EnumType.STRING)
  private OrderStatus status;

  @Column private Double totalAmount;

  @Column private Double shippingCharge;

  @Column private Double tax;

  @Column @CreationTimestamp private Date createdDate;

  @Column @UpdateTimestamp private Date modifiedDate;

  @Column
  @Enumerated(EnumType.STRING)
  @NotNull(message= "Shipping type must not be null")
  private ShippingType shippingType;

  @Column
  @Enumerated(EnumType.STRING)
  private PaymentType paymentType;

  @Column @CreationTimestamp private Date paymentDate;

  @Column
  private UUID paymentConfirmationNumber;

  @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
  private Set<CartItem> cartItems = new HashSet<>();

  @ManyToOne
  @JoinColumn(name = "customer_id", referencedColumnName = "id")
  private Customer customer;

  @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
  private Set<PaymentDetails> paymentDetails = new HashSet<>();

  @Column private String shippingAddressLine1;

  @Column private String shippingAddressLine2;

  @Column private String shippingCity;

  @Column private String shippingState;

  @Column private String shippingZip;

  public ShippingType getShippingType() {
    return shippingType;
  }

  public void setShippingType(ShippingType shippingType) {
    this.shippingType = shippingType;
  }

  public Set<CartItem> getCartItems() {
    return cartItems;
  }

  public void setCartItems(Set<CartItem> cartItems) {
    this.cartItems = cartItems;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public Set<PaymentDetails> getPaymentDetails() {
    return paymentDetails;
  }

  public void setPaymentDetails(Set<PaymentDetails> paymentDetails) {
    this.paymentDetails = paymentDetails;
  }

  public PaymentType getPaymentType() {
    return paymentType;
  }

  public void setPaymentType(PaymentType paymentType) {
    this.paymentType = paymentType;
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

  public Double getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(Double totalAmount) {
    this.totalAmount = totalAmount;
  }

  public Double getShippingCharge() {
    return shippingCharge;
  }

  public void setShippingCharge(Double shippingCharge) {
    this.shippingCharge = shippingCharge;
  }

  public Double getTax() {
    return tax;
  }

  public void setTax(Double tax) {
    this.tax = tax;
  }

  public OrderStatus getStatus() {
    return status;
  }

  public void setStatus(OrderStatus status) {
    this.status = status;
  }

  public UUID getPaymentConfirmationNumber() {
    return paymentConfirmationNumber;
  }

  public void setPaymentConfirmationNumber(UUID paymentConfirmationNumber) {
    this.paymentConfirmationNumber = paymentConfirmationNumber;
  }

  public Long getId() {
    return id;
  }
}
