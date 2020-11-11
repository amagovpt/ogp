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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import pt.ama.service.db.entities.exception.NoSuchUserPersonalDataException;
import pt.ama.service.db.entities.model.UserPersonalData;

/**
 * The persistence interface for the user personal data service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see pt.ama.service.db.entities.service.persistence.impl.UserPersonalDataPersistenceImpl
 * @see UserPersonalDataUtil
 * @generated
 */
@ProviderType
public interface UserPersonalDataPersistence extends BasePersistence<UserPersonalData> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserPersonalDataUtil} to access the user personal data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the user personal data where identificationId = &#63; or throws a {@link NoSuchUserPersonalDataException} if it could not be found.
	*
	* @param identificationId the identification ID
	* @return the matching user personal data
	* @throws NoSuchUserPersonalDataException if a matching user personal data could not be found
	*/
	public UserPersonalData findByidentificationId(
		java.lang.String identificationId)
		throws NoSuchUserPersonalDataException;

	/**
	* Returns the user personal data where identificationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param identificationId the identification ID
	* @return the matching user personal data, or <code>null</code> if a matching user personal data could not be found
	*/
	public UserPersonalData fetchByidentificationId(
		java.lang.String identificationId);

	/**
	* Returns the user personal data where identificationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param identificationId the identification ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching user personal data, or <code>null</code> if a matching user personal data could not be found
	*/
	public UserPersonalData fetchByidentificationId(
		java.lang.String identificationId, boolean retrieveFromCache);

	/**
	* Removes the user personal data where identificationId = &#63; from the database.
	*
	* @param identificationId the identification ID
	* @return the user personal data that was removed
	*/
	public UserPersonalData removeByidentificationId(
		java.lang.String identificationId)
		throws NoSuchUserPersonalDataException;

	/**
	* Returns the number of user personal datas where identificationId = &#63;.
	*
	* @param identificationId the identification ID
	* @return the number of matching user personal datas
	*/
	public int countByidentificationId(java.lang.String identificationId);

	/**
	* Returns the user personal data where lawerId = &#63; or throws a {@link NoSuchUserPersonalDataException} if it could not be found.
	*
	* @param lawerId the lawer ID
	* @return the matching user personal data
	* @throws NoSuchUserPersonalDataException if a matching user personal data could not be found
	*/
	public UserPersonalData findBylawerId(java.lang.String lawerId)
		throws NoSuchUserPersonalDataException;

	/**
	* Returns the user personal data where lawerId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param lawerId the lawer ID
	* @return the matching user personal data, or <code>null</code> if a matching user personal data could not be found
	*/
	public UserPersonalData fetchBylawerId(java.lang.String lawerId);

	/**
	* Returns the user personal data where lawerId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param lawerId the lawer ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching user personal data, or <code>null</code> if a matching user personal data could not be found
	*/
	public UserPersonalData fetchBylawerId(java.lang.String lawerId,
		boolean retrieveFromCache);

	/**
	* Removes the user personal data where lawerId = &#63; from the database.
	*
	* @param lawerId the lawer ID
	* @return the user personal data that was removed
	*/
	public UserPersonalData removeBylawerId(java.lang.String lawerId)
		throws NoSuchUserPersonalDataException;

	/**
	* Returns the number of user personal datas where lawerId = &#63;.
	*
	* @param lawerId the lawer ID
	* @return the number of matching user personal datas
	*/
	public int countBylawerId(java.lang.String lawerId);

	/**
	* Returns the user personal data where solicitorId = &#63; or throws a {@link NoSuchUserPersonalDataException} if it could not be found.
	*
	* @param solicitorId the solicitor ID
	* @return the matching user personal data
	* @throws NoSuchUserPersonalDataException if a matching user personal data could not be found
	*/
	public UserPersonalData findBysolicitorId(java.lang.String solicitorId)
		throws NoSuchUserPersonalDataException;

	/**
	* Returns the user personal data where solicitorId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param solicitorId the solicitor ID
	* @return the matching user personal data, or <code>null</code> if a matching user personal data could not be found
	*/
	public UserPersonalData fetchBysolicitorId(java.lang.String solicitorId);

	/**
	* Returns the user personal data where solicitorId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param solicitorId the solicitor ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching user personal data, or <code>null</code> if a matching user personal data could not be found
	*/
	public UserPersonalData fetchBysolicitorId(java.lang.String solicitorId,
		boolean retrieveFromCache);

	/**
	* Removes the user personal data where solicitorId = &#63; from the database.
	*
	* @param solicitorId the solicitor ID
	* @return the user personal data that was removed
	*/
	public UserPersonalData removeBysolicitorId(java.lang.String solicitorId)
		throws NoSuchUserPersonalDataException;

	/**
	* Returns the number of user personal datas where solicitorId = &#63;.
	*
	* @param solicitorId the solicitor ID
	* @return the number of matching user personal datas
	*/
	public int countBysolicitorId(java.lang.String solicitorId);

	/**
	* Returns the user personal data where notaryId = &#63; or throws a {@link NoSuchUserPersonalDataException} if it could not be found.
	*
	* @param notaryId the notary ID
	* @return the matching user personal data
	* @throws NoSuchUserPersonalDataException if a matching user personal data could not be found
	*/
	public UserPersonalData findBynotaryId(java.lang.String notaryId)
		throws NoSuchUserPersonalDataException;

	/**
	* Returns the user personal data where notaryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param notaryId the notary ID
	* @return the matching user personal data, or <code>null</code> if a matching user personal data could not be found
	*/
	public UserPersonalData fetchBynotaryId(java.lang.String notaryId);

	/**
	* Returns the user personal data where notaryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param notaryId the notary ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching user personal data, or <code>null</code> if a matching user personal data could not be found
	*/
	public UserPersonalData fetchBynotaryId(java.lang.String notaryId,
		boolean retrieveFromCache);

	/**
	* Removes the user personal data where notaryId = &#63; from the database.
	*
	* @param notaryId the notary ID
	* @return the user personal data that was removed
	*/
	public UserPersonalData removeBynotaryId(java.lang.String notaryId)
		throws NoSuchUserPersonalDataException;

	/**
	* Returns the number of user personal datas where notaryId = &#63;.
	*
	* @param notaryId the notary ID
	* @return the number of matching user personal datas
	*/
	public int countBynotaryId(java.lang.String notaryId);

	/**
	* Returns the user personal data where passportId = &#63; and nationality = &#63; or throws a {@link NoSuchUserPersonalDataException} if it could not be found.
	*
	* @param passportId the passport ID
	* @param nationality the nationality
	* @return the matching user personal data
	* @throws NoSuchUserPersonalDataException if a matching user personal data could not be found
	*/
	public UserPersonalData findBypassport(java.lang.String passportId,
		java.lang.String nationality) throws NoSuchUserPersonalDataException;

	/**
	* Returns the user personal data where passportId = &#63; and nationality = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param passportId the passport ID
	* @param nationality the nationality
	* @return the matching user personal data, or <code>null</code> if a matching user personal data could not be found
	*/
	public UserPersonalData fetchBypassport(java.lang.String passportId,
		java.lang.String nationality);

	/**
	* Returns the user personal data where passportId = &#63; and nationality = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param passportId the passport ID
	* @param nationality the nationality
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching user personal data, or <code>null</code> if a matching user personal data could not be found
	*/
	public UserPersonalData fetchBypassport(java.lang.String passportId,
		java.lang.String nationality, boolean retrieveFromCache);

	/**
	* Removes the user personal data where passportId = &#63; and nationality = &#63; from the database.
	*
	* @param passportId the passport ID
	* @param nationality the nationality
	* @return the user personal data that was removed
	*/
	public UserPersonalData removeBypassport(java.lang.String passportId,
		java.lang.String nationality) throws NoSuchUserPersonalDataException;

	/**
	* Returns the number of user personal datas where passportId = &#63; and nationality = &#63;.
	*
	* @param passportId the passport ID
	* @param nationality the nationality
	* @return the number of matching user personal datas
	*/
	public int countBypassport(java.lang.String passportId,
		java.lang.String nationality);

	/**
	* Returns the user personal data where userId = &#63; or throws a {@link NoSuchUserPersonalDataException} if it could not be found.
	*
	* @param userId the user ID
	* @return the matching user personal data
	* @throws NoSuchUserPersonalDataException if a matching user personal data could not be found
	*/
	public UserPersonalData findByuserId(long userId)
		throws NoSuchUserPersonalDataException;

	/**
	* Returns the user personal data where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @return the matching user personal data, or <code>null</code> if a matching user personal data could not be found
	*/
	public UserPersonalData fetchByuserId(long userId);

	/**
	* Returns the user personal data where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching user personal data, or <code>null</code> if a matching user personal data could not be found
	*/
	public UserPersonalData fetchByuserId(long userId, boolean retrieveFromCache);

	/**
	* Removes the user personal data where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @return the user personal data that was removed
	*/
	public UserPersonalData removeByuserId(long userId)
		throws NoSuchUserPersonalDataException;

	/**
	* Returns the number of user personal datas where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching user personal datas
	*/
	public int countByuserId(long userId);

	/**
	* Caches the user personal data in the entity cache if it is enabled.
	*
	* @param userPersonalData the user personal data
	*/
	public void cacheResult(UserPersonalData userPersonalData);

	/**
	* Caches the user personal datas in the entity cache if it is enabled.
	*
	* @param userPersonalDatas the user personal datas
	*/
	public void cacheResult(java.util.List<UserPersonalData> userPersonalDatas);

	/**
	* Creates a new user personal data with the primary key. Does not add the user personal data to the database.
	*
	* @param userId the primary key for the new user personal data
	* @return the new user personal data
	*/
	public UserPersonalData create(long userId);

	/**
	* Removes the user personal data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userId the primary key of the user personal data
	* @return the user personal data that was removed
	* @throws NoSuchUserPersonalDataException if a user personal data with the primary key could not be found
	*/
	public UserPersonalData remove(long userId)
		throws NoSuchUserPersonalDataException;

	public UserPersonalData updateImpl(UserPersonalData userPersonalData);

	/**
	* Returns the user personal data with the primary key or throws a {@link NoSuchUserPersonalDataException} if it could not be found.
	*
	* @param userId the primary key of the user personal data
	* @return the user personal data
	* @throws NoSuchUserPersonalDataException if a user personal data with the primary key could not be found
	*/
	public UserPersonalData findByPrimaryKey(long userId)
		throws NoSuchUserPersonalDataException;

	/**
	* Returns the user personal data with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userId the primary key of the user personal data
	* @return the user personal data, or <code>null</code> if a user personal data with the primary key could not be found
	*/
	public UserPersonalData fetchByPrimaryKey(long userId);

	@Override
	public java.util.Map<java.io.Serializable, UserPersonalData> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the user personal datas.
	*
	* @return the user personal datas
	*/
	public java.util.List<UserPersonalData> findAll();

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
	public java.util.List<UserPersonalData> findAll(int start, int end);

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
	public java.util.List<UserPersonalData> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserPersonalData> orderByComparator);

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
	public java.util.List<UserPersonalData> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserPersonalData> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the user personal datas from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of user personal datas.
	*
	* @return the number of user personal datas
	*/
	public int countAll();
}