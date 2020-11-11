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

package ama.opengov.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import ama.opengov.exception.NoSuchemailContactException;

import ama.opengov.model.emailContact;
import ama.opengov.model.impl.emailContactImpl;
import ama.opengov.model.impl.emailContactModelImpl;

import ama.opengov.service.persistence.emailContactPersistence;

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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
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
 * The persistence implementation for the email contact service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see emailContactPersistence
 * @see ama.opengov.service.persistence.emailContactUtil
 * @generated
 */
@ProviderType
public class emailContactPersistenceImpl extends BasePersistenceImpl<emailContact>
	implements emailContactPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link emailContactUtil} to access the email contact persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = emailContactImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(emailContactModelImpl.ENTITY_CACHE_ENABLED,
			emailContactModelImpl.FINDER_CACHE_ENABLED, emailContactImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(emailContactModelImpl.ENTITY_CACHE_ENABLED,
			emailContactModelImpl.FINDER_CACHE_ENABLED, emailContactImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(emailContactModelImpl.ENTITY_CACHE_ENABLED,
			emailContactModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(emailContactModelImpl.ENTITY_CACHE_ENABLED,
			emailContactModelImpl.FINDER_CACHE_ENABLED, emailContactImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(emailContactModelImpl.ENTITY_CACHE_ENABLED,
			emailContactModelImpl.FINDER_CACHE_ENABLED, emailContactImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			emailContactModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(emailContactModelImpl.ENTITY_CACHE_ENABLED,
			emailContactModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the email contacts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching email contacts
	 */
	@Override
	public List<emailContact> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<emailContact> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<emailContact> findByUuid(String uuid, int start, int end,
		OrderByComparator<emailContact> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<emailContact> findByUuid(String uuid, int start, int end,
		OrderByComparator<emailContact> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<emailContact> list = null;

		if (retrieveFromCache) {
			list = (List<emailContact>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (emailContact emailContact : list) {
					if (!Objects.equals(uuid, emailContact.getUuid())) {
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

			query.append(_SQL_SELECT_EMAILCONTACT_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(emailContactModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<emailContact>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<emailContact>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first email contact in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email contact
	 * @throws NoSuchemailContactException if a matching email contact could not be found
	 */
	@Override
	public emailContact findByUuid_First(String uuid,
		OrderByComparator<emailContact> orderByComparator)
		throws NoSuchemailContactException {
		emailContact emailContact = fetchByUuid_First(uuid, orderByComparator);

		if (emailContact != null) {
			return emailContact;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchemailContactException(msg.toString());
	}

	/**
	 * Returns the first email contact in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email contact, or <code>null</code> if a matching email contact could not be found
	 */
	@Override
	public emailContact fetchByUuid_First(String uuid,
		OrderByComparator<emailContact> orderByComparator) {
		List<emailContact> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last email contact in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email contact
	 * @throws NoSuchemailContactException if a matching email contact could not be found
	 */
	@Override
	public emailContact findByUuid_Last(String uuid,
		OrderByComparator<emailContact> orderByComparator)
		throws NoSuchemailContactException {
		emailContact emailContact = fetchByUuid_Last(uuid, orderByComparator);

		if (emailContact != null) {
			return emailContact;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchemailContactException(msg.toString());
	}

	/**
	 * Returns the last email contact in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email contact, or <code>null</code> if a matching email contact could not be found
	 */
	@Override
	public emailContact fetchByUuid_Last(String uuid,
		OrderByComparator<emailContact> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<emailContact> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public emailContact[] findByUuid_PrevAndNext(long id, String uuid,
		OrderByComparator<emailContact> orderByComparator)
		throws NoSuchemailContactException {
		emailContact emailContact = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			emailContact[] array = new emailContactImpl[3];

			array[0] = getByUuid_PrevAndNext(session, emailContact, uuid,
					orderByComparator, true);

			array[1] = emailContact;

			array[2] = getByUuid_PrevAndNext(session, emailContact, uuid,
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

	protected emailContact getByUuid_PrevAndNext(Session session,
		emailContact emailContact, String uuid,
		OrderByComparator<emailContact> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EMAILCONTACT_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
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
			query.append(emailContactModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(emailContact);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<emailContact> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the email contacts where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (emailContact emailContact : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(emailContact);
		}
	}

	/**
	 * Returns the number of email contacts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching email contacts
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EMAILCONTACT_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "emailContact.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "emailContact.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(emailContact.uuid IS NULL OR emailContact.uuid = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ID = new FinderPath(emailContactModelImpl.ENTITY_CACHE_ENABLED,
			emailContactModelImpl.FINDER_CACHE_ENABLED, emailContactImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ID = new FinderPath(emailContactModelImpl.ENTITY_CACHE_ENABLED,
			emailContactModelImpl.FINDER_CACHE_ENABLED, emailContactImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByid",
			new String[] { String.class.getName() },
			emailContactModelImpl.NOME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ID = new FinderPath(emailContactModelImpl.ENTITY_CACHE_ENABLED,
			emailContactModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the email contacts where nome = &#63;.
	 *
	 * @param nome the nome
	 * @return the matching email contacts
	 */
	@Override
	public List<emailContact> findByid(String nome) {
		return findByid(nome, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<emailContact> findByid(String nome, int start, int end) {
		return findByid(nome, start, end, null);
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
	@Override
	public List<emailContact> findByid(String nome, int start, int end,
		OrderByComparator<emailContact> orderByComparator) {
		return findByid(nome, start, end, orderByComparator, true);
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
	@Override
	public List<emailContact> findByid(String nome, int start, int end,
		OrderByComparator<emailContact> orderByComparator,
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

		List<emailContact> list = null;

		if (retrieveFromCache) {
			list = (List<emailContact>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (emailContact emailContact : list) {
					if (!Objects.equals(nome, emailContact.getNome())) {
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

			query.append(_SQL_SELECT_EMAILCONTACT_WHERE);

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
				query.append(emailContactModelImpl.ORDER_BY_JPQL);
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
					list = (List<emailContact>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<emailContact>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first email contact in the ordered set where nome = &#63;.
	 *
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email contact
	 * @throws NoSuchemailContactException if a matching email contact could not be found
	 */
	@Override
	public emailContact findByid_First(String nome,
		OrderByComparator<emailContact> orderByComparator)
		throws NoSuchemailContactException {
		emailContact emailContact = fetchByid_First(nome, orderByComparator);

		if (emailContact != null) {
			return emailContact;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("nome=");
		msg.append(nome);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchemailContactException(msg.toString());
	}

	/**
	 * Returns the first email contact in the ordered set where nome = &#63;.
	 *
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email contact, or <code>null</code> if a matching email contact could not be found
	 */
	@Override
	public emailContact fetchByid_First(String nome,
		OrderByComparator<emailContact> orderByComparator) {
		List<emailContact> list = findByid(nome, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last email contact in the ordered set where nome = &#63;.
	 *
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email contact
	 * @throws NoSuchemailContactException if a matching email contact could not be found
	 */
	@Override
	public emailContact findByid_Last(String nome,
		OrderByComparator<emailContact> orderByComparator)
		throws NoSuchemailContactException {
		emailContact emailContact = fetchByid_Last(nome, orderByComparator);

		if (emailContact != null) {
			return emailContact;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("nome=");
		msg.append(nome);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchemailContactException(msg.toString());
	}

	/**
	 * Returns the last email contact in the ordered set where nome = &#63;.
	 *
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email contact, or <code>null</code> if a matching email contact could not be found
	 */
	@Override
	public emailContact fetchByid_Last(String nome,
		OrderByComparator<emailContact> orderByComparator) {
		int count = countByid(nome);

		if (count == 0) {
			return null;
		}

		List<emailContact> list = findByid(nome, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public emailContact[] findByid_PrevAndNext(long id, String nome,
		OrderByComparator<emailContact> orderByComparator)
		throws NoSuchemailContactException {
		emailContact emailContact = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			emailContact[] array = new emailContactImpl[3];

			array[0] = getByid_PrevAndNext(session, emailContact, nome,
					orderByComparator, true);

			array[1] = emailContact;

			array[2] = getByid_PrevAndNext(session, emailContact, nome,
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

	protected emailContact getByid_PrevAndNext(Session session,
		emailContact emailContact, String nome,
		OrderByComparator<emailContact> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EMAILCONTACT_WHERE);

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
			query.append(emailContactModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(emailContact);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<emailContact> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the email contacts where nome = &#63; from the database.
	 *
	 * @param nome the nome
	 */
	@Override
	public void removeByid(String nome) {
		for (emailContact emailContact : findByid(nome, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(emailContact);
		}
	}

	/**
	 * Returns the number of email contacts where nome = &#63;.
	 *
	 * @param nome the nome
	 * @return the number of matching email contacts
	 */
	@Override
	public int countByid(String nome) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ID;

		Object[] finderArgs = new Object[] { nome };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EMAILCONTACT_WHERE);

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

	private static final String _FINDER_COLUMN_ID_NOME_1 = "emailContact.nome IS NULL";
	private static final String _FINDER_COLUMN_ID_NOME_2 = "emailContact.nome = ?";
	private static final String _FINDER_COLUMN_ID_NOME_3 = "(emailContact.nome IS NULL OR emailContact.nome = '')";

	public emailContactPersistenceImpl() {
		setModelClass(emailContact.class);

		try {
			Field field = ReflectionUtil.getDeclaredField(BasePersistenceImpl.class,
					"_dbColumnNames");

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("uuid", "uuid_");
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
	 * Caches the email contact in the entity cache if it is enabled.
	 *
	 * @param emailContact the email contact
	 */
	@Override
	public void cacheResult(emailContact emailContact) {
		entityCache.putResult(emailContactModelImpl.ENTITY_CACHE_ENABLED,
			emailContactImpl.class, emailContact.getPrimaryKey(), emailContact);

		emailContact.resetOriginalValues();
	}

	/**
	 * Caches the email contacts in the entity cache if it is enabled.
	 *
	 * @param emailContacts the email contacts
	 */
	@Override
	public void cacheResult(List<emailContact> emailContacts) {
		for (emailContact emailContact : emailContacts) {
			if (entityCache.getResult(
						emailContactModelImpl.ENTITY_CACHE_ENABLED,
						emailContactImpl.class, emailContact.getPrimaryKey()) == null) {
				cacheResult(emailContact);
			}
			else {
				emailContact.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all email contacts.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(emailContactImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the email contact.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(emailContact emailContact) {
		entityCache.removeResult(emailContactModelImpl.ENTITY_CACHE_ENABLED,
			emailContactImpl.class, emailContact.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<emailContact> emailContacts) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (emailContact emailContact : emailContacts) {
			entityCache.removeResult(emailContactModelImpl.ENTITY_CACHE_ENABLED,
				emailContactImpl.class, emailContact.getPrimaryKey());
		}
	}

	/**
	 * Creates a new email contact with the primary key. Does not add the email contact to the database.
	 *
	 * @param id the primary key for the new email contact
	 * @return the new email contact
	 */
	@Override
	public emailContact create(long id) {
		emailContact emailContact = new emailContactImpl();

		emailContact.setNew(true);
		emailContact.setPrimaryKey(id);

		String uuid = PortalUUIDUtil.generate();

		emailContact.setUuid(uuid);

		return emailContact;
	}

	/**
	 * Removes the email contact with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the email contact
	 * @return the email contact that was removed
	 * @throws NoSuchemailContactException if a email contact with the primary key could not be found
	 */
	@Override
	public emailContact remove(long id) throws NoSuchemailContactException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the email contact with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the email contact
	 * @return the email contact that was removed
	 * @throws NoSuchemailContactException if a email contact with the primary key could not be found
	 */
	@Override
	public emailContact remove(Serializable primaryKey)
		throws NoSuchemailContactException {
		Session session = null;

		try {
			session = openSession();

			emailContact emailContact = (emailContact)session.get(emailContactImpl.class,
					primaryKey);

			if (emailContact == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchemailContactException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(emailContact);
		}
		catch (NoSuchemailContactException nsee) {
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
	protected emailContact removeImpl(emailContact emailContact) {
		emailContact = toUnwrappedModel(emailContact);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(emailContact)) {
				emailContact = (emailContact)session.get(emailContactImpl.class,
						emailContact.getPrimaryKeyObj());
			}

			if (emailContact != null) {
				session.delete(emailContact);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (emailContact != null) {
			clearCache(emailContact);
		}

		return emailContact;
	}

	@Override
	public emailContact updateImpl(emailContact emailContact) {
		emailContact = toUnwrappedModel(emailContact);

		boolean isNew = emailContact.isNew();

		emailContactModelImpl emailContactModelImpl = (emailContactModelImpl)emailContact;

		if (Validator.isNull(emailContact.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			emailContact.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (emailContact.isNew()) {
				session.save(emailContact);

				emailContact.setNew(false);
			}
			else {
				emailContact = (emailContact)session.merge(emailContact);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!emailContactModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { emailContactModelImpl.getUuid() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] { emailContactModelImpl.getNome() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_ID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((emailContactModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						emailContactModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { emailContactModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((emailContactModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						emailContactModelImpl.getOriginalNome()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ID,
					args);

				args = new Object[] { emailContactModelImpl.getNome() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ID,
					args);
			}
		}

		entityCache.putResult(emailContactModelImpl.ENTITY_CACHE_ENABLED,
			emailContactImpl.class, emailContact.getPrimaryKey(), emailContact,
			false);

		emailContact.resetOriginalValues();

		return emailContact;
	}

	protected emailContact toUnwrappedModel(emailContact emailContact) {
		if (emailContact instanceof emailContactImpl) {
			return emailContact;
		}

		emailContactImpl emailContactImpl = new emailContactImpl();

		emailContactImpl.setNew(emailContact.isNew());
		emailContactImpl.setPrimaryKey(emailContact.getPrimaryKey());

		emailContactImpl.setUuid(emailContact.getUuid());
		emailContactImpl.setId(emailContact.getId());
		emailContactImpl.setNome(emailContact.getNome());
		emailContactImpl.setEmail(emailContact.getEmail());
		emailContactImpl.setMensagem(emailContact.getMensagem());
		emailContactImpl.setStatus(emailContact.isStatus());

		return emailContactImpl;
	}

	/**
	 * Returns the email contact with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the email contact
	 * @return the email contact
	 * @throws NoSuchemailContactException if a email contact with the primary key could not be found
	 */
	@Override
	public emailContact findByPrimaryKey(Serializable primaryKey)
		throws NoSuchemailContactException {
		emailContact emailContact = fetchByPrimaryKey(primaryKey);

		if (emailContact == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchemailContactException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return emailContact;
	}

	/**
	 * Returns the email contact with the primary key or throws a {@link NoSuchemailContactException} if it could not be found.
	 *
	 * @param id the primary key of the email contact
	 * @return the email contact
	 * @throws NoSuchemailContactException if a email contact with the primary key could not be found
	 */
	@Override
	public emailContact findByPrimaryKey(long id)
		throws NoSuchemailContactException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the email contact with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the email contact
	 * @return the email contact, or <code>null</code> if a email contact with the primary key could not be found
	 */
	@Override
	public emailContact fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(emailContactModelImpl.ENTITY_CACHE_ENABLED,
				emailContactImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		emailContact emailContact = (emailContact)serializable;

		if (emailContact == null) {
			Session session = null;

			try {
				session = openSession();

				emailContact = (emailContact)session.get(emailContactImpl.class,
						primaryKey);

				if (emailContact != null) {
					cacheResult(emailContact);
				}
				else {
					entityCache.putResult(emailContactModelImpl.ENTITY_CACHE_ENABLED,
						emailContactImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(emailContactModelImpl.ENTITY_CACHE_ENABLED,
					emailContactImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return emailContact;
	}

	/**
	 * Returns the email contact with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the email contact
	 * @return the email contact, or <code>null</code> if a email contact with the primary key could not be found
	 */
	@Override
	public emailContact fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, emailContact> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, emailContact> map = new HashMap<Serializable, emailContact>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			emailContact emailContact = fetchByPrimaryKey(primaryKey);

			if (emailContact != null) {
				map.put(primaryKey, emailContact);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(emailContactModelImpl.ENTITY_CACHE_ENABLED,
					emailContactImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (emailContact)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_EMAILCONTACT_WHERE_PKS_IN);

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

			for (emailContact emailContact : (List<emailContact>)q.list()) {
				map.put(emailContact.getPrimaryKeyObj(), emailContact);

				cacheResult(emailContact);

				uncachedPrimaryKeys.remove(emailContact.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(emailContactModelImpl.ENTITY_CACHE_ENABLED,
					emailContactImpl.class, primaryKey, nullModel);
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
	 * Returns all the email contacts.
	 *
	 * @return the email contacts
	 */
	@Override
	public List<emailContact> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<emailContact> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<emailContact> findAll(int start, int end,
		OrderByComparator<emailContact> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<emailContact> findAll(int start, int end,
		OrderByComparator<emailContact> orderByComparator,
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

		List<emailContact> list = null;

		if (retrieveFromCache) {
			list = (List<emailContact>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_EMAILCONTACT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EMAILCONTACT;

				if (pagination) {
					sql = sql.concat(emailContactModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<emailContact>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<emailContact>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the email contacts from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (emailContact emailContact : findAll()) {
			remove(emailContact);
		}
	}

	/**
	 * Returns the number of email contacts.
	 *
	 * @return the number of email contacts
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_EMAILCONTACT);

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
		return emailContactModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the email contact persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(emailContactImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_EMAILCONTACT = "SELECT emailContact FROM emailContact emailContact";
	private static final String _SQL_SELECT_EMAILCONTACT_WHERE_PKS_IN = "SELECT emailContact FROM emailContact emailContact WHERE id_ IN (";
	private static final String _SQL_SELECT_EMAILCONTACT_WHERE = "SELECT emailContact FROM emailContact emailContact WHERE ";
	private static final String _SQL_COUNT_EMAILCONTACT = "SELECT COUNT(emailContact) FROM emailContact emailContact";
	private static final String _SQL_COUNT_EMAILCONTACT_WHERE = "SELECT COUNT(emailContact) FROM emailContact emailContact WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "emailContact.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No emailContact exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No emailContact exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(emailContactPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid", "id"
			});
}