package jpa.domain;

import java.io.Serializable;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.OrderColumn;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;

@Entity(name = "item")
public class Item implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private Dimention dimention;
  private Weight weight;

  @ElementCollection(fetch = FetchType.EAGER)
  @CollectionTable(name = "image-kristina", joinColumns = @JoinColumn(name = "item_id"))
  @Column(name = "fileimage")
  @MapKeyColumn(name = "imagename") // if not specified it will be done automatically
  private Map<ImageName, Image> images = new HashMap<>();

  @OneToMany(mappedBy = "item", fetch = FetchType.EAGER)
  private Set<Bid> bids = new HashSet<>();

  public Item() {}
  
  public Item(Dimention dimention, Weight weight, Map<ImageName, Image> images) {
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

  public Long getId() {
    return id;
  }

  public void setBids(Set<Bid> bids) {
    this.bids = bids;
  }

  public Set<Bid> getBids() {
    return bids;
  }

  public Map<ImageName, Image> getImages() {
    return images;
  }
  public void setImages(Map<ImageName, Image> images) {
    this.images = images;
  }

  @Override
  public String toString() {
    return "Item [id=" + id + ", dimention=" + dimention + ", weight=" + weight + ", images=" + images + "]";
  }
}
