package ru.multicon.demospring5.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.multicon.demospring5.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
