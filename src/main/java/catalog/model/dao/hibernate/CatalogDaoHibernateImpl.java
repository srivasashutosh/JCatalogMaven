/*
 * JCatalog Project
 */
package catalog.model.dao.hibernate;

import java.sql.SQLException;
import java.util.List;

/*import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;*/
//
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;
//
import org.springframework.orm.hibernate.HibernateCallback;
import org.springframework.orm.hibernate.support.HibernateDaoSupport;

//
import catalog.model.businessobject.Product;
import catalog.model.businessobject.Category;
import catalog.model.dao.CatalogDao;

/**
 * The Hibernate implementation of the <code>CatalogDao</code>.
 * 
 * @author <a href="mailto:derek_shen@hotmail.com">Derek Y. Shen</a>
 * @see CatalogDao
 */
public class CatalogDaoHibernateImpl extends HibernateDaoSupport implements CatalogDao {
	/**
	 * Default constructor.
	 */
	public CatalogDaoHibernateImpl() {
		super();
	}
	
	/**
	 * @see CatalogDao#saveProduct(Product)
	 */
	public Product saveProduct(Product product) {
		this.getHibernateTemplate().save(product);
		return product;
	}
	
	/**
	 * @see CatalogDao#getProduct(String)
	 */
	public Product getProduct(String id) {
		return (Product)this.getHibernateTemplate().load(Product.class, id);
	}
	
	/**
	 * @see CatalogDao#updateProduct(Product)
	 */
	public void updateProduct(Product product) {
		this.getHibernateTemplate().update(product);
	}
	
	/**
	 * @see CatalogDao#deleteProduct(Product)
	 */
	public void deleteProduct(Product product) {
		this.getHibernateTemplate().delete(product);
	}
	
	/**
	 * @see CatalogDao#getAllProducts()
	 */
	public List getAllProducts() {
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
				throws HibernateException, SQLException {

				StringBuffer sb = new StringBuffer(100);
				sb.append("select distinct product ");
				sb.append("from Product product ");
				sb.append("order by product.id");

				Query query = session.createQuery(sb.toString());
				List list = query.list();

				return list;
			}

		});		
	}
	
	/**
	 * @see CatalogDao#getCategory(String)
	 */
	public Category getCategory(String id) {
		return (Category)getHibernateTemplate().load(Category.class, id);
	}
	
	/**
	 * @see CatalogDao#getAllCategories()
	 */
	public List getAllCategories() {
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
				throws HibernateException, SQLException {

				StringBuffer sb = new StringBuffer(100);
				sb.append("select distinct category ");
				sb.append("from Category category ");
				sb.append("order by category.id");

				Query query = session.createQuery(sb.toString());
				List list = query.list();

				return list;
			}

			
		});		
	}
}
