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

package ama.opengov.service.persistence;

import aQute.bnd.annotation.ProviderType;

import ama.opengov.model.emailContact;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the email contact service. This utility wraps {@link ama.opengov.service.persistence.impl.emailContactPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see emailContactPersistence
 * @see ama.opengov.service.persistence.impl.emailContactPersistenceImpl
 * @generated
 */
@ProviderType
public class emailContactUtil {
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
	public static void clearCache(emailContact emailContact) {
		getPersistence().clearCache(emailContact);
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
	public static List<emailContact> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<emailContact> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<emailContact> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<emailContact> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static emailContact update(emailContact emailContact) {
		return getPersistence().update(emailContact);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static emailContact update(emailContact emailContact,
		ServiceContext serviceContext) {
		return getPersistence().update(emailContact, serviceContext);
	}

	/**
	* Returns all the email contacts where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching email contacts
	*/
	public static List<emailContact> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the email contacts where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link emailContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of email contacts
	* @param end the upper bound of the range of email contacts (not inclusive)
	* @return the range of matching email contacts
	*/
	public static List<emailContact> findByUuid(java.lang.String uuid,
		int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the email contacts where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link emailContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of email contacts
	* @param end the upper bound of the range of email contacts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching email contacts
	*/
	public static List<emailContact> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<emailContact> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the email contacts where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link emailContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of email contacts
	* @param end the upper bound of the range of email contacts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching email contacts
	*/
	public static List<emailContact> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<emailContact> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first email contact in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching email contact
	* @throws NoSuchemailContactException if a matching email contact could not be found
	*/
	public static emailContact findByUuid_First(java.lang.String uuid,
		OrderByComparator<emailContact> orderByComparator)
		throws ama.opengov.exception.NoSuchemailContactException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first email contact in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching email contact, or <code>null</code> if a matching email contact could not be found
	*/
	public static emailContact fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<emailContact> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last email contact in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching email contact
	* @throws NoSuchemailContactException if a matching email contact could not be found
	*/
	public static emailContact findByUuid_Last(java.lang.String uuid,
		OrderByComparator<emailContact> orderByComparator)
		throws ama.opengov.exception.NoSuchemailContactException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last email contact in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching email contact, or <code>null</code> if a matching email contact could not be found
	*/
	public static emailContact fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<emailContact> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the email contacts before and after the current email contact in the ordered set where uuid = &#63;.
	*
	* @param id the primary key of the current email contact
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next email contact
	* @throws NoSuchemailContactException if a email contact with the primary key could not be found
	*/
	public static emailContact[] findByUuid_PrevAndNext(long id,
		java.lang.String uuid, OrderByComparator<emailContact> orderByComparator)
		throws ama.opengov.exception.NoSuchemailContactException {
		return getPersistence()
				   .findByUuid_PrevAndNext(id, uuid, orderByComparator);
	}

	/**
	* Removes all the email contacts where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of email contacts where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching email contacts
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns all the email contacts where nome = &#63;.
	*
	* @param nome the nome
	* @return the matching email contacts
	*/
	public static List<emailContact> findByid(java.lang.String nome) {
		return getPersistence().findByid(nome);
	}

	/**
	* Returns a range of all the email contacts where nome = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link emailContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param nome the nome
	* @param start the lower bound of the range of email contacts
	* @param end the upper bound of the range of email contacts (not inclusive)
	* @return the range of matching email contacts
	*/
	public static List<emailContact> findByid(java.lang.String nome, int start,
		int end) {
		return getPersistence().findByid(nome, start, end);
	}

	/**
	* Returns an ordered range of all the email contacts where nome = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link emailContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param nome the nome
	* @param start the lower bound of the range of email contacts
	* @param end the upper bound of the range of email contacts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching email contacts
	*/
	public static List<emailContact> findByid(java.lang.String nome, int start,
		int end, OrderByComparator<emailContact> orderByComparator) {
		return getPersistence().findByid(nome, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the email contacts where nome = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link emailContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param nome the nome
	* @param start the lower bound of the range of email contacts
	* @param end the upper bound of the range of email contacts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching email contacts
	*/
	public static List<emailContact> findByid(java.lang.String nome, int start,
		int end, OrderByComparator<emailContact> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByid(nome, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first email contact in the ordered set where nome = &#63;.
	*
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching email contact
	* @throws NoSuchemailContactException if a matching email contact could not be found
	*/
	public static emailContact findByid_First(java.lang.String nome,
		OrderByComparator<emailContact> orderByComparator)
		throws ama.opengov.exception.NoSuchemailContactException {
		return getPersistence().findByid_First(nome, orderByComparator);
	}

	/**
	* Returns the first email contact in the ordered set where nome = &#63;.
	*
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching email contact, or <code>null</code> if a matching email contact could not be found
	*/
	public static emailContact fetchByid_First(java.lang.String nome,
		OrderByComparator<emailContact> orderByComparator) {
		return getPersistence().fetchByid_First(nome, orderByComparator);
	}

	/**
	* Returns the last email contact in the ordered set where nome = &#63;.
	*
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching email contact
	* @throws NoSuchemailContactException if a matching email contact could not be found
	*/
	public static emailContact findByid_Last(java.lang.String nome,
		OrderByComparator<emailContact> orderByComparator)
		throws ama.opengov.exception.NoSuchemailContactException {
		return getPersistence().findByid_Last(nome, orderByComparator);
	}

	/**
	* Returns the last email contact in the ordered set where nome = &#63;.
	*
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching email contact, or <code>null</code> if a matching email contact could not be found
	*/
	public static emailContact fetchByid_Last(java.lang.String nome,
		OrderByComparator<emailContact> orderByComparator) {
		return getPersistence().fetchByid_Last(nome, orderByComparator);
	}

	/**
	* Returns the email contacts before and after the current email contact in the ordered set where nome = &#63;.
	*
	* @param id the primary key of the current email contact
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next email contact
	* @throws NoSuchemailContactException if a email contact with the primary key could not be found
	*/
	public static emailContact[] findByid_PrevAndNext(long id,
		java.lang.String nome, OrderByComparator<emailContact> orderByComparator)
		throws ama.opengov.exception.NoSuchemailContactException {
		return getPersistence().findByid_PrevAndNext(id, nome, orderByComparator);
	}

	/**
	* Removes all the email contacts where nome = &#63; from the database.
	*
	* @param nome the nome
	*/
	public static void removeByid(java.lang.String nome) {
		getPersistence().removeByid(nome);
	}

	/**
	* Returns the number of email contacts where nome = &#63;.
	*
	* @param nome the nome
	* @return the number of matching email contacts
	*/
	public static int countByid(java.lang.String nome) {
		return getPersistence().countByid(nome);
	}

	/**
	* Caches the email contact in the entity cache if it is enabled.
	*
	* @param emailContact the email contact
	*/
	public static void cacheResult(emailContact emailContact) {
		getPersistence().cacheResult(emailContact);
	}

	/**
	* Caches the email contacts in the entity cache if it is enabled.
	*
	* @param emailContacts the email contacts
	*/
	public static void cacheResult(List<emailContact> emailContacts) {
		getPersistence().cacheResult(emailContacts);
	}

	/**
	* Creates a new email contact with the primary key. Does not add the email contact to the database.
	*
	* @param id the primary key for the new email contact
	* @return the new email contact
	*/
	public static emailContact create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the email contact with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the email contact
	* @return the email contact that was removed
	* @throws NoSuchemailContactException if a email contact with the primary key could not be found
	*/
	public static emailContact remove(long id)
		throws ama.opengov.exception.NoSuchemailContactException {
		return getPersistence().remove(id);
	}

	public static emailContact updateImpl(emailContact emailContact) {
		return getPersistence().updateImpl(emailContact);
	}

	/**
	* Returns the email contact with the primary key or throws a {@link NoSuchemailContactException} if it could not be found.
	*
	* @param id the primary key of the email contact
	* @return the email contact
	* @throws NoSuchemailContactException if a email contact with the primary key could not be found
	*/
	public static emailContact findByPrimaryKey(long id)
		throws ama.opengov.exception.NoSuchemailContactException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the email contact with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the email contact
	* @return the email contact, or <code>null</code> if a email contact with the primary key could not be found
	*/
	public static emailContact fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	public static java.util.Map<java.io.Serializable, emailContact> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the email contacts.
	*
	* @return the email contacts
	*/
	public static List<emailContact> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the email contacts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link emailContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of email contacts
	* @param end the upper bound of the range of email contacts (not inclusive)
	* @return the range of email contacts
	*/
	public static List<emailContact> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the email contacts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link emailContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of email contacts
	* @param end the upper bound of the range of email contacts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of email contacts
	*/
	public static List<emailContact> findAll(int start, int end,
		OrderByComparator<emailContact> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the email contacts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link emailContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of email contacts
	* @param end the upper bound of the range of email contacts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of email contacts
	*/
	public static List<emailContact> findAll(int start, int end,
		OrderByComparator<emailContact> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the email contacts from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of email contacts.
	*
	* @return the number of email contacts
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static emailContactPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<emailContactPersistence, emailContactPersistence> _serviceTracker =
		ServiceTrackerFactory.open(emailContactPersistence.class);
}