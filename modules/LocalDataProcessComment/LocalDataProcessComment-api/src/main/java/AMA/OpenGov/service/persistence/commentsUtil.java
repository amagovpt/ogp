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

package AMA.OpenGov.service.persistence;

import AMA.OpenGov.model.comments;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the comments service. This utility wraps {@link AMA.OpenGov.service.persistence.impl.commentsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see commentsPersistence
 * @see AMA.OpenGov.service.persistence.impl.commentsPersistenceImpl
 * @generated
 */
@ProviderType
public class commentsUtil {
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
	public static void clearCache(comments comments) {
		getPersistence().clearCache(comments);
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
	public static List<comments> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<comments> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<comments> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<comments> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static comments update(comments comments) {
		return getPersistence().update(comments);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static comments update(comments comments,
		ServiceContext serviceContext) {
		return getPersistence().update(comments, serviceContext);
	}

	/**
	* Returns all the commentses where nome = &#63;.
	*
	* @param nome the nome
	* @return the matching commentses
	*/
	public static List<comments> findByid(java.lang.String nome) {
		return getPersistence().findByid(nome);
	}

	/**
	* Returns a range of all the commentses where nome = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link commentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param nome the nome
	* @param start the lower bound of the range of commentses
	* @param end the upper bound of the range of commentses (not inclusive)
	* @return the range of matching commentses
	*/
	public static List<comments> findByid(java.lang.String nome, int start,
		int end) {
		return getPersistence().findByid(nome, start, end);
	}

	/**
	* Returns an ordered range of all the commentses where nome = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link commentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param nome the nome
	* @param start the lower bound of the range of commentses
	* @param end the upper bound of the range of commentses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching commentses
	*/
	public static List<comments> findByid(java.lang.String nome, int start,
		int end, OrderByComparator<comments> orderByComparator) {
		return getPersistence().findByid(nome, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the commentses where nome = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link commentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param nome the nome
	* @param start the lower bound of the range of commentses
	* @param end the upper bound of the range of commentses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching commentses
	*/
	public static List<comments> findByid(java.lang.String nome, int start,
		int end, OrderByComparator<comments> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByid(nome, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first comments in the ordered set where nome = &#63;.
	*
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching comments
	* @throws NoSuchcommentsException if a matching comments could not be found
	*/
	public static comments findByid_First(java.lang.String nome,
		OrderByComparator<comments> orderByComparator)
		throws AMA.OpenGov.exception.NoSuchcommentsException {
		return getPersistence().findByid_First(nome, orderByComparator);
	}

	/**
	* Returns the first comments in the ordered set where nome = &#63;.
	*
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching comments, or <code>null</code> if a matching comments could not be found
	*/
	public static comments fetchByid_First(java.lang.String nome,
		OrderByComparator<comments> orderByComparator) {
		return getPersistence().fetchByid_First(nome, orderByComparator);
	}

	/**
	* Returns the last comments in the ordered set where nome = &#63;.
	*
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching comments
	* @throws NoSuchcommentsException if a matching comments could not be found
	*/
	public static comments findByid_Last(java.lang.String nome,
		OrderByComparator<comments> orderByComparator)
		throws AMA.OpenGov.exception.NoSuchcommentsException {
		return getPersistence().findByid_Last(nome, orderByComparator);
	}

	/**
	* Returns the last comments in the ordered set where nome = &#63;.
	*
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching comments, or <code>null</code> if a matching comments could not be found
	*/
	public static comments fetchByid_Last(java.lang.String nome,
		OrderByComparator<comments> orderByComparator) {
		return getPersistence().fetchByid_Last(nome, orderByComparator);
	}

	/**
	* Returns the commentses before and after the current comments in the ordered set where nome = &#63;.
	*
	* @param id the primary key of the current comments
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next comments
	* @throws NoSuchcommentsException if a comments with the primary key could not be found
	*/
	public static comments[] findByid_PrevAndNext(long id,
		java.lang.String nome, OrderByComparator<comments> orderByComparator)
		throws AMA.OpenGov.exception.NoSuchcommentsException {
		return getPersistence().findByid_PrevAndNext(id, nome, orderByComparator);
	}

	/**
	* Removes all the commentses where nome = &#63; from the database.
	*
	* @param nome the nome
	*/
	public static void removeByid(java.lang.String nome) {
		getPersistence().removeByid(nome);
	}

	/**
	* Returns the number of commentses where nome = &#63;.
	*
	* @param nome the nome
	* @return the number of matching commentses
	*/
	public static int countByid(java.lang.String nome) {
		return getPersistence().countByid(nome);
	}

	/**
	* Caches the comments in the entity cache if it is enabled.
	*
	* @param comments the comments
	*/
	public static void cacheResult(comments comments) {
		getPersistence().cacheResult(comments);
	}

	/**
	* Caches the commentses in the entity cache if it is enabled.
	*
	* @param commentses the commentses
	*/
	public static void cacheResult(List<comments> commentses) {
		getPersistence().cacheResult(commentses);
	}

	/**
	* Creates a new comments with the primary key. Does not add the comments to the database.
	*
	* @param id the primary key for the new comments
	* @return the new comments
	*/
	public static comments create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the comments with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the comments
	* @return the comments that was removed
	* @throws NoSuchcommentsException if a comments with the primary key could not be found
	*/
	public static comments remove(long id)
		throws AMA.OpenGov.exception.NoSuchcommentsException {
		return getPersistence().remove(id);
	}

	public static comments updateImpl(comments comments) {
		return getPersistence().updateImpl(comments);
	}

	/**
	* Returns the comments with the primary key or throws a {@link NoSuchcommentsException} if it could not be found.
	*
	* @param id the primary key of the comments
	* @return the comments
	* @throws NoSuchcommentsException if a comments with the primary key could not be found
	*/
	public static comments findByPrimaryKey(long id)
		throws AMA.OpenGov.exception.NoSuchcommentsException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the comments with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the comments
	* @return the comments, or <code>null</code> if a comments with the primary key could not be found
	*/
	public static comments fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	public static java.util.Map<java.io.Serializable, comments> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the commentses.
	*
	* @return the commentses
	*/
	public static List<comments> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the commentses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link commentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of commentses
	* @param end the upper bound of the range of commentses (not inclusive)
	* @return the range of commentses
	*/
	public static List<comments> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the commentses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link commentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of commentses
	* @param end the upper bound of the range of commentses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of commentses
	*/
	public static List<comments> findAll(int start, int end,
		OrderByComparator<comments> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the commentses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link commentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of commentses
	* @param end the upper bound of the range of commentses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of commentses
	*/
	public static List<comments> findAll(int start, int end,
		OrderByComparator<comments> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the commentses from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of commentses.
	*
	* @return the number of commentses
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static commentsPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<commentsPersistence, commentsPersistence> _serviceTracker =
		ServiceTrackerFactory.open(commentsPersistence.class);
}