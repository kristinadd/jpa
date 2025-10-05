package jpa.domain.kristinaTest;

import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="recipe")
public class Recipe {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false, columnDefinition = "TEXT")
  private String description;

  @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
  private Set<RecipeIngredient> recipeIngredients;

  public Recipe() {}

  public Recipe(String name, String description) {
    this.name = name;
    this.description = description;
    this.recipeIngredients = new HashSet<>();
  }

  public Long getId() {
    return id;
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
  public void addIngredient(RecipeIngredient recipeIngredient) {
    this.recipeIngredients.add(recipeIngredient);
  }

  @Override
  public String toString() {
    return "Recipe [id=" + id + ", name=" + name + ", description=" + description + "]";
  }
}
