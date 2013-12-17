/*
 * JCatalog Project
 */
package catalog.view.builder;

import org.apache.commons.beanutils.BeanUtils;
//
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
//
import catalog.view.bean.ProductBean;
import catalog.model.businessobject.Product;
import catalog.model.exception.CatalogException;

/**
 * The builder class for <code>ProductBean</code> and <code>Product</code>.
 * <p>
 * The backing beans are used view objects in the presentation tier.
 * The business objects are used in the business logic tier.
 * This class is used to convert in between the backing beans and business objects.
 * <p>
 * Commons BeanUtils is used.
 * 
 * @author <a href="mailto:derek_shen@hotmail.com">Derek Y. Shen</a>
 * @see <a href="http://jakarta.apache.org/commons/beanutils/">Commons BeanUtils</a>
 */
public class ProductBuilder {
	//the logger for this class
	private static Log logger = LogFactory.getLog("catalog.view.builder.ProductBeanBuilder");
	
	/**
	 * Populate the <code>ProductBean<code> based on the <code>Product</code> business object.
	 * 
	 * @param productBean the product bean to be populated
	 * @param product the product business object
	 * @throws CatalogException
	 */
	public static void populateProductBean(ProductBean productBean, Product product) throws CatalogException {
		try {
			BeanUtils.copyProperties(productBean, product);
		} catch (Exception e) {
			throw new CatalogException("Could not populate ProductBean " + e.toString(), e);
		}
	}
	
	/**
	 * Create a new <code>ProductBean</code> based on the <code>Product</code> business object.
	 * 
	 * @param product the product business object
	 * @return the new product bean
	 * @throws CatalogException
	 */
	public static ProductBean createProductBean(Product product) throws CatalogException {
		ProductBean productBean = new ProductBean();
		
		try {
			BeanUtils.copyProperties(productBean, product);
		} catch (Exception e) {
			throw new CatalogException("Could not build ProductBean " + e.toString(), e);
		}
		return productBean;
	}
	
	/**
	 * Create a new <code>Product</code> based on the <code>ProductBean</code>
	 * 
	 * @param productBean the product managed bean
	 * @return the new product business object
	 * @throws CatalogException
	 */
	public static Product createProduct(ProductBean productBean) throws CatalogException {
		Product product = new Product();
		
		try {
			BeanUtils.copyProperties(product, productBean);
		} catch (Exception e) {
			throw new CatalogException("Could not build Product " + e.toString(), e);
		}
		
		if (productBean.getSelectedCategoryIds() != null) {
			for (int i=0; i<productBean.getSelectedCategoryIds().size(); i++) {
				product.addCategoryId((String)productBean.getSelectedCategoryIds().get(i));
			}
		}	
		
		return product;	
	}
}
