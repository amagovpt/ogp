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

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for UserPersonalData. This utility wraps
 * {@link pt.ama.service.db.entities.service.impl.UserPersonalDataLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see UserPersonalDataLocalService
 * @see pt.ama.service.db.entities.service.base.UserPersonalDataLocalServiceBaseImpl
 * @see pt.ama.service.db.entities.service.impl.UserPersonalDataLocalServiceImpl
 * @generated
 */
@ProviderType
public class UserPersonalDataLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link pt.ama.service.db.entities.service.impl.UserPersonalDataLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	public static com.liferay.portal.kernel.model.User createUser(
		long userCreatorID, long companyId, long groupId,
		java.lang.String screenName, java.lang.String firstName,
		java.lang.String lastName, java.lang.String identificationId,
		java.lang.String lawerId, java.lang.String notaryId,
		java.lang.String solicitorId, java.lang.String passportId,
		java.lang.String email, java.lang.String nationality,
		java.lang.String agreeFullName, java.lang.String agreePortalUseData,
		java.lang.String agreeEmail) {
		return getService()
				   .createUser(userCreatorID, companyId, groupId, screenName,
			firstName, lastName, identificationId, lawerId, notaryId,
			solicitorId, passportId, email, nationality, agreeFullName,
			agreePortalUseData, agreeEmail);
	}

	public static com.liferay.portal.kernel.model.User getUserByIdentificationId(
		java.lang.String identificationId) {
		return getService().getUserByIdentificationId(identificationId);
	}

	/**
	* Returns the number of user personal datas.
	*
	* @return the number of user personal datas
	*/
	public static int getUserPersonalDatasCount() {
		return getService().getUserPersonalDatasCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
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
	public static java.util.List<pt.ama.service.db.entities.model.UserPersonalData> getUserPersonalDatas(
		int start, int end) {
		return getService().getUserPersonalDatas(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	/**
	* Adds the user personal data to the database. Also notifies the appropriate model listeners.
	*
	* @param userPersonalData the user personal data
	* @return the user personal data that was added
	*/
	public static pt.ama.service.db.entities.model.UserPersonalData addUserPersonalData(
		pt.ama.service.db.entities.model.UserPersonalData userPersonalData) {
		return getService().addUserPersonalData(userPersonalData);
	}

	/**
	* Creates a new user personal data with the primary key. Does not add the user personal data to the database.
	*
	* @param userId the primary key for the new user personal data
	* @return the new user personal data
	*/
	public static pt.ama.service.db.entities.model.UserPersonalData createUserPersonalData(
		long userId) {
		return getService().createUserPersonalData(userId);
	}

	/**
	* Deletes the user personal data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userId the primary key of the user personal data
	* @return the user personal data that was removed
	* @throws PortalException if a user personal data with the primary key could not be found
	*/
	public static pt.ama.service.db.entities.model.UserPersonalData deleteUserPersonalData(
		long userId) throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteUserPersonalData(userId);
	}

	/**
	* Deletes the user personal data from the database. Also notifies the appropriate model listeners.
	*
	* @param userPersonalData the user personal data
	* @return the user personal data that was removed
	*/
	public static pt.ama.service.db.entities.model.UserPersonalData deleteUserPersonalData(
		pt.ama.service.db.entities.model.UserPersonalData userPersonalData) {
		return getService().deleteUserPersonalData(userPersonalData);
	}

	public static pt.ama.service.db.entities.model.UserPersonalData fetchUserPersonalData(
		long userId) {
		return getService().fetchUserPersonalData(userId);
	}

	/**
	* Returns the user personal data with the primary key.
	*
	* @param userId the primary key of the user personal data
	* @return the user personal data
	* @throws PortalException if a user personal data with the primary key could not be found
	*/
	public static pt.ama.service.db.entities.model.UserPersonalData getUserPersonalData(
		long userId) throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getUserPersonalData(userId);
	}

	/**
	* Updates the user personal data in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userPersonalData the user personal data
	* @return the user personal data that was updated
	*/
	public static pt.ama.service.db.entities.model.UserPersonalData updateUserPersonalData(
		pt.ama.service.db.entities.model.UserPersonalData userPersonalData) {
		return getService().updateUserPersonalData(userPersonalData);
	}

	public static void updateUserPersonalData(long userId,
		java.lang.String authenticationType) {
		getService().updateUserPersonalData(userId, authenticationType);
	}

	public static UserPersonalDataLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<UserPersonalDataLocalService, UserPersonalDataLocalService> _serviceTracker =
		ServiceTrackerFactory.open(UserPersonalDataLocalService.class);
}