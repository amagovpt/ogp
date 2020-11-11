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

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link UserPersonalData}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserPersonalData
 * @generated
 */
@ProviderType
public class UserPersonalDataWrapper implements UserPersonalData,
	ModelWrapper<UserPersonalData> {
	public UserPersonalDataWrapper(UserPersonalData userPersonalData) {
		_userPersonalData = userPersonalData;
	}

	@Override
	public Class<?> getModelClass() {
		return UserPersonalData.class;
	}

	@Override
	public String getModelClassName() {
		return UserPersonalData.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userId", getUserId());
		attributes.put("companyId", getCompanyId());
		attributes.put("identificationId", getIdentificationId());
		attributes.put("lawerId", getLawerId());
		attributes.put("solicitorId", getSolicitorId());
		attributes.put("notaryId", getNotaryId());
		attributes.put("passportId", getPassportId());
		attributes.put("nationality", getNationality());
		attributes.put("authenticationType", getAuthenticationType());
		attributes.put("agreeFullName", getAgreeFullName());
		attributes.put("agreePortalUseData", getAgreePortalUseData());
		attributes.put("agreeEmail", getAgreeEmail());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String identificationId = (String)attributes.get("identificationId");

		if (identificationId != null) {
			setIdentificationId(identificationId);
		}

		String lawerId = (String)attributes.get("lawerId");

		if (lawerId != null) {
			setLawerId(lawerId);
		}

		String solicitorId = (String)attributes.get("solicitorId");

		if (solicitorId != null) {
			setSolicitorId(solicitorId);
		}

		String notaryId = (String)attributes.get("notaryId");

		if (notaryId != null) {
			setNotaryId(notaryId);
		}

		String passportId = (String)attributes.get("passportId");

		if (passportId != null) {
			setPassportId(passportId);
		}

		String nationality = (String)attributes.get("nationality");

		if (nationality != null) {
			setNationality(nationality);
		}

		String authenticationType = (String)attributes.get("authenticationType");

		if (authenticationType != null) {
			setAuthenticationType(authenticationType);
		}

		String agreeFullName = (String)attributes.get("agreeFullName");

		if (agreeFullName != null) {
			setAgreeFullName(agreeFullName);
		}

		String agreePortalUseData = (String)attributes.get("agreePortalUseData");

		if (agreePortalUseData != null) {
			setAgreePortalUseData(agreePortalUseData);
		}

		String agreeEmail = (String)attributes.get("agreeEmail");

		if (agreeEmail != null) {
			setAgreeEmail(agreeEmail);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _userPersonalData.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _userPersonalData.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _userPersonalData.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _userPersonalData.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<pt.ama.service.db.entities.model.UserPersonalData> toCacheModel() {
		return _userPersonalData.toCacheModel();
	}

	@Override
	public int compareTo(
		pt.ama.service.db.entities.model.UserPersonalData userPersonalData) {
		return _userPersonalData.compareTo(userPersonalData);
	}

	@Override
	public int hashCode() {
		return _userPersonalData.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _userPersonalData.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new UserPersonalDataWrapper((UserPersonalData)_userPersonalData.clone());
	}

	/**
	* Returns the agree email of this user personal data.
	*
	* @return the agree email of this user personal data
	*/
	@Override
	public java.lang.String getAgreeEmail() {
		return _userPersonalData.getAgreeEmail();
	}

	/**
	* Returns the agree full name of this user personal data.
	*
	* @return the agree full name of this user personal data
	*/
	@Override
	public java.lang.String getAgreeFullName() {
		return _userPersonalData.getAgreeFullName();
	}

	/**
	* Returns the agree portal use data of this user personal data.
	*
	* @return the agree portal use data of this user personal data
	*/
	@Override
	public java.lang.String getAgreePortalUseData() {
		return _userPersonalData.getAgreePortalUseData();
	}

	/**
	* Returns the authentication type of this user personal data.
	*
	* @return the authentication type of this user personal data
	*/
	@Override
	public java.lang.String getAuthenticationType() {
		return _userPersonalData.getAuthenticationType();
	}

	/**
	* Returns the identification ID of this user personal data.
	*
	* @return the identification ID of this user personal data
	*/
	@Override
	public java.lang.String getIdentificationId() {
		return _userPersonalData.getIdentificationId();
	}

	/**
	* Returns the lawer ID of this user personal data.
	*
	* @return the lawer ID of this user personal data
	*/
	@Override
	public java.lang.String getLawerId() {
		return _userPersonalData.getLawerId();
	}

	/**
	* Returns the nationality of this user personal data.
	*
	* @return the nationality of this user personal data
	*/
	@Override
	public java.lang.String getNationality() {
		return _userPersonalData.getNationality();
	}

	/**
	* Returns the notary ID of this user personal data.
	*
	* @return the notary ID of this user personal data
	*/
	@Override
	public java.lang.String getNotaryId() {
		return _userPersonalData.getNotaryId();
	}

	/**
	* Returns the passport ID of this user personal data.
	*
	* @return the passport ID of this user personal data
	*/
	@Override
	public java.lang.String getPassportId() {
		return _userPersonalData.getPassportId();
	}

	/**
	* Returns the solicitor ID of this user personal data.
	*
	* @return the solicitor ID of this user personal data
	*/
	@Override
	public java.lang.String getSolicitorId() {
		return _userPersonalData.getSolicitorId();
	}

	/**
	* Returns the user uuid of this user personal data.
	*
	* @return the user uuid of this user personal data
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _userPersonalData.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _userPersonalData.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _userPersonalData.toXmlString();
	}

	/**
	* Returns the company ID of this user personal data.
	*
	* @return the company ID of this user personal data
	*/
	@Override
	public long getCompanyId() {
		return _userPersonalData.getCompanyId();
	}

	/**
	* Returns the primary key of this user personal data.
	*
	* @return the primary key of this user personal data
	*/
	@Override
	public long getPrimaryKey() {
		return _userPersonalData.getPrimaryKey();
	}

	/**
	* Returns the user ID of this user personal data.
	*
	* @return the user ID of this user personal data
	*/
	@Override
	public long getUserId() {
		return _userPersonalData.getUserId();
	}

	@Override
	public pt.ama.service.db.entities.model.UserPersonalData toEscapedModel() {
		return new UserPersonalDataWrapper(_userPersonalData.toEscapedModel());
	}

	@Override
	public pt.ama.service.db.entities.model.UserPersonalData toUnescapedModel() {
		return new UserPersonalDataWrapper(_userPersonalData.toUnescapedModel());
	}

	@Override
	public void persist() {
		_userPersonalData.persist();
	}

	/**
	* Sets the agree email of this user personal data.
	*
	* @param agreeEmail the agree email of this user personal data
	*/
	@Override
	public void setAgreeEmail(java.lang.String agreeEmail) {
		_userPersonalData.setAgreeEmail(agreeEmail);
	}

	/**
	* Sets the agree full name of this user personal data.
	*
	* @param agreeFullName the agree full name of this user personal data
	*/
	@Override
	public void setAgreeFullName(java.lang.String agreeFullName) {
		_userPersonalData.setAgreeFullName(agreeFullName);
	}

	/**
	* Sets the agree portal use data of this user personal data.
	*
	* @param agreePortalUseData the agree portal use data of this user personal data
	*/
	@Override
	public void setAgreePortalUseData(java.lang.String agreePortalUseData) {
		_userPersonalData.setAgreePortalUseData(agreePortalUseData);
	}

	/**
	* Sets the authentication type of this user personal data.
	*
	* @param authenticationType the authentication type of this user personal data
	*/
	@Override
	public void setAuthenticationType(java.lang.String authenticationType) {
		_userPersonalData.setAuthenticationType(authenticationType);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_userPersonalData.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this user personal data.
	*
	* @param companyId the company ID of this user personal data
	*/
	@Override
	public void setCompanyId(long companyId) {
		_userPersonalData.setCompanyId(companyId);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_userPersonalData.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_userPersonalData.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_userPersonalData.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the identification ID of this user personal data.
	*
	* @param identificationId the identification ID of this user personal data
	*/
	@Override
	public void setIdentificationId(java.lang.String identificationId) {
		_userPersonalData.setIdentificationId(identificationId);
	}

	/**
	* Sets the lawer ID of this user personal data.
	*
	* @param lawerId the lawer ID of this user personal data
	*/
	@Override
	public void setLawerId(java.lang.String lawerId) {
		_userPersonalData.setLawerId(lawerId);
	}

	/**
	* Sets the nationality of this user personal data.
	*
	* @param nationality the nationality of this user personal data
	*/
	@Override
	public void setNationality(java.lang.String nationality) {
		_userPersonalData.setNationality(nationality);
	}

	@Override
	public void setNew(boolean n) {
		_userPersonalData.setNew(n);
	}

	/**
	* Sets the notary ID of this user personal data.
	*
	* @param notaryId the notary ID of this user personal data
	*/
	@Override
	public void setNotaryId(java.lang.String notaryId) {
		_userPersonalData.setNotaryId(notaryId);
	}

	/**
	* Sets the passport ID of this user personal data.
	*
	* @param passportId the passport ID of this user personal data
	*/
	@Override
	public void setPassportId(java.lang.String passportId) {
		_userPersonalData.setPassportId(passportId);
	}

	/**
	* Sets the primary key of this user personal data.
	*
	* @param primaryKey the primary key of this user personal data
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_userPersonalData.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_userPersonalData.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the solicitor ID of this user personal data.
	*
	* @param solicitorId the solicitor ID of this user personal data
	*/
	@Override
	public void setSolicitorId(java.lang.String solicitorId) {
		_userPersonalData.setSolicitorId(solicitorId);
	}

	/**
	* Sets the user ID of this user personal data.
	*
	* @param userId the user ID of this user personal data
	*/
	@Override
	public void setUserId(long userId) {
		_userPersonalData.setUserId(userId);
	}

	/**
	* Sets the user uuid of this user personal data.
	*
	* @param userUuid the user uuid of this user personal data
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_userPersonalData.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserPersonalDataWrapper)) {
			return false;
		}

		UserPersonalDataWrapper userPersonalDataWrapper = (UserPersonalDataWrapper)obj;

		if (Objects.equals(_userPersonalData,
					userPersonalDataWrapper._userPersonalData)) {
			return true;
		}

		return false;
	}

	@Override
	public UserPersonalData getWrappedModel() {
		return _userPersonalData;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _userPersonalData.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _userPersonalData.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_userPersonalData.resetOriginalValues();
	}

	private final UserPersonalData _userPersonalData;
}