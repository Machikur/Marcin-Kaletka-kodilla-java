package com.kodilla.patterns2.observer.forum;

import org.junit.Assert;
import org.junit.Test;

public class ForumUserTest {

    @Test
    public void testUpdate() {
        //Given
        ForumTopic javaHelpForumTopic = new JavaHelpForumTopic();
        ForumTopic javaToolsForumTopic = new JavaToolsForumTopic();
        ForumUser forumUser1 = new ForumUser("Janusz");
        ForumUser forumUser2 = new ForumUser("Grażyna");
        ForumUser forumUser3 = new ForumUser("Halyna");

        javaHelpForumTopic.registerObserver(forumUser1);
        javaHelpForumTopic.registerObserver(forumUser2);
        javaToolsForumTopic.registerObserver(forumUser2);
        javaToolsForumTopic.registerObserver(forumUser3);

        //when
        javaHelpForumTopic.addPost("Message one");
        javaHelpForumTopic.addPost("Message two");
        javaToolsForumTopic.addPost("Message one");
        javaToolsForumTopic.addPost("Message two");

        //then
        Assert.assertEquals(2, forumUser1.getUpdateCount());
        Assert.assertEquals(4, forumUser2.getUpdateCount());
        Assert.assertEquals(2, forumUser3.getUpdateCount());
    }
}