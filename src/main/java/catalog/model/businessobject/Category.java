/*
 * JCatalog Project
 */
package catalog.model.businessobject;

/**
 * Category business object.
 * 
 * @author <a href="mailto:derek_shen@hotmail.com">Derek Y. Shen</a>
 */
public class Category {
	private String id;
	private String name;
	private String description;
	
	/**
	 * Default constructor.
	 */
	public Category() {
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
}
