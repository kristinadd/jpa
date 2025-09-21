package jpa.domain;

import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;

@MappedSuperclass
public abstract class Measurment {

  @NotNull
  protected String name; // to be visible for the subclasses

  @NotNull
  protected String symbol;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSymbol() {
    return symbol;
  }

  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }

  @Override
  public String toString() {
    return "Measurment [name=" + name + ", symbol=" + symbol + "]";
  }
}
