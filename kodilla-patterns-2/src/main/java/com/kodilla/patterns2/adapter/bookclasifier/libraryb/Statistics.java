package com.kodilla.patterns2.adapter.bookclasifier.libraryb;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Statistics implements BookStatistics {
    @Override
    public double averagePublicationYear(Map<BookSignature, Book> books) {
        return books.values().stream()
                .mapToInt(Book::getPublicationYear)
                .average().orElse(0);
    }

    @Override
    public double medianPublicationYear(Map<BookSignature, Book> books) {
        List<Integer> years = books.values().stream()
                .map(Book::getPublicationYear)
                .sorted()
                .collect(Collectors.toList());
        if (years.size() % 2 == 0) {
            return years.get((int) (years.size() / 2 + 0.5));
        } else return years.get(years.size() / 2);
    }
}
