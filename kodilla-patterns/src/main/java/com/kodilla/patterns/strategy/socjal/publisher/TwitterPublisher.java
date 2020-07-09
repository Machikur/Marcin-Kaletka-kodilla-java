package com.kodilla.patterns.strategy.socjal.publisher;

public class TwitterPublisher implements SocialPublisher{
    @Override
    public String share() {
        return "Share it on Twitter";
    }
}
