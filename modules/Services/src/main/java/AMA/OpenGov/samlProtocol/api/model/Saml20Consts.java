package AMA.OpenGov.samlProtocol.api.model;

/**
 * Clazz Saml20Consts.
 * @author paulolancao
 */
public final class Saml20Consts {
	
	public static final String ResponseExpirationMinutesAlias = "pt.ama.portal.saml.response.responseExpirationMinutes";
	public static final String FACertificatePathAlias = "pt.ama.portal.saml.response.cert.FACertificatePath";
	public static final String PropBaseResponsePath = "/certificates/response/";
	
	
	public static final String SAML_20_PROTOCOL_NAMESPACE = "urn:oasis:names:tc:SAML:2.0:protocol";
	public static final String SAML_20_PROTOCOL_PREFIX = "samlp";
	
	public static final String SAML_20_LOGOUT_CONSENT = "urn:oasis:names:tc:SAML:2.0:logout:user";
	
	public static final String SAML_20_CONSENT = "urn:oasis:names:tc:SAML:2.0:consent:unspecified";
	public static final String SAML_20_BINDINGS = "urn:oasis:names:tc:SAML:2.0:bindings:HTTP-POST";
	
	public static final String SAML_20_ASSERTION_NAMESPACE = "urn:oasis:names:tc:SAML:2.0:assertion";
	public static final String SAML_20_ASSERTION_PREFIX = "saml";
	
	public static final String SAML_20_REQUESTED_ATTRIBUTES_NAMESPACE = "http://autenticacao.cartaodecidadao.pt/atributos";
	public static final String SAML_20_REQUESTED_ATTRIBUTES_PREFIX = "fa";
	
	public static final String SAML_20_CONSENT_RESPONSE = "http://interop.gov.pt/MDC/FA/PassarConsentimento";
	
	/* Citizen Card */
	public static final String SAML_20_FULLNAME_RESPONSE = "http://interop.gov.pt/MDC/Cidadao/NomeCompleto";
	public static final String SAML_20_NIF_RESPONSE = "http://interop.gov.pt/MDC/Cidadao/NIF";
	public static final String SAML_20_NIC_RESPONSE = "http://interop.gov.pt/MDC/Cidadao/NIC";
	public static final String SAML_20_SERIALNUMBER_RESPONSE = "http://interop.gov.pt/MDC/Cidadao/NumeroSerie";
	public static final String SAML_20_FIRSTNAME_RESPONSE = "http://interop.gov.pt/MDC/Cidadao/NomeProprio";
	public static final String SAML_20_LASTNAME_RESPONSE = "http://interop.gov.pt/MDC/Cidadao/NomeApelido";
	public static final String SAML_20_NISS_RESPONSE = "http://interop.gov.pt/MDC/Cidadao/NISS";
	public static final String SAML_20_BIRTHDAY_RESPONSE = "http://interop.gov.pt/MDC/Cidadao/DataNascimento";
	public static final String SAML_20_EMAIL_ADDRESS_RESPONSE = "http://interop.gov.pt/MDC/Cidadao/CorreioElectronico";
	public static final String SAML_20_PASSPORTID_RESPONSE = "http://interop.gov.pt/MDC/Cidadao/Passport";
	public static final String SAML_20_NATIONALITY_RESPONSE = "http://interop.gov.pt/MDC/Cidadao/Nacionalidade";

	/* Certificates */
	public static final String SAML_20_CERT_ADV_FULLNAME_RESPONSE = "http://interop.gov.pt/MDC/Advogado/NomeCompleto";
	public static final String SAML_20_CERT_ADV_NOA_RESPONSE = "http://interop.gov.pt/MDC/Advogado/NOA";
	public static final String SAML_20_CERT_NOT_FULLNAME_RESPONSE = "http://interop.gov.pt/MDC/Notario/NomeCompleto";
	public static final String SAML_20_CERT_NOT_NON_RESPONSE = "http://interop.gov.pt/MDC/Notario/NON";
	public static final String SAML_20_CERT_NOT_MNON_RESPONSE = "http://interop.gov.pt/MDC/Notario/NMECON";
	
	public static final String SAML_20_CERT_NOT_FIRSTNAME_RESPONSE = "http://interop.gov.pt/MDC/Notario/NomeProprio";
	public static final String SAML_20_CERT_NOT_LASTNAME_RESPONSE = "http://interop.gov.pt/MDC/Notario/NomeApelido";
	public static final String SAML_20_CERT_SOL_NCS_RESPONSE = "http://interop.gov.pt/MDC/Solicitador/NCS";
	public static final String SAML_20_CERT_SOL_FULLNAME_RESPONSE = "http://interop.gov.pt/MDC/Solicitador/NomeCompleto";
	public static final String SAML_20_CERT_ADV_EMAIL = "http://interop.gov.pt/MDC/Advogado/CorreioElectronico";
	public static final String SAML_20_CERT_NOT_EMAIL = "http://interop.gov.pt/MDC/Notario/CorreioElectronico";
	public static final String SAML_20_CERT_SOL_EMAIL = "http://interop.gov.pt/MDC/Solicitador/CorreioElectronico";
	
