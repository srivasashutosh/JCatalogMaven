/*
 * JCatalog Project
 */
package catalog.model.service.impl;

import java.util.List;
//
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
//
import org.springframework.orm.hibernate.HibernateObjectRetrievalFailureException;
//
import catalog.model.service.UserService;
import catalog.model.dao.UserDao;
import catalog.model.businessobject.User;
import catalog.model.exception.CatalogException;
import catalog.model.exception.UsernameNotExistException;
import catalog.model.util.EmailUtil;

/**
 * The implementation of the <code>UserService</code>.
 * </p>
 * Spring Framework is used to manage this service bean.
 * Since this class is not dependend on Spring API, it can be used outside the Spring IOC container.
 * 
 * @author <a href="mailto:derek_shen@hotmail.com">Derek Y. Shen</a>
 * @see UserService
 */
public class UserServiceImpl implements UserService {
	//the logger for this class
	private Log logger = LogFactory.getLog(this.getClass());
	
	//the smtp server host address
	private String smtpHost;
	
	//the default sender email address
	private String defaultSenderAddress;
	
	//the default sender name
	private String defaultSenderName;
	
	//the receiver email addresses
	private List receiverAddresses;
	
	//the UserDao used
	private UserDao userDao;
	
	public void setSmtpHost(String host) {
		this.smtpHost = host;
	}
	
	public void setDefaultSenderAddress(String newDefaultSenderAddress) {
		this.defaultSenderAddress = newDefaultSenderAddress;
	}
	
	public void setDefaultSenderName(String newDefaultSenderName) {
		this.defaultSenderName = newDefaultSenderName;
	}
	
	public void setReceiverAddresses(List newDefaultReceiverAddresses) {
		this.receiverAddresses = newDefaultReceiverAddresses;
	}
	
	public void setUserDao(UserDao newUserDao) {
		this.userDao = newUserDao;
	}
	
	/**
	 * @see UserService#login(String, String)
	 */
	public User login(String username, String password) throws CatalogException {
		try {
			User user = this.userDao.getUser(username);
			
			if (user != null) {
				if (!user.getPassword().equals(password)) {
					user = null;
				}
			}
			
			return user;
		} catch (HibernateObjectRetrievalFailureException he) {
			//username does not exist
			throw new UsernameNotExistException(username);
		} catch (Exception e) {
			this.logger.error("Could not login", e);
			throw new CatalogException("Could not login", e);
		}
	}
	
	/**
	 * @see UserService#sendEmail(String, String, String, String)
	 */
	public void sendEmail(String senderAddress, String senderName, String sub, String msg) throws CatalogException {
		if (senderAddress == null || senderAddress.trim().equals("")) {
			senderAddress = this.defaultSenderAddress;
		}
		
		if (senderName == null || senderName.trim().equals("")) {
			senderName = this.defaultSenderName;
		}
		
		EmailUtil.sendEmail(this.smtpHost, senderAddress, senderName, this.receiverAddresses, sub, msg);
	}
}
