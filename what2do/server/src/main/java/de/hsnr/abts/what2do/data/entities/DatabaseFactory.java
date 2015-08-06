package de.hsnr.abts.what2do.data.entities;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class DatabaseFactory {
	private EntityManager em;
	Session session;

	public DatabaseFactory() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("mongodb");
		
		em = emf.createEntityManager();
		session = em.unwrap(Session.class);

	}

	public List<CategoryEntity> getCategories(UserEntity user) {
		Criteria criteria = session.createCriteria(CategoryEntity.class);
		criteria.add(Restrictions.eq("user", user));
		return (List<CategoryEntity>) criteria.list();
	}
	
	public List<UserEntity> getUsers() {
		Criteria criteria = session.createCriteria(UserEntity.class);
		return (List<UserEntity>) criteria.list();
	}
	
	public List<TaskEntity> getTasks(CategoryEntity c) {
		Criteria criteria = session.createCriteria(TaskEntity.class);
		criteria.add(Restrictions.eq("category", c));
		return (List<TaskEntity>) criteria.list();
	}
	
	public List<TaskEntity> getTasks(UserEntity u) {
		Criteria criteria = session.createCriteria(TaskEntity.class);
		criteria.add(Restrictions.eq("category.user", u));
		return (List<TaskEntity>) criteria.list();
	}
}
