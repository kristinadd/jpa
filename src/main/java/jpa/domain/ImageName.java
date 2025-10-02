package jpa.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;

@Embeddable
public class ImageName {
  // this class is embeddable so it doesn't need an ID
  @Column
  private String name;
  private String description;
  
  public ImageName() {}

  public ImageName(String name, String description) {
    this.name = name;
    this.description = description;
  }
  
  public String getName() {
    return name;
  }
  
  public String getDescription() {
    return description;
  }

  public void setName(String name) {
    this.name = name;
  }
  
  public void setDescription(String description) {
    this.description = description;
  } 

  @Override
  public String toString() {
    return "ImageName [name=" + name + ", description=" + description + "]";
  }

  @Override
  public boolean equals(Object object) {
    if (this == object ) return true;
    if (object == null || object.getClass() != this.getClass()) return false;

    ImageName imageName = (ImageName) object;

    if (!this.name.equals(imageName.name)
    || !this.description.equals(imageName.description)) return false;

    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description);
  }
}
