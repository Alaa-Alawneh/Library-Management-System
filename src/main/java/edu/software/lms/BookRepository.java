package edu.software.lms;



public interface BookRepository {
    public Book getBookById(int id);
    public Book getBookByName(String name);
    public Book getBookByAuthor(String author);
    public Book getBookByISBN(String isbn);
    public boolean addBook(Book book);

}
