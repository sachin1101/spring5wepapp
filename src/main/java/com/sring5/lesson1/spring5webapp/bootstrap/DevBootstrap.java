package com.sring5.lesson1.spring5webapp.bootstrap;

import com.sring5.lesson1.spring5webapp.model.Author;
import com.sring5.lesson1.spring5webapp.model.Book;
import com.sring5.lesson1.spring5webapp.model.Publisher;
import com.sring5.lesson1.spring5webapp.repositories.AuthorRepository;
import com.sring5.lesson1.spring5webapp.repositories.BookRepository;
import com.sring5.lesson1.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository)
    {
        this.authorRepository=authorRepository;
        this.bookRepository=bookRepository;
        this.publisherRepository = publisherRepository;
    }

    private void initData()
    {
        Author eric = new Author("Eric", "Evans");
        Publisher penguin = new Publisher("Penguin Books","abc drive");

        this.publisherRepository.save(penguin);

        Book ddd = new Book("Domain Driven Design", "1234", penguin);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);



        this.authorRepository.save(eric);
        this.bookRepository.save(ddd);


        Author rod = new Author("Rod" , "Johnson");
        Book noEJB = new Book("J2EE development without EJB", "4567",penguin);
        rod.getBooks().add(noEJB   );
        noEJB.getAuthors().add(rod);
        this.bookRepository.save(noEJB);
        this.authorRepository.save(rod);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
