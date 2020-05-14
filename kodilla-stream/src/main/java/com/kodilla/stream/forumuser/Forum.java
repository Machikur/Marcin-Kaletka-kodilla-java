package com.kodilla.stream.forumuser;

import java.util.ArrayList;
import java.util.List;

public class Forum {

    private final List<ForumUser> usersList = new ArrayList<>();

    public Forum() {
        usersList.add(new ForumUser(111, "Michał", 'M', 152, 1990, 1, 12));
        usersList.add(new ForumUser(124, "Kaśka", 'K', 0, 1992, 7, 12));
        usersList.add(new ForumUser(122, "Michał", 'M', 1122, 1993, 12, 12));
        usersList.add(new ForumUser(172, "Paulina", 'K', 16, 2000, 12, 12));
        usersList.add(new ForumUser(152, "Michał", 'M', 1, 2002, 12, 12));
        usersList.add(new ForumUser(182, "Leszek", 'M', 123, 1997, 12, 12));

    }

    public List<ForumUser> getUserList() {
        return new ArrayList<>(usersList);
    }
}