package AMA.OpenGov.samlProtocol.api.model;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

/**
 * Clazz SamlResponse.
 * 
 * @author Gfi
 */
public class SamlBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String fullName;
	private String firstName;
	private String lastName;
	private String faaaLevel;
	private String emailAddress;
	// solicitor
	private String ncs;

	// CC
	private String serialNumber;
	private String niss;
	private String nif;
	private String nic;
	private String birthday;

	// notary
	private String non;

	// Lawer
	private String noa;
	private String passport;
	private String nationality;

	public SamlBean() {
	}

	public SamlBean(String fullName, String firstName, String lastName) {
		this.fullName = fullName;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public SamlBean(String fullName, String firstName, String lastName, String emailAddress) {
		this.fullName = fullName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
	}

	public SamlBean(String fullName) {
		this.fullName = fullName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getFirstName() {
		if ((firstName == null || firstName == "") && fullName != null) {
			String names[] = fullName.split(" ");
			if (names.length > 0) {
				return names[0];
			} else {
				return "";
			}
		} else

		{
			return firstName;
		}
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		
		if ((lastName == null || lastName == "") && fullName != null) {
			String names[] = fullName.split(" ");
			if (names.length > 0) {
				return names[names.length-1];
			} else {
				return "";
			}
		} else

		{
			return lastName;
		}
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFaaaLevel() {
		return faaaLevel;
	}

	public void setFaaaLevel(String faaaLevel) {
		this.faaaLevel = faaaLevel;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	// solicitor
	public String getNcs() {
		return ncs;
	}

	public void setNcs(String ncs) {
		this.ncs = ncs;
	}

	// CC
	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getNiss() {
		return niss;
	}

	public void setNiss(String niss) {
		this.niss = niss;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	// notary
	public String getNon() {
		return non;
	}

	public void setNon(String non) {
		this.non = non;
	}

	// Lawer
	public String getNoa() {
		return noa;
	}

	public void setNoa(String noa) {
		this.noa = noa;
	}

	// CMD Estrangeira

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public String getNationality() {
		return this.nationality;
	}

	public void setNationality(String citizenship) {
		this.nationality = citizenship;
	}

	public String getScreenName() {
		String screenName = "";

		if (firstName != null && !firstName.trim().isEmpty() && lastName != null && !lastName.trim().isEmpty()) {
			screenName = firstName.trim().charAt(0) + lastName.replace(" ", "");

			screenName = StringUtils.stripAccents(screenName);
		} else if (fullName != null && !fullName.trim().isEmpty()) {
			String names[] = fullName.split(" ");

			if (names != null && names.length > 0) {
				char firstLetter = names[0] != null ? names[0].charAt(0) : 'a';
				screenName = firstLetter + names[names.length - 1];
			}
		}

		return screenName;
	}
}
