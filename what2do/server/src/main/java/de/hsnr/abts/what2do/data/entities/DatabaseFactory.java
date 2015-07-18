package de.hsnr.abts.what2do.data.entities;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import de.hsnr.abts.what2do.business.Category;
import de.hsnr.abts.what2do.business.Task;
import de.hsnr.abts.what2do.business.User;

public class DatabaseFactory {
	private static List<String> list = new ArrayList<String>();
	static {
		list.add("dozer.xml");
	}
	public static Mapper mapper = new DozerBeanMapper(list);

	public static Category getCategory(CategoryEntity c) {
		return DatabaseFactory.mapper.map(c, Category.class);
	}

	public static User getUser(UserEntity u) {
		List<String> list = new ArrayList<String>();
		list.add("dozer.xml");
		Mapper mapper = new DozerBeanMapper(list);

		return mapper.map(u, User.class);
	}

	public static Task getTask(TaskEntity t) {

		return mapper.map(t, Task.class);
	}
}
