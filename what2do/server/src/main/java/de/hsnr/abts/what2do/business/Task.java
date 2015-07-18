package de.hsnr.abts.what2do.business;

import java.util.Date;

import de.hsnr.abts.what2do.data.entities.CategoryEntity;

public class Task {
	private String id;
	private CategoryEntity category;
	private String title;
	private Integer priority;
	private Date dueDate;
	private Date notificationDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getNotificationDate() {
		return notificationDate;
	}

	public void setNotificationDate(Date notificationDate) {
		this.notificationDate = notificationDate;
	}

}
