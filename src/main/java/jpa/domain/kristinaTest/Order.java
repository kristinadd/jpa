package jpa.domain.kristinaTest;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer_order")
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @Column(nullable = false)
  private String name;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn( // order has the foreign key, order owns the relationship, The entity with the @JoinColumn annotation owns the relationship!
    name = "customer_id", // the column name in the database
    nullable = false
    )
  private Customer2 customer;
  
  public Order() {}

  public Order(String name) {
    this.name = name;
  }

  public Order(String name, Customer2 customer) {
    this.name = name;
    this.customer = customer;
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

  public Customer2 getCustomer() {
    return customer;
  }

  public void setCustomer(Customer2 customer) {
    this.customer = customer;
  }

  @Override
  public String toString() {
    return "Order [id=" + id + ", name=" + name + "]";
  }
}
