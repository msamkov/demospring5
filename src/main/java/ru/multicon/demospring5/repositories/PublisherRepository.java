package ru.multicon.demospring5.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.multicon.demospring5.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
