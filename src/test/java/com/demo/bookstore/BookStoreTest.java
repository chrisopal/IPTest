package com.demo.bookstore;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BookStoreTest {

    @Test
    public void test_empty_bookshelf_when_no_book_added() {

        BookShelf shelf = new BookShelf();
        List<String> books = shelf.books();
        assertTrue(books.isEmpty(), () ->"BookShelf should be empty.");
    }

    @Test
    public void test_bookshelf_contains_two_books_when_two_books_added() {
        BookShelf shelf = new BookShelf();
        shelf.add("Effective Java","Code Complete");
        List<String> books = shelf.books();
        assertEquals(2, books.size(), () -> "BookShelf should have two books.");
    }

    @Test
    void booksReturnedFromBookShelfIsImmutableForClient() {
        BookShelf shelf = new BookShelf();
        shelf.add("Effective Java", "Code Complete");
        List<String> books = shelf.books();
        try {
            books.add("The Mythical Man-Month");
            fail(() -> "Should not be able to add book to books");
        } catch (Exception e) {
            assertTrue(e instanceof UnsupportedOperationException, () -> "Should throw UnsupportedOperationException.");
        }
    }

}
