/*
 * JCatalog Project
 */
package catalog.view.bean;

import catalog.model.businessobject.User;
import catalog.model.exception.UsernameNotExistException;
import catalog.view.util.FacesUtils;

/** 
 * User backing bean.
 * 
 * @author <a href="mailto:derek_shen@hotmail.com">Derek Y. Shen</a>
 */
public class UserBean extends BaseBean {
	//the username of the current user
	private String username;
	
	//the password of the current user
	private String password;
	
	//whether or not the user is logged in
	private boolean loggedIn;
	
	/**
	 * Default constructor.
	 */ 
	public UserBean() {
		this.clear();
		this.logger.debug("UserBean is created");
	}
	
	/**
	 * Backing bean action to login a user.
	 * 
	 * @return the navigation result
	 */
	public String loginAction() {
		try {
			User user = this.serviceLocator.getUserService().login(this.username, this.password);
			
			if (user != null) {
				this.loggedIn = true;
				
				return NavigationResults.SUCCESS;
			}
			else {
				this.loggedIn = false;
				
				String msg = "Incorrect password ";
				FacesUtils.addErrorMessage(msg + ", please try again.");
				this.logger.debug(msg);
				
				return NavigationResults.RETRY;
			}
		}
		catch (UsernameNotExistException ue) {
			String msg = "Non-existing username ";
			this.logger.info(msg);
			FacesUtils.addErrorMessage(msg + ", please try again.");
			
			return NavigationResults.RETRY;
		}
		catch (Exception e) {
			this.logger.error("Could not log in user.", e);
			FacesUtils.addInfoMessage("Could not log in user: Internal Error");
			
			return NavigationResults.FAILURE;
		}
	}
	
	/**
	 * The backing bean action to logout a user.
	 * 
	 * @return the navigation result
	 */
	public String logoutAction() {
		this.clear();
		this.logger.debug("Logout successfully.");
		
		return NavigationResults.HOME;
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
	
	public boolean getLoggedIn() {
		return this.loggedIn;
	}
	
	public void setLoggedIn(boolean newLoggedIn) {
		this.loggedIn = newLoggedIn;
	}
	
	public String getDummyVariable() {
		return null;
	}
	
	private void clear() {
		this.username = null;
		this.password = null;
		this.loggedIn = false;
	}
}
