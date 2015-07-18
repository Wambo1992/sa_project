package de.hsnr.abts.what2do.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import junit.framework.TestCase;

import org.junit.Test;

import de.hsnr.abts.what2do.data.entities.CategoryEntity;
import de.hsnr.abts.what2do.data.entities.TaskEntity;
import de.hsnr.abts.what2do.data.entities.UserEntity;

public class EntityTest extends TestCase {
	EntityManagerFactory emf = null;
	EntityManager em = null;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		// Create Entity Manager
		emf = Persistence.createEntityManagerFactory("mongodb");
		em = emf.createEntityManager();
		
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		if (em != null)
			em.close();
		if (emf != null)
			emf.close();
	}

	@Test
	public void testWriteToDB() {

		try {
			String username = "testUser";
			String password = "testUserPW";
			// Write to DB
			UserEntity user = createUser(username, password);

			// Read from DB
			UserEntity newUser = em.find(UserEntity.class, user.getId());

			assertEquals(username, newUser.getUsername());
			assertEquals(password, newUser.getPassword());
			assertNotNull(newUser.getId());

			// Write to DB
			String categoryName = "Einkaufsliste";
			CategoryEntity category = createCategory(categoryName, newUser);

			// Read from DB
			CategoryEntity newCategory = em.find(CategoryEntity.class,
					category.getId());

			assertEquals(categoryName, newCategory.getTitle());
			assertEquals(newUser, newCategory.getUser());
			assertNotNull(newCategory.getId());

			// WriteToDB
			String titleTask1 = "Brot";
			String titleTask2 = "Eier";
			String titleTask3 = "Butter";

			TaskEntity task1 = createTask(titleTask1, newCategory);
			TaskEntity task2 = createTask(titleTask2, newCategory);
			TaskEntity task3 = createTask(titleTask3, newCategory);

			// Read from DB
			TaskEntity newTask1 = em.find(TaskEntity.class, task1.getId());
			TaskEntity newTask2 = em.find(TaskEntity.class, task2.getId());
			TaskEntity newTask3 = em.find(TaskEntity.class, task3.getId());

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
		}

	}

	private UserEntity createUser(String username, String password) {
		// start Transaction
		em.getTransaction().begin();
		// Create User
		UserEntity user = new UserEntity(username, password);
		em.persist(user);
		em.getTransaction().commit();
		return user;
	}

	private CategoryEntity createCategory(String categoryName, UserEntity user) {
		// start Transaction
		em.getTransaction().begin();

		// Create Category
		CategoryEntity category = new CategoryEntity(categoryName, user);
		em.persist(category);
		em.getTransaction().commit();

		return category;
	}

	private TaskEntity createTask(String desc, CategoryEntity category) {
		// start Transaction
		em.getTransaction().begin();

		// Create Task
		TaskEntity task = new TaskEntity(desc, category);
		em.persist(task);
		em.getTransaction().commit();
		return task;
	}
}
