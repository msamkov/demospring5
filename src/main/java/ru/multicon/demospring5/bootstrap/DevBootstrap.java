package ru.multicon.demospring5.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import ru.multicon.demospring5.model.Author;
import ru.multicon.demospring5.model.Book;
import ru.multicon.demospring5.model.Publisher;
import ru.multicon.demospring5.repositories.AuthorRepository;
import ru.multicon.demospring5.repositories.BookRepository;
import ru.multicon.demospring5.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    private void initData() {
        //Eric
        Author eric = new Author("Eric", "Evans");
        Publisher harp = new Publisher("Harper Collins","Street 1001");
        Book ddd = new Book("Domain Driven Design", "1234", harp);


        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        publisherRepository.save(harp);
        authorRepository.save(eric);
        bookRepository.save(ddd);


        //Rod
        Author rod = new Author("Rod", "Johnson");
        Publisher worx = new Publisher("Worx","Street 1002");
        Book noEJB = new Book("J2EE Development withot EJB", "23444", worx);
        rod.getBooks().add(noEJB);

        publisherRepository.save(worx);
        authorRepository.save(rod);
        bookRepository.save(noEJB);

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
