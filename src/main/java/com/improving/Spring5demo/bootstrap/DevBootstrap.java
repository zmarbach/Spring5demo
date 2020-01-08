package com.improving.Spring5demo.bootstrap;

import com.improving.Spring5demo.model.Author;
import com.improving.Spring5demo.model.Book;
import com.improving.Spring5demo.model.Publisher;
import com.improving.Spring5demo.repositories.AuthorRepo;
import com.improving.Spring5demo.repositories.BookRepo;
import com.improving.Spring5demo.repositories.PublisherRepo;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepo authorRepo;
    private BookRepo bookRepo;
    private PublisherRepo publisherRepo;

    public DevBootstrap(AuthorRepo authorRepo, BookRepo bookRepo, PublisherRepo publisherRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
        this.publisherRepo = publisherRepo;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){
        Author eric = new Author("Eric", "Evans");
        Publisher harperCollins = new Publisher("Harper Collins", "1234 fake street");
        Book ddd = new Book("Domain Driven Design", "1234", harperCollins);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        //save into DB
        publisherRepo.save(harperCollins);
        authorRepo.save(eric);
        bookRepo.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Publisher worx = new Publisher("Worx", "123 example ave");
        Book noEJB = new Book("J2EE Development without EJB", "23444", worx);
        rod.getBooks().add(noEJB);

        //save into DB
        publisherRepo.save(worx);
        authorRepo.save(rod);
        bookRepo.save(noEJB);

    }
}
