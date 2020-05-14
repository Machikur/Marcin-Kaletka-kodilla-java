package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {
    private final int userID;
    private final String userName;
    private final char sex;
    private final int postAmount;
    private final LocalDate dateOfBirth;

    public ForumUser(final int userID, final String userName, final char sex,
                     final int postAmount, final int year, final int month, final int dayOfMonth) {
        this.userID = userID;
        this.userName = userName;
        this.sex = sex;
        this.postAmount = postAmount;
        this.dateOfBirth = LocalDate.of(year, month, dayOfMonth);


    }

    public int getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public char getSex() {
        return sex;
    }

    public int getPostAmount() {
        return postAmount;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String toString() {
        return "ForumUser{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", sex=" + sex +
                ", postAmount=" + postAmount +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
