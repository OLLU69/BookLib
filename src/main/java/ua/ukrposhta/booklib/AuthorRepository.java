package ua.ukrposhta.booklib;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

@SuppressWarnings("unused")
public interface AuthorRepository extends CrudRepository<Author, Long> {
    List<Author> findAuthorByFirstName(String firstName);

    @Query("select b from Book b where b.title like %:s% ")
    List<Book> findByBookSubStr(@Param("s") String str);
}
