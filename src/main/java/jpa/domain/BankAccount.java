package jpa.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "bank_account")
public class BankAccount extends BillingDetails {

  // @Id
  // // @GeneratedValue(strategy = GenerationType.IDENTITY)
  // protected long id; // use protected to be accessible to the child classes

  @NotNull
  private String accountName;

  @NotNull
  private String bankName;

  @NotNull
  private String swift;

  public BankAccount() {}

  public long getId() {
    return id;
  }

  public String getAccountName() {
    return accountName;
  }

  public void setAccountName(String accountName) {
    this.accountName = accountName;
  }

  public String getBankName() {
    return bankName;
  }

  public void setBankName(String bankName) {
    this.bankName = bankName;
  }

  public String getSwift() {
    return swift;
  }

  public void setSwift(String swift) {
    this.swift = swift;
  }

  @Override
  public String toString() {
    return "BankAccount [id=" + id + ", accountName=" + accountName + ", bankName=" + bankName + ", swift=" + swift
        + "]";
  }
}
