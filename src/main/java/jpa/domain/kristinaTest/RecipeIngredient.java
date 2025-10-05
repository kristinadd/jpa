package jpa.domain.kristinaTest;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "recipe_ingredient")
public class RecipeIngredient {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long Id;

  @ManyToOne
  @JoinColumn(name = "recipe_id")
  private Recipe recipe;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "ingredient_id")
  private Ingredient ingredient;
  // Many RecipeIngredients can belong to One Ingredient

  private String quantity;

  private String unit;


  public RecipeIngredient() {}

  public RecipeIngredient(Recipe recipe, Ingredient ingredient, String quantity, String unit) {
    this.recipe = recipe;
    this.ingredient = ingredient;
    this.quantity = quantity;
    this.unit = unit;
  }

  public Recipe getRecipe() {
    return recipe;
  }
  
  public Ingredient getIngredients() {
    return ingredient;
  }

  public String getQuantity() {
    return quantity;
  }
  
  public String getUnit() {
    return unit;
  }

  public void setRecipe(Recipe recipe) {
    this.recipe = recipe;
  }
  
  public void setIngredients(Ingredient ingredient) {
    this.ingredient = ingredient;
  }

  public void setQuantity(String quantity) {
    this.quantity = quantity;
  }
  
  public void setUnit(String unit) {
    this.unit = unit;
  }

  @Override
  public String toString() {
    return "RecipeIngredient [Id=" + Id + ", recipe=" + recipe + ", ingredient=" + ingredient + ", quantity=" + quantity + ", unit=" + unit + "]";
  }
}
