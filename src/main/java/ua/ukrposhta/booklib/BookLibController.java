package ua.ukrposhta.booklib;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings("unused")
@RestController
@RequestMapping(value = "/")
public class BookLibController {
    final Logger logger = LoggerFactory.getLogger(BookLibController.class);

    @Autowired
    private BookLibService bookLibService;

    @RequestMapping(value = "/authors", method = RequestMethod.GET)
    public Authors listData() {
        return new Authors(bookLibService.findAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Author findAuthorById(@PathVariable Long id) {
        return bookLibService.findAuthorById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Author create(@RequestBody Author author) {
        logger.info("Creating Author: " + author);
        author = bookLibService.save(author);
        logger.info("Author created successfully with info: " + author);
        return author;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Author update(@RequestBody Author author,
                         @PathVariable Long id) {
        logger.info("Updating Author: " + author);
        author = bookLibService.save(author);
        logger.info("Author updated successfully with info: " + author);
        return author;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        logger.info("Deleting Author with id: " + id);
        Author author = bookLibService.findAuthorById(id);
        bookLibService.delete(author);
        logger.info("Author deleted successfully");
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Authors findAuthorBySubStr(@RequestParam("substr") String subStr) {
        return new Authors(bookLibService.findAuthorByBookSubStr(subStr));
    }
}
