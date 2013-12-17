/*
 * JCatalog Project
 */
package catalog.model.exception;

/**
 * Exception thrown when a product with duplicate id is to be inserted.
 * 
 * @author <a href="mailto:derek_shen@hotmail.com">Derek Y. Shen</a>
 * @see CatalogException
 */
public class DuplicateProductIdException extends CatalogException {
	/**
	 * Constructor.
	 * 
	 * @param msg the error message
	 * @param cause the root cause of the exception
	 */
	public DuplicateProductIdException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
