package jpa.domain;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;

@Embeddable // no id because this class is embeddable
@AttributeOverrides({
  @AttributeOverride(name = "name", column = @Column(name = "weight_name")),
  @AttributeOverride(name = "symbol", column = @Column(name = "weight_symbol")),
})
public class Weight extends Measurment {
  @NotNull
  private double weight;

  public Weight() {}

  public Weight(@NotNull double weight) {
    this.name = "WEIGHT";
    this.symbol = "W";
    this.weight = weight;
  }

  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

  @Override
  public String toString() {
    return "Weight [weight=" + weight + "]";
  }

}
