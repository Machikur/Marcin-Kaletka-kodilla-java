package com.kodilla.patterns.strategy.socjal;

import com.kodilla.patterns.strategy.socjal.publisher.SnapchatPublisher;
import com.kodilla.patterns.strategy.socjal.publisher.TwitterPublisher;
import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {

    @Test
    public void testDefaultSharingStrategies() {
        //given
        User user1 = new Millenials("Janek");
        User user2 = new YGeneration("Franek");
        User user3 = new ZGeneration("Mirek");

        //when&then
        Assert.assertEquals("Share it on Twitter", user1.share());
        Assert.assertEquals("Share it on Snapchat", user2.share());
        Assert.assertEquals("Share it on Facebook", user3.share());

    }

    @Test
    public void testIndividualSharingStrategy() {
        //given
        User user1 = new Millenials("Janek");
        User user2 = new YGeneration("Franek");
        User user3 = new ZGeneration("Mirek");

        //when
        user1.setSocialPublisher(new TwitterPublisher());
        user2.setSocialPublisher(new TwitterPublisher());
        user3.setSocialPublisher(new SnapchatPublisher());

        // then
        Assert.assertEquals("Share it on Twitter", user1.share());
        Assert.assertEquals("Share it on Twitter", user2.share());
        Assert.assertEquals("Share it on Snapchat", user3.share());
    }

}
