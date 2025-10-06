package jpa.domain.kristinaTest;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name = "customer2")
public class Customer2 {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull // Application validation (faster)
  @Column(nullable = false, unique = true, length = 255) // Database validation (slower)
  private String name;

  // Bidirectional relationship - Customer controls Order lifecycle
  @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Set<Order> orders = new HashSet<>();

  public Customer2() {}

  public Customer2(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<Order> getOrders() {
    return orders;
  }

  public void setOrders(Set<Order> orders) {
    this.orders = orders;
  }

  // Helper method to maintain both sides of the relationship
  public void addOrder(Order order) {
    this.orders.add(order);
    order.setCustomer(this); // Maintain both sides
  }

  public void removeOrder(Order order) {
    this.orders.remove(order);
    order.setCustomer(null);
  }

  @Override
  public String toString() {
    return "Customer [Id=" + id + ", name=" + name + "]";
  }
}
