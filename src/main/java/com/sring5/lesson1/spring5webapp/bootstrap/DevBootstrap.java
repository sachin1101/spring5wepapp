package com.sring5.lesson1.spring5webapp.bootstrap;

import com.sring5.lesson1.spring5webapp.model.Author;
import com.sring5.lesson1.spring5webapp.model.Book;
import com.sring5.lesson1.spring5webapp.repositories.AuthorRepository;
import com.sring5.lesson1.spring5webapp.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository)
    {
        this.authorRepository=authorRepository;
        this.bookRepository=bookRepository;
    }

    private void initData()
    {
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", "Harper Collins");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        this.authorRepository.save(eric);
        this.bookRepository.save(ddd);


        Author rod = new Author("Rod" , "Johnson");
        Book noEJB = new Book("J2EE development without EJB", "4567","Worx");
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
