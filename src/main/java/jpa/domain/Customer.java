package jpa.domain;

import java.io.Serializable; // marker interface
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
// import jakarta.persistence.OneToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
// import jakarta.persistence.Transient;
import jakarta.persistence.CascadeType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.EnumType;

// for one to many relationship
import java.util.Set;
import java.util.HashSet;

// the address needs to be object
// customer DAO
// embeded value object, address should not have an id at all
// compossition obkect 

@Entity
@Table(name = "customer") // database table name, never plural, and use underscore for spaces
public class Customer implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
  private long id; // java automatically turns the long into Long object , has a default value of 0


  @NotNull
  @Size(min = 3, max = 128, message = "Name must be between 3 and 128 characters")
  @Column(nullable = false, unique = true, length = 255)
  private String name;

  @Enumerated(EnumType.STRING)
  private Gender gender;

  @Column(name = "date_of_birth")
  private LocalDate dob;

  @Embedded
  private Address address;

  @AttributeOverrides({
    //                  original name,       new name
    @AttributeOverride(name = "street", column = @Column(name = "delivery_street")),
    @AttributeOverride(name = "city.name", column = @Column(name = "delivery_city_name")),
    @AttributeOverride(name = "city.country", column = @Column(name = "delivery_city_country")),
    @AttributeOverride(name = "city.zipcode", column = @Column(name = "delivery_city_zipcode"))
  })
  private Address deliveryAddress;


  // @OneToOne(cascade = CascadeType.ALL)
  // @JoinColumn(name = "billing_details")
  // @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER) // the default is EAGER if not specified; LAZY but there is an issue with the session.


  @OneToMany(cascade = CascadeType.ALL, fetch =FetchType.EAGER) // for one customer there are many billing details // needs to be a collection. 
  private Set<BillingDetails> billingDetails  = new HashSet<>();
  // Set - no duplicates, no order
  // List - duplicates, order
  // Map - key, value
  

  public Customer() {}

  public Customer(String name, Gender gender, LocalDate dob, Address address, Address deliveryAddress, Set<BillingDetails> billingDetails) {
    this.name = name;
    this.gender = gender;
    this.dob = dob;
    this.address = address;
    this.deliveryAddress = deliveryAddress;
    this.billingDetails = billingDetails;
  }

  public long getId() {
    return id;
  }

  // identity should never be chnaged, the classs shoudn't have setId method !!!
  // public void setId(long id) {
  //   this.id = id;
  // }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public LocalDate getDob() {
    return dob;
  }

  public void setDob(LocalDate dob) {
    this.dob = dob;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public Address getDeliveryAddress() {
    return deliveryAddress;
  }

  public void setDeliveryAddress(Address deliveryAddress) {
    this.deliveryAddress = deliveryAddress;
  }

  public Set<BillingDetails> getBillingDetails() {
    return billingDetails;
  }

  public void setBillingDetails(Set<BillingDetails> billingDetails) {
    this.billingDetails = billingDetails;
  }

  @Override
  public String toString() {
    return "Customer [id=" + id + ", name=" + name + ", gender=" + gender + ", dob=" + dob + ", address=" + address
        + ", billingDetails=" + billingDetails + "]";
  }
}
