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

package pt.ama.service.db.entities.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import pt.ama.service.db.entities.model.UserPersonalData;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing UserPersonalData in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see UserPersonalData
 * @generated
 */
@ProviderType
public class UserPersonalDataCacheModel implements CacheModel<UserPersonalData>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserPersonalDataCacheModel)) {
			return false;
		}

		UserPersonalDataCacheModel userPersonalDataCacheModel = (UserPersonalDataCacheModel)obj;

		if (userId == userPersonalDataCacheModel.userId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, userId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{userId=");
		sb.append(userId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", identificationId=");
		sb.append(identificationId);
		sb.append(", lawerId=");
		sb.append(lawerId);
		sb.append(", solicitorId=");
		sb.append(solicitorId);
		sb.append(", notaryId=");
		sb.append(notaryId);
		sb.append(", passportId=");
		sb.append(passportId);
		sb.append(", nationality=");
		sb.append(nationality);
		sb.append(", authenticationType=");
		sb.append(authenticationType);
		sb.append(", agreeFullName=");
		sb.append(agreeFullName);
		sb.append(", agreePortalUseData=");
		sb.append(agreePortalUseData);
		sb.append(", agreeEmail=");
		sb.append(agreeEmail);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UserPersonalData toEntityModel() {
		UserPersonalDataImpl userPersonalDataImpl = new UserPersonalDataImpl();

		userPersonalDataImpl.setUserId(userId);
		userPersonalDataImpl.setCompanyId(companyId);

		if (identificationId == null) {
			userPersonalDataImpl.setIdentificationId(StringPool.BLANK);
		}
		else {
			userPersonalDataImpl.setIdentificationId(identificationId);
		}

		if (lawerId == null) {
			userPersonalDataImpl.setLawerId(StringPool.BLANK);
		}
		else {
			userPersonalDataImpl.setLawerId(lawerId);
		}

		if (solicitorId == null) {
			userPersonalDataImpl.setSolicitorId(StringPool.BLANK);
		}
		else {
			userPersonalDataImpl.setSolicitorId(solicitorId);
		}

		if (notaryId == null) {
			userPersonalDataImpl.setNotaryId(StringPool.BLANK);
		}
		else {
			userPersonalDataImpl.setNotaryId(notaryId);
		}

		if (passportId == null) {
			userPersonalDataImpl.setPassportId(StringPool.BLANK);
		}
		else {
			userPersonalDataImpl.setPassportId(passportId);
		}

		if (nationality == null) {
			userPersonalDataImpl.setNationality(StringPool.BLANK);
		}
		else {
			userPersonalDataImpl.setNationality(nationality);
		}

		if (authenticationType == null) {
			userPersonalDataImpl.setAuthenticationType(StringPool.BLANK);
		}
		else {
			userPersonalDataImpl.setAuthenticationType(authenticationType);
		}

		if (agreeFullName == null) {
			userPersonalDataImpl.setAgreeFullName(StringPool.BLANK);
		}
		else {
			userPersonalDataImpl.setAgreeFullName(agreeFullName);
		}

		if (agreePortalUseData == null) {
			userPersonalDataImpl.setAgreePortalUseData(StringPool.BLANK);
		}
		else {
			userPersonalDataImpl.setAgreePortalUseData(agreePortalUseData);
		}

		if (agreeEmail == null) {
			userPersonalDataImpl.setAgreeEmail(StringPool.BLANK);
		}
		else {
			userPersonalDataImpl.setAgreeEmail(agreeEmail);
		}

		userPersonalDataImpl.resetOriginalValues();

		return userPersonalDataImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		userId = objectInput.readLong();

		companyId = objectInput.readLong();
		identificationId = objectInput.readUTF();
		lawerId = objectInput.readUTF();
		solicitorId = objectInput.readUTF();
		notaryId = objectInput.readUTF();
		passportId = objectInput.readUTF();
		nationality = objectInput.readUTF();
		authenticationType = objectInput.readUTF();
		agreeFullName = objectInput.readUTF();
		agreePortalUseData = objectInput.readUTF();
		agreeEmail = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(userId);

		objectOutput.writeLong(companyId);

		if (identificationId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(identificationId);
		}

		if (lawerId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lawerId);
		}

		if (solicitorId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(solicitorId);
		}

		if (notaryId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(notaryId);
		}

		if (passportId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(passportId);
		}

		if (nationality == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nationality);
		}

		if (authenticationType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(authenticationType);
		}

		if (agreeFullName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(agreeFullName);
		}

		if (agreePortalUseData == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(agreePortalUseData);
		}

		if (agreeEmail == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(agreeEmail);
		}
	}

	public long userId;
	public long companyId;
	public String identificationId;
	public String lawerId;
	public String solicitorId;
	public String notaryId;
	public String passportId;
	public String nationality;
	public String authenticationType;
	public String agreeFullName;
	public String agreePortalUseData;
	public String agreeEmail;
}