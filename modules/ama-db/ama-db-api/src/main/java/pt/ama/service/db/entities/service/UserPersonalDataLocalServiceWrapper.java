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
 * Provides a wrapper for {@link UserPersonalDataLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see UserPersonalDataLocalService
 * @generated
 */
@ProviderType
public class UserPersonalDataLocalServiceWrapper
	implements UserPersonalDataLocalService,
		ServiceWrapper<UserPersonalDataLocalService> {
	public UserPersonalDataLocalServiceWrapper(
		UserPersonalDataLocalService userPersonalDataLocalService) {
		_userPersonalDataLocalService = userPersonalDataLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _userPersonalDataLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _userPersonalDataLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _userPersonalDataLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userPersonalDataLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userPersonalDataLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.liferay.portal.kernel.model.User createUser(long userCreatorID,
		long companyId, long groupId, java.lang.String screenName,
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String identificationId, java.lang.String lawerId,
		java.lang.String notaryId, java.lang.String solicitorId,
		java.lang.String passportId, java.lang.String email,
		java.lang.String nationality, java.lang.String agreeFullName,
		java.lang.String agreePortalUseData, java.lang.String agreeEmail) {
		return _userPersonalDataLocalService.createUser(userCreatorID,
			companyId, groupId, screenName, firstName, lastName,
			identificationId, lawerId, notaryId, solicitorId, passportId,
			email, nationality, agreeFullName, agreePortalUseData, agreeEmail);
	}

	@Override
	public com.liferay.portal.kernel.model.User getUserByIdentificationId(
		java.lang.String identificationId) {
		return _userPersonalDataLocalService.getUserByIdentificationId(identificationId);
	}

	/**
	* Returns the number of user personal datas.
	*
	* @return the number of user personal datas
	*/
	@Override
	public int getUserPersonalDatasCount() {
		return _userPersonalDataLocalService.getUserPersonalDatasCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _userPersonalDataLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _userPersonalDataLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link pt.ama.service.db.entities.model.impl.UserPersonalDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _userPersonalDataLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link pt.ama.service.db.entities.model.impl.UserPersonalDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _userPersonalDataLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns a range of all the user personal datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link pt.ama.service.db.entities.model.impl.UserPersonalDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user personal datas
	* @param end the upper bound of the range of user personal datas (not inclusive)
	* @return the range of user personal datas
	*/
	@Override
	public java.util.List<pt.ama.service.db.entities.model.UserPersonalData> getUserPersonalDatas(
		int start, int end) {
		return _userPersonalDataLocalService.getUserPersonalDatas(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _userPersonalDataLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _userPersonalDataLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	/**
	* Adds the user personal data to the database. Also notifies the appropriate model listeners.
	*
	* @param userPersonalData the user personal data
	* @return the user personal data that was added
	*/
	@Override
	public pt.ama.service.db.entities.model.UserPersonalData addUserPersonalData(
		pt.ama.service.db.entities.model.UserPersonalData userPersonalData) {
		return _userPersonalDataLocalService.addUserPersonalData(userPersonalData);
	}

	/**
	* Creates a new user personal data with the primary key. Does not add the user personal data to the database.
	*
	* @param userId the primary key for the new user personal data
	* @return the new user personal data
	*/
	@Override
	public pt.ama.service.db.entities.model.UserPersonalData createUserPersonalData(
		long userId) {
		return _userPersonalDataLocalService.createUserPersonalData(userId);
	}

	/**
	* Deletes the user personal data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userId the primary key of the user personal data
	* @return the user personal data that was removed
	* @throws PortalException if a user personal data with the primary key could not be found
	*/
	@Override
	public pt.ama.service.db.entities.model.UserPersonalData deleteUserPersonalData(
		long userId) throws com.liferay.portal.kernel.exception.PortalException {
		return _userPersonalDataLocalService.deleteUserPersonalData(userId);
	}

	/**
	* Deletes the user personal data from the database. Also notifies the appropriate model listeners.
	*
	* @param userPersonalData the user personal data
	* @return the user personal data that was removed
	*/
	@Override
	public pt.ama.service.db.entities.model.UserPersonalData deleteUserPersonalData(
		pt.ama.service.db.entities.model.UserPersonalData userPersonalData) {
		return _userPersonalDataLocalService.deleteUserPersonalData(userPersonalData);
	}

	@Override
	public pt.ama.service.db.entities.model.UserPersonalData fetchUserPersonalData(
		long userId) {
		return _userPersonalDataLocalService.fetchUserPersonalData(userId);
	}

	/**
	* Returns the user personal data with the primary key.
	*
	* @param userId the primary key of the user personal data
	* @return the user personal data
	* @throws PortalException if a user personal data with the primary key could not be found
	*/
	@Override
	public pt.ama.service.db.entities.model.UserPersonalData getUserPersonalData(
		long userId) throws com.liferay.portal.kernel.exception.PortalException {
		return _userPersonalDataLocalService.getUserPersonalData(userId);
	}

	/**
	* Updates the user personal data in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userPersonalData the user personal data
	* @return the user personal data that was updated
	*/
	@Override
	public pt.ama.service.db.entities.model.UserPersonalData updateUserPersonalData(
		pt.ama.service.db.entities.model.UserPersonalData userPersonalData) {
		return _userPersonalDataLocalService.updateUserPersonalData(userPersonalData);
	}

	@Override
	public void updateUserPersonalData(long userId,
		java.lang.String authenticationType) {
		_userPersonalDataLocalService.updateUserPersonalData(userId,
			authenticationType);
	}

	@Override
	public UserPersonalDataLocalService getWrappedService() {
		return _userPersonalDataLocalService;
	}

	@Override
	public void setWrappedService(
		UserPersonalDataLocalService userPersonalDataLocalService) {
		_userPersonalDataLocalService = userPersonalDataLocalService;
	}

	private UserPersonalDataLocalService _userPersonalDataLocalService;
}