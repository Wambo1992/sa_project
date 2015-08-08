package de.hsnr.abts.what2do.data.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.bson.types.ObjectId;

@Entity
@Table(name="TASKS")
public class TaskEntity implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private ObjectId id;
	
	@OneToOne
	private CategoryEntity category;
	
	private String title;
	
	private Integer priority;
	
	@Temporal(TemporalType.DATE)
	private Date dueDate;
	
	@Temporal(TemporalType.DATE)
	private Date notificationDate;

	public TaskEntity(){}
	
	public TaskEntity(String title, CategoryEntity category) {
		this.category = category;
		this.title = title;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
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
