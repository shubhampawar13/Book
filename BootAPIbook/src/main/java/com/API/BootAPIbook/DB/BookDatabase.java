package com.API.BootAPIbook.DB;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.API.BootAPIbook.Dao.BookRepository;
import com.API.BootAPIbook.Entitee.Book;
@Component
public class BookDatabase {
//	private static List<Book> list = new ArrayList<>();

//	static {
//		list.add(new Book(1, "Napoleon", "Nikhil", "Sunshine Publication", 2002));
//		list.add(new Book(2, "War and Peace", "Leo Tolstoy", "Penguin Classics", 1869));
//		list.add(new Book(3, "Pride and Prejudice", "Jane Austen", "Whitehall", 1813));
//		list.add(new Book(4, "1984", "George Orwell", "Secker & Warburg", 1949));
//		list.add(new Book(5, "Moby Dick", "Herman Melville", "Harper & Brothers", 1851));
//		list.add(new Book(6, "The Great Gatsby", "F. Scott Fitzgerald", "Scribner", 1925));
//		list.add(new Book(7, "Ulysses", "James Joyce", "Sylvia Beach", 1922));
//		list.add(new Book(8, "The Odyssey", "Homer", "Penguin Classics", -800));
//		list.add(new Book(9, "To Kill a Mockingbird", "Harper Lee", "J.B. Lippincott & Co.", 1960));
//		list.add(new Book(10, "Crime and Punishment", "Fyodor Dostoevsky", "The Russian Messenger", 1866));
//		list.add(new Book(11, "The Catcher in the Rye", "J.D. Salinger", "Little, Brown and Company", 1951));
//		list.add(new Book(12, "Brave New World", "Aldous Huxley", "Chatto & Windus", 1932));
//		list.add(new Book(13, "The Lord of the Rings", "J.R.R. Tolkien", "Allen & Unwin", 1954));
//		list.add(new Book(14, "Anna Karenina", "Leo Tolstoy", "The Russian Messenger", 1877));
//		list.add(new Book(15, "Madame Bovary", "Gustave Flaubert", "Revue de Paris", 1857));
//		list.add(new Book(16, "The Divine Comedy", "Dante Alighieri", "Giovanni Boccaccio", 1320));
//		list.add(new Book(17, "The Brothers Karamazov", "Fyodor Dostoevsky", "The Russian Messenger", 1880));
//		list.add(new Book(18, "One Hundred Years of Solitude", "Gabriel Garcia Marquez", "Harper & Row", 1967));
//		list.add(new Book(19, "Don Quixote", "Miguel de Cervantes", "Francisco de Robles", 1605));
//		list.add(new Book(20, "The Iliad", "Homer", "Penguin Classics", -750));
//		list.add(new Book(21, "The Hobbit", "J.R.R. Tolkien", "George Allen & Unwin", 1937));
//		list.add(new Book(22, "Fahrenheit 451", "Ray Bradbury", "Ballantine Books", 1953));
//		list.add(new Book(23, "Jane Eyre", "Charlotte Brontë", "Smith, Elder & Co.", 1847));
//		list.add(new Book(24, "Wuthering Heights", "Emily Brontë", "Thomas Cautley Newby", 1847));
//		list.add(new Book(25, "The Count of Monte Cristo", "Alexandre Dumas", "Penguin Classics", 1844));
//
//	}
	@Autowired
	private BookRepository bookrepo;

//get all book method
	public List<Book> getAllBooks(){
		List<Book> list = (List<Book>)bookrepo.findAll();
		return list;
	}
	
	//get single book by id
	public Book getBook(int id) {
		Book bk = null;
//		for(int i=0 ; i < list.size(); i++) {
//			if(list.get(i).getId()==id) {
//				bk= list.get(i);
//				break;
//			}
//		}
		try {
			bk= bookrepo.findById(id).get();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return bk;
	}
	
	public Book addBook(Book b) {
//		list.add(b);
		this.bookrepo.save(b);
		return b;
	}
	
	public void deleteBook(int id) {
//		for(int i=0 ; i < list.size(); i++) {
//			if(list.get(i).getId()==id) {
//				list.remove(list.get(i));
//				break;
//			}
//		}
		this.bookrepo.deleteById(id);
	}
	
	public Book updateBook(Book b , int id) {
//		Book bk = null;
//		
//		try {
//			for(int i=0 ; i < list.size(); i++) {
//				if(list.get(i).getId()==id) {
//					list.get(i).setName(b.getName());
//					list.get(i).setPublication(b.getPublication());
//					list.get(i).setYear(b.getYear());
//					list.get(i).setAuthor(b.getAuthor());
//					bk=list.get(i);
//					break;
//				}
//				
//				
//			}
//		}catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
		
		b.setId(id);
		this.bookrepo.save(b);
		return b;
	}
}
