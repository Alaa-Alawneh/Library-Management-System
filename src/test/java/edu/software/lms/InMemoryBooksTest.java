package edu.software.lms;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryBooksTest {
    InMemoryBooks inMemoryBooks;
    Book testBooK;

    @BeforeEach
    void setUp() {
        inMemoryBooks = new InMemoryBooks();
        testBooK = new Book(1,"OOP","Arthur Morgan","123");
        inMemoryBooks.addBook(testBooK);
    }

    @AfterEach
    void tearDown() {
        inMemoryBooks = null;
    }

    @Test
    void getBookById() {
        Book book = inMemoryBooks.getBookById(1);
        assertNotNull(book);



    }

    @Test
    void getBookByName() {
        Book book = inMemoryBooks.getBookByName("OOP");
        assertNotNull(book);

    }

    @Test
    void getBookByAuthor() {
        Book book = inMemoryBooks.getBookByAuthor("Arthur Morgan");
        assertNotNull(book);
    }

    @Test
    void getBookByISBN() {
        Book book = inMemoryBooks.getBookByISBN("123");
    }

    @Test
    void addNullBook() {
        Book book = null;
        boolean adding_result = inMemoryBooks.addBook(book);
        assertFalse(adding_result);

    }
    @Test
    void addIdSimilarBook() {
        Book book2 = new Book(1,"OOP","Arthur Morgan","123123");
        boolean adding_result = inMemoryBooks.addBook(book2);
        assertFalse(adding_result);
    }
    @Test
    void addISBNSimilarBook() {
        Book book2 = new Book(2,"OOP","Arthur Morgan","123");
        boolean adding_result = inMemoryBooks.addBook(book2);
        assertFalse(adding_result);
    }
    @Test
    void addNewBook() {
        Book book2 = new Book(2,"Software","Ali","1234");
        boolean adding_result = inMemoryBooks.addBook(book2);
        assertTrue(adding_result);
    }
}