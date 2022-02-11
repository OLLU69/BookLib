package ua.ukrposhta.booklib;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("unused")
public class Books implements Serializable {
    private List<Book> books;

    public Books() {
    }

    public Books(List<Book> authors) {
        this.books = authors;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
