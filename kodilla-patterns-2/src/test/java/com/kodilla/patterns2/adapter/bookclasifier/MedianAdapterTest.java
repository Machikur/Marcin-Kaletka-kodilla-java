package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.librarya.BookOld;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.Statistics;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class MedianAdapterTest {

    @Test
    public void medianTest() {

        //given
        MedianAdapter medianAdapter = new MedianAdapter(new Statistics());
        Set<BookOld> bookOldSet = new HashSet<>();
        bookOldSet.add(new BookOld("Mickiewicz1", "W pustyni1", 2001, "ASDsad1"));
        bookOldSet.add(new BookOld("Mickiewicz2", "W pustyni2", 2000, "ASDsad2"));
        bookOldSet.add(new BookOld("Mickiewicz3", "W pustyni3", 2004, "ASDsad3"));
        bookOldSet.add(new BookOld("Mickiewicz4", "W pustyni5", 2002, "ASDsad4"));
        bookOldSet.add(new BookOld("Mickiewicz5", "W pustyni5", 2003, "ASDsad5"));

        //when
        double year = medianAdapter.publicationYearMedian(bookOldSet);

        //then

        Assert.assertEquals(2002, year, 0.1);
    }


}