package ua.ukrposhta.booklib;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
@Service("BookLibService")
@Repository
@Transactional
public class BookLibServiceImpl implements BookLibService {
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Author> findAll() {
        return Lists.newArrayList(authorRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Author findAuthorById(Long id) {
        return authorRepository.findOne(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Author> findAuthorByBookSubStr(String subStr) {
        //        List<Book> books = authorRepository.findByBookSubStr(subStr);
        //        return books.stream()
        //                .flatMap(book -> book.getAuthors().stream())
        //                .distinct()
        //                .collect(Collectors.toList());

        List<Author> list = new ArrayList<>();
        for (Book book : authorRepository.findByBookSubStr(subStr)) {
            list.addAll(book.getAuthors());
        }
        return list;
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public void delete(Author author) {
        authorRepository.delete(author);
    }
}
