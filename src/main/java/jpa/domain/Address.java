package jpa.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;


@Embeddable
public class Address {
  // there is no id, because it is an embeded value object
  @NotNull
  @Column(name = "street", nullable = false)
  private String street;
  
  @NotNull
  @AttributeOverrides({
    @AttributeOverride(name = "name", column = @Column(name = "city_name")),
  })
  private City city;


  public Address() {} // for JPA

  public Address(String street, City city) {
    this.street = street;
    this.city = city;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public City getCity() {
    return city;
  }

  public void setCity(City city) {
    this.city = city;
  }

  @Override
  public String toString() {
    return "Address [street=" + street + ", city=" + city + "]";
  } 
}
