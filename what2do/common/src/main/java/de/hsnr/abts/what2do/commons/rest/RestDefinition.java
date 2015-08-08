package de.hsnr.abts.what2do.commons.rest;

public abstract class RestDefinition {
	/**
	 * Rest Prefix for data access
	 */
	public static final String REST_PATH_DATA = "/data";

	//##########################
	// GET
	//##########################
	
	/**
	 * All Categories of User with ID {ID}
	 */
	public static final String GET_DATA_CATEGORIES_USER_ALL = "/categories/user/{ID}";
	
	/**
	 *  Category with ID {ID}
	 */
	public static final String GET_DATA_CATEGORIES_BY_ID = "/categories/id/{ID}";
	
	/**
	 * All Users
	 */
	public static final String GET_DATA_USER_ALL = "/users";
	
	/**
	 * User with ID {ID}
	 */
	public static final String GET_DATA_USER_BY_ID = "/users/{ID}";
	
	/**
	 * All Tasks from Category with ID {ID}
	 */
	public static final String GET_DATA_TASK_BY_ID = "/tasks/{ID}";
		
	/**
	 * All Tasks of User with ID {ID}
	 */
	public static final String GET_DATA_TASK_USER_ALL = "/tasks/user/{ID}";
	
	/**
	 * All Tasks from Category with ID {ID}
	 */
	public static final String GET_DATA_TASK_CATEGORY_ALL = "/tasks/category/{ID}";
	

	//##########################
	// POST
	//##########################

}
