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

package AMA.OpenGov.LocalDataSaveEmail.service.persistence.impl;

import AMA.OpenGov.LocalDataSaveEmail.exception.NoSuchogp_commentsException;
import AMA.OpenGov.LocalDataSaveEmail.model.impl.ogp_commentsImpl;
import AMA.OpenGov.LocalDataSaveEmail.model.impl.ogp_commentsModelImpl;
import AMA.OpenGov.LocalDataSaveEmail.model.ogp_comments;
import AMA.OpenGov.LocalDataSaveEmail.service.persistence.ogp_commentsPersistence;

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
 * The persistence implementation for the ogp_comments service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ogp_commentsPersistence
 * @see AMA.OpenGov.LocalDataSaveEmail.service.persistence.ogp_commentsUtil
 * @generated
 */
@ProviderType
public class ogp_commentsPersistenceImpl extends BasePersistenceImpl<ogp_comments>
	implements ogp_commentsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ogp_commentsUtil} to access the ogp_comments persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ogp_commentsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ogp_commentsModelImpl.ENTITY_CACHE_ENABLED,
			ogp_commentsModelImpl.FINDER_CACHE_ENABLED, ogp_commentsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ogp_commentsModelImpl.ENTITY_CACHE_ENABLED,
			ogp_commentsModelImpl.FINDER_CACHE_ENABLED, ogp_commentsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ogp_commentsModelImpl.ENTITY_CACHE_ENABLED,
			ogp_commentsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ID = new FinderPath(ogp_commentsModelImpl.ENTITY_CACHE_ENABLED,
			ogp_commentsModelImpl.FINDER_CACHE_ENABLED, ogp_commentsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ID = new FinderPath(ogp_commentsModelImpl.ENTITY_CACHE_ENABLED,
			ogp_commentsModelImpl.FINDER_CACHE_ENABLED, ogp_commentsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByid",
			new String[] { String.class.getName() },
			ogp_commentsModelImpl.NOME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ID = new FinderPath(ogp_commentsModelImpl.ENTITY_CACHE_ENABLED,
			ogp_commentsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the ogp_commentses where nome = &#63;.
	 *
	 * @param nome the nome
	 * @return the matching ogp_commentses
	 */
	@Override
	public List<ogp_comments> findByid(String nome) {
		return findByid(nome, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ogp_comments> findByid(String nome, int start, int end) {
		return findByid(nome, start, end, null);
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
	@Override
	public List<ogp_comments> findByid(String nome, int start, int end,
		OrderByComparator<ogp_comments> orderByComparator) {
		return findByid(nome, start, end, orderByComparator, true);
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
	@Override
	public List<ogp_comments> findByid(String nome, int start, int end,
		OrderByComparator<ogp_comments> orderByComparator,
		boolean retrieveFromCache) {
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

		List<ogp_comments> list = null;

		if (retrieveFromCache) {
			list = (List<ogp_comments>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ogp_comments ogp_comments : list) {
					if (!Objects.equals(nome, ogp_comments.getNome())) {
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

			query.append(_SQL_SELECT_OGP_COMMENTS_WHERE);

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
				query.append(ogp_commentsModelImpl.ORDER_BY_JPQL);
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
					list = (List<ogp_comments>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ogp_comments>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first ogp_comments in the ordered set where nome = &#63;.
	 *
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ogp_comments
	 * @throws NoSuchogp_commentsException if a matching ogp_comments could not be found
	 */
	@Override
	public ogp_comments findByid_First(String nome,
		OrderByComparator<ogp_comments> orderByComparator)
		throws NoSuchogp_commentsException {
		ogp_comments ogp_comments = fetchByid_First(nome, orderByComparator);

		if (ogp_comments != null) {
			return ogp_comments;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("nome=");
		msg.append(nome);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchogp_commentsException(msg.toString());
	}

	/**
	 * Returns the first ogp_comments in the ordered set where nome = &#63;.
	 *
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ogp_comments, or <code>null</code> if a matching ogp_comments could not be found
	 */
	@Override
	public ogp_comments fetchByid_First(String nome,
		OrderByComparator<ogp_comments> orderByComparator) {
		List<ogp_comments> list = findByid(nome, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ogp_comments in the ordered set where nome = &#63;.
	 *
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ogp_comments
	 * @throws NoSuchogp_commentsException if a matching ogp_comments could not be found
	 */
	@Override
	public ogp_comments findByid_Last(String nome,
		OrderByComparator<ogp_comments> orderByComparator)
		throws NoSuchogp_commentsException {
		ogp_comments ogp_comments = fetchByid_Last(nome, orderByComparator);

		if (ogp_comments != null) {
			return ogp_comments;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("nome=");
		msg.append(nome);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchogp_commentsException(msg.toString());
	}

	/**
	 * Returns the last ogp_comments in the ordered set where nome = &#63;.
	 *
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ogp_comments, or <code>null</code> if a matching ogp_comments could not be found
	 */
	@Override
	public ogp_comments fetchByid_Last(String nome,
		OrderByComparator<ogp_comments> orderByComparator) {
		int count = countByid(nome);

		if (count == 0) {
			return null;
		}

		List<ogp_comments> list = findByid(nome, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ogp_comments[] findByid_PrevAndNext(long id, String nome,
		OrderByComparator<ogp_comments> orderByComparator)
		throws NoSuchogp_commentsException {
		ogp_comments ogp_comments = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ogp_comments[] array = new ogp_commentsImpl[3];

			array[0] = getByid_PrevAndNext(session, ogp_comments, nome,
					orderByComparator, true);

			array[1] = ogp_comments;

			array[2] = getByid_PrevAndNext(session, ogp_comments, nome,
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

	protected ogp_comments getByid_PrevAndNext(Session session,
		ogp_comments ogp_comments, String nome,
		OrderByComparator<ogp_comments> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_OGP_COMMENTS_WHERE);

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
			query.append(ogp_commentsModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(ogp_comments);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ogp_comments> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ogp_commentses where nome = &#63; from the database.
	 *
	 * @param nome the nome
	 */
	@Override
	public void removeByid(String nome) {
		for (ogp_comments ogp_comments : findByid(nome, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(ogp_comments);
		}
	}

	/**
	 * Returns the number of ogp_commentses where nome = &#63;.
	 *
	 * @param nome the nome
	 * @return the number of matching ogp_commentses
	 */
	@Override
	public int countByid(String nome) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ID;

		Object[] finderArgs = new Object[] { nome };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_OGP_COMMENTS_WHERE);

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

	private static final String _FINDER_COLUMN_ID_NOME_1 = "ogp_comments.nome IS NULL";
	private static final String _FINDER_COLUMN_ID_NOME_2 = "ogp_comments.nome = ?";
	private static final String _FINDER_COLUMN_ID_NOME_3 = "(ogp_comments.nome IS NULL OR ogp_comments.nome = '')";

	public ogp_commentsPersistenceImpl() {
		setModelClass(ogp_comments.class);

		try {
			Field field = ReflectionUtil.getDeclaredField(BasePersistenceImpl.class,
					"_dbColumnNames");

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("id", "id_");
			dbColumnNames.put("date", "date_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the ogp_comments in the entity cache if it is enabled.
	 *
	 * @param ogp_comments the ogp_comments
	 */
	@Override
	public void cacheResult(ogp_comments ogp_comments) {
		entityCache.putResult(ogp_commentsModelImpl.ENTITY_CACHE_ENABLED,
			ogp_commentsImpl.class, ogp_comments.getPrimaryKey(), ogp_comments);

		ogp_comments.resetOriginalValues();
	}

	/**
	 * Caches the ogp_commentses in the entity cache if it is enabled.
	 *
	 * @param ogp_commentses the ogp_commentses
	 */
	@Override
	public void cacheResult(List<ogp_comments> ogp_commentses) {
		for (ogp_comments ogp_comments : ogp_commentses) {
			if (entityCache.getResult(
						ogp_commentsModelImpl.ENTITY_CACHE_ENABLED,
						ogp_commentsImpl.class, ogp_comments.getPrimaryKey()) == null) {
				cacheResult(ogp_comments);
			}
			else {
				ogp_comments.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all ogp_commentses.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ogp_commentsImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the ogp_comments.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ogp_comments ogp_comments) {
		entityCache.removeResult(ogp_commentsModelImpl.ENTITY_CACHE_ENABLED,
			ogp_commentsImpl.class, ogp_comments.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ogp_comments> ogp_commentses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ogp_comments ogp_comments : ogp_commentses) {
			entityCache.removeResult(ogp_commentsModelImpl.ENTITY_CACHE_ENABLED,
				ogp_commentsImpl.class, ogp_comments.getPrimaryKey());
		}
	}

	/**
	 * Creates a new ogp_comments with the primary key. Does not add the ogp_comments to the database.
	 *
	 * @param id the primary key for the new ogp_comments
	 * @return the new ogp_comments
	 */
	@Override
	public ogp_comments create(long id) {
		ogp_comments ogp_comments = new ogp_commentsImpl();

		ogp_comments.setNew(true);
		ogp_comments.setPrimaryKey(id);

		return ogp_comments;
	}

	/**
	 * Removes the ogp_comments with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the ogp_comments
	 * @return the ogp_comments that was removed
	 * @throws NoSuchogp_commentsException if a ogp_comments with the primary key could not be found
	 */
	@Override
	public ogp_comments remove(long id) throws NoSuchogp_commentsException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the ogp_comments with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ogp_comments
	 * @return the ogp_comments that was removed
	 * @throws NoSuchogp_commentsException if a ogp_comments with the primary key could not be found
	 */
	@Override
	public ogp_comments remove(Serializable primaryKey)
		throws NoSuchogp_commentsException {
		Session session = null;

		try {
			session = openSession();

			ogp_comments ogp_comments = (ogp_comments)session.get(ogp_commentsImpl.class,
					primaryKey);

			if (ogp_comments == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchogp_commentsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(ogp_comments);
		}
		catch (NoSuchogp_commentsException nsee) {
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
	protected ogp_comments removeImpl(ogp_comments ogp_comments) {
		ogp_comments = toUnwrappedModel(ogp_comments);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(ogp_comments)) {
				ogp_comments = (ogp_comments)session.get(ogp_commentsImpl.class,
						ogp_comments.getPrimaryKeyObj());
			}

			if (ogp_comments != null) {
				session.delete(ogp_comments);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (ogp_comments != null) {
			clearCache(ogp_comments);
		}

		return ogp_comments;
	}

	@Override
	public ogp_comments updateImpl(ogp_comments ogp_comments) {
		ogp_comments = toUnwrappedModel(ogp_comments);

		boolean isNew = ogp_comments.isNew();

		ogp_commentsModelImpl ogp_commentsModelImpl = (ogp_commentsModelImpl)ogp_comments;

		Session session = null;

		try {
			session = openSession();

			if (ogp_comments.isNew()) {
				session.save(ogp_comments);

				ogp_comments.setNew(false);
			}
			else {
				ogp_comments = (ogp_comments)session.merge(ogp_comments);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!ogp_commentsModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { ogp_commentsModelImpl.getNome() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_ID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((ogp_commentsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ogp_commentsModelImpl.getOriginalNome()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ID,
					args);

				args = new Object[] { ogp_commentsModelImpl.getNome() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ID,
					args);
			}
		}

		entityCache.putResult(ogp_commentsModelImpl.ENTITY_CACHE_ENABLED,
			ogp_commentsImpl.class, ogp_comments.getPrimaryKey(), ogp_comments,
			false);

		ogp_comments.resetOriginalValues();

		return ogp_comments;
	}

	protected ogp_comments toUnwrappedModel(ogp_comments ogp_comments) {
		if (ogp_comments instanceof ogp_commentsImpl) {
			return ogp_comments;
		}

		ogp_commentsImpl ogp_commentsImpl = new ogp_commentsImpl();

		ogp_commentsImpl.setNew(ogp_comments.isNew());
		ogp_commentsImpl.setPrimaryKey(ogp_comments.getPrimaryKey());

		ogp_commentsImpl.setId(ogp_comments.getId());
		ogp_commentsImpl.setNome(ogp_comments.getNome());
		ogp_commentsImpl.setEmail(ogp_comments.getEmail());
		ogp_commentsImpl.setMensagem(ogp_comments.getMensagem());
		ogp_commentsImpl.setStatus(ogp_comments.isStatus());
		ogp_commentsImpl.setDate(ogp_comments.getDate());

		return ogp_commentsImpl;
	}

	/**
	 * Returns the ogp_comments with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the ogp_comments
	 * @return the ogp_comments
	 * @throws NoSuchogp_commentsException if a ogp_comments with the primary key could not be found
	 */
	@Override
	public ogp_comments findByPrimaryKey(Serializable primaryKey)
		throws NoSuchogp_commentsException {
		ogp_comments ogp_comments = fetchByPrimaryKey(primaryKey);

		if (ogp_comments == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchogp_commentsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return ogp_comments;
	}

	/**
	 * Returns the ogp_comments with the primary key or throws a {@link NoSuchogp_commentsException} if it could not be found.
	 *
	 * @param id the primary key of the ogp_comments
	 * @return the ogp_comments
	 * @throws NoSuchogp_commentsException if a ogp_comments with the primary key could not be found
	 */
	@Override
	public ogp_comments findByPrimaryKey(long id)
		throws NoSuchogp_commentsException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the ogp_comments with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ogp_comments
	 * @return the ogp_comments, or <code>null</code> if a ogp_comments with the primary key could not be found
	 */
	@Override
	public ogp_comments fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(ogp_commentsModelImpl.ENTITY_CACHE_ENABLED,
				ogp_commentsImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		ogp_comments ogp_comments = (ogp_comments)serializable;

		if (ogp_comments == null) {
			Session session = null;

			try {
				session = openSession();

				ogp_comments = (ogp_comments)session.get(ogp_commentsImpl.class,
						primaryKey);

				if (ogp_comments != null) {
					cacheResult(ogp_comments);
				}
				else {
					entityCache.putResult(ogp_commentsModelImpl.ENTITY_CACHE_ENABLED,
						ogp_commentsImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ogp_commentsModelImpl.ENTITY_CACHE_ENABLED,
					ogp_commentsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return ogp_comments;
	}

	/**
	 * Returns the ogp_comments with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the ogp_comments
	 * @return the ogp_comments, or <code>null</code> if a ogp_comments with the primary key could not be found
	 */
	@Override
	public ogp_comments fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, ogp_comments> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, ogp_comments> map = new HashMap<Serializable, ogp_comments>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			ogp_comments ogp_comments = fetchByPrimaryKey(primaryKey);

			if (ogp_comments != null) {
				map.put(primaryKey, ogp_comments);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(ogp_commentsModelImpl.ENTITY_CACHE_ENABLED,
					ogp_commentsImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (ogp_comments)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_OGP_COMMENTS_WHERE_PKS_IN);

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

			for (ogp_comments ogp_comments : (List<ogp_comments>)q.list()) {
				map.put(ogp_comments.getPrimaryKeyObj(), ogp_comments);

				cacheResult(ogp_comments);

				uncachedPrimaryKeys.remove(ogp_comments.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(ogp_commentsModelImpl.ENTITY_CACHE_ENABLED,
					ogp_commentsImpl.class, primaryKey, nullModel);
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
	 * Returns all the ogp_commentses.
	 *
	 * @return the ogp_commentses
	 */
	@Override
	public List<ogp_comments> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ogp_comments> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<ogp_comments> findAll(int start, int end,
		OrderByComparator<ogp_comments> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<ogp_comments> findAll(int start, int end,
		OrderByComparator<ogp_comments> orderByComparator,
		boolean retrieveFromCache) {
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

		List<ogp_comments> list = null;

		if (retrieveFromCache) {
			list = (List<ogp_comments>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_OGP_COMMENTS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_OGP_COMMENTS;

				if (pagination) {
					sql = sql.concat(ogp_commentsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ogp_comments>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ogp_comments>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the ogp_commentses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ogp_comments ogp_comments : findAll()) {
			remove(ogp_comments);
		}
	}

	/**
	 * Returns the number of ogp_commentses.
	 *
	 * @return the number of ogp_commentses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_OGP_COMMENTS);

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
		return ogp_commentsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the ogp_comments persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(ogp_commentsImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_OGP_COMMENTS = "SELECT ogp_comments FROM ogp_comments ogp_comments";
	private static final String _SQL_SELECT_OGP_COMMENTS_WHERE_PKS_IN = "SELECT ogp_comments FROM ogp_comments ogp_comments WHERE id_ IN (";
	private static final String _SQL_SELECT_OGP_COMMENTS_WHERE = "SELECT ogp_comments FROM ogp_comments ogp_comments WHERE ";
	private static final String _SQL_COUNT_OGP_COMMENTS = "SELECT COUNT(ogp_comments) FROM ogp_comments ogp_comments";
	private static final String _SQL_COUNT_OGP_COMMENTS_WHERE = "SELECT COUNT(ogp_comments) FROM ogp_comments ogp_comments WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "ogp_comments.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ogp_comments exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ogp_comments exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(ogp_commentsPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id", "date"
			});
}