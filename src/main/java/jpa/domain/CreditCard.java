package jpa.domain;

import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.DiscriminatorValue;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.Table;
// import jakarta.persistence.PrimaryKeyJoinColumn; // change the id 

@Entity
@Table(name = "credit_card")
// @PrimaryKeyJoinColumn(name = "credit_card_id")
public class CreditCard extends BillingDetails {

  // @Id
  // // @GeneratedValue(strategy = GenerationType.IDENTITY)
  // // protected long id; // use protected to be accessible to the child classes

  @NotNull
  private String cardNumber;

  @NotNull
  private String expMonth;

  @NotNull
  private String expYear;


  public CreditCard() {}


  public CreditCard(String cardNumber, String expMonth, String expYear) {
    this.cardNumber = cardNumber;
    this.expMonth = expMonth;
    this.expYear = expYear;
  }


  public long getId() {
    return id;
  }


  public String getCardNumber() {
    return cardNumber;
  }


  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }


  public String getExpMonth() {
    return expMonth;
  }


  public void setExpMonth(String expMonth) {
    this.expMonth = expMonth;
  }


  public String getExpYear() {
    return expYear;
  }


  public void setExpYear(String expYear) {
    this.expYear = expYear;
  }


  @Override
  public String toString() {
    return "CreditCard [id=" + id + ", cardNumber=" + cardNumber + ", expMonth=" + expMonth + ", expYear=" + expYear
        + "]";
  }
}
