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

package AMA.OpenGov.service.persistence.impl;

import AMA.OpenGov.exception.NoSuchcommentsException;

import AMA.OpenGov.model.comments;
import AMA.OpenGov.model.impl.commentsImpl;
import AMA.OpenGov.model.impl.commentsModelImpl;

import AMA.OpenGov.service.persistence.commentsPersistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReflectionUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the comments service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see commentsPersistence
 * @see AMA.OpenGov.service.persistence.commentsUtil
 * @generated
 */
@ProviderType
public class commentsPersistenceImpl extends BasePersistenceImpl<comments>
	implements commentsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link commentsUtil} to access the comments persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = commentsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(commentsModelImpl.ENTITY_CACHE_ENABLED,
			commentsModelImpl.FINDER_CACHE_ENABLED, commentsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(commentsModelImpl.ENTITY_CACHE_ENABLED,
			commentsModelImpl.FINDER_CACHE_ENABLED, commentsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(commentsModelImpl.ENTITY_CACHE_ENABLED,
			commentsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ID = new FinderPath(commentsModelImpl.ENTITY_CACHE_ENABLED,
			commentsModelImpl.FINDER_CACHE_ENABLED, commentsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ID = new FinderPath(commentsModelImpl.ENTITY_CACHE_ENABLED,
			commentsModelImpl.FINDER_CACHE_ENABLED, commentsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByid",
			new String[] { String.class.getName() },
			commentsModelImpl.NOME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ID = new FinderPath(commentsModelImpl.ENTITY_CACHE_ENABLED,
			commentsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the commentses where nome = &#63;.
	 *
	 * @param nome the nome
	 * @return the matching commentses
	 */
	@Override
	public List<comments> findByid(String nome) {
		return findByid(nome, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<comments> findByid(String nome, int start, int end) {
		return findByid(nome, start, end, null);
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
	@Override
	public List<comments> findByid(String nome, int start, int end,
		OrderByComparator<comments> orderByComparator) {
		return findByid(nome, start, end, orderByComparator, true);
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
	@Override
	public List<comments> findByid(String nome, int start, int end,
		OrderByComparator<comments> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ID;
			finderArgs = new Object[] { nome };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ID;
			finderArgs = new Object[] { nome, start, end, orderByComparator };
		}

		List<comments> list = null;

		if (retrieveFromCache) {
			list = (List<comments>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (comments comments : list) {
					if (!Objects.equals(nome, comments.getNome())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_COMMENTS_WHERE);

			boolean bindNome = false;

			if (nome == null) {
				query.append(_FINDER_COLUMN_ID_NOME_1);
			}
			else if (nome.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ID_NOME_3);
			}
			else {
				bindNome = true;

				query.append(_FINDER_COLUMN_ID_NOME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(commentsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindNome) {
					qPos.add(nome);
				}

				if (!pagination) {
					list = (List<comments>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<comments>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first comments in the ordered set where nome = &#63;.
	 *
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comments
	 * @throws NoSuchcommentsException if a matching comments could not be found
	 */
	@Override
	public comments findByid_First(String nome,
		OrderByComparator<comments> orderByComparator)
		throws NoSuchcommentsException {
		comments comments = fetchByid_First(nome, orderByComparator);

		if (comments != null) {
			return comments;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("nome=");
		msg.append(nome);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchcommentsException(msg.toString());
	}

	/**
	 * Returns the first comments in the ordered set where nome = &#63;.
	 *
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comments, or <code>null</code> if a matching comments could not be found
	 */
	@Override
	public comments fetchByid_First(String nome,
		OrderByComparator<comments> orderByComparator) {
		List<comments> list = findByid(nome, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last comments in the ordered set where nome = &#63;.
	 *
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comments
	 * @throws NoSuchcommentsException if a matching comments could not be found
	 */
	@Override
	public comments findByid_Last(String nome,
		OrderByComparator<comments> orderByComparator)
		throws NoSuchcommentsException {
		comments comments = fetchByid_Last(nome, orderByComparator);

		if (comments != null) {
			return comments;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("nome=");
		msg.append(nome);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchcommentsException(msg.toString());
	}

	/**
	 * Returns the last comments in the ordered set where nome = &#63;.
	 *
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comments, or <code>null</code> if a matching comments could not be found
	 */
	@Override
	public comments fetchByid_Last(String nome,
		OrderByComparator<comments> orderByComparator) {
		int count = countByid(nome);

		if (count == 0) {
			return null;
		}

		List<comments> list = findByid(nome, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public comments[] findByid_PrevAndNext(long id, String nome,
		OrderByComparator<comments> orderByComparator)
		throws NoSuchcommentsException {
		comments comments = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			comments[] array = new commentsImpl[3];

			array[0] = getByid_PrevAndNext(session, comments, nome,
					orderByComparator, true);

			array[1] = comments;

			array[2] = getByid_PrevAndNext(session, comments, nome,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected comments getByid_PrevAndNext(Session session, comments comments,
		String nome, OrderByComparator<comments> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COMMENTS_WHERE);

		boolean bindNome = false;

		if (nome == null) {
			query.append(_FINDER_COLUMN_ID_NOME_1);
		}
		else if (nome.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_ID_NOME_3);
		}
		else {
			bindNome = true;

			query.append(_FINDER_COLUMN_ID_NOME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(commentsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindNome) {
			qPos.add(nome);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(comments);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<comments> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the commentses where nome = &#63; from the database.
	 *
	 * @param nome the nome
	 */
	@Override
	public void removeByid(String nome) {
		for (comments comments : findByid(nome, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(comments);
		}
	}

	/**
	 * Returns the number of commentses where nome = &#63;.
	 *
	 * @param nome the nome
	 * @return the number of matching commentses
	 */
	@Override
	public int countByid(String nome) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ID;

		Object[] finderArgs = new Object[] { nome };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COMMENTS_WHERE);

			boolean bindNome = false;

			if (nome == null) {
				query.append(_FINDER_COLUMN_ID_NOME_1);
			}
			else if (nome.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ID_NOME_3);
			}
			else {
				bindNome = true;

				query.append(_FINDER_COLUMN_ID_NOME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindNome) {
					qPos.add(nome);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ID_NOME_1 = "comments.nome IS NULL";
	private static final String _FINDER_COLUMN_ID_NOME_2 = "comments.nome = ?";
	private static final String _FINDER_COLUMN_ID_NOME_3 = "(comments.nome IS NULL OR comments.nome = '')";

	public commentsPersistenceImpl() {
		setModelClass(comments.class);

		try {
			Field field = ReflectionUtil.getDeclaredField(BasePersistenceImpl.class,
					"_dbColumnNames");

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("id", "id_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the comments in the entity cache if it is enabled.
	 *
	 * @param comments the comments
	 */
	@Override
	public void cacheResult(comments comments) {
		entityCache.putResult(commentsModelImpl.ENTITY_CACHE_ENABLED,
			commentsImpl.class, comments.getPrimaryKey(), comments);

		comments.resetOriginalValues();
	}

	/**
	 * Caches the commentses in the entity cache if it is enabled.
	 *
	 * @param commentses the commentses
	 */
	@Override
	public void cacheResult(List<comments> commentses) {
		for (comments comments : commentses) {
			if (entityCache.getResult(commentsModelImpl.ENTITY_CACHE_ENABLED,
						commentsImpl.class, comments.getPrimaryKey()) == null) {
				cacheResult(comments);
			}
			else {
				comments.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all commentses.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(commentsImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the comments.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(comments comments) {
		entityCache.removeResult(commentsModelImpl.ENTITY_CACHE_ENABLED,
			commentsImpl.class, comments.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<comments> commentses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (comments comments : commentses) {
			entityCache.removeResult(commentsModelImpl.ENTITY_CACHE_ENABLED,
				commentsImpl.class, comments.getPrimaryKey());
		}
	}

	/**
	 * Creates a new comments with the primary key. Does not add the comments to the database.
	 *
	 * @param id the primary key for the new comments
	 * @return the new comments
	 */
	@Override
	public comments create(long id) {
		comments comments = new commentsImpl();

		comments.setNew(true);
		comments.setPrimaryKey(id);

		return comments;
	}

	/**
	 * Removes the comments with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the comments
	 * @return the comments that was removed
	 * @throws NoSuchcommentsException if a comments with the primary key could not be found
	 */
	@Override
	public comments remove(long id) throws NoSuchcommentsException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the comments with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the comments
	 * @return the comments that was removed
	 * @throws NoSuchcommentsException if a comments with the primary key could not be found
	 */
	@Override
	public comments remove(Serializable primaryKey)
		throws NoSuchcommentsException {
		Session session = null;

		try {
			session = openSession();

			comments comments = (comments)session.get(commentsImpl.class,
					primaryKey);

			if (comments == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchcommentsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(comments);
		}
		catch (NoSuchcommentsException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected comments removeImpl(comments comments) {
		comments = toUnwrappedModel(comments);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(comments)) {
				comments = (comments)session.get(commentsImpl.class,
						comments.getPrimaryKeyObj());
			}

			if (comments != null) {
				session.delete(comments);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (comments != null) {
			clearCache(comments);
		}

		return comments;
	}

	@Override
	public comments updateImpl(comments comments) {
		comments = toUnwrappedModel(comments);

		boolean isNew = comments.isNew();

		commentsModelImpl commentsModelImpl = (commentsModelImpl)comments;

		Session session = null;

		try {
			session = openSession();

			if (comments.isNew()) {
				session.save(comments);

				comments.setNew(false);
			}
			else {
				comments = (comments)session.merge(comments);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!commentsModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { commentsModelImpl.getNome() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_ID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((commentsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { commentsModelImpl.getOriginalNome() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ID,
					args);

				args = new Object[] { commentsModelImpl.getNome() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ID,
					args);
			}
		}

		entityCache.putResult(commentsModelImpl.ENTITY_CACHE_ENABLED,
			commentsImpl.class, comments.getPrimaryKey(), comments, false);

		comments.resetOriginalValues();

		return comments;
	}

	protected comments toUnwrappedModel(comments comments) {
		if (comments instanceof commentsImpl) {
			return comments;
		}

		commentsImpl commentsImpl = new commentsImpl();

		commentsImpl.setNew(comments.isNew());
		commentsImpl.setPrimaryKey(comments.getPrimaryKey());

		commentsImpl.setId(comments.getId());
		commentsImpl.setNome(comments.getNome());
		commentsImpl.setEmail(comments.getEmail());
		commentsImpl.setMensagem(comments.getMensagem());
		commentsImpl.setStatus(comments.isStatus());

		return commentsImpl;
	}

	/**
	 * Returns the comments with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the comments
	 * @return the comments
	 * @throws NoSuchcommentsException if a comments with the primary key could not be found
	 */
	@Override
	public comments findByPrimaryKey(Serializable primaryKey)
		throws NoSuchcommentsException {
		comments comments = fetchByPrimaryKey(primaryKey);

		if (comments == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchcommentsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return comments;
	}

	/**
	 * Returns the comments with the primary key or throws a {@link NoSuchcommentsException} if it could not be found.
	 *
	 * @param id the primary key of the comments
	 * @return the comments
	 * @throws NoSuchcommentsException if a comments with the primary key could not be found
	 */
	@Override
	public comments findByPrimaryKey(long id) throws NoSuchcommentsException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the comments with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the comments
	 * @return the comments, or <code>null</code> if a comments with the primary key could not be found
	 */
	@Override
	public comments fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(commentsModelImpl.ENTITY_CACHE_ENABLED,
				commentsImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		comments comments = (comments)serializable;

		if (comments == null) {
			Session session = null;

			try {
				session = openSession();

				comments = (comments)session.get(commentsImpl.class, primaryKey);

				if (comments != null) {
					cacheResult(comments);
				}
				else {
					entityCache.putResult(commentsModelImpl.ENTITY_CACHE_ENABLED,
						commentsImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(commentsModelImpl.ENTITY_CACHE_ENABLED,
					commentsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return comments;
	}

	/**
	 * Returns the comments with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the comments
	 * @return the comments, or <code>null</code> if a comments with the primary key could not be found
	 */
	@Override
	public comments fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, comments> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, comments> map = new HashMap<Serializable, comments>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			comments comments = fetchByPrimaryKey(primaryKey);

			if (comments != null) {
				map.put(primaryKey, comments);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(commentsModelImpl.ENTITY_CACHE_ENABLED,
					commentsImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (comments)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_COMMENTS_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (comments comments : (List<comments>)q.list()) {
				map.put(comments.getPrimaryKeyObj(), comments);

				cacheResult(comments);

				uncachedPrimaryKeys.remove(comments.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(commentsModelImpl.ENTITY_CACHE_ENABLED,
					commentsImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the commentses.
	 *
	 * @return the commentses
	 */
	@Override
	public List<comments> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<comments> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<comments> findAll(int start, int end,
		OrderByComparator<comments> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<comments> findAll(int start, int end,
		OrderByComparator<comments> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<comments> list = null;

		if (retrieveFromCache) {
			list = (List<comments>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_COMMENTS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COMMENTS;

				if (pagination) {
					sql = sql.concat(commentsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<comments>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<comments>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the commentses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (comments comments : findAll()) {
			remove(comments);
		}
	}

	/**
	 * Returns the number of commentses.
	 *
	 * @return the number of commentses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_COMMENTS);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return commentsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the comments persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(commentsImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_COMMENTS = "SELECT comments FROM comments comments";
	private static final String _SQL_SELECT_COMMENTS_WHERE_PKS_IN = "SELECT comments FROM comments comments WHERE id_ IN (";
	private static final String _SQL_SELECT_COMMENTS_WHERE = "SELECT comments FROM comments comments WHERE ";
	private static final String _SQL_COUNT_COMMENTS = "SELECT COUNT(comments) FROM comments comments";
	private static final String _SQL_COUNT_COMMENTS_WHERE = "SELECT COUNT(comments) FROM comments comments WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "comments.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No comments exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No comments exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(commentsPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
}