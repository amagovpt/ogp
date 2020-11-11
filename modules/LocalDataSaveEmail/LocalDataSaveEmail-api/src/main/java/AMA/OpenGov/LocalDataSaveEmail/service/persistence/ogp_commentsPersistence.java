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

import AMA.OpenGov.LocalDataSaveEmail.exception.NoSuchogp_commentsException;
import AMA.OpenGov.LocalDataSaveEmail.model.ogp_comments;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the ogp_comments service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AMA.OpenGov.LocalDataSaveEmail.service.persistence.impl.ogp_commentsPersistenceImpl
 * @see ogp_commentsUtil
 * @generated
 */
@ProviderType
public interface ogp_commentsPersistence extends BasePersistence<ogp_comments> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ogp_commentsUtil} to access the ogp_comments persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the ogp_commentses where nome = &#63;.
	*
	* @param nome the nome
	* @return the matching ogp_commentses
	*/
	public java.util.List<ogp_comments> findByid(java.lang.String nome);

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
	public java.util.List<ogp_comments> findByid(java.lang.String nome,
		int start, int end);

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
	public java.util.List<ogp_comments> findByid(java.lang.String nome,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ogp_comments> orderByComparator);

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
	public java.util.List<ogp_comments> findByid(java.lang.String nome,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ogp_comments> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first ogp_comments in the ordered set where nome = &#63;.
	*
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ogp_comments
	* @throws NoSuchogp_commentsException if a matching ogp_comments could not be found
	*/
	public ogp_comments findByid_First(java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator<ogp_comments> orderByComparator)
		throws NoSuchogp_commentsException;

	/**
	* Returns the first ogp_comments in the ordered set where nome = &#63;.
	*
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ogp_comments, or <code>null</code> if a matching ogp_comments could not be found
	*/
	public ogp_comments fetchByid_First(java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator<ogp_comments> orderByComparator);

	/**
	* Returns the last ogp_comments in the ordered set where nome = &#63;.
	*
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ogp_comments
	* @throws NoSuchogp_commentsException if a matching ogp_comments could not be found
	*/
	public ogp_comments findByid_Last(java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator<ogp_comments> orderByComparator)
		throws NoSuchogp_commentsException;

	/**
	* Returns the last ogp_comments in the ordered set where nome = &#63;.
	*
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ogp_comments, or <code>null</code> if a matching ogp_comments could not be found
	*/
	public ogp_comments fetchByid_Last(java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator<ogp_comments> orderByComparator);

	/**
	* Returns the ogp_commentses before and after the current ogp_comments in the ordered set where nome = &#63;.
	*
	* @param id the primary key of the current ogp_comments
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ogp_comments
	* @throws NoSuchogp_commentsException if a ogp_comments with the primary key could not be found
	*/
	public ogp_comments[] findByid_PrevAndNext(long id, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator<ogp_comments> orderByComparator)
		throws NoSuchogp_commentsException;

	/**
	* Removes all the ogp_commentses where nome = &#63; from the database.
	*
	* @param nome the nome
	*/
	public void removeByid(java.lang.String nome);

	/**
	* Returns the number of ogp_commentses where nome = &#63;.
	*
	* @param nome the nome
	* @return the number of matching ogp_commentses
	*/
	public int countByid(java.lang.String nome);

	/**
	* Caches the ogp_comments in the entity cache if it is enabled.
	*
	* @param ogp_comments the ogp_comments
	*/
	public void cacheResult(ogp_comments ogp_comments);

	/**
	* Caches the ogp_commentses in the entity cache if it is enabled.
	*
	* @param ogp_commentses the ogp_commentses
	*/
	public void cacheResult(java.util.List<ogp_comments> ogp_commentses);

	/**
	* Creates a new ogp_comments with the primary key. Does not add the ogp_comments to the database.
	*
	* @param id the primary key for the new ogp_comments
	* @return the new ogp_comments
	*/
	public ogp_comments create(long id);

	/**
	* Removes the ogp_comments with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the ogp_comments
	* @return the ogp_comments that was removed
	* @throws NoSuchogp_commentsException if a ogp_comments with the primary key could not be found
	*/
	public ogp_comments remove(long id) throws NoSuchogp_commentsException;

	public ogp_comments updateImpl(ogp_comments ogp_comments);

	/**
	* Returns the ogp_comments with the primary key or throws a {@link NoSuchogp_commentsException} if it could not be found.
	*
	* @param id the primary key of the ogp_comments
	* @return the ogp_comments
	* @throws NoSuchogp_commentsException if a ogp_comments with the primary key could not be found
	*/
	public ogp_comments findByPrimaryKey(long id)
		throws NoSuchogp_commentsException;

	/**
	* Returns the ogp_comments with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the ogp_comments
	* @return the ogp_comments, or <code>null</code> if a ogp_comments with the primary key could not be found
	*/
	public ogp_comments fetchByPrimaryKey(long id);

	@Override
	public java.util.Map<java.io.Serializable, ogp_comments> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the ogp_commentses.
	*
	* @return the ogp_commentses
	*/
	public java.util.List<ogp_comments> findAll();

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
	public java.util.List<ogp_comments> findAll(int start, int end);

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
	public java.util.List<ogp_comments> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ogp_comments> orderByComparator);

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
	public java.util.List<ogp_comments> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ogp_comments> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the ogp_commentses from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of ogp_commentses.
	*
	* @return the number of ogp_commentses
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}