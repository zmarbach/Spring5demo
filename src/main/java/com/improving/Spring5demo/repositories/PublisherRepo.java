package com.improving.Spring5demo.repositories;

import com.improving.Spring5demo.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepo extends CrudRepository<Publisher, Long> {
}
