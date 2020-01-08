package com.improving.Spring5demo.repositories;

import com.improving.Spring5demo.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepo extends CrudRepository<Author, Long> {
}
