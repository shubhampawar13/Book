package com.API.BootAPIbook.Dao;

import org.springframework.data.repository.CrudRepository;

import com.API.BootAPIbook.Entitee.Book;

public interface BookRepository extends CrudRepository<Book, Integer>{

}
