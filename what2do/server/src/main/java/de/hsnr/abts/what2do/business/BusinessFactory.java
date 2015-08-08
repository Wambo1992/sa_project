package de.hsnr.abts.what2do.business;

import java.util.List;

import org.dozer.Mapper;

import de.hsnr.abts.what2do.data.entities.CategoryEntity;
import de.hsnr.abts.what2do.data.entities.DatabaseFactory;
import de.hsnr.abts.what2do.data.entities.TaskEntity;
import de.hsnr.abts.what2do.data.entities.UserEntity;
import de.hsnr.abts.what2do.util.dozer.DozerUtil;

public class BusinessFactory {
	public Mapper mapper;
	private static DatabaseFactory databaseFactory;
	
	public BusinessFactory() {
		mapper = DozerUtil.getMapper();
	}

	public User createUser(String username, String password) {
		UserEntity u = getDatabaseFactory().createUser(username, password);
		return this.mapper.map(u, User.class);
	}

	public Task createTask(String categoryId, String title) {
		TaskEntity t = getDatabaseFactory().createTask(categoryId, title);
		return this.mapper.map(t, Task.class);
	}
	
	public Category createCategory(String userId, String title) {
		CategoryEntity c = getDatabaseFactory().createCategory(userId, title);
		return this.mapper.map(c, Category.class);
	}

	public Category getCategoryById(String id) {
		CategoryEntity cat = getDatabaseFactory().getCategoryById(id);
		return this.mapper.map(cat, Category.class);
	}

	public Task getTaskById(String id) {
		TaskEntity t = getDatabaseFactory().getTaskById(id);
		return this.mapper.map(t, Task.class);
	}

	public User getUserById(String id) {
		UserEntity u = getDatabaseFactory().getUserById(id);
		return this.mapper.map(u, User.class);
	}

	public List<Task> getTasks(UserEntity u) {
		List<TaskEntity> taskList = getDatabaseFactory().getTasks(u);
		return (List<Task>) DozerUtil.dozerMapCollections(taskList, Task.class);
	}
	
	public List<Task> getTasks(String userId) {
		UserEntity u = getDatabaseFactory().getUserById(userId);
		return getTasks(u);
	}

	public List<Task> getTasks(CategoryEntity c) {
		List<TaskEntity> taskList = getDatabaseFactory().getTasks(c);
		return (List<Task>) DozerUtil.dozerMapCollections(taskList, Task.class);
	}

	public List<Task> getTasks(Category c) {
		CategoryEntity cat = getDatabaseFactory().getCategoryById(c.getId());
		List<TaskEntity> taskList = getDatabaseFactory().getTasks(cat);
		return (List<Task>) DozerUtil.dozerMapCollections(taskList, Task.class);
	}

	public List<User> getUsers() {
		List<UserEntity> userList = getDatabaseFactory().getUsers();
		return (List<User>) DozerUtil.dozerMapCollections(userList, User.class);
	}

	public List<Category> getCategories(UserEntity user) {
		List<CategoryEntity> categoryList = getDatabaseFactory().getCategories(user);
		return (List<Category>) DozerUtil.dozerMapCollections(categoryList, Category.class);
	}
	
	public DatabaseFactory getDatabaseFactory() {
		if(BusinessFactory.databaseFactory == null) {
			BusinessFactory.databaseFactory = new DatabaseFactory();
		} 
		return BusinessFactory.databaseFactory;
	}
}
