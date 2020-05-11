package com.kodilla.testing.forum.statistics;

public class CalkulateStatistic {

    private int usersQuantity;
    private int postsQuantity;
    private int commentsQuantity;
    private double averagePostsPerUser;
    private double averageCommentsPerUser;
    private double averageCommentsPerPost;

    public void calculateAdvStatistics(Statistics statistics) {
        usersQuantity = statistics.usersNames().size();
        postsQuantity = statistics.postsCount();
        commentsQuantity = statistics.commentsCount();
        if (usersQuantity != 0) {
            averagePostsPerUser = (double) postsQuantity / usersQuantity;
            averageCommentsPerUser = (double) commentsQuantity / usersQuantity;
        } else {
            averagePostsPerUser = 0;
            averageCommentsPerUser = 0;
        }
        if (postsQuantity != 0) {
            averageCommentsPerPost = (double) commentsQuantity / postsQuantity;
        } else {
            averageCommentsPerPost = 0;
        }
    }

    public void showStatistics() {
        System.out.println("ilość użykowników: " + usersQuantity);
        System.out.println("ilość postów: " + postsQuantity);
        System.out.println("ilość komentarzy: " + commentsQuantity);
        System.out.println("średnio komentarzy na użytkownika: " + averageCommentsPerUser);
        System.out.println("średnio postów na użytkownika: " + averagePostsPerUser);
        System.out.println("średnio komentarzy na post: " + averageCommentsPerPost);
    }

    public int getUsersQuantity() {
        return usersQuantity;
    }

    public int getPostsQuantity() {
        return postsQuantity;
    }

    public int getCommentsQuantity() {
        return commentsQuantity;
    }

    public double getAveragePostsPerUser() {
        return averagePostsPerUser;
    }

    public double getAverageCommentsPerUser() {
        return averageCommentsPerUser;
    }

    public double getAverageCommentsPerPost() {
        return averageCommentsPerPost;
    }
}
