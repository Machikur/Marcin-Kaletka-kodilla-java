package com.kodilla.good.patterns;

import com.kodilla.good.patterns.challenges.MovieStore;

import java.util.Collection;

public class Main {
    public static void main(String[] args) {

        MovieStore movie = new MovieStore();
        movie.getMovies().values().stream()
                .flatMap(Collection::stream)
                .forEach(s -> System.out.print(s + "!"));

    }
}
