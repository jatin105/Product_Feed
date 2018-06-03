package stratergy;

import models.Post;

import java.util.Date;
import java.util.List;

public class RankingStratergyContext {
    private RankingStratergyI stratergy;

    public void setStratergy(RankingStratergyI stratergy) {
        this.stratergy = stratergy;
    }

    public List<Post> processFeeds(List<Post> feeds, Date timeStamp) {
        return this.stratergy.rankFeeds(feeds, timeStamp);
    }
}
