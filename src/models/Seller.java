package models;

import java.util.ArrayList;
import java.util.List;

public class Seller {
    private String name;
    private int rating;
    private List<Post> feeds;

    public Seller(String name, int rating) {
        this.name = name;
        this.rating = rating;
        feeds = new ArrayList<>();
    }

    private void addPost(Post p) {
        feeds.add(p);
    }

    public void removePost(Post p) {
        feeds.remove(p);
    }

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }

    public List<Post> getFeeds() {
        return feeds;
    }

    public void publishPost(String prodName, double price) {
        Post newFeed = new Post(prodName, price, name, rating);
        this.addPost(newFeed);
    }
}
