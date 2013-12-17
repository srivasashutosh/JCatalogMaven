/*
 * JCatalog Project
 */
package catalog.model.service;

import java.util.List;

//
import catalog.model.businessobject.Product;
import catalog.model.businessobject.Category;
import catalog.model.exception.CatalogException;
import catalog.model.exception.DuplicateProductIdException;

/**
 * The catalog business service interface.
 * <p>
 * This class contains catalog management related businss logic.
 * 
 * @author <a href="mailto:derek_shen@hotmail.com">Derek Y. Shen</a>
 */
public interface CatalogService {
	/**
	 * Save the product.
	 * 
	 * @param product the product to be saved
	 * @return the product saved
	 * @throws CatalogException
	 */
	public Product saveProduct(Product product)  throws CatalogException;

	/**
	 * Update product.
	 * 
	 * @param product the product to be updated
	 * @throws CatalogException
	 */
	public void updateProduct(Product product) throws CatalogException;
	
	/**
	 * Delete product.
	 * 
	 * @param product the product to be deleted
	 * @throws CatalogException
	 */
	public void deleteProduct(Product product) throws CatalogException;
	
	/**
	 * Get product by product id.
	 * @param productId the product id
	 * @return the product associated with the product id
	 * @throws CatalogException
	 */
	public Product getProduct(String productId) throws CatalogException;
	
	/**
	 * Get category by id.
	 * 
	 * @param categoryId the category id
	 * @return the category associated with the category id
	 * @throws CatalogException
	 */
	public Category getCategory(String categoryId) throws CatalogException;
	
	/**
	 * Get all products.
	 * 
	 * @return a list with all products
	 * @throws CatalogException
	 */
	public List getAllProducts() throws CatalogException;
	
	/**
	 * Get all categories.
	 * 
	 * @return a list with all categories
	 * @throws CatalogException
	 */
	public List getAllCategories() throws CatalogException;
}
