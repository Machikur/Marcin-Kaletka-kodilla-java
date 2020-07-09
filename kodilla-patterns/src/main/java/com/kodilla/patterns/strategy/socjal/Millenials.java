package com.kodilla.patterns.strategy.socjal;

import com.kodilla.patterns.strategy.socjal.publisher.TwitterPublisher;

public class Millenials extends User {

    public Millenials(String name) {
        super(name);
        this.socialPublisher=new TwitterPublisher();
    }
}
