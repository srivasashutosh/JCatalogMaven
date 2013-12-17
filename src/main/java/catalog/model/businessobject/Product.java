/*
 * JCatalog Project
 */
package catalog.model.businessobject;

import java.util.Set;
import java.util.HashSet;

/**
 * Product business object.
 * 
 * @author <a href="mailto:derek_shen@hotmail.com">Derek Y. Shen</a>
 */
public class Product {
	private String id;
	private String name;
	private String description;
	private double price;
	private double width;
	private double height;
	private Set categoryIds;
	
	/**
	 * Default constructor.
	 */
	public Product() {
		this.categoryIds = new HashSet();
	}
	
	public String getId() {
		return this.id;
	}
	
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
	
	public double getPrice() {
		return this.price;
	}
	
	public void setPrice(double newPrice) {
		this.price = newPrice;
	}
	
	public Set getCategoryIds() {
		return this.categoryIds;
	}
	
	public void setCategoryIds(Set newCategoryIds) {
		this.categoryIds = newCategoryIds;
	}
	
	public void addCategoryId(String id) {
		this.categoryIds.add(id);
	}
}
