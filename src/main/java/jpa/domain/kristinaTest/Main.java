package jpa.domain.kristinaTest;

import jpa.dao.Customer2Dao;
import jpa.dao.OrderDao;

public class Main {
  
  public static void main(String[] args) {

    Customer2Dao customer2Dao = new Customer2Dao();
    OrderDao orderDao = new OrderDao();

    Customer2 customer = new Customer2("Kristina");

    customer2Dao.create(customer);

    System.out.println("===============================================================================");

    System.out.println(customer2Dao.readAll());


    Customer2 customer2 = new Customer2("Kristina D");

    Order order = new Order("Order 1");

    // Use the helper method that maintains both sides of the relationship
    customer2.addOrder(order);

    customer2Dao.create(customer2);

    System.out.println("===============================================================================");

    System.out.println(customer2Dao.readAll());

    Order order3 = new Order("Order 3", customer2);

    customer2.addOrder(order3);
    orderDao.create(order3);

    Customer2 testCustomer = new Customer2("Test Customer");

    Order order4 = new Order("Order 4", testCustomer);


    testCustomer.addOrder(order4);

    customer2Dao.create(testCustomer);
    // orderDao.create(order4);
  }
}