package ru.multicon.demospring5.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.multicon.demospring5.model.Author;

import java.util.Optional;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
