package com.kodilla.patterns.strategy.socjal;

import com.kodilla.patterns.strategy.socjal.publisher.SocialPublisher;

public abstract class User {
    private final String name;
    protected SocialPublisher socialPublisher;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSocialPublisher(SocialPublisher socialPublisher) {
        this.socialPublisher = socialPublisher;
    }

    public String share() {
        return socialPublisher.share();
    }
}
