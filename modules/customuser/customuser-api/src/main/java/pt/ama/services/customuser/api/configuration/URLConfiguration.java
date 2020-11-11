//package pt.ama.services.customuser.api.configuration;
//
//import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;
//
//import aQute.bnd.annotation.metatype.Meta;
//
//@ExtendedObjectClassDefinition(category = "eServicos")
//@Meta.OCD(
//		id = "pt.ama.services.customuser.api.configuration.URLConfiguration",
//		localization = "content/Language",
//		name = "pt-ama-services-urlConfiguration-configuration-definition-name"
//)
//public interface URLConfiguration {
//	
//	@Meta.AD(
//	        deflt = "https://servicos.portaldocidadao.pt/PORTAL/pt/certidoes_online/HP?JS=true&idServico=902082&",
//	        description = "pt-ama-services-urlConfiguration-configuration-certidoes-desc",
//	    	name="pt-ama-services-urlConfiguration-configuration-certidoes-name",
//	        required = false
//	    )
//	public String getCertidoesURL();
//	
//	@Meta.AD(
//	        deflt = "http://preprod.eservicos.gov.pt/redirect?code=certidoes",
//	        description = "pt-ama-services-urlConfiguration-configuration-certidoesInternal-desc",
//	    	name="pt-ama-services-urlConfiguration-configuration-certidoesInternal-name",
//	        required = false
//	    )
//	public String getCertidoesInternalURL();
//
//	@Meta.AD(
//        deflt = "https://agenda.portaldocidadao.gov.pt",
//        description = "pt-ama-services-urlConfiguration-configuration-agendaUrl-desc",
//    	name="pt-ama-services-urlConfiguration-configuration-agendaUrl-name",
//        required = false
//    )
//    public String agendaUrl();
//	
//	@Meta.AD(
//	     deflt = "https://preprod.pmsp.ama.pt",
//	     description = "pt-ama-services-urlConfiguration-configuration-pmcloginAddress-desc",
//	     name="pt-ama-services-urlConfiguration-configuration-pmcloginAddress-name",
//	     required = false
//	)
//	public String pmcloginAddress();
//	
//	@Meta.AD(
//		 deflt = "https://preprod.servicos.portaldocidadao.gov.pt/c/portal/logout",
//		 description = "pt-ama-services-urlConfiguration-configuration-pmclogoutAddress-desc",
//		 name="pt-ama-services-urlConfiguration-configuration-pmclogoutAddress-name",
//		 required = false
//	)
//	public String pmclogoutAddress();
//	
//
//	@Meta.AD(
//		 deflt = "https://documentos.portaldocidadao.pt/pclogin?idServico=886586&p_auth_source=",
//		 description = "pt-ama-services-urlConfiguration-configuration-bolsaDocsAddress-desc",
//		 name="pt-ama-services-urlConfiguration-configuration-bolsaDocsAddress-name",
//		 required = false
//	)
//	public String bolsaDocsAddress();
//	
//
//	@Meta.AD(
//		 deflt = "https://documentos.portaldocidadao.pt/c/portal/logout",
//		 description = "pt-ama-services-urlConfiguration-configuration-bolsaDocsLogoutAddress-desc",
//		 name="pt-ama-services-urlConfiguration-configuration-bolsaDocsLogoutAddress-name",
//		 required = false
//	)
//	public String bolsaDocsLogoutAddress();
//		
//	
//	@Meta.AD(
//		deflt = "http://10.55.37.133:8080/redirect?code=agenda",
//		description = "pt-ama-services-urlConfiguration-configuration-agendaInternalURL-desc",
//		name="pt-ama-services-urlConfiguration-configuration-agendaInternalURL-name",
//		required = false
//	)
//	public String agendaInternalURL();
//	
//	@Meta.AD(
//		 deflt = "http://10.55.37.133:8080/redirect?code=bolsadocs",
//		 description = "pt-ama-services-urlConfiguration-configuration-bolsaDocsInternalURL-desc",
//		 name="pt-ama-services-urlConfiguration-configuration-bolsaDocsInternalURL-name",
//		 required = false
//	)
//	public String bolsaDocsInternalURL();
//	
//	@Meta.AD(
//		 deflt = "http://localhost:8080/documents/20142/31816/menu_footer.json",
//		 description = "pt-ama-services-urlConfiguration-configuration-urlMenuJson-desc",
//		 name="pt-ama-services-urlConfiguration-configuration-urlMenuJson-name",
//		 required = false
//	)
//	public String urlMenuJson();
//	
//	@Meta.AD(
//		 deflt = "https://www.mapadocidadao.pt/Search/Map?q=",
//		 description = "pt-ama-services-urlConfiguration-configuration-urlMapSite-desc",
//		 name="pt-ama-services-urlConfiguration-configuration-urlMapSite-name",
//		 required = false
//	)
//	public String urlMapSite();
//	
//	@Meta.AD(
//			 deflt = "4tIL3ip__kk.cwA.Ads.4Ql9OUcg9rSoS91cq4wKB7gQgUZLygda109EampRE9U",
//			 description = "pt-ama-services-urlConfiguration-configuration-botKey-desc",
//			 name="pt-ama-services-urlConfiguration-configuration-botKey-name",
//			 required = false
//	)
//	public String botKey();
//}
