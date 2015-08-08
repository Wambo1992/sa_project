package de.hsnr.abts.what2do.data.entities;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.bson.types.ObjectId;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DatabaseFactory {
	private EntityManager em;

	private static Session session;

	public DatabaseFactory() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("mongodb");
		em = emf.createEntityManager();
	}

	private Session getSession() {
		if (DatabaseFactory.session == null
				|| !DatabaseFactory.session.isOpen()) {
			session = em.unwrap(Session.class);
		}
		return DatabaseFactory.session;
	}

	public void close() {
		if (getSession().isOpen())
			getSession().close();
	}

	public List<CategoryEntity> getCategories(UserEntity user) {
		String query = "from  CategoryEntity c where c.userid = :id";
		Query q = getSession().createQuery(query).setString("id",
				user.getId().toString());

		// Query q = em.createQuery(
		// "SELECT * FROM CategoryEntity c where c.userid = :id")
		// .setParameter("id", user.getId().toString());

		return (List<CategoryEntity>) q.list();
	}

	public List<UserEntity> getUsers() {
		String query = "from  UserEntity u";
		Query q = getSession().createQuery(query);
		// Criteria criteria = getSession().createCriteria(UserEntity.class);
		// Query q = em.createQuery("SELECT * FROM UserEntity u");
		return (List<UserEntity>) q.list();
	}

	public List<TaskEntity> getTasks(CategoryEntity c) {
		String query = "from  TaskEntity t where t.category = :cat";
		Query q = getSession().createQuery(query).setParameter("cat", c);
		// Criteria criteria = getSession().createCriteria(TaskEntity.class);
		// criteria.add(Restrictions.eq("category", c));
		return (List<TaskEntity>) q.list();
	}

	public List<TaskEntity> getTasks(UserEntity u) {
		String query = "from  TaskEntity t where t.userid = :id";
		Query q = getSession().createQuery(query).setParameter("id", u.getId());
		// Criteria criteria = getSession().createCriteria(TaskEntity.class);
		// criteria.add(Restrictions.eq("category.user", u));
		return (List<TaskEntity>) q.list();
	}

	public UserEntity getUserById(String id) {
		String query = "from  UserEntity u where u.id = :id";
		Query q = getSession().createQuery(query).setParameter("id",
				new ObjectId(id));
		//
		// // Criteria criteria = getSession().createCriteria(UserEntity.class);
		// // criteria.add(Restrictions.eq("id", id));
		return (UserEntity) q.uniqueResult();
	}

	public TaskEntity getTaskById(String id) {
		String query = "from  TaskEntity t where t.id = :id";
		Query q = getSession().createQuery(query).setParameter("id",
				new ObjectId(id));
		// Criteria criteria = getSession().createCriteria(TaskEntity.class);
		// criteria.add(Restrictions.eq("id", id));
		return (TaskEntity) q.uniqueResult();
	}

	public CategoryEntity getCategoryById(String id) {
		String query = "from  CategoryEntity c where c.id = :id";
		Query q = getSession().createQuery(query).setParameter("id",
				new ObjectId(id));
		// Criteria criteria =
		// getSession().createCriteria(CategoryEntity.class);
		// criteria.add(Restrictions.eq("id", id));
		return (CategoryEntity) q.uniqueResult();
	}

	public UserEntity createUser(String username, String password) {
		Transaction trans = getSession().beginTransaction();
		UserEntity user = new UserEntity(username, password);
		session.save(user);
		trans.commit();
		return user;
	}

	public TaskEntity createTask(String title, String categoryId) {
		Transaction trans = getSession().beginTransaction();
		CategoryEntity cat = getCategoryById(categoryId);
		TaskEntity task = new TaskEntity(title, cat);
		session.save(task);
		trans.commit();
		return task;
	}

	public CategoryEntity createCategory(String title, String userId) {
		Transaction trans = getSession().beginTransaction();
		UserEntity user = getUserById(userId);
		CategoryEntity cat = new CategoryEntity(title, user);
		session.save(cat);
		trans.commit();
		return cat;
	}
}
