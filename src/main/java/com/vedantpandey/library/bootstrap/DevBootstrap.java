package com.vedantpandey.library.bootstrap;

import com.vedantpandey.library.models.Author;
import com.vedantpandey.library.models.Book;
import com.vedantpandey.library.models.Publisher;
import com.vedantpandey.library.models.repositories.AuthorRepository;
import com.vedantpandey.library.models.repositories.BookRepository;
import com.vedantpandey.library.models.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        // Harper Lee
        Author harper = new Author("Harper", "Lee");
        Publisher jp_lip = new Publisher("JP Lippincott", "london");
        Book to_kill_a_mockingbird = new Book("To kill a mockingbird", "1234", jp_lip);
        harper.getBooks().add(to_kill_a_mockingbird);

        authorRepository.save(harper);
        publisherRepository.save(jp_lip);
        bookRepository.save(to_kill_a_mockingbird);

        // Edgar Allan Poe
        Author poe = new Author("Edgar", "A. Poe");
        Publisher allan = new Publisher("Allan Co","london");
        Book the_raven = new Book("The Raven", "54321", allan);

        poe.getBooks().add(the_raven);

        authorRepository.save(poe);
        publisherRepository.save(allan);
        bookRepository.save(the_raven);
    }
}
