package models;

import stratergy.RankingStratergyContext;
import stratergy.SellerRatingStratergy;

import java.util.*;

public class Customer {
    private String name;
    private List<Seller> subscribedList;
    private RankingStratergyContext rankingStratergy;
    private Set<String> hiddenFeeds;
    private Date timeStamp;

    public Customer(String name) {
        this.name = name;
        subscribedList = new ArrayList<>();
        rankingStratergy = new RankingStratergyContext();
        rankingStratergy.setStratergy(new SellerRatingStratergy());
        hiddenFeeds = new HashSet<>();
        timeStamp = new Date(Long.MIN_VALUE);
    }

    public String getName() {
        return name;
    }

    public List<Seller> getSubscribedList() {
        return subscribedList;
    }

    public void subscribe(Seller s) {
        subscribedList.add(s);
    }

    public void unSubscribe(Seller s) {
        subscribedList.remove(s);
    }

    public void hidePost(Post p) {
        hiddenFeeds.add(p.getPostId());
    }

    public void showPost(Post p) {
        hiddenFeeds.remove(p.getPostId());
    }

    public List<Post> fetchFeeds() {
        List<Post> feeds = new ArrayList<>();
        for (Seller s : subscribedList) {
            feeds.addAll(s.getFeeds());
        }
        //remove hidden posts
        int i = 0;
        while (i < feeds.size()) {
            if (hiddenFeeds.contains(feeds.get(i).getPostId()))
                feeds.remove(i);
            else
                ++i;
        }

        feeds = rankingStratergy.processFeeds(feeds, timeStamp);
        timeStamp = new Date();
        return feeds;
    }
}
