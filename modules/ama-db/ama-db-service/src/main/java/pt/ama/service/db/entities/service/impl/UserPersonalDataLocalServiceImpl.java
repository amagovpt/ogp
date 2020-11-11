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

package pt.ama.service.db.entities.service.impl;

import java.util.Date;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;

import AMA.OpenGov.common.model.*;
import pt.ama.service.db.entities.model.UserPersonalData;
import pt.ama.service.db.entities.service.base.UserPersonalDataLocalServiceBaseImpl;


/**
 * The implementation of the user personal data local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link pt.ama.service.db.entities.service.UserPersonalDataLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserPersonalDataLocalServiceBaseImpl
 * @see pt.ama.service.db.entities.service.UserPersonalDataLocalServiceUtil
 */
public class UserPersonalDataLocalServiceImpl
	extends UserPersonalDataLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link pt.ama.service.db.entities.service.UserPersonalDataLocalServiceUtil} to access the user personal data local service.
	 */
	private final Log _log = LogFactoryUtil.getLog(UserPersonalDataLocalServiceImpl.class);
	
	public User getUserByIdentificationId(String identificationId) {
		User user = null;

		if (identificationId != null && identificationId != "") {
			UserPersonalData upd = userPersonalDataPersistence.fetchByidentificationId(identificationId);

			if (upd != null) {
				user = userLocalService.fetchUser(upd.getUserId());
			}
		}
		return user;
	}
	
	public User createUser(long userCreatorID, long companyId, long groupId, String screenName, String firstName, String lastName,
			String identificationId, String lawerId, String notaryId, String solicitorId, String passportId,
			String email, String nationality, String agreeFullName, String agreePortalUseData, String agreeEmail) {

		screenName = screenName.replaceAll(" ", "");

		boolean emailAddressVerified = false;

		if (email == null || email == "") {
			Date date = new Date();
			email = date.getTime() + "@mail.com";
		} else {
			emailAddressVerified = true;
		}

		long[] emptyLong = {};
		long[] grpId = {groupId};

		User user = null;
		try {
			user = userLocalService.addUser(
					userCreatorID /* long creatorUserId */,
					companyId /* long companyId */,
					false /* boolean autoPassword */,
					screenName /* String password1 */,
					screenName /* String password2 */,
					true /* boolean autoScreenName */,
					"" /* String screenName */, email /* String emailAddress */, 0, "",
					Languages.PT.getLocalePT() /* Locale locale */,
					firstName /* String firstName */,
					null /* String middleName */, lastName /* String lastName */,
					0/* int prefixId */, 0 /* int suffixId */,
					true /* boolean male */, 1 /* int birthdayMonth */,
					1 /* int birthdayDay */, 2000 /* int birthdayYear */,
					null /* String jobTitle */, grpId /* long[] groupsIds */, emptyLong /* rolesIds */,
					emptyLong /* userGroupsIds */, emptyLong /* userGroupsIds */,
					false /* boolean sendEmail */, null);

			user.setEmailAddressVerified(emailAddressVerified);
			userLocalService.updateUser(user);

			UserPersonalData userPersonalData = userPersonalDataPersistence.create(user.getUserId());
			userPersonalData.setCompanyId(user.getCompanyId());
			userPersonalData.setUserId(user.getUserId());
			userPersonalData.setIdentificationId(identificationId);
			userPersonalData.setLawerId(lawerId);
			userPersonalData.setNotaryId(notaryId);
			userPersonalData.setSolicitorId(solicitorId);
			userPersonalData.setPassportId(passportId);
			userPersonalData.setNationality(nationality);
			userPersonalData.setAgreeFullName(agreeFullName);
			userPersonalData.setAgreePortalUseData(agreePortalUseData);
			userPersonalData.setAgreeEmail(agreeEmail);
			addUserPersonalData(userPersonalData);

		} catch (PortalException e) {
			_log.error(e.getMessage(), e);
		}

		return user;
	}
	
	public void updateUserPersonalData(long userId, String authenticationType)
	{
		UserPersonalData upd = userPersonalDataPersistence.fetchByPrimaryKey(userId);
		upd.setAuthenticationType(authenticationType);
		updateUserPersonalData(upd);
	}
	
}