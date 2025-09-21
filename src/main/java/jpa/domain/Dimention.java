package jpa.domain;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;

@Embeddable // no id because this class is embeddable
@AttributeOverrides({
  @AttributeOverride(name = "name", column = @Column(name = "dimention_name")),
  @AttributeOverride(name = "symbol", column = @Column(name = "dimention_symbol")),
})
public class Dimention extends Measurment {
  @NotNull
  private double depth;

  @NotNull
  private double width;

  @NotNull
  private double height;

  public Dimention() {}

  public Dimention(@NotNull double depth, @NotNull double width, @NotNull double height) {
    this.name = "DIMENTION";
    this.symbol = "D";
    this.depth = depth;
    this.width = width;
    this.height = height;
  }

  public double getDepth() {
    return depth;
  }

  public void setDepth(double depth) {
    this.depth = depth;
  }

  public double getWidth() {
    return width;
  }

  public void setWidth(double width) {
    this.width = width;
  }

  public double getHeight() {
    return height;
  }

  public void setHeight(double height) {
    this.height = height;
  }
  
  @Override
  public String toString() {
    return "Dimention [depth=" + depth + ", width=" + width + ", height=" + height + "]";
  }
}
