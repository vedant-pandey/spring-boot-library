package com.vedantpandey.library.models.repositories;

import com.vedantpandey.library.models.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
