package com.kodilla.patterns.strategy.socjal;

import com.kodilla.patterns.strategy.socjal.publisher.SnapchatPublisher;

public class YGeneration extends User {
    public YGeneration(String name) {
        super(name);
        this.socialPublisher=new SnapchatPublisher();
    }
}
