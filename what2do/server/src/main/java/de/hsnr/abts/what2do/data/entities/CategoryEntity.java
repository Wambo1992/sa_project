package de.hsnr.abts.what2do.data.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.bson.types.ObjectId;


@Entity
@Table(name="CATEGORIES")
public class CategoryEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private ObjectId id;

	private String title;
	
	@OneToOne
	@JoinColumn(name = "userid")
	private UserEntity user;

	public CategoryEntity() {
		
	}
	
	public CategoryEntity(String title, UserEntity user) {
		setTitle(title);
		setUser(user);
	}

	
	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}
	
	
}
