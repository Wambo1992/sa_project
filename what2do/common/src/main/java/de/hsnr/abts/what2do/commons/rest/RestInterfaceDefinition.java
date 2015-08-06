package de.hsnr.abts.what2do.commons.rest;

public interface RestInterfaceDefinition {
	/**
	 * Rest Prefix for data access
	 */
	public static String REST_PATH_DATA = "/data";

	//##########################
	// GET
	//##########################
	
	/**
	 * All Categories of User with ID {ID}
	 */
	public static String GET_DATA_CATEGORIES_USER_ALL = REST_PATH_DATA + "/categories/user/{ID}";
	
	/**
	 *  Category with ID {ID}
	 */
	public static String GET_DATA_CATEGORIES_BY_ID = REST_PATH_DATA + "/categories/id/{ID}";
	
	/**
	 * All Users
	 */
	public static String GET_DATA_USER_ALL = REST_PATH_DATA + "/users";
	
	/**
	 * User with ID {ID}
	 */
	public static String GET_DATA_USER_BY_ID = REST_PATH_DATA + "/users/{ID}";
	
	/**
	 * All Tasks from Category with ID {ID}
	 */
	public static String GET_DATA_TASK_BY_ID = REST_PATH_DATA + "/tasks/{ID}";
		
	/**
	 * All Tasks of User with ID {ID}
	 */
	public static String GET_DATA_TASK_USER_ALL = REST_PATH_DATA + "/tasks/user/{ID}";
	
	/**
	 * All Tasks from Category with ID {ID}
	 */
	public static String GET_DATA_TASK_CATEGORY_ALL = REST_PATH_DATA + "/tasks/category/{ID}";
	


	//##########################
	// POST
	//##########################

}
