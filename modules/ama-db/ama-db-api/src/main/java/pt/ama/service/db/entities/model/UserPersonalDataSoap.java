/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package pt.ama.service.db.entities.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link pt.ama.service.db.entities.service.http.UserPersonalDataServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see pt.ama.service.db.entities.service.http.UserPersonalDataServiceSoap
 * @generated
 */
@ProviderType
public class UserPersonalDataSoap implements Serializable {
	public static UserPersonalDataSoap toSoapModel(UserPersonalData model) {
		UserPersonalDataSoap soapModel = new UserPersonalDataSoap();

		soapModel.setUserId(model.getUserId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setIdentificationId(model.getIdentificationId());
		soapModel.setLawerId(model.getLawerId());
		soapModel.setSolicitorId(model.getSolicitorId());
		soapModel.setNotaryId(model.getNotaryId());
		soapModel.setPassportId(model.getPassportId());
		soapModel.setNationality(model.getNationality());
		soapModel.setAuthenticationType(model.getAuthenticationType());
		soapModel.setAgreeFullName(model.getAgreeFullName());
		soapModel.setAgreePortalUseData(model.getAgreePortalUseData());
		soapModel.setAgreeEmail(model.getAgreeEmail());

		return soapModel;
	}

	public static UserPersonalDataSoap[] toSoapModels(UserPersonalData[] models) {
		UserPersonalDataSoap[] soapModels = new UserPersonalDataSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserPersonalDataSoap[][] toSoapModels(
		UserPersonalData[][] models) {
		UserPersonalDataSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UserPersonalDataSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UserPersonalDataSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserPersonalDataSoap[] toSoapModels(
		List<UserPersonalData> models) {
		List<UserPersonalDataSoap> soapModels = new ArrayList<UserPersonalDataSoap>(models.size());

		for (UserPersonalData model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UserPersonalDataSoap[soapModels.size()]);
	}

	public UserPersonalDataSoap() {
	}

	public long getPrimaryKey() {
		return _userId;
	}

	public void setPrimaryKey(long pk) {
		setUserId(pk);
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public String getIdentificationId() {
		return _identificationId;
	}

	public void setIdentificationId(String identificationId) {
		_identificationId = identificationId;
	}

	public String getLawerId() {
		return _lawerId;
	}

	public void setLawerId(String lawerId) {
		_lawerId = lawerId;
	}

	public String getSolicitorId() {
		return _solicitorId;
	}

	public void setSolicitorId(String solicitorId) {
		_solicitorId = solicitorId;
	}

	public String getNotaryId() {
		return _notaryId;
	}

	public void setNotaryId(String notaryId) {
		_notaryId = notaryId;
	}

	public String getPassportId() {
		return _passportId;
	}

	public void setPassportId(String passportId) {
		_passportId = passportId;
	}

	public String getNationality() {
		return _nationality;
	}

	public void setNationality(String nationality) {
		_nationality = nationality;
	}

	public String getAuthenticationType() {
		return _authenticationType;
	}

	public void setAuthenticationType(String authenticationType) {
		_authenticationType = authenticationType;
	}

	public String getAgreeFullName() {
		return _agreeFullName;
	}

	public void setAgreeFullName(String agreeFullName) {
		_agreeFullName = agreeFullName;
	}

	public String getAgreePortalUseData() {
		return _agreePortalUseData;
	}

	public void setAgreePortalUseData(String agreePortalUseData) {
		_agreePortalUseData = agreePortalUseData;
	}

	public String getAgreeEmail() {
		return _agreeEmail;
	}

	public void setAgreeEmail(String agreeEmail) {
		_agreeEmail = agreeEmail;
	}

	private long _userId;
	private long _companyId;
	private String _identificationId;
	private String _lawerId;
	private String _solicitorId;
	private String _notaryId;
	private String _passportId;
	private String _nationality;
	private String _authenticationType;
	private String _agreeFullName;
	private String _agreePortalUseData;
	private String _agreeEmail;
}