package com.todzhang;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String>  {

	public Book findByTitle(String title);
	public List<Book> findByType(String type);
	public List<Book> findByAuthor(String author);
}




package com.todzhang;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private BookRepository repository;
	
	public static void main(String[] args){
		SpringApplication.run(Application.class, args);
	}
	
	@Override
	public void run(String... arg0) throws Exception {
		repository.deleteAll();
		System.out.println("=== repository cleaned====");
		
		repository.save(new Book("A Tale Of Two Cities","Charles Dickens",10,"Novel"));
		repository.save(new Book("The Da Vinci Code","Dan Brown",12,"Thriller"));
		repository.save(new Book("Think and Grow Rich","Nepoleon Hill",10,"Motivational"));
		repository.save(new Book("The Hobbit","J.R.R Tolkien",8,"Fantasy"));
		
		System.out.println("--- book found all --");
		List<Book> allBooks=repository.findAll();
		for(Book book:allBooks){
			System.out.println("-- the book is:"+book);
		}
		
		System.out.println();
		
		Book book1=repository.findByTitle("The Da Vinci Code");
		System.out.println("--- find by title: +"+book1);		
		book1.setPrice(5);
		repository.save(book1);
		System.out.println("--update book ---, now it's: "+repository.findByTitle("The Da Vinci Code"));
		
		repository.delete(book1);
		System.out.println("--- after delete book ---");
		for(Book book:repository.findAll()){
			System.out.println("-- the book is:"+book);
		}
	}

}
package com.todzhang;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection="todbooks")
public class Book {

	@Id
	private String id;
	@Field("bookTitle")
	private String title;
	private String author;
	private int price;
	private String type;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Book is : id=%s, title=%s, author=%s,price=%d",id,title,author,price);
	}

	public Book( String title, String author, int price, String type) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	
	
	
}
package com.todzhang;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;


@EnableMongoRepositories
@Configuration
public class MongoConfig extends AbstractMongoConfiguration {

	@Override
	protected String getDatabaseName() {
		// TODO Auto-generated method stub
		return "todzhangdb";
	}

	@Override
	public Mongo mongo() throws Exception {
		// TODO Auto-generated method stub
		return new MongoClient("130.49.139.232",5255);
	}

	@Override
	protected String getMappingBasePackage() {
		// TODO Auto-generated method stub
		return "com.todzhang";
	}

}
