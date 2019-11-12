package com.vedantpandey.library.models.repositories;

import com.vedantpandey.library.models.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
