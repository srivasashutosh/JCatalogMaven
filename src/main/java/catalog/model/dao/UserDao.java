/*
 * JCatalog Project
 */
package catalog.model.dao;

import catalog.model.businessobject.User;

/**
 * The user DAO interface.
 * <p>
 * This class contains user management related data access logic.
 * 
 * @author <a href="mailto:derek_shen@hotmail.com">Derek Y. Shen</a>
 */
public interface UserDao {
	/**
	 * Get user by username.
	 * 
	 * @param username the username
	 * @return the user associated with the username
	 */
	public User getUser(String username);
}
