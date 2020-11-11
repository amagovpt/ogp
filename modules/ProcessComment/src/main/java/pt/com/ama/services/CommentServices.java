package pt.com.ama.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Dictionary;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.portlet.PortletPreferences;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

//import AMA.OpenGov.configuration.MyAppManager;
import AMA.OpenGov.LocalDataSaveEmail.model.*;
import AMA.OpenGov.portlet.ProcessCommentResource;
import AMA.OpenGov.LocalDataSaveEmail.service.*;
import pt.com.ama.mailProperties.MailProperties;

import pt.com.ama.services.CommentServices;

public class CommentServices {

	private static Log log = LogFactoryUtil.getLog(ProcessCommentResource.class.getName());
	
	public static boolean sendSuggestion(ogp_comments contact, String receiver) {
		boolean enviadoSn = true;
		try {
			MailProperties.init();
			InternetAddress[] distributionList = InternetAddress.parse(receiver, false);
			
			String from = contact.getEmail();
			String subject = "Formul\u00e1rio Contacto Open Gov";

			Properties props = new Properties();
			
//			System.out.println(MyAppManager.class.getName());
			
			
			props.put("mail.smtp.host", MailProperties.getHost());
			props.put("mail.smtp.port", MailProperties.getPort());
//			props.put("mail.transport.protocol", MailProperties.getProtocol());
//			if(!MailProperties.getStarttls().isEmpty()){
//				props.put("mail.smtp.starttls.enable", MailProperties.getStarttls());
//			}
//			if(!MailProperties.getAuth().isEmpty()){
//				props.put("mail.smtp.auth", MailProperties.getAuth()); 
//			}
			
			Session session = Session.getInstance(props,
					  new javax.mail.Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(MailProperties.getUsername(), MailProperties.getPassword());
						}
					  });
			
//			Teste com FakeSmtp
//			props.put("mail.smtp.host", "127.0.0.1");
//			props.put("mail.smtp.port", "5050");
//			props.put("mail.transport.protocol", "smtp");
//			Session session = Session.getDefaultInstance(props);
//			session.setDebug(false);

			log.info("A envia email para = " + distributionList);
			
			Message msg = new MimeMessage(session);
			StringBuilder builder = new StringBuilder();
			
			builder.append("<h3>Dados submetidos atrav\u00e9s do formul\u00e1rio contacto </h3>")
				   .append("<div>Nome: ").append(contact.getNome()).append("</div>")
				   .append("<div>Email: ").append(contact.getEmail()).append("</div>")
				   .append("<div>Mensagem: ").append(contact.getMensagem()).append("</div>")
				   .append("<br> ")
				   .append("<div> ------------------------------------------------------------------------------------------ ").append("</div>")
				   .append("<div> Formul\u00e1rio submetido atrav\u00e9s da plataforma Open Government Partnership Portugal").append("</div>");
			
			String message = builder.toString();
			msg.setContent(message, "text/html");
			msg.setFrom(new InternetAddress(from));
			msg.setRecipients(Message.RecipientType.TO, distributionList);
			msg.setSubject(subject);
			msg.setSentDate(new Date());
			Transport.send(msg);
			
		} catch (Exception ex) {
			log.info("Erro ao enviar email : " + ex);
//			ContatoServices.gravaEmail(request,false);
			enviadoSn = false;
//			SessionErrors.add(request, ex.getClass().getName());
			return enviadoSn;
		}

		return enviadoSn;
	}
	
	
	public static void gravaEmail(ogp_comments suggestionContact, boolean status) {

			//long EmailContatoID = CounterLocalServiceUtil.increment(ContatoServices.class.getName());			
			//emailContact emailContato = emailContactLocalServiceUtil.createemailContact(EmailContatoID);
			//emailContato.setNome(request.getParameter("nome"));
			//emailContato.setEmail(request.getParameter("email"));
			//emailContato.setMensagem(request.getParameter("mensagem"));
		
		Date date = new Date();
		
		suggestionContact.setDate(date);
		suggestionContact.setStatus(status);
		ogp_commentsLocalServiceUtil.addogp_comments(suggestionContact);
	}
	
}
