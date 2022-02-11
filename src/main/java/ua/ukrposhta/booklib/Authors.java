package ua.ukrposhta.booklib;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("unused")
public class Authors implements Serializable {
    private List<Author> authors;

    public Authors() {
    }

    public Authors(List<Author> authors) {
        this.authors = authors;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
}
