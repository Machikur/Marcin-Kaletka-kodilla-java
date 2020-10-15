package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.librarya.BookOld;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.Classifier;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.Book;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.BookSignature;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.Statistics;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MedianAdapter extends MedianAdaptee implements Classifier {


    public MedianAdapter(Statistics statistics) {
        super(statistics);
    }

    @Override
    public double publicationYearMedian(Set<BookOld> bookOldSet) {
        Map<BookSignature, Book> map = bookOldSet.stream()
                .collect(Collectors.toMap(book -> new BookSignature(book.getSignature()),
                        book -> new Book(book.getAuthor(), book.getTitle(), book.getPublicationYear())));
        return medianPublicationYear(map);
    }
}
