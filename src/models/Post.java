package models;

import java.util.Date;

public class Post {
    private String productName;
    private double productPrice;
    private String postId;
    private String sellerName;
    private int sellerRating;
    private Date timeStamp;

    public Post(String prodName, double prodPrice, String sellerName, int sellerRating) {
        this.productName = prodName;
        this.productPrice = prodPrice;
        this.timeStamp = new Date();
        this.sellerName = sellerName;
        this.sellerRating = sellerRating;
        this.postId = this.productName + "_" + this.productPrice + "_" + this.sellerName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return this.productPrice;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public int getSellerRating() {
        return sellerRating;
    }

    public void setSellerRating(int sellerRating) {
        this.sellerRating = sellerRating;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }
}
