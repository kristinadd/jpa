package jpa;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jpa.dao.BillingDetailsDao;
import jpa.dao.CustomerDao;
import jpa.dao.ItemDao;
import jpa.domain.Address;
import jpa.domain.BankAccount;
import jpa.domain.BillingDetails;
import jpa.domain.City;
import jpa.domain.CreditCard;
import jpa.domain.Customer;
import jpa.domain.Dimention;
import jpa.domain.Gender;
import jpa.domain.Item;
import jpa.domain.Weight;
public class Main {
  public static void main(String[] args) {


    ItemDao dao = new ItemDao();

    Set<String> images = new HashSet<>();
    images.add("image1.jpg");
    images.add("image2.jpg");
    images.add("image3.jpg");
    Item item = new Item(new Dimention(10, 10, 10), new Weight(10), images);
    dao.create(item);

    
    System.out.println(dao.read(1L));

    // City city = new City("Sofia", "Bulgaria", "12345");
    // Address homeAddress = new Address("123 Main St", city);
    // Address deliveryAddress = new Address("123 Main St", city);
    // Set<BillingDetails> billingDetails = new HashSet<>();

    // CreditCard creditCard = new CreditCard("1234567890", "12", "2025");
    // billingDetails.add(creditCard);

    // BankAccount bankAccount = new BankAccount();
    // bankAccount.setAccountName("Savings");
    // bankAccount.setBankName("HSBC");
    // bankAccount.setSwift("1234567890");
    // bankAccount.setOwner("Kristina D");
  
    // billingDetails.add(bankAccount);
    // creditCard.setOwner("Kristina D");
    
    // CustomerDao dao = new CustomerDao();

    // Customer customer = new Customer(
    //   "Kristina D",
    //   Gender.FEMALE,
    //   LocalDate.of(1990, 1, 1),
    //   homeAddress,
    //   deliveryAddress,
    //   billingDetails
    // );

    // creditCard.setCustomer(customer);
    // bankAccount.setCustomer(customer);

    // dao.create(customer);

    // // creditCard.setExpMonth("9");
    // System.out.println(dao.read(1L).getBillingDetails());
    // System.out.println(dao.read(1L).getBillingDetails().iterator().next().getCustomer());
    // System.out.println(dao.readAll());
    // dao.update(customer);
    // System.out.println(dao.read(1L));
    // System.out.println(dao.readAll());
    // dao.delete(customer);
  



    // ================================
    // CRUD operations for Message
    // ================================

    // MessageDao dao = new MessageDao();

    // Message message = new Message();
    // message.setContent("Hello World! It's Tuesday!");
    // dao.create(message);

    // List<Message> messages = dao.findAll();
    // System.out.println(messages);





    // // ================================
    // // CRUD operations
    // // ================================

    // // ================================
    // // Persist a record to the database
    // // ================================

    // EntityManager em = emf.createEntityManager();  // Create an entity manager to interact with the database 
    // EntityTransaction tx = em.getTransaction(); // Create a transaction to interact with the database

    // Message msg = new Message();
    // msg.setContent("Hello World! It's Wednesday!");
    // System.out.println(msg);

    // tx.begin();
    // em.persist(msg);
    // tx.commit();

    // em.close();

    // // ================================
    // // Update a record in the database
    // // ================================

    // EntityManager em2 = emf.createEntityManager();
    // EntityTransaction tx2 = em2.getTransaction();

    // Message message = em2.find(Message.class, 1L);
    // message.setContent("Hello World! Updated");

    // tx2.begin();
    // em2.merge(message);
    // tx2.commit();

    // em2.close(); // detached entity manager

    // // ================================
    // // Delete a record from the database
    // // ================================

    // EntityManager em3 = emf.createEntityManager();
    // EntityTransaction tx3 = em3.getTransaction();
    // Message message3 = em3.find(Message.class, 11L);

    // tx3.begin();
    // em3.remove(message3);
    // tx3.commit();

    // em3.close();

    // // ================================
    // // Query a record from the database
    // // ================================

    // EntityManager em4 = emf.createEntityManager();
    // Message message4 = em4.find(Message.class, 4L);
    // System.out.println(message4);

    // em4.close();

    // // ================================
    // // Query all records from the database (Doesn't require manual cast to Message) New way
    // // ================================

    // EntityManager em5 = emf.createEntityManager();
    // TypedQuery<Message> query = em5.createQuery("SELECT m FROM Message m", Message.class);
    // List<Message> messages = query.getResultList();

    // for (Message message5 : messages) {
    //   System.out.println(message5);
    // }

    // em5.close();

    // // ================================
    // // Query all records from the database with Query String (Requires cast to Message) Old way
    // // ================================

    // EntityManager em6 = emf.createEntityManager();
    // Query query6 = em6.createQuery("SELECT m FROM Message m");
    
    // // @SuppressWarnings("unchecked")
    // List<Message> messages6 = (List<Message>) query6.getResultList();

    // for (Message message6 : messages6) {
    //   System.out.println(message6);
    // }

    // // ================================
    // emf.close();
  }
}
