package ua.ukrposhta.booklib;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@SuppressWarnings("unused")
@Entity
@Table(name = "author")
public class Author implements Serializable {
    private Long id;
    private int version;
    private String firstName;
    private String lastName;
    private Set<Book> books = new HashSet<>();

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Version
    @Column(name = "VERSION")
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Column(name = "FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "author_to_book",
            joinColumns = @JoinColumn(name = "AUTHOR_ID"),
            inverseJoinColumns = @JoinColumn(name = "BOOK_ID"))
    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author - Id: " + id + ", First name: " + firstName
                + ", Last name: " + lastName;
    }
}
