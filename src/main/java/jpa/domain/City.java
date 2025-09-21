package jpa.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Embeddable
public class City {
  @NotNull
  @Column(name = "name", nullable = false)
  private String name;
  
  @NotNull
  @Column(name = "country", nullable = false)
  private String country;
  
  @NotNull
  @Size(min = 5, max = 16, message = "Zipcode must be between 5 and 16 characters")
  @Column(name = "zipcode", nullable = false, length = 16)
  private String zipcode;

  public City() {} // for JPA

  public City(String name, String country, String zipcode) {
    this.name = name;
    this.country = country;
    this.zipcode = zipcode;
  }

  public String getCity() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
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
    return "City [name=" + name + ", country=" + country + ", zipcode=" + zipcode + "]";
  }
}
