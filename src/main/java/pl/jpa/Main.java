package pl.jpa;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import pl.model.books;

public class Main {

	public static void main(String[] args) {
		

		Scanner in = new Scanner(System.in);
		boolean check = true;
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		while (check) {
			String title;
			String author;
			long page;
			
			System.out.println("1. Dodaj ksi��k� do bazy\n2. Wypisz przeczytane ksi��ki\n3. Koniec\nPodaj numer ��danej operacji");
			int number = in.nextInt();
			in.nextLine();
			switch (number) {
				case 1:
					books ref = new books();
					
					System.out.println("Prosz� poda� tytu� ksi��ki: ");
					title = in.nextLine();
					System.out.println("Prosz� poda� autora ksi��ki: ");
					author = in.nextLine();
					System.out.println("Prosz� poda� ilo�� stron ksi��ki: ");
					page = in.nextLong();
					
					ref.setTitle(title);
					ref.setAuthor(author);
					ref.setPageNumber(page);;
					
					// POCZATEK POBIERANIA ->
					entityManager.getTransaction().begin();

					// POBIERANIE
					entityManager.persist(ref);
					
					// KONIEC POBIERANIA <-
					entityManager.getTransaction().commit();
					
					break;
				case 2:
					List<books> listBooks = entityManager.createQuery("from books").getResultList();
					System.out.println("Lista ksi��ek w bazie:\n");
					String format = "|%1$-35s|%2$-35s|%3$-15s|\n";
					String format2 = "|%1$-35s|%2$-35s|%3$-15d|\n";
					System.out.format(format,
						    "-----------------------------------", "-----------------------------------", "---------------");
					System.out.format(format,
						    "Autor", "Tytu�", "Ilo�� stron");
					System.out.format(format,
						    "-----------------------------------", "-----------------------------------", "---------------");
					for(books e : listBooks) {
						System.out.format(format2,
								e.getAuthor(), e.getTitle(), e.getPageNumber());
			        }
					System.out.format(format,
						    "-----------------------------------", "-----------------------------------", "---------------");
					
					break;
				case 3:
					check = false;
					break;
				default:
				    System.out.println("Z�a odpowied�");
				    break;
			}
			System.out.println();
			System.out.println();
		}
		
		in.close();
		
		entityManager.close();
		entityManagerFactory.close();
	}
}
