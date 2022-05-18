package com.HaneiIslim.BookClub.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.HaneiIslim.BookClub.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

	public List<Book>findAll();
}
