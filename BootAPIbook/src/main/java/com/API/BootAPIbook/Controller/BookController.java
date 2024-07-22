package com.API.BootAPIbook.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.API.BootAPIbook.DB.BookDatabase;
import com.API.BootAPIbook.Entitee.Book;

@RestController
public class BookController {
	@Autowired
	private BookDatabase bdb;
//	@RequestMapping(value = "/books" , method = RequestMethod.GET)
	// instaed of above statement we can also use getMapping
	// @ResponseBody we don't need to use it when we uses @RestController annotation
//	@GetMapping("/books")
//	public String getBook() {
//		return "This is testing book";
//	}

//	@GetMapping("/books")
//	public Book getBook() {
//		Book book = new Book();
//		book.setId(101);
//		book.setName("Harry Potter");
//		book.setPublication("Shubham");
//		book.setAuthor("Harry");
//		book.setYear(2000);
//		
//		return book;
//	}

//	following code can be used create API without sending status code
	/*
	 * @GetMapping("/books")
	 *  public List<Book> getBooks(){
	 *   return
	 * this.bdb.getAllBooks(); }
	 * 
	 * //how to get object using dynamic id
	 * 
	 * @GetMapping("/books/{id}") 
	 * public Book getBook( @PathVariable("id") int id) {
	 * return this.bdb.getBook(id); }
	 * 
	 * //post operation //@Requestbody will parse our JSON data into Book object
	 * 
	 * @PostMapping("/books")
	 *  public Book addBook(@RequestBody Book b) { 
	 *  Book bk =this.bdb.addBook(b); return bk; }
	 * 
	 * //delete Operation
	 * 
	 * @DeleteMapping("/books/{BookId}") 
	 * public void deleteBook(@PathVariable("BookId") int id) { 
	 * this.bdb.deleteBook(id); }
	 * 
	 * //update operation
	 * 
	 * @PutMapping("/books/{BookId}") public void updateBook(@RequestBody Book
	 * b, @PathVariable("BookId") int id) { this.bdb.updateBook(b, id); }
	 */

	// Creating an API but also returning status code
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBooks() {

		List<Book> list = this.bdb.getAllBooks();
		if (list.size() == 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} else {
			return ResponseEntity.of(Optional.of(list));
		}
	}

	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBook(@PathVariable("id") int id) {
		
		Book bk =this.bdb.getBook(id);
		if(bk==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		else {
			return ResponseEntity.of(Optional.of(bk));
		}

	}
	
	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody Book b){
		try {
			Book bk = this.bdb.addBook(b);
			return ResponseEntity.of(Optional.of(bk));
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@DeleteMapping("/books/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable("id") int id){
		try {
			this.bdb.deleteBook(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PutMapping("/books/{id}")
	public ResponseEntity<Book> updateBook(@RequestBody Book b, @PathVariable("id") int id){
		Book bk=null;
		try {
			
					bk= this.bdb.updateBook(b, id);
					
					if(bk==null) {
						throw new Exception();
					}else {
						return ResponseEntity.of(Optional.of(bk));
					}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
}
