package com.kodilla.patterns.strategy.socjal;

import com.kodilla.patterns.strategy.socjal.publisher.FacebookPublisher;

public class ZGeneration extends User {
    public ZGeneration(String name) {
        super(name);
        this.socialPublisher = new FacebookPublisher();
    }
}
