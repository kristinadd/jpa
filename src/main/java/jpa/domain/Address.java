package jpa.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.JoinColumn;

import java.util.HashSet;
import java.util.Set;

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

  @ElementCollection(fetch = FetchType.EAGER)
  @CollectionTable(
    name = "contact",
    joinColumns = @JoinColumn(name = "customer_id")
  )
  @Column(name = "name-for-contact")
  private Set<String> contacts = new HashSet<>();
  // address is inside of a customer so it should be a customer id


  public Address() {} // for JPA

  public Address(String street, City city, Set<String> contacts) {
    this.street = street;
    this.city = city;
    this.contacts = contacts;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public Set<String> getContacts() {
    return contacts;
  }

  public void setContacts(Set<String> contacts) {
    this.contacts = contacts;
  }

  public City getCity() {
    return city;
  }

  public void setCity(City city) {
    this.city = city;
  }

  @Override
  public String toString() {
    return "Address [street=" + street + ", city=" + city + ", contacts=" + contacts + "]";
  } 
}
