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

package pt.ama.service.db.entities.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import pt.ama.service.db.entities.model.UserPersonalData;

import java.util.List;

/**
 * The persistence utility for the user personal data service. This utility wraps {@link pt.ama.service.db.entities.service.persistence.impl.UserPersonalDataPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserPersonalDataPersistence
 * @see pt.ama.service.db.entities.service.persistence.impl.UserPersonalDataPersistenceImpl
 * @generated
 */
@ProviderType
public class UserPersonalDataUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(UserPersonalData userPersonalData) {
		getPersistence().clearCache(userPersonalData);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<UserPersonalData> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserPersonalData> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserPersonalData> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<UserPersonalData> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static UserPersonalData update(UserPersonalData userPersonalData) {
		return getPersistence().update(userPersonalData);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static UserPersonalData update(UserPersonalData userPersonalData,
		ServiceContext serviceContext) {
		return getPersistence().update(userPersonalData, serviceContext);
	}

	/**
	* Returns the user personal data where identificationId = &#63; or throws a {@link NoSuchUserPersonalDataException} if it could not be found.
	*
	* @param identificationId the identification ID
	* @return the matching user personal data
	* @throws NoSuchUserPersonalDataException if a matching user personal data could not be found
	*/
	public static UserPersonalData findByidentificationId(
		java.lang.String identificationId)
		throws pt.ama.service.db.entities.exception.NoSuchUserPersonalDataException {
		return getPersistence().findByidentificationId(identificationId);
	}

	/**
	* Returns the user personal data where identificationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param identificationId the identification ID
	* @return the matching user personal data, or <code>null</code> if a matching user personal data could not be found
	*/
	public static UserPersonalData fetchByidentificationId(
		java.lang.String identificationId) {
		return getPersistence().fetchByidentificationId(identificationId);
	}

	/**
	* Returns the user personal data where identificationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param identificationId the identification ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching user personal data, or <code>null</code> if a matching user personal data could not be found
	*/
	public static UserPersonalData fetchByidentificationId(
		java.lang.String identificationId, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByidentificationId(identificationId, retrieveFromCache);
	}

	/**
	* Removes the user personal data where identificationId = &#63; from the database.
	*
	* @param identificationId the identification ID
	* @return the user personal data that was removed
	*/
	public static UserPersonalData removeByidentificationId(
		java.lang.String identificationId)
		throws pt.ama.service.db.entities.exception.NoSuchUserPersonalDataException {
		return getPersistence().removeByidentificationId(identificationId);
	}

	/**
	* Returns the number of user personal datas where identificationId = &#63;.
	*
	* @param identificationId the identification ID
	* @return the number of matching user personal datas
	*/
	public static int countByidentificationId(java.lang.String identificationId) {
		return getPersistence().countByidentificationId(identificationId);
	}

	/**
	* Returns the user personal data where lawerId = &#63; or throws a {@link NoSuchUserPersonalDataException} if it could not be found.
	*
	* @param lawerId the lawer ID
	* @return the matching user personal data
	* @throws NoSuchUserPersonalDataException if a matching user personal data could not be found
	*/
	public static UserPersonalData findBylawerId(java.lang.String lawerId)
		throws pt.ama.service.db.entities.exception.NoSuchUserPersonalDataException {
		return getPersistence().findBylawerId(lawerId);
	}

	/**
	* Returns the user personal data where lawerId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param lawerId the lawer ID
	* @return the matching user personal data, or <code>null</code> if a matching user personal data could not be found
	*/
	public static UserPersonalData fetchBylawerId(java.lang.String lawerId) {
		return getPersistence().fetchBylawerId(lawerId);
	}

	/**
	* Returns the user personal data where lawerId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param lawerId the lawer ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching user personal data, or <code>null</code> if a matching user personal data could not be found
	*/
	public static UserPersonalData fetchBylawerId(java.lang.String lawerId,
		boolean retrieveFromCache) {
		return getPersistence().fetchBylawerId(lawerId, retrieveFromCache);
	}

	/**
	* Removes the user personal data where lawerId = &#63; from the database.
	*
	* @param lawerId the lawer ID
	* @return the user personal data that was removed
	*/
	public static UserPersonalData removeBylawerId(java.lang.String lawerId)
		throws pt.ama.service.db.entities.exception.NoSuchUserPersonalDataException {
		return getPersistence().removeBylawerId(lawerId);
	}

	/**
	* Returns the number of user personal datas where lawerId = &#63;.
	*
	* @param lawerId the lawer ID
	* @return the number of matching user personal datas
	*/
	public static int countBylawerId(java.lang.String lawerId) {
		return getPersistence().countBylawerId(lawerId);
	}

	/**
	* Returns the user personal data where solicitorId = &#63; or throws a {@link NoSuchUserPersonalDataException} if it could not be found.
	*
	* @param solicitorId the solicitor ID
	* @return the matching user personal data
	* @throws NoSuchUserPersonalDataException if a matching user personal data could not be found
	*/
	public static UserPersonalData findBysolicitorId(
		java.lang.String solicitorId)
		throws pt.ama.service.db.entities.exception.NoSuchUserPersonalDataException {
		return getPersistence().findBysolicitorId(solicitorId);
	}

	/**
	* Returns the user personal data where solicitorId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param solicitorId the solicitor ID
	* @return the matching user personal data, or <code>null</code> if a matching user personal data could not be found
	*/
	public static UserPersonalData fetchBysolicitorId(
		java.lang.String solicitorId) {
		return getPersistence().fetchBysolicitorId(solicitorId);
	}

	/**
	* Returns the user personal data where solicitorId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param solicitorId the solicitor ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching user personal data, or <code>null</code> if a matching user personal data could not be found
	*/
	public static UserPersonalData fetchBysolicitorId(
		java.lang.String solicitorId, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchBysolicitorId(solicitorId, retrieveFromCache);
	}

	/**
	* Removes the user personal data where solicitorId = &#63; from the database.
	*
	* @param solicitorId the solicitor ID
	* @return the user personal data that was removed
	*/
	public static UserPersonalData removeBysolicitorId(
		java.lang.String solicitorId)
		throws pt.ama.service.db.entities.exception.NoSuchUserPersonalDataException {
		return getPersistence().removeBysolicitorId(solicitorId);
	}

	/**
	* Returns the number of user personal datas where solicitorId = &#63;.
	*
	* @param solicitorId the solicitor ID
	* @return the number of matching user personal datas
	*/
	public static int countBysolicitorId(java.lang.String solicitorId) {
		return getPersistence().countBysolicitorId(solicitorId);
	}

	/**
	* Returns the user personal data where notaryId = &#63; or throws a {@link NoSuchUserPersonalDataException} if it could not be found.
	*
	* @param notaryId the notary ID
	* @return the matching user personal data
	* @throws NoSuchUserPersonalDataException if a matching user personal data could not be found
	*/
	public static UserPersonalData findBynotaryId(java.lang.String notaryId)
		throws pt.ama.service.db.entities.exception.NoSuchUserPersonalDataException {
		return getPersistence().findBynotaryId(notaryId);
	}

	/**
	* Returns the user personal data where notaryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param notaryId the notary ID
	* @return the matching user personal data, or <code>null</code> if a matching user personal data could not be found
	*/
	public static UserPersonalData fetchBynotaryId(java.lang.String notaryId) {
		return getPersistence().fetchBynotaryId(notaryId);
	}

	/**
	* Returns the user personal data where notaryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param notaryId the notary ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching user personal data, or <code>null</code> if a matching user personal data could not be found
	*/
	public static UserPersonalData fetchBynotaryId(java.lang.String notaryId,
		boolean retrieveFromCache) {
		return getPersistence().fetchBynotaryId(notaryId, retrieveFromCache);
	}

	/**
	* Removes the user personal data where notaryId = &#63; from the database.
	*
	* @param notaryId the notary ID
	* @return the user personal data that was removed
	*/
	public static UserPersonalData removeBynotaryId(java.lang.String notaryId)
		throws pt.ama.service.db.entities.exception.NoSuchUserPersonalDataException {
		return getPersistence().removeBynotaryId(notaryId);
	}

	/**
	* Returns the number of user personal datas where notaryId = &#63;.
	*
	* @param notaryId the notary ID
	* @return the number of matching user personal datas
	*/
	public static int countBynotaryId(java.lang.String notaryId) {
		return getPersistence().countBynotaryId(notaryId);
	}

	/**
	* Returns the user personal data where passportId = &#63; and nationality = &#63; or throws a {@link NoSuchUserPersonalDataException} if it could not be found.
	*
	* @param passportId the passport ID
	* @param nationality the nationality
	* @return the matching user personal data
	* @throws NoSuchUserPersonalDataException if a matching user personal data could not be found
	*/
	public static UserPersonalData findBypassport(java.lang.String passportId,
		java.lang.String nationality)
		throws pt.ama.service.db.entities.exception.NoSuchUserPersonalDataException {
		return getPersistence().findBypassport(passportId, nationality);
	}

	/**
	* Returns the user personal data where passportId = &#63; and nationality = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param passportId the passport ID
	* @param nationality the nationality
	* @return the matching user personal data, or <code>null</code> if a matching user personal data could not be found
	*/
	public static UserPersonalData fetchBypassport(
		java.lang.String passportId, java.lang.String nationality) {
		return getPersistence().fetchBypassport(passportId, nationality);
	}

	/**
	* Returns the user personal data where passportId = &#63; and nationality = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param passportId the passport ID
	* @param nationality the nationality
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching user personal data, or <code>null</code> if a matching user personal data could not be found
	*/
	public static UserPersonalData fetchBypassport(
		java.lang.String passportId, java.lang.String nationality,
		boolean retrieveFromCache) {
		return getPersistence()
				   .fetchBypassport(passportId, nationality, retrieveFromCache);
	}

	/**
	* Removes the user personal data where passportId = &#63; and nationality = &#63; from the database.
	*
	* @param passportId the passport ID
	* @param nationality the nationality
	* @return the user personal data that was removed
	*/
	public static UserPersonalData removeBypassport(
		java.lang.String passportId, java.lang.String nationality)
		throws pt.ama.service.db.entities.exception.NoSuchUserPersonalDataException {
		return getPersistence().removeBypassport(passportId, nationality);
	}

	/**
	* Returns the number of user personal datas where passportId = &#63; and nationality = &#63;.
	*
	* @param passportId the passport ID
	* @param nationality the nationality
	* @return the number of matching user personal datas
	*/
	public static int countBypassport(java.lang.String passportId,
		java.lang.String nationality) {
		return getPersistence().countBypassport(passportId, nationality);
	}

	/**
	* Returns the user personal data where userId = &#63; or throws a {@link NoSuchUserPersonalDataException} if it could not be found.
	*
	* @param userId the user ID
	* @return the matching user personal data
	* @throws NoSuchUserPersonalDataException if a matching user personal data could not be found
	*/
	public static UserPersonalData findByuserId(long userId)
		throws pt.ama.service.db.entities.exception.NoSuchUserPersonalDataException {
		return getPersistence().findByuserId(userId);
	}

	/**
	* Returns the user personal data where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @return the matching user personal data, or <code>null</code> if a matching user personal data could not be found
	*/
	public static UserPersonalData fetchByuserId(long userId) {
		return getPersistence().fetchByuserId(userId);
	}

	/**
	* Returns the user personal data where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching user personal data, or <code>null</code> if a matching user personal data could not be found
	*/
	public static UserPersonalData fetchByuserId(long userId,
		boolean retrieveFromCache) {
		return getPersistence().fetchByuserId(userId, retrieveFromCache);
	}

	/**
	* Removes the user personal data where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @return the user personal data that was removed
	*/
	public static UserPersonalData removeByuserId(long userId)
		throws pt.ama.service.db.entities.exception.NoSuchUserPersonalDataException {
		return getPersistence().removeByuserId(userId);
	}

	/**
	* Returns the number of user personal datas where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching user personal datas
	*/
	public static int countByuserId(long userId) {
		return getPersistence().countByuserId(userId);
	}

	/**
	* Caches the user personal data in the entity cache if it is enabled.
	*
	* @param userPersonalData the user personal data
	*/
	public static void cacheResult(UserPersonalData userPersonalData) {
		getPersistence().cacheResult(userPersonalData);
	}

	/**
	* Caches the user personal datas in the entity cache if it is enabled.
	*
	* @param userPersonalDatas the user personal datas
	*/
	public static void cacheResult(List<UserPersonalData> userPersonalDatas) {
		getPersistence().cacheResult(userPersonalDatas);
	}

	/**
	* Creates a new user personal data with the primary key. Does not add the user personal data to the database.
	*
	* @param userId the primary key for the new user personal data
	* @return the new user personal data
	*/
	public static UserPersonalData create(long userId) {
		return getPersistence().create(userId);
	}

	/**
	* Removes the user personal data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userId the primary key of the user personal data
	* @return the user personal data that was removed
	* @throws NoSuchUserPersonalDataException if a user personal data with the primary key could not be found
	*/
	public static UserPersonalData remove(long userId)
		throws pt.ama.service.db.entities.exception.NoSuchUserPersonalDataException {
		return getPersistence().remove(userId);
	}

	public static UserPersonalData updateImpl(UserPersonalData userPersonalData) {
		return getPersistence().updateImpl(userPersonalData);
	}

	/**
	* Returns the user personal data with the primary key or throws a {@link NoSuchUserPersonalDataException} if it could not be found.
	*
	* @param userId the primary key of the user personal data
	* @return the user personal data
	* @throws NoSuchUserPersonalDataException if a user personal data with the primary key could not be found
	*/
	public static UserPersonalData findByPrimaryKey(long userId)
		throws pt.ama.service.db.entities.exception.NoSuchUserPersonalDataException {
		return getPersistence().findByPrimaryKey(userId);
	}

	/**
	* Returns the user personal data with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userId the primary key of the user personal data
	* @return the user personal data, or <code>null</code> if a user personal data with the primary key could not be found
	*/
	public static UserPersonalData fetchByPrimaryKey(long userId) {
		return getPersistence().fetchByPrimaryKey(userId);
	}

	public static java.util.Map<java.io.Serializable, UserPersonalData> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the user personal datas.
	*
	* @return the user personal datas
	*/
	public static List<UserPersonalData> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the user personal datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserPersonalDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user personal datas
	* @param end the upper bound of the range of user personal datas (not inclusive)
	* @return the range of user personal datas
	*/
	public static List<UserPersonalData> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the user personal datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserPersonalDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user personal datas
	* @param end the upper bound of the range of user personal datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of user personal datas
	*/
	public static List<UserPersonalData> findAll(int start, int end,
		OrderByComparator<UserPersonalData> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the user personal datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserPersonalDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user personal datas
	* @param end the upper bound of the range of user personal datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of user personal datas
	*/
	public static List<UserPersonalData> findAll(int start, int end,
		OrderByComparator<UserPersonalData> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the user personal datas from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of user personal datas.
	*
	* @return the number of user personal datas
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static UserPersonalDataPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<UserPersonalDataPersistence, UserPersonalDataPersistence> _serviceTracker =
		ServiceTrackerFactory.open(UserPersonalDataPersistence.class);
}