package com.kodilla.patterns.prototype;

import com.kodilla.patterns.prototype.library.Book;
import com.kodilla.patterns.prototype.library.Library;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class LibraryTest {

    @Test
    public void testShallowAndDeepCopy() {
        //given
        Library library = new Library("library1");
        Library copyLibrary = null;
        Library deepCopyLibrary = null;
        Book book1 = new Book("Book1", "Author", LocalDate.of(2012, 12, 12));
        Book book2 = new Book("Book2", "Author1", LocalDate.of(2011, 12, 12));
        Book book3 = new Book("Book3", "Author2", LocalDate.of(2010, 12, 12));

        //when
        try {
            copyLibrary = library.shallowCopy();
            deepCopyLibrary = library.deepCopy();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        library.getBooks().add(book1);
        library.getBooks().add(book2);
        library.getBooks().add(book3);

        //then
        Assert.assertNotEquals(library, deepCopyLibrary);
        Assert.assertNotEquals(library, copyLibrary);
        Assert.assertTrue(library.getBooks().contains(book1));
        Assert.assertTrue(copyLibrary.getBooks().contains(book2));
        Assert.assertFalse(deepCopyLibrary.getBooks().contains(book3));
        Assert.assertEquals(library.getBooks(), copyLibrary.getBooks());
        Assert.assertNotEquals(deepCopyLibrary.getBooks(), library.getBooks());


    }

}
