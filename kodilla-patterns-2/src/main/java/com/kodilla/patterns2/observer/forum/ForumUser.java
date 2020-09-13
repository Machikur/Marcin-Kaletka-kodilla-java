package com.kodilla.patterns2.observer.forum;

public class ForumUser implements Observer {
    private final String name;
    private int updateCount;

    public ForumUser(String name) {
        this.name = name;
    }

    @Override
    public void upgrade(ForumTopic forumTopic) {
        System.out.println(name + "has new message in topic " + forumTopic.getName() + " \n" +
                "total: " + forumTopic.getMessages().size() + " messages");
        updateCount++;
    }

    public String getName() {
        return name;
    }

    public int getUpdateCount() {
        return updateCount;
    }
}
