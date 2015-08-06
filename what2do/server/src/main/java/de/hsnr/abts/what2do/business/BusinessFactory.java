package de.hsnr.abts.what2do.business;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import de.hsnr.abts.what2do.data.entities.CategoryEntity;
import de.hsnr.abts.what2do.data.entities.TaskEntity;
import de.hsnr.abts.what2do.data.entities.UserEntity;

public class BusinessFactory {
	private List<String> list;
	public Mapper mapper;

	public BusinessFactory() {
		list = new ArrayList<String>();	
		list.add("dozer.xml");
		mapper = new DozerBeanMapper(list);	
	}

	public User createUser(UserEntity u) {
		return this.mapper.map(u, User.class);
	}

	public Task createTask(TaskEntity t) {
		return this.mapper.map(t, Task.class);
	}
	
	public Category createCategory(CategoryEntity c) {
		return this.mapper.map(c, Category.class);
	}

}
