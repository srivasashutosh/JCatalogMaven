/*
 * JCatalog Project
 */
package catalog.model.service.impl;

import java.util.List;

//
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
//
import org.springframework.dao.DataIntegrityViolationException;

import catalog.model.businessobject.Category;
import catalog.model.businessobject.Product;
import catalog.model.dao.CatalogDao;
import catalog.model.exception.CatalogException;
import catalog.model.exception.DuplicateProductIdException;
//
import catalog.model.service.CatalogService;

/**
 * The implementation of the <code>CatalogService</code>.
 * <p>
 * Spring Framework is used to manage this service bean.
 * Since this class is not dependend on Spring API, it can be used outside the Spring IOC container.
 * <p>
 * It is not used in the sample application. 
 * The <code>CachedCatalogServiceImpl</code> is used instead.
 * The purpose of this class is to show you by using Spring Framework, 
 * you can use different implementations of the same interface without code changing and factory.
 * 
 * @author <a href="mailto:derek_shen@hotmail.com">Derek Y. Shen</a>
 * @see CatalogService
 * @see CachedCatalogServiceImpl
 */
public class CatalogServiceImpl implements CatalogDao {
	//the logger for this class
	private Log logger = LogFactory.getLog(this.getClass());
	
	//the CatalogDao used
	private CatalogDao catalogDao;
	
	/**
	 * Set the <code>CatalogDao</code>.
	 * <p>
	 * It can be used by the Spring IOC container.
	 * 
	 * @param newCatalogDao the CatalogDao to be set
	 */
	public void setCatalogDao(CatalogDao newCatalogDao) {
		this.catalogDao = newCatalogDao;
	}
	
	/**
	 * @see CatalogService#saveProduct(Product)
	 */
	public Product saveProduct(Product product) throws CatalogException {
		this.logger.debug(("entering method saveProduct"));
		
		try {
			Product newProduct = this.catalogDao.saveProduct(product);
			
			return newProduct;
		} catch (DataIntegrityViolationException de) {
			String msg = "Could not save product, duplicate product id";
			this.logger.error(msg, de);
			
			throw new DuplicateProductIdException(msg, de);
		} catch (Exception e) {
			String msg = "Could not save product " + e.toString();
			this.logger.error(msg, e);
			
			throw new CatalogException(msg, e);
		}
	}

	/**
	 * @see CatalogService#updateProduct(Product)
	 */
	public void updateProduct(Product product) throws CatalogException {
		this.logger.debug(("entering method updateProduct"));
		
		try {
			this.catalogDao.updateProduct(product);
		} catch (Exception e) {
			String msg = "Could not update product";
			this.logger.error(msg, e);
			
			throw new CatalogException(msg, e);
		}		
	}
	
	/**
	 * @see CatalogService#deleteProduct(Product)
	 */
	public void deleteProduct(Product product) throws CatalogException {
		this.logger.debug(("entering method deleteProduct"));
		
		try {
			this.catalogDao.deleteProduct(product);
		} catch (Exception e) {
			String msg = "Could not delete product";
			this.logger.error(msg, e);
			
			throw new CatalogException(msg, e);
		}		
	}
	
	/**
	 * @see CatalogService#getProduct(String)
	 */
	public Product getProduct(String id) throws CatalogException {
		try {
			return this.catalogDao.getProduct(id);
		} catch (Exception e) {
			String msg = "Could not get product for id of " + id;
			this.logger.error(msg, e);
			
			throw new CatalogException(msg, e);
		}
	}
	
	/**
	 * @see CatalogService#getCategory(String)
	 */
	public Category getCategory(String id) throws CatalogException {
		try {
			return this.catalogDao.getCategory(id);
		} catch (Exception e) {
			String msg = "Could not get category for id of " + id;
			this.logger.error(msg, e);
			
			throw new CatalogException(msg, e);
		}
	}
	
	/**
	 * @see CatalogService#getAllProducts()
	 */
	public List getAllProducts() throws CatalogException {
		try {
			return this.catalogDao.getAllProducts();
		} catch (Exception e) {
			String msg = "Could not get all products";
			this.logger.error(msg, e);
			
			throw new CatalogException(msg, e);
		}
	}
	
	/**
	 * @see CatalogService#getAllCategories()
	 */
	public List getAllCategories() throws CatalogException {
		try {
			return this.catalogDao.getAllCategories();
		} catch (Exception e) {
			String msg = "Could not get all categories";
			this.logger.error(msg, e);
			
			throw new CatalogException(msg, e);
		}
	}
}
