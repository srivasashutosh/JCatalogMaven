/**
 * JCatalog Project
 */
package catalog.view.bean;

import javax.servlet.ServletContext;
//
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
//
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
//
import catalog.model.service.CatalogService;
import catalog.model.service.UserService;
import catalog.view.servicelocator.ServiceLocator;
import catalog.view.util.FacesUtils;

/**
 * The implementation of <code>ServiceLocator</code>.
 * <p>
 * This class is managed by the JSF managed bean facility,
 * and is set with application scope.
 * 
 * @author <a href="mailto:derek_shen@hotmail.com">Derek Y. Shen</a>
 * @see ServiceLocator
 */
public class ServiceLocatorBean implements ServiceLocator {
	//the catalog service bean name
	private static final String CATALOG_SERVICE_BEAN_NAME = "catalogService";
	
	//the user service bean name
	private static final String USER_SERVICE_BEAN_NAME = "userService";
	
	//the logger for this class
	private Log logger = LogFactory.getLog(this.getClass());
	
	//the Spring application context
	private ApplicationContext appContext;
	
	//the cached catalog service
	private CatalogService catalogService;
	
	//the cached user service
	private UserService userService;
	
	/**
	 * Constructor.
	 * <p>
	 * The following steps being done:
	 * <ul>
	 * <li>retrieve Spring application context from servlet context.
	 * <li>look up <code>CatalogService</code> from Spring application context.
	 * <li>look up <code>UserService</code> from Spring applicatino context.
	 * </ul>
	 */
	public ServiceLocatorBean() {
		ServletContext context = FacesUtils.getServletContext();
		this.appContext = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
		this.catalogService = (CatalogService)this.lookupService(CATALOG_SERVICE_BEAN_NAME);
		this.userService = (UserService)this.lookupService(USER_SERVICE_BEAN_NAME);
		
		this.logger.info("Service locator bean is initialized");
	}
	
	/**
	 * Get the <code>CatalogService</code>
	 * 
	 * @return the catalog service
	 */
	public CatalogService getCatalogService() {
		return this.catalogService;
	}
	
	/**
	 * Get the <code>UserService</code>
	 * 
	 * @return the user service
	 */
	public UserService getUserService() {
		return this.userService;
	}
	
	/**
	 * Lookup service based on service bean name.
	 * 
	 * @param serviceBeanName the service bean name
	 * @return the service bean
	 */
	public Object lookupService(String serviceBeanName) {
		return appContext.getBean(serviceBeanName);
	}
}
