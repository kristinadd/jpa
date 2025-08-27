package jpa.domain;

import java.io.Serializable; // marker interface
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;

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
  private String gender;

  @Column(name = "date_of_birth")
  private LocalDate dob;

  @Embedded
  private Address address;

  @AttributeOverrides({
    //                  original name,       new name
    @AttributeOverride(name = "street", column = @Column(name = "delivery_street")),
    @AttributeOverride(name = "city", column = @Column(name = "delivery_city")),
    @AttributeOverride(name = "country", column = @Column(name = "delivery_country")),
    @AttributeOverride(name = "zipcode", column = @Column(name = "delivery_zipcode"))
  })
  private Address deliveryAddress;

  @Transient // not managed by the database, not persisted to the database 
  private String billing;

  public Customer() {}
  public Customer(String name, String gender, LocalDate dob, Address address, Address deliveryAddress, String billing) {
    this.name = name;
    this.gender = gender;
    this.dob = dob;
    this.address = address;
    this.deliveryAddress = deliveryAddress;
    this.billing = billing;
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

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
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

  public String getBilling() {
    return billing;
  }

  public void setBilling(String billing) {
    this.billing = billing;
  }

  @Override
  public String toString() {
    return "Customer [id=" + id + ", name=" + name + ", gender=" + gender + ", dob=" + dob + ", address=" + address
        + ", billing=" + billing + "]";
  }
}
