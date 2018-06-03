package stratergy;

import models.Post;

import java.util.Date;
import java.util.List;

public interface RankingStratergyI {
    List<Post> rankFeeds(List<Post> feeds, Date timeStamp);
}
