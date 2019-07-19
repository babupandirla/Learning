package Test;

import javax.persistence.*;

import com.bookstore.entity.Category;

public class Categorytest {

	public static void main(String[] args) {
		
	Category category1 =new Category("Machine learning");
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("BookStoreWebsite");
	EntityManager em=emf.createEntityManager();
	em.getTransaction().begin();
	em.persist(category1);
	em.getTransaction().commit();
	em.close();
	emf.close();
	
	}

}
