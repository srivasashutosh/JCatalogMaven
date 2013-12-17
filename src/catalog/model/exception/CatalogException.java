/*
 * JCatalog Project
 */
package catalog.model.exception;

/**
 * Base checked exception for the JCatalog Project.
 * 
 * @author <a href="mailto:derek_shen@hotmail.com">Derek Y. Shen</a>
 */
public class CatalogException extends Exception{
	/**
	 * Constructor with error message.
	 * 
	 * @param msg the error message associated with the exception
	 */
	public CatalogException(String msg) {
		super(msg);
	}
	
	/**
	 * Constructor with error message and root cause.
	 * 
	 * @param msg the error message associated with the exception
	 * @param cause the root cause of the exception
	 */
	public CatalogException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
