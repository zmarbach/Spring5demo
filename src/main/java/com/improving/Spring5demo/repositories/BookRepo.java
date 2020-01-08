package com.improving.Spring5demo.repositories;

import com.improving.Spring5demo.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepo extends CrudRepository<Book, Long> {
}