	/* FA LEVELS */
	public static final String SAML_20_FA_LEVEL_1 = "1";
	public static final String SAML_20_FA_LEVEL_2 = "2";
	public static final String SAML_20_FA_LEVEL_3 = "3";
	public static final String SAML_20_FA_LEVEL_4 = "4";
	
	/* Presentation */
	public static final String SAML_20_PRE_CC = "CC";
	public static final String SAML_20_PRE_CMD = "CMD";
	public static final String SAML_20_PRE_UPP = "UPP";
	public static final String SAML_20_PRE_RSS = "RSS";
	
	public static final String alteracaoMoradaCcOutrasEntidades = "alteracaoMoradaCcOutrasEntidades";
	public static final String alteracaoMoradaDeResidencia = "alteracaoMoradaDeResidencia";
	public static final String alteracaoMoradaNaoDeResidencia = "alteracaoMoradaNaoDeResidencia";
	public static final String pesquisaProcessosAlteracaoMorada = "pesquisaProcessosAlteracaoMorada";
	public static final String cancelamentoCC = "cancelamentoCC";
	public static final String renovacaoCCProprio = "renovacaoCC-Proprio";
	public static final String renovacaoCCTerceiro = "renovacaoCC-Terceiro";
	public static final String consultaCC = "consultaCC";
	
	



//	public static class CitizenCard{
//
//		public static final String DataNascimento = "http://interop.gov.pt/MDC/Cidadao/DataNascimento";
//		public static final String Nacionalidade ="http://interop.gov.pt/MDC/Cidadao/Nacionalidade";
//
//		public static final String NIC ="http://interop.gov.pt/MDC/Cidadao/NIC";
//
//		public static final String NICCifrado ="http://interop.gov.pt/MDC/Cidadao/NICCifrado";
//
//		public static final String NIF ="http://interop.gov.pt/MDC/Cidadao/NIF";
//
//		public static final String NIFCifrado ="http://interop.gov.pt/MDC/Cidadao/NIFCifrado";
//
//		public static final String NISS ="http://interop.gov.pt/MDC/Cidadao/NISS";
//
//		public static final String NISSCifrado ="http://interop.gov.pt/MDC/Cidadao/NISSCifrado";
//
//		public static final String NomeApelido ="http://interop.gov.pt/MDC/Cidadao/NomeApelido";
//
//		public static final String NomeCompleto ="http://interop.gov.pt/MDC/Cidadao/NomeCompleto";
//
//		public static final String NomeProprio ="http://interop.gov.pt/MDC/Cidadao/NomeProprio";
//
//		public static final String NumeroSerie ="http://interop.gov.pt/MDC/Cidadao/NumeroSerie";
//
//		public static final String PassarConsentimento ="http://interop.gov.pt/MDC/FA/PassarConsentimento";
//
//		public static final String DataValidade ="http://interop.gov.pt/MDC/Cidadao/DataValidade";
//		
//		
//		public static final String NoDocumento ="http://interop.gov.pt/MDC/Cidadao/NoDocumento";
//
//		public static final String NoDocumentoCheckPartOnly ="NoDocumentoCheckPartOnly";
//
//		public static final String TipoDeVia ="http://interop.gov.pt/MDC/Cidadao/TipoDeVia";
//
//		public static final String DesignacaoDaVia ="http://interop.gov.pt/MDC/Cidadao/DesignacaoDaVia";
//
//		public static final String NumeroPorta ="http://interop.gov.pt/MDC/Cidadao/NumeroPorta";
//
//		public static final String Andar ="http://interop.gov.pt/MDC/Cidadao/Andar";
//
//		public static final String Lado ="http://interop.gov.pt/MDC/Cidadao/Lado";
//
//		public static final String Lugar ="http://interop.gov.pt/MDC/Cidadao/Lugar";
//
//		public static final String Localidade ="http://interop.gov.pt/MDC/Cidadao/Localidade";
//
//		public static final String CodigoPostal4 ="http://interop.gov.pt/MDC/Cidadao/CodigoPostal4";
//
//		public static final String CodigoPostal3 ="http://interop.gov.pt/MDC/Cidadao/CodigoPostal3";
//
//		public static final String LocalidadePostal ="http://interop.gov.pt/MDC/Cidadao/LocalidadePostal";
//
//		public static final String Freguesia ="http://interop.gov.pt/MDC/Cidadao/Freguesia";
//
//		public static final String Concelho ="http://interop.gov.pt/MDC/Cidadao/Concelho";
//
//		public static final String Distrito ="http://interop.gov.pt/MDC/Cidadao/Distrito";
//		// ##### Atributos necessários ao serviço "Serviço de Alteração de Morada"
//
//	
//	
//		//#### Fornecedor CVCC
//				public static final String NICCVCC = "http://interop.gov.pt/MDC/Cidadao/NIC";
//				
//				public static final String NomeCompletoCVCC ="http://interop.gov.pt/MDC/Cidadao/NomeCompleto";
//				
//				public static final String NoDocumentoCVCC ="http://interop.gov.pt/CVCC/Cidadao/NoDocumento";
//				
//				public static final String NomeProprioCVCC ="http://interop.gov.pt/CVCC/Cidadao/NomeProprio";
//				
//				public static final String NomeApelidoCVCC ="http://interop.gov.pt/CVCC/Cidadao/NomeApelido";
//
//				public static final String DataNascimentoCVCC ="http://interop.gov.pt/CVCC/Cidadao/DataNascimento";
//
//				public static final String SexoCVCC ="http://interop.gov.pt/CVCC/Cidadao/Sexo";
//
//				public static final String AlturaCVCC ="http://interop.gov.pt/CVCC/Cidadao/Altura";
//				
//				public static final String NacionalidadeCVCC ="http://interop.gov.pt/CVCC/Cidadao/Nacionalidade";
//				
//				public static final String NomeProprioPaiCVCC ="http://interop.gov.pt/CVCC/Cidadao/NomeProprioPai";
//
//				public static final String NomeApelidoPaiCVCC ="http://interop.gov.pt/CVCC/Cidadao/NomeApelidoPai";
//				
//				public static final String NomeProprioMaeCVCC ="http://interop.gov.pt/CVCC/Cidadao/NomeProprioMae";
//
//				public static final String NomeApelidoMaeCVCC ="http://interop.gov.pt/CVCC/Cidadao/NomeApelidoMae";
//
//				public static final String FotoCVCC ="http://interop.gov.pt/CVCC/Cidadao/Foto";
//				
//				public static final String AssinaturaCVCC ="http://interop.gov.pt/CVCC/Cidadao/Assinatura";
//
//				public static final String MoradaCVCC = "http://interop.gov.pt/CVCC/Cidadao/Morada";
//				
//				public static final String ContactosCVCC = "http://interop.gov.pt/CVCC/Cidadao/Contactos";
//				
//		
//				public static final String DataValidadeCVCC = "http://interop.gov.pt/CVCC/Cidadao/DataValidade";
//
//				public static final String IDProcesso = "http://interop.gov.pt/CVCC/Cidadao/IDProcesso";
//
//	}
//
//
//	public static class Lawyer{
//
//
//		public static final String NomeProfissional = "http://interop.gov.pt/MDC/Advogado/NomeProfissional";
//
//		public static final String NomeCompleto = "http://interop.gov.pt/MDC/Advogado/NomeCompleto";
//
//		public static final String NumeroOrdemAdvogados = "http://interop.gov.pt/MDC/Advogado/NOA";
//
//		public static final String Sociedade = "http://interop.gov.pt/MDC/Advogado/Sociedade";
//
//		public static final String NumeroIdentificacaoDaSociedade = "http://interop.gov.pt/MDC/Advogado/NSociedade";
//
//		public static final String CorreioElectronicoProfissional = "http://interop.gov.pt/MDC/Advogado/CorreioElectronico";
//
//		public static final String NumeroSerieCertificadoDigital = "http://interop.gov.pt/MDC/Advogado/NumeroSerie";
//
//		public static final String PassarConsentimento = "http://interop.gov.pt/MDC/FA/PassarConsentimento";
//
//	}
//
//
//	public static class Solicitor{
//
//		public static final String NumeroCamaraSolicitadores = "http://interop.gov.pt/MDC/Solicitador/NCS";
//
//		public static final String NomeCompleto = "http://interop.gov.pt/MDC/Solicitador/NomeCompleto";
//
//		public static final String CorreioElectronicoProfissional = "http://interop.gov.pt/MDC/Solicitador/CorreioElectronico";
//
//		public static final String NumeroSerieCertificadoDigital = "http://interop.gov.pt/MDC/Solicitador/NumeroSerie";
//
//		public static final String PassarConsentimento = "http://interop.gov.pt/MDC/FA/PassarConsentimento";
//
//	}
//
//
//	public static class Notary{
//
//		public static final String NumeroOrdemNotarios = "http://interop.gov.pt/MDC/Notario/NON";
//
//		public static final String NomeProprio = "http://interop.gov.pt/MDC/Notario/NomeProprio";
//
//		public static final String NomeCompleto = "http://interop.gov.pt/MDC/Notario/NomeCompleto";
//
//		public static final String NomeApelido = "http://interop.gov.pt/MDC/Notario/NomeApelido";
//
//		public static final String NumeroSerieCertificadoDigital = "http://interop.gov.pt/MDC/Notario/NumeroSerie";
//
//		public static final String NumeroCartorioNotarial = "http://interop.gov.pt/MDC/Notario/NomeCartorioNotarial";
//
//		public static final String LocalidadeCartorioNotarial = "http://interop.gov.pt/MDC/Notario/LocalidadeCartorioNotarial";
//
//		public static final String DistritoCartorioNotarial = "http://interop.gov.pt/MDC/Notario/DistritoCartorioNotarial";
//
//		public static final String Nacionalidade = "http://interop.gov.pt/MDC/Notario/Nacionalidade";
//
//		public static final String CorreioElectronico = "http://interop.gov.pt/MDC/Notario/CorreioElectronico";
//
//		public static final String PassarConsentimento = "http://interop.gov.pt/MDC/FA/PassarConsentimento";
//	}

}
