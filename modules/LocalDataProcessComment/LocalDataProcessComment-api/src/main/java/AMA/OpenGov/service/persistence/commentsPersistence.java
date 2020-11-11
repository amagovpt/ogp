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

import AMA.OpenGov.exception.NoSuchcommentsException;

import AMA.OpenGov.model.comments;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the comments service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AMA.OpenGov.service.persistence.impl.commentsPersistenceImpl
 * @see commentsUtil
 * @generated
 */
@ProviderType
public interface commentsPersistence extends BasePersistence<comments> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link commentsUtil} to access the comments persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the commentses where nome = &#63;.
	*
	* @param nome the nome
	* @return the matching commentses
	*/
	public java.util.List<comments> findByid(java.lang.String nome);

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
	public java.util.List<comments> findByid(java.lang.String nome, int start,
		int end);

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
	public java.util.List<comments> findByid(java.lang.String nome, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<comments> orderByComparator);

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
	public java.util.List<comments> findByid(java.lang.String nome, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<comments> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first comments in the ordered set where nome = &#63;.
	*
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching comments
	* @throws NoSuchcommentsException if a matching comments could not be found
	*/
	public comments findByid_First(java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator<comments> orderByComparator)
		throws NoSuchcommentsException;

	/**
	* Returns the first comments in the ordered set where nome = &#63;.
	*
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching comments, or <code>null</code> if a matching comments could not be found
	*/
	public comments fetchByid_First(java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator<comments> orderByComparator);

	/**
	* Returns the last comments in the ordered set where nome = &#63;.
	*
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching comments
	* @throws NoSuchcommentsException if a matching comments could not be found
	*/
	public comments findByid_Last(java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator<comments> orderByComparator)
		throws NoSuchcommentsException;

	/**
	* Returns the last comments in the ordered set where nome = &#63;.
	*
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching comments, or <code>null</code> if a matching comments could not be found
	*/
	public comments fetchByid_Last(java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator<comments> orderByComparator);

	/**
	* Returns the commentses before and after the current comments in the ordered set where nome = &#63;.
	*
	* @param id the primary key of the current comments
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next comments
	* @throws NoSuchcommentsException if a comments with the primary key could not be found
	*/
	public comments[] findByid_PrevAndNext(long id, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator<comments> orderByComparator)
		throws NoSuchcommentsException;

	/**
	* Removes all the commentses where nome = &#63; from the database.
	*
	* @param nome the nome
	*/
	public void removeByid(java.lang.String nome);

	/**
	* Returns the number of commentses where nome = &#63;.
	*
	* @param nome the nome
	* @return the number of matching commentses
	*/
	public int countByid(java.lang.String nome);

	/**
	* Caches the comments in the entity cache if it is enabled.
	*
	* @param comments the comments
	*/
	public void cacheResult(comments comments);

	/**
	* Caches the commentses in the entity cache if it is enabled.
	*
	* @param commentses the commentses
	*/
	public void cacheResult(java.util.List<comments> commentses);

	/**
	* Creates a new comments with the primary key. Does not add the comments to the database.
	*
	* @param id the primary key for the new comments
	* @return the new comments
	*/
	public comments create(long id);

	/**
	* Removes the comments with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the comments
	* @return the comments that was removed
	* @throws NoSuchcommentsException if a comments with the primary key could not be found
	*/
	public comments remove(long id) throws NoSuchcommentsException;

	public comments updateImpl(comments comments);

	/**
	* Returns the comments with the primary key or throws a {@link NoSuchcommentsException} if it could not be found.
	*
	* @param id the primary key of the comments
	* @return the comments
	* @throws NoSuchcommentsException if a comments with the primary key could not be found
	*/
	public comments findByPrimaryKey(long id) throws NoSuchcommentsException;

	/**
	* Returns the comments with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the comments
	* @return the comments, or <code>null</code> if a comments with the primary key could not be found
	*/
	public comments fetchByPrimaryKey(long id);

	@Override
	public java.util.Map<java.io.Serializable, comments> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the commentses.
	*
	* @return the commentses
	*/
	public java.util.List<comments> findAll();

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
	public java.util.List<comments> findAll(int start, int end);

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
	public java.util.List<comments> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<comments> orderByComparator);

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
	public java.util.List<comments> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<comments> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the commentses from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of commentses.
	*
	* @return the number of commentses
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}