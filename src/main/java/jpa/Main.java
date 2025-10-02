package jpa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jpa.dao.BidDao;
import jpa.dao.BillingDetailsDao;
import jpa.dao.CustomerDao;
import jpa.dao.ItemDao;
import jpa.domain.Address;
import jpa.domain.BankAccount;
import jpa.domain.Bid;
import jpa.domain.BillingDetails;
import jpa.domain.City;
import jpa.domain.CreditCard;
import jpa.domain.Customer;
import jpa.domain.Dimention;
import jpa.domain.Gender;
import jpa.domain.Image;
import jpa.domain.ImageName;
import jpa.domain.Item;
import jpa.domain.Weight;
public class Main {
  public static void main(String[] args) {


    BidDao bidDao = new BidDao();
    ItemDao itemDao = new ItemDao();
    Item item = new Item();
    itemDao.create(item);
    Bid bid = new Bid(item, 100000000);
    Bid bid2 = new Bid(item, 200000000);



    bidDao.create(bid);
    bidDao.create(bid2);
    System.out.println(bidDao.read(1L));
    System.out.println(bidDao.read(2L));


    List<Bid> bids = bidDao.readAll();
    System.out.println("✅ All bids: ");
    System.out.println(bids);


    bid2.setAmount(300000000);
    bidDao.update(bid2);
    System.out.println("✅ Updated bid: ");
    System.out.println(bidDao.read(2L));

    bidDao.delete(bid2);
    List<Bid> bids2 = bidDao.readAll();
    System.out.println("✅ All bids: " + bids2);



    Item item3 = new Item();
    itemDao.create(item3);
    Bid bid3 = new Bid(item3, 400000000);
    Bid bid4 = new Bid(item3, 500000000);
    bidDao.create(bid3);
    bidDao.create(bid4);
    System.out.println("✅ Bid: " + bidDao.read(3L));


    List<Bid> bidsList = bidDao.findByItemId(item3.getId());
    System.out.println("✅ Bids list: " + bidsList);

    Set<Bid> bidsSet = item3.getBids();
    System.out.println("✅ Bids set: " + bidsSet);















    // CustomerDao customerDao = new CustomerDao();

    // Set<String> contacts = new HashSet<>();
    // contacts.add("1234567890");
    // contacts.add("0987654321");
    // Address address = new Address("123 Main St", new City("Sofia", "Bulgaria", "12345"), contacts);
    // Address deliveryAddress = new Address("456 Delivery St", new City("Sofia", "Bulgaria", "12345"), contacts);

    // Customer customer = new Customer("Alice Johnson", Gender.FEMALE, LocalDate.of(1990, 1, 1), address, deliveryAddress, new HashSet<>());
    // customerDao.create(customer);
    // System.out.println(customerDao.read(1L));
    

    // System.out.println(address);
















    // ItemDao dao = new ItemDao();

    // Map<ImageName, Image> images = new HashMap<>();

    // Set<String> tags = new HashSet<>();
    // tags.add("like");
    // tags.add("cool");
    // tags.add("funny");

    // Image image1 = new Image("monkey", "image1.jpg", 100, 100);
    // ImageName imageName1 = new ImageName("monkey", "monkey image");

    // images.put(imageName1, image1);

    // // images.put("image2.jpg", new Image("tiger", "image2.jpg", 100, 100));
    // // images.put("image3.jpg", new Image("elephant", "image3.jpg", 100, 100));

    // Item item = new Item(new Dimention(10, 10, 10), new Weight(10), images);

    // dao.create(item);
    // System.out.println(dao.read(1L));

    // image1.setTitle("monkey2");
    // dao.update(item);
    // System.out.println(dao.read(1L));

    // dao.delete(item);



    // dao.delete(item);

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
