package jpa.domain;

import java.io.Serializable;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Set;
import java.util.HashSet;

public class Item implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private Dimention dimention;
  private Weight weight;

  @ElementCollection
  @CollectionTable(name = "image", joinColumns = @JoinColumn(name = "item_id"))
  @Column(name = "fileimage")
  private Set<String> images = new HashSet<>();

  public Item() {}
  
  public Item(Dimention dimention, Weight weight, Set<String> images) {
    this.dimention = dimention;
    this.weight = weight;
    this.images = images;
  }

  public Dimention getDimention() {
    return dimention;
  }
  public void setDimention(Dimention dimention) {
    this.dimention = dimention;
  }
  public Weight getWeight() {
    return weight;
  }
  public void setWeight(Weight weight) {
    this.weight = weight;
  }

  public Set<String> getImages() {
    return images;
  }
  public void setImages(Set<String> images) {
    this.images = images;
  }

  @Override
  public String toString() {
    return "Item [dimention=" + dimention + ", weight=" + weight + ", images=" + images + "]";
  }
}
