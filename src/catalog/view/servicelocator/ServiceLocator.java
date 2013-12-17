/**
 * JCatalog Project
 */
package catalog.view.servicelocator;

import catalog.model.service.CatalogService;
import catalog.model.service.UserService;

/**
 * Interface needs to be implemented by ServiceLocator.
 * <p>
 * ServiceLocator is used to lookup for business services.
 * 
 * @author <a href="mailto:derek_shen@hotmail.com">Derek Y. Shen</a>
 */
public interface ServiceLocator {
	/**
	 * Get the <code>CatalogService</code>.
	 * 
	 * @return the catalog service
	 */
	public CatalogService getCatalogService();
	
	/**
	 * Get the <code>UserService</code>.
	 * 
	 * @return the user service
	 */
	public UserService getUserService();
}
