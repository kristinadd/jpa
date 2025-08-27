package jpa.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Embeddable
public class Address {
  // there is no id, because it is an embeded value object
  @NotNull
  @Column(name = "street", nullable = false)
  private String street;
  
  @NotNull
  @Column(name = "city", nullable = false)
  private String city;
  
  @NotNull
  @Column(name = "country", nullable = false)
  private String country;
  
  @NotNull
  @Size(min = 5, max = 16, message = "Zipcode must be between 5 and 16 characters")
  @Column(name = "zipcode", nullable = false, length = 16)
  private String zipcode;

  public Address() {} // for JPA

  public Address(String street, String city, String country, String zipcode) {
    this.street = street;
    this.city = city;
    this.country = country;
    this.zipcode = zipcode;
  }

  
  public String getStreet() {
    return street;
  }
  public void setStreet(String street) {
    this.street = street;
  }
  public String getCity() {
    return city;
  }
  public void setCity(String city) {
    this.city = city;
  }
  public String getCountry() {
    return country;
  }
  public void setCountry(String country) {
    this.country = country;
  }
  public String getZipcode() {
    return zipcode;
  }
  public void setZipcode(String zipcode) {
    this.zipcode = zipcode;
  }

  @Override
  public String toString() {
    return "Address [street=" + street + ", city=" + city + ", country=" + country + ", zipcode=" + zipcode + "]";
  }
}
