package com.kodilla.patterns.strategy.socjal.publisher;

public class FacebookPublisher implements SocialPublisher {
    @Override
    public String share() {
        return "Share it on Facebook";
    }
}
