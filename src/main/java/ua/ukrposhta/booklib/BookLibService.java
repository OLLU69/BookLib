package ua.ukrposhta.booklib;

import java.util.List;

@SuppressWarnings("UnusedReturnValue")
public interface BookLibService {
    List<Author> findAll();

    Author findAuthorById(Long id);

    List<Author> findAuthorByBookSubStr(String subStr);

    Author save(Author author);

    void delete(Author author);
}
