/*
 * JCatalog Project
 */
package catalog.model.businessobject;

/**
 * User business object.
 * 
 * @author <a href="mailto:derek_shen@hotmail.com">Derek Y. Shen</a>
 */
public class User {
	private String username;
	private String password;
	
	/**
	 * Default constructor.
	 */
	public User() {
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public void setUsername(String newUsername) {
		this.username = newUsername;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String newPassword) {
		this.password = newPassword;
	}
}
