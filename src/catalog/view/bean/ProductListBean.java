/*
 * JCatalog Project
 */
package catalog.view.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Iterator;
//
import javax.faces.FacesException;
//
import catalog.model.businessobject.Product;
import catalog.view.builder.ProductBuilder;
import catalog.view.util.FacesUtils;

/**
 * ProductList backing bean.
 * <p>
 * It contains a list of <code>ProductBean</code>.
 * It is used for the catalog page and the productList page.
 * It contains the pagination logic for the catalog page.
 * 
 * @author <a href="mailto:derek_shen@hotmail.com">Derek Y. Shen</a>
 */
public class ProductListBean extends BaseBean {
	//default products per page
	private static final int DEFAULT_PRODUCTS_PER_PAGE = 6;
	
	//list of all the product backing beans
	private List productBeans;
	
	//the product backing beans for the current page
	private List currentProductBeans;
	
	//the cached product beans
	private Map productBeansMap;
	
	//the category id for the current catalog selection
	private String currentCategoryId;
	
	//the category name for the current catalog selection
	private String currentCategoryName;
	
	//number of products per page for the catalog page
	private int productsPerPage;
	
	//total pages for the current catalog selection
	private int totalPages;
	
	//current page number
	private int pageNo;
	
	/**
	 * Default constructor.
	 */
	public ProductListBean() {
		this.productBeans = new ArrayList();
		this.currentProductBeans = new ArrayList();
		this.productBeansMap = new HashMap();
		
		this.logger.debug("ProductListBean is created");
	}
	
	/**
	 * Initializes the ProductListBean.
	 * <p>
	 * The following steps are being done:
	 * <ul>
	 * <li>retrieve all the products.
	 * <li>convert all the products to product beans.
	 * <li>pagination logic
	 * </ul>
	 * 
	 * @see BaseBean#init()
	 */
	protected void init() {
		try {
			List products = this.serviceLocator.getCatalogService().getAllProducts();
			
			for (int i=0; i<products.size(); i++) {
				Product product = (Product)products.get(i);
				
				ProductBean productBean = ProductBuilder.createProductBean(product);
				productBean.setServiceLocator(this.serviceLocator);
				
				this.productBeans.add(productBean);
			}
			
			this.currentProductBeans = this.productBeans;
			
			this.setProductsPerPage();
			
			this.buildProductBeansMap();
		} catch (Exception e) {
			String msg = "Could not initialize ProductListBean";
			this.logger.error("Could not initialize ProductListBean", e);
			throw new FacesException(msg, e);
		}
		
		this.logger.debug("ProductListBean is initialized");
	}
	
	/**
	 * Backing bean action to search products by category.
	 * 
	 * @return the navigation result
	 */
	public String searchByCategoryAction() {
		this.currentCategoryId = FacesUtils.getRequestParameter(RequestParamNames.CATEGORY_ID);
		String pageNoString = FacesUtils.getRequestParameter(RequestParamNames.PAGE_NO);
		
		try {
			this.pageNo = Integer.parseInt(pageNoString);
		} catch (Exception e) {
			this.pageNo = 1;
		}
		
		this.totalPages = 0;
		
		this.currentProductBeans = new ArrayList();
		
		this.logger.debug("searchByCategoryAction is invoked");
		this.logger.debug("categoryId = " + this.currentCategoryId);
		this.logger.debug("pageNo = " + this.pageNo);
		
		if (this.currentCategoryId == null || this.currentCategoryId.equals("")) {
			//get all products, no pagination
			this.currentProductBeans = this.productBeans;
		
			return NavigationResults.PRODUCT_LIST;
		}
		else {
			//catalog
			Map categoryProductBeans = (Map)this.productBeansMap.get(this.currentCategoryId);
			if (categoryProductBeans != null) {
				this.totalPages = categoryProductBeans.size();
				
				List productBeans = (List)categoryProductBeans.get(new Integer(this.pageNo));
				
				if (productBeans != null) {
					this.currentProductBeans = productBeans;
				}
			}
			
			this.logger.debug("currentProductBeans size = " + this.currentProductBeans.size());
			
			//set current category name
			this.currentCategoryName = FacesUtils.getApplicationBean().getCategoryName(this.currentCategoryId);
			
			return NavigationResults.CATALOG;
		}
	}
	
