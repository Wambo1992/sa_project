package de.hsnr.abts.what2do.data;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.hibernate.HibernateException;
import org.junit.Test;

import de.hsnr.abts.what2do.data.entities.CategoryEntity;
import de.hsnr.abts.what2do.data.entities.DatabaseFactory;
import de.hsnr.abts.what2do.data.entities.TaskEntity;
import de.hsnr.abts.what2do.data.entities.UserEntity;

public class EntityTest {
	EntityManagerFactory emf = null;
	EntityManager em = null;
	DatabaseFactory dataFact;

	protected void setUp() throws Exception {
		// Create Entity Manager
		emf = Persistence.createEntityManagerFactory("mongodb");
		em = emf.createEntityManager();

		deleteAllData();
	}

	protected void tearDown() throws Exception {
		if (em != null)
			em.close();
		if (emf != null)
			emf.close();
		dataFact.close();
	}

	@Test
	public void testWriteToDB() {
		dataFact = new DatabaseFactory();
		try {
			String username = "testUser";
			String password = "testUserPW";
			// Write to DB
			UserEntity user = dataFact.createUser(username, password);

			// Read from DB
			UserEntity newUser = dataFact.getUserById(user.getId().toString());

			assertEquals(username, newUser.getUsername());
			assertEquals(password, newUser.getPassword());
			assertNotNull(newUser.getId());

			// Write to DB
			String categoryName = "Einkaufsliste";
			CategoryEntity category = dataFact.createCategory(categoryName,
					newUser.getId().toString());

			// Read from DB
			CategoryEntity newCategory = dataFact.getCategoryById(category.getId().toString());

			assertEquals(categoryName, newCategory.getTitle());
			assertEquals(newUser, newCategory.getUser());
			assertNotNull(newCategory.getId());

			// WriteToDB
			String titleTask1 = "Brot";
			String titleTask2 = "Eier";
			String titleTask3 = "Butter";

			TaskEntity task1 = dataFact.createTask(titleTask1, newCategory
					.getId().toString());
			TaskEntity task2 = dataFact.createTask(titleTask2, newCategory
					.getId().toString());
			TaskEntity task3 = dataFact.createTask(titleTask3, newCategory
					.getId().toString());

			// Read from DB
			TaskEntity newTask1 = dataFact.getTaskById(task1.getId().toString());
			TaskEntity newTask2 = dataFact.getTaskById(task2.getId().toString());
			TaskEntity newTask3 = dataFact.getTaskById(task3.getId().toString());

			assertEquals(titleTask1, newTask1.getTitle());
			assertEquals(newCategory, newTask1.getCategory());
			assertNotNull(newTask1.getCategory().getUser());
			assertNotNull(newTask1.getId());

			assertEquals(titleTask2, newTask2.getTitle());
			assertEquals(newCategory, newTask2.getCategory());
			assertNotNull(newTask2.getCategory().getUser());
			assertNotNull(newTask2.getId());

			assertEquals(titleTask3, newTask3.getTitle());
			assertEquals(newCategory, newTask3.getCategory());
			assertNotNull(newTask3.getCategory().getUser());
			assertNotNull(newTask3.getId());

		} catch (PersistenceException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} finally {
			dataFact.close();
		}
		
	}

	@Test
	public void testDatabaseFactory() {
		dataFact = new DatabaseFactory();
		
		UserEntity user = dataFact.createUser("test", "test");
		UserEntity u = dataFact.getUserById(user.getId().toString());

		assertEquals(u.getId(), user.getId().toString());
		assertEquals(u.getUsername(), user.getUsername());
		assertEquals(u.getPassword(), user.getPassword());

		CategoryEntity ce = dataFact.createCategory("TestCategory", user
				.getId().toString());
		CategoryEntity c = dataFact.getCategoryById(ce.getId().toString());

		assertEquals(c.getId(), ce.getId().toString());
		assertEquals(c.getTitle(), ce.getTitle());

		TaskEntity te = dataFact.createTask("TestTask", ce.getId().toString());
		TaskEntity t = dataFact.getTaskById(te.getId().toString());

		assertEquals(t.getId(), te.getId().toString());
		assertEquals(t.getTitle(), te.getTitle());
		
		dataFact.close();
	}

	@Test(expected = HibernateException.class)
	public void testDoubleEntriesForUser() throws Exception{
		dataFact = new DatabaseFactory();
		dataFact.createUser("test", "test");
		dataFact.createUser("test", "test");
	}
	private void deleteAllData() {
		// TODO: implement reset of Database
	}

}
