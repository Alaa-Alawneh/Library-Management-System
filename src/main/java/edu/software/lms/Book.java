package edu.software.lms;

public class Book {
    private int id;
    private String name;
    private String author;
    private String isbn;

    public Book(int id, String name, String author, String isbn) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.isbn = isbn;
    }
    //todo: Equals method
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
