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

package AMA.OpenGov.LocalDataSaveEmail.service.persistence;

import AMA.OpenGov.LocalDataSaveEmail.model.ogp_comments;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the ogp_comments service. This utility wraps {@link AMA.OpenGov.LocalDataSaveEmail.service.persistence.impl.ogp_commentsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ogp_commentsPersistence
 * @see AMA.OpenGov.LocalDataSaveEmail.service.persistence.impl.ogp_commentsPersistenceImpl
 * @generated
 */
@ProviderType
public class ogp_commentsUtil {
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
	public static void clearCache(ogp_comments ogp_comments) {
		getPersistence().clearCache(ogp_comments);
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
	public static List<ogp_comments> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ogp_comments> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ogp_comments> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ogp_comments> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ogp_comments update(ogp_comments ogp_comments) {
		return getPersistence().update(ogp_comments);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ogp_comments update(ogp_comments ogp_comments,
		ServiceContext serviceContext) {
		return getPersistence().update(ogp_comments, serviceContext);
	}

	/**
	* Returns all the ogp_commentses where nome = &#63;.
	*
	* @param nome the nome
	* @return the matching ogp_commentses
	*/
	public static List<ogp_comments> findByid(java.lang.String nome) {
		return getPersistence().findByid(nome);
	}

	/**
	* Returns a range of all the ogp_commentses where nome = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ogp_commentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param nome the nome
	* @param start the lower bound of the range of ogp_commentses
	* @param end the upper bound of the range of ogp_commentses (not inclusive)
	* @return the range of matching ogp_commentses
	*/
	public static List<ogp_comments> findByid(java.lang.String nome, int start,
		int end) {
		return getPersistence().findByid(nome, start, end);
	}

	/**
	* Returns an ordered range of all the ogp_commentses where nome = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ogp_commentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param nome the nome
	* @param start the lower bound of the range of ogp_commentses
	* @param end the upper bound of the range of ogp_commentses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ogp_commentses
	*/
	public static List<ogp_comments> findByid(java.lang.String nome, int start,
		int end, OrderByComparator<ogp_comments> orderByComparator) {
		return getPersistence().findByid(nome, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the ogp_commentses where nome = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ogp_commentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param nome the nome
	* @param start the lower bound of the range of ogp_commentses
	* @param end the upper bound of the range of ogp_commentses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching ogp_commentses
	*/
	public static List<ogp_comments> findByid(java.lang.String nome, int start,
		int end, OrderByComparator<ogp_comments> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByid(nome, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first ogp_comments in the ordered set where nome = &#63;.
	*
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ogp_comments
	* @throws NoSuchogp_commentsException if a matching ogp_comments could not be found
	*/
	public static ogp_comments findByid_First(java.lang.String nome,
		OrderByComparator<ogp_comments> orderByComparator)
		throws AMA.OpenGov.LocalDataSaveEmail.exception.NoSuchogp_commentsException {
		return getPersistence().findByid_First(nome, orderByComparator);
	}

	/**
	* Returns the first ogp_comments in the ordered set where nome = &#63;.
	*
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ogp_comments, or <code>null</code> if a matching ogp_comments could not be found
	*/
	public static ogp_comments fetchByid_First(java.lang.String nome,
		OrderByComparator<ogp_comments> orderByComparator) {
		return getPersistence().fetchByid_First(nome, orderByComparator);
	}

	/**
	* Returns the last ogp_comments in the ordered set where nome = &#63;.
	*
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ogp_comments
	* @throws NoSuchogp_commentsException if a matching ogp_comments could not be found
	*/
	public static ogp_comments findByid_Last(java.lang.String nome,
		OrderByComparator<ogp_comments> orderByComparator)
		throws AMA.OpenGov.LocalDataSaveEmail.exception.NoSuchogp_commentsException {
		return getPersistence().findByid_Last(nome, orderByComparator);
	}

	/**
	* Returns the last ogp_comments in the ordered set where nome = &#63;.
	*
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ogp_comments, or <code>null</code> if a matching ogp_comments could not be found
	*/
	public static ogp_comments fetchByid_Last(java.lang.String nome,
		OrderByComparator<ogp_comments> orderByComparator) {
		return getPersistence().fetchByid_Last(nome, orderByComparator);
	}

	/**
	* Returns the ogp_commentses before and after the current ogp_comments in the ordered set where nome = &#63;.
	*
	* @param id the primary key of the current ogp_comments
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ogp_comments
	* @throws NoSuchogp_commentsException if a ogp_comments with the primary key could not be found
	*/
	public static ogp_comments[] findByid_PrevAndNext(long id,
		java.lang.String nome, OrderByComparator<ogp_comments> orderByComparator)
		throws AMA.OpenGov.LocalDataSaveEmail.exception.NoSuchogp_commentsException {
		return getPersistence().findByid_PrevAndNext(id, nome, orderByComparator);
	}

	/**
	* Removes all the ogp_commentses where nome = &#63; from the database.
	*
	* @param nome the nome
	*/
	public static void removeByid(java.lang.String nome) {
		getPersistence().removeByid(nome);
	}

	/**
	* Returns the number of ogp_commentses where nome = &#63;.
	*
	* @param nome the nome
	* @return the number of matching ogp_commentses
	*/
	public static int countByid(java.lang.String nome) {
		return getPersistence().countByid(nome);
	}

	/**
	* Caches the ogp_comments in the entity cache if it is enabled.
	*
	* @param ogp_comments the ogp_comments
	*/
	public static void cacheResult(ogp_comments ogp_comments) {
		getPersistence().cacheResult(ogp_comments);
	}

	/**
	* Caches the ogp_commentses in the entity cache if it is enabled.
	*
	* @param ogp_commentses the ogp_commentses
	*/
	public static void cacheResult(List<ogp_comments> ogp_commentses) {
		getPersistence().cacheResult(ogp_commentses);
	}

	/**
	* Creates a new ogp_comments with the primary key. Does not add the ogp_comments to the database.
	*
	* @param id the primary key for the new ogp_comments
	* @return the new ogp_comments
	*/
	public static ogp_comments create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the ogp_comments with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the ogp_comments
	* @return the ogp_comments that was removed
	* @throws NoSuchogp_commentsException if a ogp_comments with the primary key could not be found
	*/
	public static ogp_comments remove(long id)
		throws AMA.OpenGov.LocalDataSaveEmail.exception.NoSuchogp_commentsException {
		return getPersistence().remove(id);
	}

	public static ogp_comments updateImpl(ogp_comments ogp_comments) {
		return getPersistence().updateImpl(ogp_comments);
	}

	/**
	* Returns the ogp_comments with the primary key or throws a {@link NoSuchogp_commentsException} if it could not be found.
	*
	* @param id the primary key of the ogp_comments
	* @return the ogp_comments
	* @throws NoSuchogp_commentsException if a ogp_comments with the primary key could not be found
	*/
	public static ogp_comments findByPrimaryKey(long id)
		throws AMA.OpenGov.LocalDataSaveEmail.exception.NoSuchogp_commentsException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the ogp_comments with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the ogp_comments
	* @return the ogp_comments, or <code>null</code> if a ogp_comments with the primary key could not be found
	*/
	public static ogp_comments fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	public static java.util.Map<java.io.Serializable, ogp_comments> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the ogp_commentses.
	*
	* @return the ogp_commentses
	*/
	public static List<ogp_comments> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the ogp_commentses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ogp_commentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ogp_commentses
	* @param end the upper bound of the range of ogp_commentses (not inclusive)
	* @return the range of ogp_commentses
	*/
	public static List<ogp_comments> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the ogp_commentses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ogp_commentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ogp_commentses
	* @param end the upper bound of the range of ogp_commentses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of ogp_commentses
	*/
	public static List<ogp_comments> findAll(int start, int end,
		OrderByComparator<ogp_comments> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the ogp_commentses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ogp_commentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ogp_commentses
	* @param end the upper bound of the range of ogp_commentses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of ogp_commentses
	*/
	public static List<ogp_comments> findAll(int start, int end,
		OrderByComparator<ogp_comments> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the ogp_commentses from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of ogp_commentses.
	*
	* @return the number of ogp_commentses
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static ogp_commentsPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ogp_commentsPersistence, ogp_commentsPersistence> _serviceTracker =
		ServiceTrackerFactory.open(ogp_commentsPersistence.class);
}