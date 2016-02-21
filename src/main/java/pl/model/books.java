package pl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Ksiazki")
public class books {
	@Id
	@GeneratedValue
	private long idBooks;
	@Column(name = "autor", columnDefinition = "VARCHAR(35)")
	private String author;
	@Column(name = "tytul", columnDefinition = "VARCHAR(35)")
	private String title;
	@Column(name = "iloscStron")
	private long pageNumber;
	
	public long getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(long pageNumber) {
		this.pageNumber = pageNumber;
	}
	public long getIdBooks() {
		return idBooks;
	}
	public void setIdBooks(long idBooks) {
		this.idBooks = idBooks;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
