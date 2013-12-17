/*
 * JCatalog Project
 */
package catalog.model.service.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataIntegrityViolationException;

import catalog.model.businessobject.Category;
import catalog.model.businessobject.Product;
import catalog.model.dao.CatalogDao;
import catalog.model.exception.CatalogException;
import catalog.model.exception.DuplicateProductIdException;
import catalog.model.service.CatalogService;


/**
 * The implementation of the <code>CatalogService</code>.
 * <p>
 * Spring Framework is used to manage this service bean.
 * Since this class is not dependend on Spring API, it can be used outside the Spring IOC container.
 * <p>
 * Read/write caches for products and categories are implemented inside this class.
 * It will be configured as a singleton in the Spring container.
 * So the caches are in the application scope.
 * 
 * @author <a href="mailto:derek_shen@hotmail.com">Derek Y. Shen</a>
 * @see CatalogService
 */
public class CachedCatalogServiceImpl implements CatalogService {
	//the logger for this class
	private Log logger = LogFactory.getLog(this.getClass());
	
	//the CatalogDao used
	private CatalogDao catalogDao;
	
	//the read/write cache for products
	private Map productCache;
	
	//the read/write cache for categories
	private Map categoryCache;
	
	/**
	 * Default constructor.
	 * 
	 * @throws CatalogException If internal error occurs while populates the caches
	 */
	@SuppressWarnings("unchecked")
	public CachedCatalogServiceImpl() throws CatalogException {
		this.productCache = Collections.synchronizedMap(new LinkedHashMap());
		this.categoryCache = Collections.synchronizedMap(new LinkedHashMap());
	}
	
	/* Set the <code>CatalogDao</code>.
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
	@SuppressWarnings("unchecked")
	public Product saveProduct(Product product) throws CatalogException {
		this.logger.debug(("entering method saveProduct"));
		
		try {
			Product newProduct = this.catalogDao.saveProduct(product);
			
			this.productCache.put(newProduct.getId(), newProduct);
			
			return newProduct;
		} catch (DataIntegrityViolationException de) {
			String msg = "Could not save product, duplicate product id " + de.getMessage();
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
	@SuppressWarnings("unchecked")
	public void updateProduct(Product product) throws CatalogException {
		this.logger.debug(("entering method updateProduct"));
		
		try {
			this.catalogDao.updateProduct(product);
			
			this.productCache.put(product.getId(), product);
		} catch (Exception e) {
			String msg = "Could not update product " + e.getMessage();
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
			
			this.productCache.remove(product.getId());
		} catch (Exception e) {
			String msg = "Could not delete product " + e.getMessage();
			this.logger.error(msg, e);
			
			throw new CatalogException(msg, e);
		}		
	}

	/**
	 * @see CatalogService#getProduct(String)
	 */	
	public Product getProduct(String id) {
		return (Product)this.productCache.get(id);
	}

	/**
	 * @see CatalogService#getCategory(String)
	 */	
	public Category getCategory(String id) {
		return (Category)this.categoryCache.get(id);
	}

	/**
	 * @see CatalogService#getAllProducts()
	 */	
	public List getAllProducts() {
		return this.getValueList(this.productCache);
	}
	
	public List getAllCategories() {
		return this.getValueList(this.categoryCache);
	}
	
	public void init() throws CatalogException {
		try {
			this.populateCache();
		} catch (Exception e) {
			String msg = "Could not populate cache";
			this.logger.error(msg, e);
			
			throw new CatalogException(msg, e);
		}
	}

	/**
	 * @see CatalogService#getAllCategories()
	 */	
	private void populateCache() {
		List products = this.catalogDao.getAllProducts();
		
		for (int i=0; i<products.size(); i++) {
			Product p = (Product)products.get(i);
			this.productCache.put(p.getId(), p);
		}
		
		List categories = this.catalogDao.getAllCategories();
		
		for (int i=0; i<categories.size(); i++) {
			Category c = (Category)categories.get(i);
			this.categoryCache.put(c.getId(), c);
		}
	}
	
	private List getValueList(Map data) {
		List list = new LinkedList();
		Collection values = data.values();
		
		Iterator ite = values.iterator();
		while(ite.hasNext()) {
			list.add(ite.next());
		}
		
		return list;
	}

	
}