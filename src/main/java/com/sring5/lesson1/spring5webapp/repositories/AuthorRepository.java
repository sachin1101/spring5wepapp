package com.sring5.lesson1.spring5webapp.repositories;

import com.sring5.lesson1.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
