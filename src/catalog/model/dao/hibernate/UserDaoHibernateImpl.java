/*
 * JCatalog Project
 */
package catalog.model.dao.hibernate;

import org.springframework.orm.hibernate.support.HibernateDaoSupport;
//
import catalog.model.businessobject.User;
import catalog.model.dao.UserDao;

/**
 * The Hibernate implementation of the <code>UserDao</code>.
 * 
 * @author <a href="mailto:derek_shen@hotmail.com">Derek Y. Shen</a>
 * @see UserDao
 */
public class UserDaoHibernateImpl extends HibernateDaoSupport implements UserDao {
	/**
	 * Default constructor.
	 */
	public UserDaoHibernateImpl() {
		super();
	}
	
	/**
	 * @see UserDao#getUser(String)
	 */
	public User getUser(String username) {
		User user = (User)getHibernateTemplate().load(User.class, username);
		return user;
	}
}