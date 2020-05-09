package com.kodilla.testing.forum.statistics;

public class CalkulateStatistic {

    private int usersquantity;
    private int postsquantity;
    private int commentsquantity;
    private double averagePostsPerUser;
    private double averageCommentsPerUser;
    private double averageCommentsPerPost;

    public void calculateAdvStatistics(Statistics statistics) {
        usersquantity = statistics.usersNames().size();
        postsquantity = statistics.postsCount();
        commentsquantity = statistics.commentsCount();
        if (usersquantity != 0) {
            averagePostsPerUser = postsquantity / usersquantity;
            averageCommentsPerUser = commentsquantity / usersquantity;
        } else {
            averagePostsPerUser = 0;
        }
        if (postsquantity != 0) {
            averageCommentsPerPost = commentsquantity / postsquantity;
        } else {
            averageCommentsPerPost = 0;
        }
    }

    public void showStatistics() {
        System.out.println("ilość użykowników: " + usersquantity);
        System.out.println("ilość postów: " + postsquantity);
        System.out.println("ilość komentarzy: " + commentsquantity);
        System.out.println("średnio komentarzy na użytkownika: " + averageCommentsPerUser);
        System.out.println("średnio postów na użytkownika: " + averagePostsPerUser);
        System.out.println("średnio komentarzy na post: " + averageCommentsPerPost);
    }

    public int getUsersquantity() {
        return usersquantity;
    }

    public int getPostsquantity() {
        return postsquantity;
    }

    public int getCommentsquantity() {
        return commentsquantity;
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
