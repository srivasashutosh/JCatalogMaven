/*
 * JCatalog Project
 */
package catalog.model.dao;

import java.util.List;
//
import catalog.model.businessobject.Product;
import catalog.model.businessobject.Category;

/**
 * Catalog DAO interface.
 * <p>
 * This class contains catalog management related data access logic.
 * 
 * @author <a href="mailto:derek_shen@hotmail.com">Derek Y. Shen</a>
 */
public interface CatalogDao {
	/**
	 * Save the product.
	 * 
	 * @param product the product to be saved
	 * @return the product saved
	 */
	public abstract Product saveProduct(Product product);
	
	/**
	 * Get product by product id.
	 * 
	 * @param id the product id
	 * @return the product associated with the product id
	 */
	public abstract Product getProduct(String id);
	
	/**
	 * Update product.
	 * 
	 * @param product the product to be updated
	 */
	public abstract void updateProduct(Product product);
	
	/**
	 * Delete product.
	 * 
	 * @param product the product to be deleted
	 */
	public abstract void deleteProduct(Product product);
	
	/**
	 * Get all the products.
	 * 
	 * @return a list of all products
	 */
	public abstract List getAllProducts();
	
	/**
	 * Get category by category id.
	 * 
	 * @param id The category id
	 * @return the category associated with the category id
	 */
	public abstract Category getCategory(String id);
	
	/**
	 * Get all categories.
	 * 
	 * @return a list of all categories
	 */
	public abstract List getAllCategories();
}
