//package Ama.OpenGov.common.model;
//
//import java.util.Locale;
//
//public enum Languages {
//
//	PT("pt","PT"),
//	EN("en","GB"),
//	ES("es","");
//
//	private final String language;
//	private final String country;
//
//	Languages(String l, String c) {
//		language = l;
//		country = c;
//	}
//
//	public String getLanguage() {
//		return language;
//	}
//	
//	public String getCountry() {
//		return country;
//	}
//	
//	public Locale getLocalePT(){
//		return new Locale(Languages.PT.getLanguage(), Languages.PT.getCountry());
//	}
//	
//	public Locale getLocaleEN(){
//        return new Locale(Languages.EN.getLanguage(), Languages.EN.getCountry());
//    }
//	
//	public String getPTText(){
//		return Languages.PT.getLanguage() +"_"+ Languages.PT.getCountry();
//	}
//	
//	public String getENText(){
//		return Languages.EN.getLanguage() +"_"+ Languages.EN.getCountry();
//	}
//	
//	public static String getText(Locale locale){
//		return locale.getLanguage() +"_"+ locale.getCountry();
//	}
//	
//
//	public static Languages fromValue(String v) {
//		for (Languages c : Languages.values()) {
//			if (c.name().equalsIgnoreCase(v)) {
//				return c;
//			}
//		}
//		return Languages.PT;
//	}
//	
//	public static Locale getLocale(String v) {
//		for (Languages l : Languages.values()) {
//			if (l.name().equalsIgnoreCase(v)) {
//				return new Locale(l.getLanguage(), l.getCountry());
//			}
//		}
//		return new Locale(Languages.PT.getLanguage(), Languages.PT.getCountry());
//	}
//
//}