	public List getProductBeans() {
		return this.productBeans;
	}
	
	public List getCurrentProductBeans() {
		return this.currentProductBeans;
	}
	
	public int getPageNo() {
		return this.pageNo;
	}
	
	public int getTotalPages() {
		return this.totalPages;
	}
	
	private void buildProductBeansMap() {
		this.logger.debug("buildProductBeansMap is invoked");
		
		this.productBeansMap = new HashMap();
		
		Map categoryProductsMap = new HashMap();
		
		for (int i=0; i<this.productBeans.size(); i++) {
			ProductBean product = (ProductBean)this.productBeans.get(i);
			
			Set categoryIds = product.getCategoryIds();
			Iterator ite = categoryIds.iterator();
			while (ite.hasNext()) {
				String categoryId = (String)ite.next();
				
				if (! categoryProductsMap.containsKey(categoryId)) {
					//new category
					List list = new ArrayList();
					list.add(product);
					categoryProductsMap.put(categoryId, list);
				}
				else {
					List list = (List) categoryProductsMap.get(categoryId);
					list.add(product);
				}
			}
		}
		
		Iterator ite = categoryProductsMap.keySet().iterator();
		
		while (ite.hasNext()) {
			Object category = ite.next();
			
			List productBeans = (List)categoryProductsMap.get(category);
			this.productBeansMap.put(category, this.pagination(productBeans));
		}
	}
	
	public String getCurrentCategoryId() {
		return this.currentCategoryId;
	}
	
	public String getCurrentCategoryName() {
		return this.currentCategoryName;
	}
	
	private ProductBean getProductBeanById(String id) {
		Iterator ite = this.productBeans.iterator();
		while (ite.hasNext()) {
			ProductBean p = (ProductBean)ite.next();
			
			if (p.getId().equals(id)) {
				return p;
			}
		}
		
		return null;
	}
	
	/**
	 * Pagination logic.
	 * 
	 * @param products the list of products to be paginated
	 * @return a map with page number as the key and list of products as the value
	 */
	private Map pagination(List products) {
		this.logger.debug("pagination is invoked");
		this.logger.debug("products size" + products.size());
		
		Map pagenatedProductBeans = new HashMap();
		
		int totalPages = 0;
		
		if (products.size()%this.productsPerPage == 0) {
			totalPages = products.size()/this.productsPerPage;
		}
		else {
			totalPages = products.size()/this.productsPerPage + 1;
		}
		
		for (int i=0; i<totalPages; i++) {
			List productBeans = new ArrayList();
			pagenatedProductBeans.put(new Integer(i+1), productBeans);
		}
		
		for (int i=0; i<products.size(); i++) {
			ProductBean p = (ProductBean)products.get(i);
			
			int pageNo = i/this.productsPerPage + 1;
			((List)pagenatedProductBeans.get(new Integer(pageNo))).add(p);
		}
		
		this.processLastPage((List)pagenatedProductBeans.get(new Integer(totalPages)));

		this.logger.debug("totalPages = " + totalPages);
		
		return pagenatedProductBeans;
	}
	
	/**
	 * Add dummy products for the last page to simplify the presentation.
	 * 
	 * @param productsOnLastPage the list of products on the last page
	 */
	private void processLastPage(List productsOnLastPage) {
		if (productsOnLastPage.size() >= this.productsPerPage) return;
		
		List dummyProducts = new ArrayList();
		int diff = this.productsPerPage - productsOnLastPage.size();
		
		for (int i=0; i<diff; i++) {
			dummyProducts.add(new ProductBean());
		}
		
		productsOnLastPage.addAll(dummyProducts);
	}
	
	private void setProductsPerPage() {
		this.productsPerPage = FacesUtils.getApplicationBean().getProductsPerPage();
		if (this.productsPerPage <= 0) {
			this.productsPerPage = DEFAULT_PRODUCTS_PER_PAGE;
		}
	}
}
