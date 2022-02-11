package ua.ukrposhta.booklib;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.web.client.RestTemplate;

public class RestfulClientSample {
    private static final String URL_GET_ALL_AUTHORS =
            "http://localhost:8080/ch12/restful/listauthors";
    private static final String URL_GET_AUTHOR_BY_ID =
            "http://localhost:8080/ch12/restful/contact/{id}";
    private static final String URL_CREATE_AUTHOR =
            "http://localhost:8080/ch12/restful/contact/";
    private static final String URL_AUTHOR_CONTACT =
            "http://localhost:8080/ch12/restful/contact/{id}";
    private static final String URL_DELETE_AUTHOR =
            "http://localhost:8080/ch12/restful/contact/{id}";

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/restful-client-app-context.xml");
        ctx.refresh();

        Author author;
        RestTemplate restTemplate = ctx.getBean("restTemplate", RestTemplate.class);

        System.out.println("Testing retrieve all contacts:");
        Authors authors = restTemplate.getForObject(URL_GET_ALL_AUTHORS, Authors.class);
        listContacts(authors);

        System.out.println("Testing retrieve a contact by id :");
        author = restTemplate.getForObject(URL_GET_AUTHOR_BY_ID, Author.class, 1);
        System.out.println(author);
        System.out.println();

        author = restTemplate.getForObject(URL_AUTHOR_CONTACT, Author.class, 1);
        author.setFirstName("John Doe");
        System.out.println("Testing update contact by id :");
        restTemplate.put(URL_AUTHOR_CONTACT, author, 1);
        System.out.println("Contact update successfully: " + author);
        System.out.println();

        restTemplate.delete(URL_DELETE_AUTHOR, 1);
        System.out.println("Testing delete contact by id :");
        authors = restTemplate.getForObject(URL_GET_ALL_AUTHORS, Authors.class);
        listContacts(authors);

        System.out.println("Testing create contact :");
        Author authorNew = new Author();
        authorNew.setFirstName("James");
        authorNew.setLastName("Gosling");
        authorNew = restTemplate.postForObject(URL_CREATE_AUTHOR, authorNew, Author.class);
        System.out.println("Contact created successfully: " + authorNew);
    }

    private static void listContacts(Authors authors) {
        for (Author author : authors.getAuthors()) {
            System.out.println(author);
        }

        System.out.println();
    }
}
