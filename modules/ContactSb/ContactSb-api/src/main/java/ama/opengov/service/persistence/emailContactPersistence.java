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

import ama.opengov.exception.NoSuchemailContactException;

import ama.opengov.model.emailContact;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the email contact service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ama.opengov.service.persistence.impl.emailContactPersistenceImpl
 * @see emailContactUtil
 * @generated
 */
@ProviderType
public interface emailContactPersistence extends BasePersistence<emailContact> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link emailContactUtil} to access the email contact persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the email contacts where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching email contacts
	*/
	public java.util.List<emailContact> findByUuid(java.lang.String uuid);

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
	public java.util.List<emailContact> findByUuid(java.lang.String uuid,
		int start, int end);

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
	public java.util.List<emailContact> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<emailContact> orderByComparator);

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
	public java.util.List<emailContact> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<emailContact> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first email contact in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching email contact
	* @throws NoSuchemailContactException if a matching email contact could not be found
	*/
	public emailContact findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<emailContact> orderByComparator)
		throws NoSuchemailContactException;

	/**
	* Returns the first email contact in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching email contact, or <code>null</code> if a matching email contact could not be found
	*/
	public emailContact fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<emailContact> orderByComparator);

	/**
	* Returns the last email contact in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching email contact
	* @throws NoSuchemailContactException if a matching email contact could not be found
	*/
	public emailContact findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<emailContact> orderByComparator)
		throws NoSuchemailContactException;

	/**
	* Returns the last email contact in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching email contact, or <code>null</code> if a matching email contact could not be found
	*/
	public emailContact fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<emailContact> orderByComparator);

	/**
	* Returns the email contacts before and after the current email contact in the ordered set where uuid = &#63;.
	*
	* @param id the primary key of the current email contact
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next email contact
	* @throws NoSuchemailContactException if a email contact with the primary key could not be found
	*/
	public emailContact[] findByUuid_PrevAndNext(long id,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<emailContact> orderByComparator)
		throws NoSuchemailContactException;

	/**
	* Removes all the email contacts where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of email contacts where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching email contacts
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns all the email contacts where nome = &#63;.
	*
	* @param nome the nome
	* @return the matching email contacts
	*/
	public java.util.List<emailContact> findByid(java.lang.String nome);

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
	public java.util.List<emailContact> findByid(java.lang.String nome,
		int start, int end);

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
	public java.util.List<emailContact> findByid(java.lang.String nome,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<emailContact> orderByComparator);

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
	public java.util.List<emailContact> findByid(java.lang.String nome,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<emailContact> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first email contact in the ordered set where nome = &#63;.
	*
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching email contact
	* @throws NoSuchemailContactException if a matching email contact could not be found
	*/
	public emailContact findByid_First(java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator<emailContact> orderByComparator)
		throws NoSuchemailContactException;

	/**
	* Returns the first email contact in the ordered set where nome = &#63;.
	*
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching email contact, or <code>null</code> if a matching email contact could not be found
	*/
	public emailContact fetchByid_First(java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator<emailContact> orderByComparator);

	/**
	* Returns the last email contact in the ordered set where nome = &#63;.
	*
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching email contact
	* @throws NoSuchemailContactException if a matching email contact could not be found
	*/
	public emailContact findByid_Last(java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator<emailContact> orderByComparator)
		throws NoSuchemailContactException;

	/**
	* Returns the last email contact in the ordered set where nome = &#63;.
	*
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching email contact, or <code>null</code> if a matching email contact could not be found
	*/
	public emailContact fetchByid_Last(java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator<emailContact> orderByComparator);

	/**
	* Returns the email contacts before and after the current email contact in the ordered set where nome = &#63;.
	*
	* @param id the primary key of the current email contact
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next email contact
	* @throws NoSuchemailContactException if a email contact with the primary key could not be found
	*/
	public emailContact[] findByid_PrevAndNext(long id, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator<emailContact> orderByComparator)
		throws NoSuchemailContactException;

	/**
	* Removes all the email contacts where nome = &#63; from the database.
	*
	* @param nome the nome
	*/
	public void removeByid(java.lang.String nome);

	/**
	* Returns the number of email contacts where nome = &#63;.
	*
	* @param nome the nome
	* @return the number of matching email contacts
	*/
	public int countByid(java.lang.String nome);

	/**
	* Caches the email contact in the entity cache if it is enabled.
	*
	* @param emailContact the email contact
	*/
	public void cacheResult(emailContact emailContact);

	/**
	* Caches the email contacts in the entity cache if it is enabled.
	*
	* @param emailContacts the email contacts
	*/
	public void cacheResult(java.util.List<emailContact> emailContacts);

	/**
	* Creates a new email contact with the primary key. Does not add the email contact to the database.
	*
	* @param id the primary key for the new email contact
	* @return the new email contact
	*/
	public emailContact create(long id);

	/**
	* Removes the email contact with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the email contact
	* @return the email contact that was removed
	* @throws NoSuchemailContactException if a email contact with the primary key could not be found
	*/
	public emailContact remove(long id) throws NoSuchemailContactException;

	public emailContact updateImpl(emailContact emailContact);

	/**
	* Returns the email contact with the primary key or throws a {@link NoSuchemailContactException} if it could not be found.
	*
	* @param id the primary key of the email contact
	* @return the email contact
	* @throws NoSuchemailContactException if a email contact with the primary key could not be found
	*/
	public emailContact findByPrimaryKey(long id)
		throws NoSuchemailContactException;

	/**
	* Returns the email contact with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the email contact
	* @return the email contact, or <code>null</code> if a email contact with the primary key could not be found
	*/
	public emailContact fetchByPrimaryKey(long id);

	@Override
	public java.util.Map<java.io.Serializable, emailContact> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the email contacts.
	*
	* @return the email contacts
	*/
	public java.util.List<emailContact> findAll();

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
	public java.util.List<emailContact> findAll(int start, int end);

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
	public java.util.List<emailContact> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<emailContact> orderByComparator);

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
	public java.util.List<emailContact> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<emailContact> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the email contacts from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of email contacts.
	*
	* @return the number of email contacts
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}