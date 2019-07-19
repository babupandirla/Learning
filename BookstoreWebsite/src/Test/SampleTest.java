package Test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

import com.bookstore.dao.UserDAO;
import com.bookstore.entity.Users;

public class SampleTest {


	@Test
	void testCreateUsers() {
		Users user1 = new Users();
		user1.setEmail("abcd4@gmail.com");
		user1.setFullName("fourth user");
		user1.setPassword("abcd@004");

		EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();
		UserDAO userDAO = new UserDAO(entitymanager);
		user1 = userDAO.create(user1);
		entitymanager.close();
		entitymanagerfactory.close();
		int a = user1.getUserId();
		assertNotEquals(a, 0);
	}

	@Test
	void tetsUpdateuser() {
		Users user1 = new Users();
		user1.setUserId(3);
		user1.setEmail("abcd3@gmail.com");
		user1.setFullName("third user");
		user1.setPassword("abcd@003");
		EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();
		UserDAO userDAO = new UserDAO(entitymanager);
		user1 = userDAO.update(user1);
		entitymanager.close();
		entitymanagerfactory.close();
		String email = user1.getEmail();
		String expected = "abcd@gmail.com";
		assertNotEquals(email, expected);
	}

	@Test
	void getuser() {
		int userid = 3;
		EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();
		UserDAO userDAO = new UserDAO(entitymanager);
		Users user = userDAO.get(userid);
		entitymanager.close();
		entitymanagerfactory.close();
		assertNotNull(user);
		System.out.println(user.getEmail());
	}

	@Test
	void testdeleteuser() {
		int userid = 5;
		EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();
		UserDAO userDAO = new UserDAO(entitymanager);
		userDAO.delete(userid);
		Users user = userDAO.get(5);
		entitymanager.close();
		entitymanagerfactory.close();
		assertNull(user);
	}

//	@Test(expected = Exception.class)
//	void testnonexistingdeleteuser() {
//		int userid = 55;
//		EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
//		EntityManager entitymanager = entitymanagerfactory.createEntityManager();
//		UserDAO userDAO = new UserDAO(entitymanager);
//		userDAO.delete(userid);
//		entitymanager.close();
//		entitymanagerfactory.close();
//	}

	@Test
	public void testallusers() {
		EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();
		UserDAO userDAO = new UserDAO(entitymanager);
		List<Users> allusers = userDAO.listAll();
		entitymanager.close();
		entitymanagerfactory.close();
		assertTrue(allusers.size() > 0);
	}


}
