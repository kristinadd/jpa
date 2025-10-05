package jpa.domain.kristinaTest;

import jpa.dao.Customer2Dao;

public class Main {
  
  public static void main(String[] args) {

    Customer2Dao customer2Dao = new Customer2Dao();

    Customer2 customer = new Customer2("Kristina");

    customer2Dao.create(customer);

    System.out.println("===============================================================================");

    System.out.println(customer2Dao.readAll());
  }
}