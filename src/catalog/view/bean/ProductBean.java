/*
 * JCatalog Project
 */
package catalog.view.bean;

import java.util.Set;
import java.util.HashSet;
import java.util.List;
//
import javax.faces.FacesException;
//
import catalog.model.businessobject.Product;
import catalog.model.exception.DuplicateProductIdException;
import catalog.model.exception.CatalogException;
import catalog.view.util.ViewUtils;
import catalog.view.util.FacesUtils;
import catalog.view.builder.ProductBuilder;

/**
 * Product backing bean.
 * <p>
 * Used by the createProduct page and editProduct page.
 * 
 * @author <a href="mailto:derek_shen@hotmail.com">Derek Y. Shen</a>
 */
public class ProductBean extends BaseBean {
	//the product id
	private String id;
	
	//the product name
	private String name;
	
	//the product description
	private String description;
	
	//the product price
	private double price;
	
	//the product width
	private double width;
	
	//the product height
	private double height;
	
	//the category ids associated with the product
	private Set categoryIds;
	
	//the category id selected by the user on the page
	private List selectedCategoryIds;
	
	/**
	 * Default constructor.
	 */
	public ProductBean() {
		this.categoryIds = new HashSet();
		this.logger.debug("ProductBean is created");
	}
	
	/**
	 * Initializes ProductBean.
	 * 
	 * @see BaseBean#init()
	 */
	protected void init() {
		this.logger.debug("id = " + this.id);
		
		try {
			if (this.id != null) {
				Product p = this.serviceLocator.getCatalogService().getProduct(this.id);
				ProductBuilder.populateProductBean(this, p);
				
				this.logger.debug("Product with id of " + this.id + "is retrieved successfully");
			}
		} catch (CatalogException ce) {
			String msg = "Could not retrieve Product with id of " + this.id;
			this.logger.debug(msg, ce);
			
			throw new FacesException(msg, ce);
		}
	}
	
	/**
	 * Backing bean action to update product.
	 * 
	 * @return the navigation result
	 */
	public String updateAction() {
		this.logger.debug("updateAction is invoked");
		
		try {
			Product product = ProductBuilder.createProduct(this);
			this.logger.debug("productId = " + product.getId());
			
			this.serviceLocator.getCatalogService().updateProduct(product);
			
			//remove the productList inside the cache
			FacesUtils.resetManagedBean(BeanNames.PRODUCT_LIST_BEAN);
		} catch (Exception e) {
			String msg = "Could not update product";
			this.logger.error(msg, e);
			FacesUtils.addErrorMessage(msg + ": Internal Error.");
			
			return NavigationResults.FAILURE;
		}
	
		String msg = "Product with id of " + this.id + " was updated successfully.";
		this.logger.debug(msg);
		FacesUtils.addInfoMessage(msg);
		
		return NavigationResults.SUCCESS;
	}
	
	/**
	 * Backing bean action to create a new product.
	 * 
	 * @return the navigation result
	 */
	public String createAction() {
		this.logger.debug("createAction is invoked");
		
		try {
			Product product = ProductBuilder.createProduct(this);
			
			this.serviceLocator.getCatalogService().saveProduct(product);

			//store the current product id inside the session bean.
			//for the use of image uploader.
			FacesUtils.getSessionBean().setCurrentProductId(this.id);
			
			//remove the productList inside the cache
			this.logger.debug("remove ProductListBean from cache");
			FacesUtils.resetManagedBean(BeanNames.PRODUCT_LIST_BEAN);
		} catch (DuplicateProductIdException de) {
			String msg = "Product id already exists";
			this.logger.info(msg);
			FacesUtils.addErrorMessage(msg);
			
			return NavigationResults.RETRY;
		} catch (Exception e) {
			String msg = "Could not save product";
			this.logger.error(msg, e);
			FacesUtils.addErrorMessage(msg + ": Internal Error");
			
			return NavigationResults.FAILURE;
		}
		String msg = "Product with id of " + this.id + " was created successfully.";
		
		this.logger.debug(msg);
		FacesUtils.addInfoMessage(msg);
		
		return NavigationResults.SUCCESS;
	}
	
	/**
	 * Backing bean action to delete product.
	 * 
	 * @return the navigation result
	 */
	public String deleteAction() {
		this.logger.debug("deleteAction is invoked");
		
		try {
			Product product = ProductBuilder.createProduct(this);
			
			this.serviceLocator.getCatalogService().deleteProduct(product);
		
			//remove the productList inside the cache
			FacesUtils.resetManagedBean(BeanNames.PRODUCT_LIST_BEAN);
		} catch (Exception e) {
			String msg = "Could not delete product. ";
			this.logger.error(msg, e);
			FacesUtils.addErrorMessage(null, msg + "Internal Error.");
			
			return NavigationResults.FAILURE;
		}
		
		String msg = "Product with id of " + this.id + " was deleted successfully.";
		this.logger.debug(msg);
		FacesUtils.addInfoMessage(msg);
		
		return NavigationResults.SUCCESS;
	}
	
	public String getId() {
		return this.id;
	}
	
	/**
	 * Invoked by the JSF managed bean facility. 
	 * <p>
	 * The id is from the request parameter.
	 * If the id is not null, by using the id as the key,
	 * the product bean is initialized.
	 * 
	 * @param newQueryId the query id from request parameter
	 */
	public void setId(String newId) {
		this.id = newId;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String newName) {
		this.name = newName;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String newDescription) {
		this.description = newDescription;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public void setPrice(double newPrice) {
		this.price = newPrice;
	}
	
	public double getWidth() {
		return this.width;
	}
	
	public void setWidth(double newWidth) {
		this.width = newWidth;
	}
	
	public double getHeight() {
		return this.height;
	}
	
	public void setHeight(double newHeight) {
		this.height = newHeight;
	}
	
	public Set getCategoryIds() {
		return this.categoryIds;
	}
	
	public void setCategoryIds(Set newCategoryIds) {
		this.categoryIds = newCategoryIds;
		
		if (this.categoryIds != null) {
			this.selectedCategoryIds = ViewUtils.convertToList(this.categoryIds);
		}
	}
	
	public List getSelectedCategoryIds() {
		return this.selectedCategoryIds;
	}
	
	public void setSelectedCategoryIds(List newSelectedCategoryIds) {
		this.selectedCategoryIds = newSelectedCategoryIds;
		this.categoryIds = ViewUtils.convertToSet(selectedCategoryIds);
	}
	
	/**
	 * Get the short description of the product.
	 * <p>
	 * It is used in the productSummary page.
	 * 
	 * @return the short description of the product
	 */
	public String getShortDescription() {
		int shortDescriptionLength = 40;
		
		StringBuffer sb = new StringBuffer("");
		
		if (this.description != null) {
			String[] words = this.description.split(" ");
			
			int length = (shortDescriptionLength>words.length)?words.length:shortDescriptionLength;
			
			for (int i=0; i<length; i++) {
				sb.append(words[i]);
				sb.append(" ");
			}
		}
		
		return sb.toString().trim();
	}
	
	public String toString() {
		return "id=" + this.id + " name=" + this.name;
	}
}
