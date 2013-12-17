/*
 * JCatalog Project
 */
package catalog.view.bean;

/**
 * The managed bean with session scope. 
 * <p>
 * It is used as a session scope cache.
 * In JSF, the properties are set by bean management facility.
 * 
 * @author <a href="mailto:derek_shen@hotmail.com">Derek Y. Shen</a>
 */
public class SessionBean {
	private String currentProductId;
	
	public SessionBean() {
	}
	
	public String getCurrentProductId(){
		return this.currentProductId;
	}
	
	public void setCurrentProductId(String newCurrentProductId) {
		this.currentProductId = newCurrentProductId;
	}
}
