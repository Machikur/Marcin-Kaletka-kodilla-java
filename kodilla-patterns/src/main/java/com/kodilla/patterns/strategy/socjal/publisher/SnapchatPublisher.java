package com.kodilla.patterns.strategy.socjal.publisher;

public class SnapchatPublisher implements SocialPublisher {
    @Override
    public String share() {
        return "Share it on Snapchat";
    }
}
