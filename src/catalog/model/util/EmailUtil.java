/*
 * JCatalog Project
 */
package catalog.model.util;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
//
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
//
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
//
import catalog.model.exception.CatalogException;

/**
 * Utility class to send email.
 * 
 * @author <a href="mailto:derek_shen@hotmail.com">Derek Y. Shen</a>
 */
public class EmailUtil {
	//the logger for this class
	private static Log logger = LogFactory.getLog("catalog.view.util.EmailUtil");

	/**
	 * Send email to a single recipient.
	 * 
	 * @param smtpHost the SMTP email server address
	 * @param senderAddress the sender email address
	 * @param senderName the sender name
	 * @param receiverAddress the recipient email address
	 * @param sub the subject of the email
	 * @param msg the message content of the email
	 */
	public static void sendEmail(String smtpHost, String senderAddress, String senderName,
					String receiverAddress, String sub, String msg) throws CatalogException {
		List recipients = new ArrayList();
		recipients.add(receiverAddress);

		sendEmail(smtpHost, senderAddress, senderName, recipients, sub, msg);
	}

	/**
	 * Send email to a list of recipients.
	 * 
	 * @param smtpHost the SMTP email server address
	 * @param senderAddress the sender email address
	 * @param senderName the sender name
	 * @param recipients a list of receipients email addresses
	 * @param sub the subject of the email
	 * @param msg the message content of the email
	 */
	public static void sendEmail(String smtpHost, String senderAddress, String senderName,
					List recipients, String sub, String msg) throws CatalogException {
		if (smtpHost == null) {
			String errMsg = "Could not send email: smtp host address is null";
			
			logger.error(errMsg);
			throw new CatalogException(errMsg);
		}

		try {
			Properties props = System.getProperties();
			props.put("mail.smtp.host", smtpHost);
			Session session = Session.getDefaultInstance(props, null );
			MimeMessage message = new MimeMessage( session );
			message.addHeader("Content-type", "text/plain");
			message.setSubject(sub);
			message.setFrom(new InternetAddress(senderAddress, senderName));

			for (Iterator it = recipients.iterator(); it.hasNext();) {
				String email = (String)it.next();
				message.addRecipients(Message.RecipientType.TO, email);
			}

			message.setText(msg);
			message.setSentDate( new Date() );
			Transport.send(message);
		 } catch (Exception e) {
		 	String errorMsg = "Could not send email";
			logger.error(errorMsg, e);
			
			throw new CatalogException("errorMsg", e);
		 }
	}
}
