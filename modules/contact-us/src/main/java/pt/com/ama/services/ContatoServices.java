package pt.com.ama.services;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.portlet.PortletException;

import bd.ama.model.emailContact;
import bd.ama.service.emailContactLocalServiceUtil;
import pt.com.ama.mailProperties.MailProperties;

public class ContatoServices {

	
	public static boolean sendSuggestion(emailContact suggestionContact)
			 throws IOException, PortletException
	{
		boolean enviadoSn = true;
		try {
			MailProperties.init();
			InternetAddress[] distributionList = InternetAddress.parse(suggestionContact.getEmail(), false);
			
			String from = MailProperties.getReceiver();
			String subject = "Formul\u00e1rio Contacto";

			Properties props = new Properties();
			props.put("mail.smtp.host", MailProperties.getHost());
			props.put("mail.smtp.port", MailProperties.getPort());
			props.put("mail.transport.protocol", MailProperties.getProtocol());
			if(!MailProperties.getStarttls().isEmpty()){
				props.put("mail.smtp.starttls.enable", MailProperties.getStarttls());
			}
			if(!MailProperties.getAuth().isEmpty()){
				props.put("mail.smtp.auth", MailProperties.getAuth()); 
			}
			
			Session session = Session.getInstance(props,
					  new javax.mail.Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(MailProperties.getUsername(), MailProperties.getPassword());
						}
					  });
			//Teste com FakeSmtp
//			props.put("mail.smtp.host", "127.0.0.1");
//			props.put("mail.smtp.port", "5050");
//			props.put("mail.transport.protocol", "smtp");
//			Session session = Session.getDefaultInstance(props, session);
//			session.setDebug(false);

			Message msg = new MimeMessage(session);
			StringBuilder builder = new StringBuilder();
			
			builder.append("<div>Dados submetidos atraves do formulario contacto </div>")
				   .append("<div>Nome: ").append(suggestionContact.getNome()).append("</div>")
				   .append("<div>Email: ").append(suggestionContact.getEmail()).append("</div>")
				   .append("<div>Mensagem: ").append(suggestionContact.getMensagem()).append("</div>");
			
			String message = builder.toString();
			msg.setContent(message, "text/html");
			msg.setFrom(new InternetAddress(from));
			msg.setRecipients(Message.RecipientType.TO, distributionList);
			msg.setSubject(subject);
			msg.setSentDate(new Date());
			Transport.send(msg);
			
		} catch (Exception ex) {
//			ContatoServices.gravaEmail(request,false);
			enviadoSn = false;
//			SessionErrors.add(request, ex.getClass().getName());
			return enviadoSn;
		}

		return enviadoSn;
	}
	
	
	public static void gravaEmail(emailContact suggestionContact, boolean status) {

			//long EmailContatoID = CounterLocalServiceUtil.increment(emailContact.class.getName());			
			//emailContact emailContato = emailContactLocalServiceUtil.createemailContact(EmailContatoID);
			//emailContato.setNome(request.getParameter("nome"));
			//emailContato.setEmail(request.getParameter("email"));
			//emailContato.setMensagem(request.getParameter("mensagem"));
		suggestionContact.setStatus(status);
		emailContactLocalServiceUtil.addemailContact(suggestionContact);
	}
	
}
