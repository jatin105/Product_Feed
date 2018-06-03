package main;

import models.Customer;
import models.Post;
import models.Seller;

import java.util.HashSet;
import java.util.Set;

public class Main {
    static Set<Customer> customers = new HashSet<>();
    static Set<Seller> sellers = new HashSet<>();

    private static Seller createSeller(String name, int rating) {
        // Adding a new Seller
        Seller seller1 = new Seller(name, rating);
        sellers.add(seller1);
        return seller1;
    }

    private static void deleteSeller(Seller s) {
        sellers.remove(s);
        for (Customer customer : customers) {
            customer.getSubscribedList().remove(s);
        }
    }

    private static Customer createCustomer(String name) {
        Customer cust = new Customer(name);
        customers.add(cust);
        return cust;
    }

    private static void printFeeds(Customer customer) {
        for (Post p : customer.fetchFeeds()) {
            System.out.println(p.getProductName() + " sold at Rs. " + p.getProductPrice() + " by " + p.getSellerName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Test 1");
        // Adding Seller1 n sell2
        Seller seller1 = createSeller("seller1", 5);
        Seller seller2 = createSeller("seller2", 3);

        // Create customer1
        Customer customer1 = createCustomer("customer1");

        // customer 1 subscribes to both sellers
        customer1.subscribe(seller1);
        customer1.subscribe(seller2);

        // publishing post
        seller1.publishPost("table", 20);
        seller2.publishPost("chair", 30);
        seller1.publishPost("chair", 50);

        // get customer1 feeds
        printFeeds(customer1);


        System.out.println("Test 2");
        seller1.publishPost("test", 124);
        //remove seller1 first post
        Post p = seller1.getFeeds().get(0);
        seller1.removePost(p);

        System.out.println();
        // get customer1 feeds
        printFeeds(customer1);

        System.out.println();

        System.out.println("Test 3");
        // remove Seller2
        //deleteSeller(seller2);
        customer1.unSubscribe(seller2);

        // get customer1 feeds
        printFeeds(customer1);
        Thread.sleep(1000);
        System.out.println("Test 4");
        // hide seller1's first post
        p = seller1.getFeeds().get(0);
        customer1.hidePost(p);
        customer1.subscribe(seller2);

        // get customer1 feeds
        printFeeds(customer1);
    }
}
