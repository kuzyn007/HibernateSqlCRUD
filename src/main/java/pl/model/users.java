package pl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Uzytkownicy")
public class users {
	
    @Id
    @GeneratedValue
	private long idUsers;
    @Column(name = "imie", columnDefinition = "VARCHAR(30)")
	private String name;
    @Column(name = "nazwisko", columnDefinition = "VARCHAR(30)")
	private String surname;
	public long getIdUsers() {
		return idUsers;
	}
	public void setIdUsers(long idUsers) {
		this.idUsers = idUsers;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
}