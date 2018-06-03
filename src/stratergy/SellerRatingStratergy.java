package stratergy;

import models.Post;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class SellerRatingStratergy implements RankingStratergyI {
    @Override
    public List<Post> rankFeeds(List<Post> feeds, Date timeStamp) {
        int i = 0;
        while (i < feeds.size()) {
            if (feeds.get(i).getTimeStamp().before(timeStamp))
                feeds.remove(i);
            else
                ++i;
        }
        Collections.sort(feeds, new Comparator<Post>() {
            @Override
            public int compare(Post o1, Post o2) {
                return o2.getSellerRating() - o1.getSellerRating();
            }
        });
        return feeds;
    }
}
