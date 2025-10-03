package jpa.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.Column;

@Entity
@Table(name = "billing_details")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BillingDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected long id; // use protected to be accessible to the child classes

  @NotNull
  @Column(name = "owner", nullable = false)
  private String owner;

  @ManyToOne
  private Customer customer;

  public String getOwner() {
    return owner;
  }
  public void setOwner(String owner) {
    this.owner = owner;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  @Override
  public String toString() {
    return "BillingDetails [id=" + id + ", owner=" + owner + ", customer=" + customer + "]";
  }
}

