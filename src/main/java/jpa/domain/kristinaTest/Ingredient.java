package jpa.domain.kristinaTest;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ingredient")
public class Ingredient {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  private Long id;

  @Column(nullable = false)
  private String name;

  // mappedBy is the inverse side of the relationship, it means that the relationship is owned by the RecipeIngredient class
  @OneToMany(mappedBy = "ingredient") // mapped by the RecipeIngredients field, the name needs to match the actual field name
  private Set<RecipeIngredient> recipeIngredients;
  // one ingredient can have many recipe ingredients

  public Ingredient() {}

  public Ingredient(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  } 

  @Override
  public String toString() {
    return "Ingredient [id=" + id + ", name=" + name + "]";
  }
}
