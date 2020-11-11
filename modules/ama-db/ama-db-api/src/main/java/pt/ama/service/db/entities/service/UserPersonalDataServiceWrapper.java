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

package pt.ama.service.db.entities.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link UserPersonalDataService}.
 *
 * @author Brian Wing Shun Chan
 * @see UserPersonalDataService
 * @generated
 */
@ProviderType
public class UserPersonalDataServiceWrapper implements UserPersonalDataService,
	ServiceWrapper<UserPersonalDataService> {
	public UserPersonalDataServiceWrapper(
		UserPersonalDataService userPersonalDataService) {
		_userPersonalDataService = userPersonalDataService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _userPersonalDataService.getOSGiServiceIdentifier();
	}

	@Override
	public UserPersonalDataService getWrappedService() {
		return _userPersonalDataService;
	}

	@Override
	public void setWrappedService(
		UserPersonalDataService userPersonalDataService) {
		_userPersonalDataService = userPersonalDataService;
	}

	private UserPersonalDataService _userPersonalDataService;
}