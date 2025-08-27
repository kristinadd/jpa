package jpa;

import java.time.LocalDate;

import java.util.List;

import jpa.dao.CustomerDao;
import jpa.domain.Address;
import jpa.domain.Customer;
public class Main {
  public static void main(String[] args) {

    Address address = new Address("123 Main St", "Anytown", "USA", "12345");
    Address deliveryAddress = new Address("456 Main St", "Sydney", "Australia", "2000");
    Customer customer = new Customer("John Doe", "M", LocalDate.parse("1990-01-01"), address, deliveryAddress, "12345");

    CustomerDao customerDao = new CustomerDao();
    customerDao.create(customer);

    Address address2 = new Address("456 Main St", "Sydney", "Australia", "2000");

    customer.setAddress(address2);
    customerDao.update(customer);



    Customer readCustomer = customerDao.read(1L);
    System.out.println("💖" + readCustomer);



    List<Customer> customers = customerDao.findByCity("Sydney");
    System.out.println(customers);































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
