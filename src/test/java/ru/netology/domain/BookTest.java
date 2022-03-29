package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    Book book = new Book(1, "One", 100, "AOne");

    @Test
    void shouldMatchesByName() {
        String text = "One";
        book.matches(text);
        assertTrue(book.matches(text));

    }

   @Test
    void shouldMatchByAuthor() {
        String text = "AOne";
        book.matches(text);
        assertTrue(book.matches(text));

    }

    @Test
    void shouldMatchesByNameInvalid() {
        String text = "Second";
        book.matches(text);
        assertFalse(book.matches(text));

    }

    @Test
    void shouldMatchByAuthorInvalid() {
        String text = "ASecond";
        book.matches(text);
        assertFalse(book.matches(text));


    }

}