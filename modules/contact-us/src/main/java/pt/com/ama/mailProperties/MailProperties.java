package pt.com.ama.mailProperties;

import java.io.IOException;
import java.util.Properties;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;

public class MailProperties {
	
	private static Properties mailProperties;

	public static void init() throws IOException {
		if(mailProperties == null) {
			mailProperties = new Properties();
			try {
				// load a properties file
				mailProperties.load(MailProperties.class.getClassLoader().getResourceAsStream("mail.properties"));
			} catch (IOException ex) {
				throw ex;
			}
		}
	}
	
	
	public static String getUsername() {
		return mailProperties.getProperty("mail.username");
	}
	
	public static String getPassword() {
		return mailProperties.getProperty("mail.password");
	}
	
	public static String getHost() {
		return mailProperties.getProperty("mail.host");
	}
	
	public static String getReceiver() {
		return mailProperties.getProperty("mail.receiver");
	}
	
	public static String getPort() {
		return mailProperties.getProperty("mail.port");
	}
	
	public static String getProtocol() {
		return mailProperties.getProperty("mail.protocol");
	}


	public static String getStarttls() {
		// TODO Auto-generated method stub
		return mailProperties.getProperty("mail.starttls");
	}


	public static String getAuth() {
		// TODO Auto-generated method stub
		return mailProperties.getProperty("mail.auth");
	}
	

	
}
