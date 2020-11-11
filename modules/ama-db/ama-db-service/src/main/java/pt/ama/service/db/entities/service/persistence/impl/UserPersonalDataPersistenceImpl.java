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

package pt.ama.service.db.entities.service.persistence.impl;

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
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import pt.ama.service.db.entities.exception.NoSuchUserPersonalDataException;
import pt.ama.service.db.entities.model.UserPersonalData;
import pt.ama.service.db.entities.model.impl.UserPersonalDataImpl;
import pt.ama.service.db.entities.model.impl.UserPersonalDataModelImpl;
import pt.ama.service.db.entities.service.persistence.UserPersonalDataPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the user personal data service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserPersonalDataPersistence
 * @see pt.ama.service.db.entities.service.persistence.UserPersonalDataUtil
 * @generated
 */
@ProviderType
public class UserPersonalDataPersistenceImpl extends BasePersistenceImpl<UserPersonalData>
	implements UserPersonalDataPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link UserPersonalDataUtil} to access the user personal data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = UserPersonalDataImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UserPersonalDataModelImpl.ENTITY_CACHE_ENABLED,
			UserPersonalDataModelImpl.FINDER_CACHE_ENABLED,
			UserPersonalDataImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UserPersonalDataModelImpl.ENTITY_CACHE_ENABLED,
			UserPersonalDataModelImpl.FINDER_CACHE_ENABLED,
			UserPersonalDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UserPersonalDataModelImpl.ENTITY_CACHE_ENABLED,
			UserPersonalDataModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_IDENTIFICATIONID = new FinderPath(UserPersonalDataModelImpl.ENTITY_CACHE_ENABLED,
			UserPersonalDataModelImpl.FINDER_CACHE_ENABLED,
			UserPersonalDataImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByidentificationId", new String[] { String.class.getName() },
			UserPersonalDataModelImpl.IDENTIFICATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_IDENTIFICATIONID = new FinderPath(UserPersonalDataModelImpl.ENTITY_CACHE_ENABLED,
			UserPersonalDataModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByidentificationId", new String[] { String.class.getName() });

	/**
	 * Returns the user personal data where identificationId = &#63; or throws a {@link NoSuchUserPersonalDataException} if it could not be found.
	 *
	 * @param identificationId the identification ID
	 * @return the matching user personal data
	 * @throws NoSuchUserPersonalDataException if a matching user personal data could not be found
	 */
	@Override
	public UserPersonalData findByidentificationId(String identificationId)
		throws NoSuchUserPersonalDataException {
		UserPersonalData userPersonalData = fetchByidentificationId(identificationId);

		if (userPersonalData == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("identificationId=");
			msg.append(identificationId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchUserPersonalDataException(msg.toString());
		}

		return userPersonalData;
	}

	/**
	 * Returns the user personal data where identificationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param identificationId the identification ID
	 * @return the matching user personal data, or <code>null</code> if a matching user personal data could not be found
	 */
	@Override
	public UserPersonalData fetchByidentificationId(String identificationId) {
		return fetchByidentificationId(identificationId, true);
	}

	/**
	 * Returns the user personal data where identificationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param identificationId the identification ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching user personal data, or <code>null</code> if a matching user personal data could not be found
	 */
	@Override
	public UserPersonalData fetchByidentificationId(String identificationId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { identificationId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_IDENTIFICATIONID,
					finderArgs, this);
		}

		if (result instanceof UserPersonalData) {
			UserPersonalData userPersonalData = (UserPersonalData)result;

			if (!Objects.equals(identificationId,
						userPersonalData.getIdentificationId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_USERPERSONALDATA_WHERE);

			boolean bindIdentificationId = false;

			if (identificationId == null) {
				query.append(_FINDER_COLUMN_IDENTIFICATIONID_IDENTIFICATIONID_1);
			}
			else if (identificationId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_IDENTIFICATIONID_IDENTIFICATIONID_3);
			}
			else {
				bindIdentificationId = true;

				query.append(_FINDER_COLUMN_IDENTIFICATIONID_IDENTIFICATIONID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindIdentificationId) {
					qPos.add(identificationId);
				}

				List<UserPersonalData> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_IDENTIFICATIONID,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"UserPersonalDataPersistenceImpl.fetchByidentificationId(String, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					UserPersonalData userPersonalData = list.get(0);

					result = userPersonalData;

					cacheResult(userPersonalData);

					if ((userPersonalData.getIdentificationId() == null) ||
							!userPersonalData.getIdentificationId()
												 .equals(identificationId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_IDENTIFICATIONID,
							finderArgs, userPersonalData);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_IDENTIFICATIONID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (UserPersonalData)result;
		}
	}

	/**
	 * Removes the user personal data where identificationId = &#63; from the database.
	 *
	 * @param identificationId the identification ID
	 * @return the user personal data that was removed
	 */
	@Override
	public UserPersonalData removeByidentificationId(String identificationId)
		throws NoSuchUserPersonalDataException {
		UserPersonalData userPersonalData = findByidentificationId(identificationId);

		return remove(userPersonalData);
	}

	/**
	 * Returns the number of user personal datas where identificationId = &#63;.
	 *
	 * @param identificationId the identification ID
	 * @return the number of matching user personal datas
	 */
	@Override
	public int countByidentificationId(String identificationId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_IDENTIFICATIONID;

		Object[] finderArgs = new Object[] { identificationId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERPERSONALDATA_WHERE);

			boolean bindIdentificationId = false;

			if (identificationId == null) {
				query.append(_FINDER_COLUMN_IDENTIFICATIONID_IDENTIFICATIONID_1);
			}
			else if (identificationId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_IDENTIFICATIONID_IDENTIFICATIONID_3);
			}
			else {
				bindIdentificationId = true;

				query.append(_FINDER_COLUMN_IDENTIFICATIONID_IDENTIFICATIONID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindIdentificationId) {
					qPos.add(identificationId);
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

	private static final String _FINDER_COLUMN_IDENTIFICATIONID_IDENTIFICATIONID_1 =
		"userPersonalData.identificationId IS NULL";
	private static final String _FINDER_COLUMN_IDENTIFICATIONID_IDENTIFICATIONID_2 =
		"userPersonalData.identificationId = ?";
	private static final String _FINDER_COLUMN_IDENTIFICATIONID_IDENTIFICATIONID_3 =
		"(userPersonalData.identificationId IS NULL OR userPersonalData.identificationId = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_LAWERID = new FinderPath(UserPersonalDataModelImpl.ENTITY_CACHE_ENABLED,
			UserPersonalDataModelImpl.FINDER_CACHE_ENABLED,
			UserPersonalDataImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchBylawerId", new String[] { String.class.getName() },
			UserPersonalDataModelImpl.LAWERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LAWERID = new FinderPath(UserPersonalDataModelImpl.ENTITY_CACHE_ENABLED,
			UserPersonalDataModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBylawerId",
			new String[] { String.class.getName() });

	/**
	 * Returns the user personal data where lawerId = &#63; or throws a {@link NoSuchUserPersonalDataException} if it could not be found.
	 *
	 * @param lawerId the lawer ID
	 * @return the matching user personal data
	 * @throws NoSuchUserPersonalDataException if a matching user personal data could not be found
	 */
	@Override
	public UserPersonalData findBylawerId(String lawerId)
		throws NoSuchUserPersonalDataException {
		UserPersonalData userPersonalData = fetchBylawerId(lawerId);

		if (userPersonalData == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("lawerId=");
			msg.append(lawerId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchUserPersonalDataException(msg.toString());
		}

		return userPersonalData;
	}

	/**
	 * Returns the user personal data where lawerId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param lawerId the lawer ID
	 * @return the matching user personal data, or <code>null</code> if a matching user personal data could not be found
	 */
	@Override
	public UserPersonalData fetchBylawerId(String lawerId) {
		return fetchBylawerId(lawerId, true);
	}

	/**
	 * Returns the user personal data where lawerId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param lawerId the lawer ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching user personal data, or <code>null</code> if a matching user personal data could not be found
	 */
	@Override
	public UserPersonalData fetchBylawerId(String lawerId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { lawerId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_LAWERID,
					finderArgs, this);
		}

		if (result instanceof UserPersonalData) {
			UserPersonalData userPersonalData = (UserPersonalData)result;

			if (!Objects.equals(lawerId, userPersonalData.getLawerId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_USERPERSONALDATA_WHERE);

			boolean bindLawerId = false;

			if (lawerId == null) {
				query.append(_FINDER_COLUMN_LAWERID_LAWERID_1);
			}
			else if (lawerId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LAWERID_LAWERID_3);
			}
			else {
				bindLawerId = true;

				query.append(_FINDER_COLUMN_LAWERID_LAWERID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLawerId) {
					qPos.add(lawerId);
				}

				List<UserPersonalData> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_LAWERID,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"UserPersonalDataPersistenceImpl.fetchBylawerId(String, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					UserPersonalData userPersonalData = list.get(0);

					result = userPersonalData;

					cacheResult(userPersonalData);

					if ((userPersonalData.getLawerId() == null) ||
							!userPersonalData.getLawerId().equals(lawerId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_LAWERID,
							finderArgs, userPersonalData);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_LAWERID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (UserPersonalData)result;
		}
	}

	/**
	 * Removes the user personal data where lawerId = &#63; from the database.
	 *
	 * @param lawerId the lawer ID
	 * @return the user personal data that was removed
	 */
	@Override
	public UserPersonalData removeBylawerId(String lawerId)
		throws NoSuchUserPersonalDataException {
		UserPersonalData userPersonalData = findBylawerId(lawerId);

		return remove(userPersonalData);
	}

	/**
	 * Returns the number of user personal datas where lawerId = &#63;.
	 *
	 * @param lawerId the lawer ID
	 * @return the number of matching user personal datas
	 */
	@Override
	public int countBylawerId(String lawerId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LAWERID;

		Object[] finderArgs = new Object[] { lawerId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERPERSONALDATA_WHERE);

			boolean bindLawerId = false;

			if (lawerId == null) {
				query.append(_FINDER_COLUMN_LAWERID_LAWERID_1);
			}
			else if (lawerId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LAWERID_LAWERID_3);
			}
			else {
				bindLawerId = true;

				query.append(_FINDER_COLUMN_LAWERID_LAWERID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLawerId) {
					qPos.add(lawerId);
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

	private static final String _FINDER_COLUMN_LAWERID_LAWERID_1 = "userPersonalData.lawerId IS NULL";
	private static final String _FINDER_COLUMN_LAWERID_LAWERID_2 = "userPersonalData.lawerId = ?";
	private static final String _FINDER_COLUMN_LAWERID_LAWERID_3 = "(userPersonalData.lawerId IS NULL OR userPersonalData.lawerId = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_SOLICITORID = new FinderPath(UserPersonalDataModelImpl.ENTITY_CACHE_ENABLED,
			UserPersonalDataModelImpl.FINDER_CACHE_ENABLED,
			UserPersonalDataImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchBysolicitorId", new String[] { String.class.getName() },
			UserPersonalDataModelImpl.SOLICITORID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SOLICITORID = new FinderPath(UserPersonalDataModelImpl.ENTITY_CACHE_ENABLED,
			UserPersonalDataModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBysolicitorId",
			new String[] { String.class.getName() });

	/**
	 * Returns the user personal data where solicitorId = &#63; or throws a {@link NoSuchUserPersonalDataException} if it could not be found.
	 *
	 * @param solicitorId the solicitor ID
	 * @return the matching user personal data
	 * @throws NoSuchUserPersonalDataException if a matching user personal data could not be found
	 */
	@Override
	public UserPersonalData findBysolicitorId(String solicitorId)
		throws NoSuchUserPersonalDataException {
		UserPersonalData userPersonalData = fetchBysolicitorId(solicitorId);

		if (userPersonalData == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("solicitorId=");
			msg.append(solicitorId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchUserPersonalDataException(msg.toString());
		}

		return userPersonalData;
	}

	/**
	 * Returns the user personal data where solicitorId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param solicitorId the solicitor ID
	 * @return the matching user personal data, or <code>null</code> if a matching user personal data could not be found
	 */
	@Override
	public UserPersonalData fetchBysolicitorId(String solicitorId) {
		return fetchBysolicitorId(solicitorId, true);
	}

	/**
	 * Returns the user personal data where solicitorId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param solicitorId the solicitor ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching user personal data, or <code>null</code> if a matching user personal data could not be found
	 */
	@Override
	public UserPersonalData fetchBysolicitorId(String solicitorId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { solicitorId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_SOLICITORID,
					finderArgs, this);
		}

		if (result instanceof UserPersonalData) {
			UserPersonalData userPersonalData = (UserPersonalData)result;

			if (!Objects.equals(solicitorId, userPersonalData.getSolicitorId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_USERPERSONALDATA_WHERE);

			boolean bindSolicitorId = false;

			if (solicitorId == null) {
				query.append(_FINDER_COLUMN_SOLICITORID_SOLICITORID_1);
			}
			else if (solicitorId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SOLICITORID_SOLICITORID_3);
			}
			else {
				bindSolicitorId = true;

				query.append(_FINDER_COLUMN_SOLICITORID_SOLICITORID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindSolicitorId) {
					qPos.add(solicitorId);
				}

				List<UserPersonalData> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_SOLICITORID,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"UserPersonalDataPersistenceImpl.fetchBysolicitorId(String, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					UserPersonalData userPersonalData = list.get(0);

					result = userPersonalData;

					cacheResult(userPersonalData);

					if ((userPersonalData.getSolicitorId() == null) ||
							!userPersonalData.getSolicitorId()
												 .equals(solicitorId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_SOLICITORID,
							finderArgs, userPersonalData);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_SOLICITORID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (UserPersonalData)result;
		}
	}

	/**
	 * Removes the user personal data where solicitorId = &#63; from the database.
	 *
	 * @param solicitorId the solicitor ID
	 * @return the user personal data that was removed
	 */
	@Override
	public UserPersonalData removeBysolicitorId(String solicitorId)
		throws NoSuchUserPersonalDataException {
		UserPersonalData userPersonalData = findBysolicitorId(solicitorId);

		return remove(userPersonalData);
	}

	/**
	 * Returns the number of user personal datas where solicitorId = &#63;.
	 *
	 * @param solicitorId the solicitor ID
	 * @return the number of matching user personal datas
	 */
	@Override
	public int countBysolicitorId(String solicitorId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SOLICITORID;

		Object[] finderArgs = new Object[] { solicitorId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERPERSONALDATA_WHERE);

			boolean bindSolicitorId = false;

			if (solicitorId == null) {
				query.append(_FINDER_COLUMN_SOLICITORID_SOLICITORID_1);
			}
			else if (solicitorId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SOLICITORID_SOLICITORID_3);
			}
			else {
				bindSolicitorId = true;

				query.append(_FINDER_COLUMN_SOLICITORID_SOLICITORID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindSolicitorId) {
					qPos.add(solicitorId);
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

	private static final String _FINDER_COLUMN_SOLICITORID_SOLICITORID_1 = "userPersonalData.solicitorId IS NULL";
	private static final String _FINDER_COLUMN_SOLICITORID_SOLICITORID_2 = "userPersonalData.solicitorId = ?";
	private static final String _FINDER_COLUMN_SOLICITORID_SOLICITORID_3 = "(userPersonalData.solicitorId IS NULL OR userPersonalData.solicitorId = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_NOTARYID = new FinderPath(UserPersonalDataModelImpl.ENTITY_CACHE_ENABLED,
			UserPersonalDataModelImpl.FINDER_CACHE_ENABLED,
			UserPersonalDataImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchBynotaryId", new String[] { String.class.getName() },
			UserPersonalDataModelImpl.NOTARYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NOTARYID = new FinderPath(UserPersonalDataModelImpl.ENTITY_CACHE_ENABLED,
			UserPersonalDataModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBynotaryId",
			new String[] { String.class.getName() });

	/**
	 * Returns the user personal data where notaryId = &#63; or throws a {@link NoSuchUserPersonalDataException} if it could not be found.
	 *
	 * @param notaryId the notary ID
	 * @return the matching user personal data
	 * @throws NoSuchUserPersonalDataException if a matching user personal data could not be found
	 */
	@Override
	public UserPersonalData findBynotaryId(String notaryId)
		throws NoSuchUserPersonalDataException {
		UserPersonalData userPersonalData = fetchBynotaryId(notaryId);

		if (userPersonalData == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("notaryId=");
			msg.append(notaryId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchUserPersonalDataException(msg.toString());
		}

		return userPersonalData;
	}

	/**
	 * Returns the user personal data where notaryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param notaryId the notary ID
	 * @return the matching user personal data, or <code>null</code> if a matching user personal data could not be found
	 */
	@Override
	public UserPersonalData fetchBynotaryId(String notaryId) {
		return fetchBynotaryId(notaryId, true);
	}

	/**
	 * Returns the user personal data where notaryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param notaryId the notary ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching user personal data, or <code>null</code> if a matching user personal data could not be found
	 */
	@Override
	public UserPersonalData fetchBynotaryId(String notaryId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { notaryId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_NOTARYID,
					finderArgs, this);
		}

		if (result instanceof UserPersonalData) {
			UserPersonalData userPersonalData = (UserPersonalData)result;

			if (!Objects.equals(notaryId, userPersonalData.getNotaryId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_USERPERSONALDATA_WHERE);

			boolean bindNotaryId = false;

			if (notaryId == null) {
				query.append(_FINDER_COLUMN_NOTARYID_NOTARYID_1);
			}
			else if (notaryId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NOTARYID_NOTARYID_3);
			}
			else {
				bindNotaryId = true;

				query.append(_FINDER_COLUMN_NOTARYID_NOTARYID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindNotaryId) {
					qPos.add(notaryId);
				}

				List<UserPersonalData> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_NOTARYID,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"UserPersonalDataPersistenceImpl.fetchBynotaryId(String, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					UserPersonalData userPersonalData = list.get(0);

					result = userPersonalData;

					cacheResult(userPersonalData);

					if ((userPersonalData.getNotaryId() == null) ||
							!userPersonalData.getNotaryId().equals(notaryId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_NOTARYID,
							finderArgs, userPersonalData);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_NOTARYID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (UserPersonalData)result;
		}
	}

	/**
	 * Removes the user personal data where notaryId = &#63; from the database.
	 *
	 * @param notaryId the notary ID
	 * @return the user personal data that was removed
	 */
	@Override
	public UserPersonalData removeBynotaryId(String notaryId)
		throws NoSuchUserPersonalDataException {
		UserPersonalData userPersonalData = findBynotaryId(notaryId);

		return remove(userPersonalData);
	}

	/**
	 * Returns the number of user personal datas where notaryId = &#63;.
	 *
	 * @param notaryId the notary ID
	 * @return the number of matching user personal datas
	 */
	@Override
	public int countBynotaryId(String notaryId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NOTARYID;

		Object[] finderArgs = new Object[] { notaryId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERPERSONALDATA_WHERE);

			boolean bindNotaryId = false;

			if (notaryId == null) {
				query.append(_FINDER_COLUMN_NOTARYID_NOTARYID_1);
			}
			else if (notaryId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NOTARYID_NOTARYID_3);
			}
			else {
				bindNotaryId = true;

				query.append(_FINDER_COLUMN_NOTARYID_NOTARYID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindNotaryId) {
					qPos.add(notaryId);
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

	private static final String _FINDER_COLUMN_NOTARYID_NOTARYID_1 = "userPersonalData.notaryId IS NULL";
	private static final String _FINDER_COLUMN_NOTARYID_NOTARYID_2 = "userPersonalData.notaryId = ?";
	private static final String _FINDER_COLUMN_NOTARYID_NOTARYID_3 = "(userPersonalData.notaryId IS NULL OR userPersonalData.notaryId = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_PASSPORT = new FinderPath(UserPersonalDataModelImpl.ENTITY_CACHE_ENABLED,
			UserPersonalDataModelImpl.FINDER_CACHE_ENABLED,
			UserPersonalDataImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchBypassport",
			new String[] { String.class.getName(), String.class.getName() },
			UserPersonalDataModelImpl.PASSPORTID_COLUMN_BITMASK |
			UserPersonalDataModelImpl.NATIONALITY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PASSPORT = new FinderPath(UserPersonalDataModelImpl.ENTITY_CACHE_ENABLED,
			UserPersonalDataModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBypassport",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns the user personal data where passportId = &#63; and nationality = &#63; or throws a {@link NoSuchUserPersonalDataException} if it could not be found.
	 *
	 * @param passportId the passport ID
	 * @param nationality the nationality
	 * @return the matching user personal data
	 * @throws NoSuchUserPersonalDataException if a matching user personal data could not be found
	 */
	@Override
	public UserPersonalData findBypassport(String passportId, String nationality)
		throws NoSuchUserPersonalDataException {
		UserPersonalData userPersonalData = fetchBypassport(passportId,
				nationality);

		if (userPersonalData == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("passportId=");
			msg.append(passportId);

			msg.append(", nationality=");
			msg.append(nationality);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchUserPersonalDataException(msg.toString());
		}

		return userPersonalData;
	}

	/**
	 * Returns the user personal data where passportId = &#63; and nationality = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param passportId the passport ID
	 * @param nationality the nationality
	 * @return the matching user personal data, or <code>null</code> if a matching user personal data could not be found
	 */
	@Override
	public UserPersonalData fetchBypassport(String passportId,
		String nationality) {
		return fetchBypassport(passportId, nationality, true);
	}

	/**
	 * Returns the user personal data where passportId = &#63; and nationality = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param passportId the passport ID
	 * @param nationality the nationality
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching user personal data, or <code>null</code> if a matching user personal data could not be found
	 */
	@Override
	public UserPersonalData fetchBypassport(String passportId,
		String nationality, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { passportId, nationality };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_PASSPORT,
					finderArgs, this);
		}

		if (result instanceof UserPersonalData) {
			UserPersonalData userPersonalData = (UserPersonalData)result;

			if (!Objects.equals(passportId, userPersonalData.getPassportId()) ||
					!Objects.equals(nationality,
						userPersonalData.getNationality())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_USERPERSONALDATA_WHERE);

			boolean bindPassportId = false;

			if (passportId == null) {
				query.append(_FINDER_COLUMN_PASSPORT_PASSPORTID_1);
			}
			else if (passportId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PASSPORT_PASSPORTID_3);
			}
			else {
				bindPassportId = true;

				query.append(_FINDER_COLUMN_PASSPORT_PASSPORTID_2);
			}

			boolean bindNationality = false;

			if (nationality == null) {
				query.append(_FINDER_COLUMN_PASSPORT_NATIONALITY_1);
			}
			else if (nationality.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PASSPORT_NATIONALITY_3);
			}
			else {
				bindNationality = true;

				query.append(_FINDER_COLUMN_PASSPORT_NATIONALITY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPassportId) {
					qPos.add(passportId);
				}

				if (bindNationality) {
					qPos.add(nationality);
				}

				List<UserPersonalData> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_PASSPORT,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"UserPersonalDataPersistenceImpl.fetchBypassport(String, String, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					UserPersonalData userPersonalData = list.get(0);

					result = userPersonalData;

					cacheResult(userPersonalData);

					if ((userPersonalData.getPassportId() == null) ||
							!userPersonalData.getPassportId().equals(passportId) ||
							(userPersonalData.getNationality() == null) ||
							!userPersonalData.getNationality()
												 .equals(nationality)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_PASSPORT,
							finderArgs, userPersonalData);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_PASSPORT,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (UserPersonalData)result;
		}
	}

	/**
	 * Removes the user personal data where passportId = &#63; and nationality = &#63; from the database.
	 *
	 * @param passportId the passport ID
	 * @param nationality the nationality
	 * @return the user personal data that was removed
	 */
	@Override
	public UserPersonalData removeBypassport(String passportId,
		String nationality) throws NoSuchUserPersonalDataException {
		UserPersonalData userPersonalData = findBypassport(passportId,
				nationality);

		return remove(userPersonalData);
	}

	/**
	 * Returns the number of user personal datas where passportId = &#63; and nationality = &#63;.
	 *
	 * @param passportId the passport ID
	 * @param nationality the nationality
	 * @return the number of matching user personal datas
	 */
	@Override
	public int countBypassport(String passportId, String nationality) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PASSPORT;

		Object[] finderArgs = new Object[] { passportId, nationality };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_USERPERSONALDATA_WHERE);

			boolean bindPassportId = false;

			if (passportId == null) {
				query.append(_FINDER_COLUMN_PASSPORT_PASSPORTID_1);
			}
			else if (passportId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PASSPORT_PASSPORTID_3);
			}
			else {
				bindPassportId = true;

				query.append(_FINDER_COLUMN_PASSPORT_PASSPORTID_2);
			}

			boolean bindNationality = false;

			if (nationality == null) {
				query.append(_FINDER_COLUMN_PASSPORT_NATIONALITY_1);
			}
			else if (nationality.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PASSPORT_NATIONALITY_3);
			}
			else {
				bindNationality = true;

				query.append(_FINDER_COLUMN_PASSPORT_NATIONALITY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPassportId) {
					qPos.add(passportId);
				}

				if (bindNationality) {
					qPos.add(nationality);
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

	private static final String _FINDER_COLUMN_PASSPORT_PASSPORTID_1 = "userPersonalData.passportId IS NULL AND ";
	private static final String _FINDER_COLUMN_PASSPORT_PASSPORTID_2 = "userPersonalData.passportId = ? AND ";
	private static final String _FINDER_COLUMN_PASSPORT_PASSPORTID_3 = "(userPersonalData.passportId IS NULL OR userPersonalData.passportId = '') AND ";
	private static final String _FINDER_COLUMN_PASSPORT_NATIONALITY_1 = "userPersonalData.nationality IS NULL";
	private static final String _FINDER_COLUMN_PASSPORT_NATIONALITY_2 = "userPersonalData.nationality = ?";
	private static final String _FINDER_COLUMN_PASSPORT_NATIONALITY_3 = "(userPersonalData.nationality IS NULL OR userPersonalData.nationality = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_USERID = new FinderPath(UserPersonalDataModelImpl.ENTITY_CACHE_ENABLED,
			UserPersonalDataModelImpl.FINDER_CACHE_ENABLED,
			UserPersonalDataImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByuserId", new String[] { Long.class.getName() },
			UserPersonalDataModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(UserPersonalDataModelImpl.ENTITY_CACHE_ENABLED,
			UserPersonalDataModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByuserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the user personal data where userId = &#63; or throws a {@link NoSuchUserPersonalDataException} if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching user personal data
	 * @throws NoSuchUserPersonalDataException if a matching user personal data could not be found
	 */
	@Override
	public UserPersonalData findByuserId(long userId)
		throws NoSuchUserPersonalDataException {
		UserPersonalData userPersonalData = fetchByuserId(userId);

		if (userPersonalData == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchUserPersonalDataException(msg.toString());
		}

		return userPersonalData;
	}

	/**
	 * Returns the user personal data where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching user personal data, or <code>null</code> if a matching user personal data could not be found
	 */
	@Override
	public UserPersonalData fetchByuserId(long userId) {
		return fetchByuserId(userId, true);
	}

	/**
	 * Returns the user personal data where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching user personal data, or <code>null</code> if a matching user personal data could not be found
	 */
	@Override
	public UserPersonalData fetchByuserId(long userId, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { userId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_USERID,
					finderArgs, this);
		}

		if (result instanceof UserPersonalData) {
			UserPersonalData userPersonalData = (UserPersonalData)result;

			if ((userId != userPersonalData.getUserId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_USERPERSONALDATA_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				List<UserPersonalData> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_USERID,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"UserPersonalDataPersistenceImpl.fetchByuserId(long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					UserPersonalData userPersonalData = list.get(0);

					result = userPersonalData;

					cacheResult(userPersonalData);

					if ((userPersonalData.getUserId() != userId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_USERID,
							finderArgs, userPersonalData);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_USERID, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (UserPersonalData)result;
		}
	}

	/**
	 * Removes the user personal data where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the user personal data that was removed
	 */
	@Override
	public UserPersonalData removeByuserId(long userId)
		throws NoSuchUserPersonalDataException {
		UserPersonalData userPersonalData = findByuserId(userId);

		return remove(userPersonalData);
	}

	/**
	 * Returns the number of user personal datas where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching user personal datas
	 */
	@Override
	public int countByuserId(long userId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERPERSONALDATA_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "userPersonalData.userId = ?";

	public UserPersonalDataPersistenceImpl() {
		setModelClass(UserPersonalData.class);
	}

	/**
	 * Caches the user personal data in the entity cache if it is enabled.
	 *
	 * @param userPersonalData the user personal data
	 */
	@Override
	public void cacheResult(UserPersonalData userPersonalData) {
		entityCache.putResult(UserPersonalDataModelImpl.ENTITY_CACHE_ENABLED,
			UserPersonalDataImpl.class, userPersonalData.getPrimaryKey(),
			userPersonalData);

		finderCache.putResult(FINDER_PATH_FETCH_BY_IDENTIFICATIONID,
			new Object[] { userPersonalData.getIdentificationId() },
			userPersonalData);

		finderCache.putResult(FINDER_PATH_FETCH_BY_LAWERID,
			new Object[] { userPersonalData.getLawerId() }, userPersonalData);

		finderCache.putResult(FINDER_PATH_FETCH_BY_SOLICITORID,
			new Object[] { userPersonalData.getSolicitorId() }, userPersonalData);

		finderCache.putResult(FINDER_PATH_FETCH_BY_NOTARYID,
			new Object[] { userPersonalData.getNotaryId() }, userPersonalData);

		finderCache.putResult(FINDER_PATH_FETCH_BY_PASSPORT,
			new Object[] {
				userPersonalData.getPassportId(),
				userPersonalData.getNationality()
			}, userPersonalData);

		finderCache.putResult(FINDER_PATH_FETCH_BY_USERID,
			new Object[] { userPersonalData.getUserId() }, userPersonalData);

		userPersonalData.resetOriginalValues();
	}

	/**
	 * Caches the user personal datas in the entity cache if it is enabled.
	 *
	 * @param userPersonalDatas the user personal datas
	 */
	@Override
	public void cacheResult(List<UserPersonalData> userPersonalDatas) {
		for (UserPersonalData userPersonalData : userPersonalDatas) {
			if (entityCache.getResult(
						UserPersonalDataModelImpl.ENTITY_CACHE_ENABLED,
						UserPersonalDataImpl.class,
						userPersonalData.getPrimaryKey()) == null) {
				cacheResult(userPersonalData);
			}
			else {
				userPersonalData.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all user personal datas.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(UserPersonalDataImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the user personal data.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UserPersonalData userPersonalData) {
		entityCache.removeResult(UserPersonalDataModelImpl.ENTITY_CACHE_ENABLED,
			UserPersonalDataImpl.class, userPersonalData.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((UserPersonalDataModelImpl)userPersonalData,
			true);
	}

	@Override
	public void clearCache(List<UserPersonalData> userPersonalDatas) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UserPersonalData userPersonalData : userPersonalDatas) {
			entityCache.removeResult(UserPersonalDataModelImpl.ENTITY_CACHE_ENABLED,
				UserPersonalDataImpl.class, userPersonalData.getPrimaryKey());

			clearUniqueFindersCache((UserPersonalDataModelImpl)userPersonalData,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		UserPersonalDataModelImpl userPersonalDataModelImpl) {
		Object[] args = new Object[] {
				userPersonalDataModelImpl.getIdentificationId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_IDENTIFICATIONID, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_IDENTIFICATIONID, args,
			userPersonalDataModelImpl, false);

		args = new Object[] { userPersonalDataModelImpl.getLawerId() };

		finderCache.putResult(FINDER_PATH_COUNT_BY_LAWERID, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_LAWERID, args,
			userPersonalDataModelImpl, false);

		args = new Object[] { userPersonalDataModelImpl.getSolicitorId() };

		finderCache.putResult(FINDER_PATH_COUNT_BY_SOLICITORID, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_SOLICITORID, args,
			userPersonalDataModelImpl, false);

		args = new Object[] { userPersonalDataModelImpl.getNotaryId() };

		finderCache.putResult(FINDER_PATH_COUNT_BY_NOTARYID, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_NOTARYID, args,
			userPersonalDataModelImpl, false);

		args = new Object[] {
				userPersonalDataModelImpl.getPassportId(),
				userPersonalDataModelImpl.getNationality()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_PASSPORT, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_PASSPORT, args,
			userPersonalDataModelImpl, false);

		args = new Object[] { userPersonalDataModelImpl.getUserId() };

		finderCache.putResult(FINDER_PATH_COUNT_BY_USERID, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_USERID, args,
			userPersonalDataModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		UserPersonalDataModelImpl userPersonalDataModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					userPersonalDataModelImpl.getIdentificationId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_IDENTIFICATIONID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_IDENTIFICATIONID, args);
		}

		if ((userPersonalDataModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_IDENTIFICATIONID.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					userPersonalDataModelImpl.getOriginalIdentificationId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_IDENTIFICATIONID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_IDENTIFICATIONID, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] { userPersonalDataModelImpl.getLawerId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_LAWERID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_LAWERID, args);
		}

		if ((userPersonalDataModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_LAWERID.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					userPersonalDataModelImpl.getOriginalLawerId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_LAWERID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_LAWERID, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
					userPersonalDataModelImpl.getSolicitorId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_SOLICITORID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_SOLICITORID, args);
		}

		if ((userPersonalDataModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_SOLICITORID.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					userPersonalDataModelImpl.getOriginalSolicitorId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_SOLICITORID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_SOLICITORID, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] { userPersonalDataModelImpl.getNotaryId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_NOTARYID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_NOTARYID, args);
		}

		if ((userPersonalDataModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_NOTARYID.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					userPersonalDataModelImpl.getOriginalNotaryId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_NOTARYID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_NOTARYID, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
					userPersonalDataModelImpl.getPassportId(),
					userPersonalDataModelImpl.getNationality()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PASSPORT, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_PASSPORT, args);
		}

		if ((userPersonalDataModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_PASSPORT.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					userPersonalDataModelImpl.getOriginalPassportId(),
					userPersonalDataModelImpl.getOriginalNationality()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PASSPORT, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_PASSPORT, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] { userPersonalDataModelImpl.getUserId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_USERID, args);
		}

		if ((userPersonalDataModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_USERID.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					userPersonalDataModelImpl.getOriginalUserId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_USERID, args);
		}
	}

	/**
	 * Creates a new user personal data with the primary key. Does not add the user personal data to the database.
	 *
	 * @param userId the primary key for the new user personal data
	 * @return the new user personal data
	 */
	@Override
	public UserPersonalData create(long userId) {
		UserPersonalData userPersonalData = new UserPersonalDataImpl();

		userPersonalData.setNew(true);
		userPersonalData.setPrimaryKey(userId);

		userPersonalData.setCompanyId(companyProvider.getCompanyId());

		return userPersonalData;
	}

	/**
	 * Removes the user personal data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userId the primary key of the user personal data
	 * @return the user personal data that was removed
	 * @throws NoSuchUserPersonalDataException if a user personal data with the primary key could not be found
	 */
	@Override
	public UserPersonalData remove(long userId)
		throws NoSuchUserPersonalDataException {
		return remove((Serializable)userId);
	}

	/**
	 * Removes the user personal data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user personal data
	 * @return the user personal data that was removed
	 * @throws NoSuchUserPersonalDataException if a user personal data with the primary key could not be found
	 */
	@Override
	public UserPersonalData remove(Serializable primaryKey)
		throws NoSuchUserPersonalDataException {
		Session session = null;

		try {
			session = openSession();

			UserPersonalData userPersonalData = (UserPersonalData)session.get(UserPersonalDataImpl.class,
					primaryKey);

			if (userPersonalData == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserPersonalDataException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(userPersonalData);
		}
		catch (NoSuchUserPersonalDataException nsee) {
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
	protected UserPersonalData removeImpl(UserPersonalData userPersonalData) {
		userPersonalData = toUnwrappedModel(userPersonalData);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(userPersonalData)) {
				userPersonalData = (UserPersonalData)session.get(UserPersonalDataImpl.class,
						userPersonalData.getPrimaryKeyObj());
			}

			if (userPersonalData != null) {
				session.delete(userPersonalData);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (userPersonalData != null) {
			clearCache(userPersonalData);
		}

		return userPersonalData;
	}

	@Override
	public UserPersonalData updateImpl(UserPersonalData userPersonalData) {
		userPersonalData = toUnwrappedModel(userPersonalData);

		boolean isNew = userPersonalData.isNew();

		UserPersonalDataModelImpl userPersonalDataModelImpl = (UserPersonalDataModelImpl)userPersonalData;

		Session session = null;

		try {
			session = openSession();

			if (userPersonalData.isNew()) {
				session.save(userPersonalData);

				userPersonalData.setNew(false);
			}
			else {
				userPersonalData = (UserPersonalData)session.merge(userPersonalData);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!UserPersonalDataModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(UserPersonalDataModelImpl.ENTITY_CACHE_ENABLED,
			UserPersonalDataImpl.class, userPersonalData.getPrimaryKey(),
			userPersonalData, false);

		clearUniqueFindersCache(userPersonalDataModelImpl, false);
		cacheUniqueFindersCache(userPersonalDataModelImpl);

		userPersonalData.resetOriginalValues();

		return userPersonalData;
	}

	protected UserPersonalData toUnwrappedModel(
		UserPersonalData userPersonalData) {
		if (userPersonalData instanceof UserPersonalDataImpl) {
			return userPersonalData;
		}

		UserPersonalDataImpl userPersonalDataImpl = new UserPersonalDataImpl();

		userPersonalDataImpl.setNew(userPersonalData.isNew());
		userPersonalDataImpl.setPrimaryKey(userPersonalData.getPrimaryKey());

		userPersonalDataImpl.setUserId(userPersonalData.getUserId());
		userPersonalDataImpl.setCompanyId(userPersonalData.getCompanyId());
		userPersonalDataImpl.setIdentificationId(userPersonalData.getIdentificationId());
		userPersonalDataImpl.setLawerId(userPersonalData.getLawerId());
		userPersonalDataImpl.setSolicitorId(userPersonalData.getSolicitorId());
		userPersonalDataImpl.setNotaryId(userPersonalData.getNotaryId());
		userPersonalDataImpl.setPassportId(userPersonalData.getPassportId());
		userPersonalDataImpl.setNationality(userPersonalData.getNationality());
		userPersonalDataImpl.setAuthenticationType(userPersonalData.getAuthenticationType());
		userPersonalDataImpl.setAgreeFullName(userPersonalData.getAgreeFullName());
		userPersonalDataImpl.setAgreePortalUseData(userPersonalData.getAgreePortalUseData());
		userPersonalDataImpl.setAgreeEmail(userPersonalData.getAgreeEmail());

		return userPersonalDataImpl;
	}

	/**
	 * Returns the user personal data with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the user personal data
	 * @return the user personal data
	 * @throws NoSuchUserPersonalDataException if a user personal data with the primary key could not be found
	 */
	@Override
	public UserPersonalData findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUserPersonalDataException {
		UserPersonalData userPersonalData = fetchByPrimaryKey(primaryKey);

		if (userPersonalData == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUserPersonalDataException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return userPersonalData;
	}

	/**
	 * Returns the user personal data with the primary key or throws a {@link NoSuchUserPersonalDataException} if it could not be found.
	 *
	 * @param userId the primary key of the user personal data
	 * @return the user personal data
	 * @throws NoSuchUserPersonalDataException if a user personal data with the primary key could not be found
	 */
	@Override
	public UserPersonalData findByPrimaryKey(long userId)
		throws NoSuchUserPersonalDataException {
		return findByPrimaryKey((Serializable)userId);
	}

	/**
	 * Returns the user personal data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user personal data
	 * @return the user personal data, or <code>null</code> if a user personal data with the primary key could not be found
	 */
	@Override
	public UserPersonalData fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(UserPersonalDataModelImpl.ENTITY_CACHE_ENABLED,
				UserPersonalDataImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		UserPersonalData userPersonalData = (UserPersonalData)serializable;

		if (userPersonalData == null) {
			Session session = null;

			try {
				session = openSession();

				userPersonalData = (UserPersonalData)session.get(UserPersonalDataImpl.class,
						primaryKey);

				if (userPersonalData != null) {
					cacheResult(userPersonalData);
				}
				else {
					entityCache.putResult(UserPersonalDataModelImpl.ENTITY_CACHE_ENABLED,
						UserPersonalDataImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(UserPersonalDataModelImpl.ENTITY_CACHE_ENABLED,
					UserPersonalDataImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return userPersonalData;
	}

	/**
	 * Returns the user personal data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userId the primary key of the user personal data
	 * @return the user personal data, or <code>null</code> if a user personal data with the primary key could not be found
	 */
	@Override
	public UserPersonalData fetchByPrimaryKey(long userId) {
		return fetchByPrimaryKey((Serializable)userId);
	}

	@Override
	public Map<Serializable, UserPersonalData> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, UserPersonalData> map = new HashMap<Serializable, UserPersonalData>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			UserPersonalData userPersonalData = fetchByPrimaryKey(primaryKey);

			if (userPersonalData != null) {
				map.put(primaryKey, userPersonalData);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(UserPersonalDataModelImpl.ENTITY_CACHE_ENABLED,
					UserPersonalDataImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (UserPersonalData)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_USERPERSONALDATA_WHERE_PKS_IN);

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

			for (UserPersonalData userPersonalData : (List<UserPersonalData>)q.list()) {
				map.put(userPersonalData.getPrimaryKeyObj(), userPersonalData);

				cacheResult(userPersonalData);

				uncachedPrimaryKeys.remove(userPersonalData.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(UserPersonalDataModelImpl.ENTITY_CACHE_ENABLED,
					UserPersonalDataImpl.class, primaryKey, nullModel);
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
	 * Returns all the user personal datas.
	 *
	 * @return the user personal datas
	 */
	@Override
	public List<UserPersonalData> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<UserPersonalData> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<UserPersonalData> findAll(int start, int end,
		OrderByComparator<UserPersonalData> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<UserPersonalData> findAll(int start, int end,
		OrderByComparator<UserPersonalData> orderByComparator,
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

		List<UserPersonalData> list = null;

		if (retrieveFromCache) {
			list = (List<UserPersonalData>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_USERPERSONALDATA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_USERPERSONALDATA;

				if (pagination) {
					sql = sql.concat(UserPersonalDataModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<UserPersonalData>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UserPersonalData>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the user personal datas from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (UserPersonalData userPersonalData : findAll()) {
			remove(userPersonalData);
		}
	}

	/**
	 * Returns the number of user personal datas.
	 *
	 * @return the number of user personal datas
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_USERPERSONALDATA);

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
	protected Map<String, Integer> getTableColumnsMap() {
		return UserPersonalDataModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the user personal data persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(UserPersonalDataImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_USERPERSONALDATA = "SELECT userPersonalData FROM UserPersonalData userPersonalData";
	private static final String _SQL_SELECT_USERPERSONALDATA_WHERE_PKS_IN = "SELECT userPersonalData FROM UserPersonalData userPersonalData WHERE userId IN (";
	private static final String _SQL_SELECT_USERPERSONALDATA_WHERE = "SELECT userPersonalData FROM UserPersonalData userPersonalData WHERE ";
	private static final String _SQL_COUNT_USERPERSONALDATA = "SELECT COUNT(userPersonalData) FROM UserPersonalData userPersonalData";
	private static final String _SQL_COUNT_USERPERSONALDATA_WHERE = "SELECT COUNT(userPersonalData) FROM UserPersonalData userPersonalData WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "userPersonalData.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No UserPersonalData exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No UserPersonalData exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(UserPersonalDataPersistenceImpl.class);
}