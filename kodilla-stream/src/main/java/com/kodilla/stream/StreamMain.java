package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {

        Forum forum = new Forum();
        List<ForumUser> usersList = forum.getUserList();

        Map<Integer, ForumUser> usersMap = usersList.stream()
                .filter(user -> String.valueOf(user.getSex()).equals("M"))
                .filter(user -> ChronoUnit.YEARS.between(user.getDateOfBirth(), LocalDate.now()) >= 20)
                .filter(user -> user.getPostAmount() >= 1)
                .collect(Collectors.toMap(ForumUser::getUserID, user -> user));

        usersMap.entrySet().stream()
                .forEach(System.out::println);


    }
}