package jpa;

import java.io.Serializable; // marker interface
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

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


  
  private String name;
  private String gender;
  private LocalDate dob;
  private String address;
  private String billing;

  public Customer() {}

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

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
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
