package jpa.domain.kristinaTest;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="recipe")
public class Recipe {
  @Id
  private Long id;
  private String name;

  public Recipe() {}
  public Recipe(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Recipe [id=" + id + ", name=" + name + "]";
  }
}
