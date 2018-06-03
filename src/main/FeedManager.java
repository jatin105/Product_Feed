package main;

import models.Customer;
import models.Post;
import models.Seller;

import java.util.HashMap;
import java.util.Map;

public class FeedManager {
    static Map<String, Customer> customers = new HashMap<>();
    static Map<String, Seller> sellers = new HashMap<>();

    private static FeedManager ourInstance = new FeedManager();

    private FeedManager() {
    }

    public static FeedManager getInstance() {
        return ourInstance;
    }

    public static Seller createSeller(String name, int rating) {
        // Adding a new Seller
        Seller seller1 = new Seller(name, rating);
        sellers.put(name, seller1);
        return seller1;
    }

    public static void deleteSeller(String name) {
        Seller s = sellers.get(name);
        sellers.remove(s);
        for (Customer customer : customers.values()) {
            customer.getSubscribedList().remove(s);
        }
    }

    public static void publishPost(String sellerName, String productName, double price) {
        Seller s = sellers.get(sellerName);
        s.publishPost(productName, price);
    }


    public static Customer createCustomer(String name) {
        Customer cust = new Customer(name);
        customers.put(name, cust);
        return cust;
    }

    public static void printFeeds(String name) {
        Customer customer = customers.get(name);
        for (Post p : customer.fetchFeeds()) {
            System.out.println(p.getProductName() + " sold at Rs. " + p.getProductPrice() + " by " + p.getSellerName());
        }
    }
}
