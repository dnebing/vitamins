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

package com.dnebinger.vitamins.service.persistence.impl;

import com.dnebinger.vitamins.exception.NoSuchPersistedVitaminException;
import com.dnebinger.vitamins.model.PersistedVitamin;
import com.dnebinger.vitamins.model.impl.PersistedVitaminImpl;
import com.dnebinger.vitamins.model.impl.PersistedVitaminModelImpl;
import com.dnebinger.vitamins.service.persistence.PersistedVitaminPersistence;
import com.dnebinger.vitamins.service.persistence.impl.constants.NEBPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.sanitizer.Sanitizer;
import com.liferay.portal.kernel.sanitizer.SanitizerException;
import com.liferay.portal.kernel.sanitizer.SanitizerUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the persisted vitamin service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = PersistedVitaminPersistence.class)
@ProviderType
public class PersistedVitaminPersistenceImpl
	extends BasePersistenceImpl<PersistedVitamin>
	implements PersistedVitaminPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PersistedVitaminUtil</code> to access the persisted vitamin persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PersistedVitaminImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the persisted vitamins where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching persisted vitamins
	 */
	@Override
	public List<PersistedVitamin> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the persisted vitamins where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedVitaminModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of persisted vitamins
	 * @param end the upper bound of the range of persisted vitamins (not inclusive)
	 * @return the range of matching persisted vitamins
	 */
	@Override
	public List<PersistedVitamin> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the persisted vitamins where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedVitaminModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of persisted vitamins
	 * @param end the upper bound of the range of persisted vitamins (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching persisted vitamins
	 */
	@Override
	public List<PersistedVitamin> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PersistedVitamin> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the persisted vitamins where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedVitaminModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of persisted vitamins
	 * @param end the upper bound of the range of persisted vitamins (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching persisted vitamins
	 */
	@Override
	public List<PersistedVitamin> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PersistedVitamin> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<PersistedVitamin> list = null;

		if (useFinderCache) {
			list = (List<PersistedVitamin>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PersistedVitamin persistedVitamin : list) {
					if (!uuid.equals(persistedVitamin.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_PERSISTEDVITAMIN_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(PersistedVitaminModelImpl.ORDER_BY_JPQL);
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
					list = (List<PersistedVitamin>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<PersistedVitamin>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception e) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first persisted vitamin in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted vitamin
	 * @throws NoSuchPersistedVitaminException if a matching persisted vitamin could not be found
	 */
	@Override
	public PersistedVitamin findByUuid_First(
			String uuid, OrderByComparator<PersistedVitamin> orderByComparator)
		throws NoSuchPersistedVitaminException {

		PersistedVitamin persistedVitamin = fetchByUuid_First(
			uuid, orderByComparator);

		if (persistedVitamin != null) {
			return persistedVitamin;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchPersistedVitaminException(msg.toString());
	}

	/**
	 * Returns the first persisted vitamin in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted vitamin, or <code>null</code> if a matching persisted vitamin could not be found
	 */
	@Override
	public PersistedVitamin fetchByUuid_First(
		String uuid, OrderByComparator<PersistedVitamin> orderByComparator) {

		List<PersistedVitamin> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last persisted vitamin in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted vitamin
	 * @throws NoSuchPersistedVitaminException if a matching persisted vitamin could not be found
	 */
	@Override
	public PersistedVitamin findByUuid_Last(
			String uuid, OrderByComparator<PersistedVitamin> orderByComparator)
		throws NoSuchPersistedVitaminException {

		PersistedVitamin persistedVitamin = fetchByUuid_Last(
			uuid, orderByComparator);

		if (persistedVitamin != null) {
			return persistedVitamin;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchPersistedVitaminException(msg.toString());
	}

	/**
	 * Returns the last persisted vitamin in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted vitamin, or <code>null</code> if a matching persisted vitamin could not be found
	 */
	@Override
	public PersistedVitamin fetchByUuid_Last(
		String uuid, OrderByComparator<PersistedVitamin> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<PersistedVitamin> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the persisted vitamins before and after the current persisted vitamin in the ordered set where uuid = &#63;.
	 *
	 * @param persistedVitaminId the primary key of the current persisted vitamin
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next persisted vitamin
	 * @throws NoSuchPersistedVitaminException if a persisted vitamin with the primary key could not be found
	 */
	@Override
	public PersistedVitamin[] findByUuid_PrevAndNext(
			long persistedVitaminId, String uuid,
			OrderByComparator<PersistedVitamin> orderByComparator)
		throws NoSuchPersistedVitaminException {

		uuid = Objects.toString(uuid, "");

		PersistedVitamin persistedVitamin = findByPrimaryKey(
			persistedVitaminId);

		Session session = null;

		try {
			session = openSession();

			PersistedVitamin[] array = new PersistedVitaminImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, persistedVitamin, uuid, orderByComparator, true);

			array[1] = persistedVitamin;

			array[2] = getByUuid_PrevAndNext(
				session, persistedVitamin, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PersistedVitamin getByUuid_PrevAndNext(
		Session session, PersistedVitamin persistedVitamin, String uuid,
		OrderByComparator<PersistedVitamin> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PERSISTEDVITAMIN_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

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
			query.append(PersistedVitaminModelImpl.ORDER_BY_JPQL);
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
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						persistedVitamin)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<PersistedVitamin> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the persisted vitamins where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (PersistedVitamin persistedVitamin :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(persistedVitamin);
		}
	}

	/**
	 * Returns the number of persisted vitamins where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching persisted vitamins
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PERSISTEDVITAMIN_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
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

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"persistedVitamin.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(persistedVitamin.uuid IS NULL OR persistedVitamin.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the persisted vitamin where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchPersistedVitaminException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching persisted vitamin
	 * @throws NoSuchPersistedVitaminException if a matching persisted vitamin could not be found
	 */
	@Override
	public PersistedVitamin findByUUID_G(String uuid, long groupId)
		throws NoSuchPersistedVitaminException {

		PersistedVitamin persistedVitamin = fetchByUUID_G(uuid, groupId);

		if (persistedVitamin == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchPersistedVitaminException(msg.toString());
		}

		return persistedVitamin;
	}

	/**
	 * Returns the persisted vitamin where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching persisted vitamin, or <code>null</code> if a matching persisted vitamin could not be found
	 */
	@Override
	public PersistedVitamin fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the persisted vitamin where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching persisted vitamin, or <code>null</code> if a matching persisted vitamin could not be found
	 */
	@Override
	public PersistedVitamin fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof PersistedVitamin) {
			PersistedVitamin persistedVitamin = (PersistedVitamin)result;

			if (!Objects.equals(uuid, persistedVitamin.getUuid()) ||
				(groupId != persistedVitamin.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_PERSISTEDVITAMIN_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<PersistedVitamin> list = q.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					PersistedVitamin persistedVitamin = list.get(0);

					result = persistedVitamin;

					cacheResult(persistedVitamin);
				}
			}
			catch (Exception e) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByUUID_G, finderArgs);
				}

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
			return (PersistedVitamin)result;
		}
	}

	/**
	 * Removes the persisted vitamin where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the persisted vitamin that was removed
	 */
	@Override
	public PersistedVitamin removeByUUID_G(String uuid, long groupId)
		throws NoSuchPersistedVitaminException {

		PersistedVitamin persistedVitamin = findByUUID_G(uuid, groupId);

		return remove(persistedVitamin);
	}

	/**
	 * Returns the number of persisted vitamins where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching persisted vitamins
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PERSISTEDVITAMIN_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"persistedVitamin.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(persistedVitamin.uuid IS NULL OR persistedVitamin.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"persistedVitamin.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the persisted vitamins where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching persisted vitamins
	 */
	@Override
	public List<PersistedVitamin> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the persisted vitamins where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedVitaminModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of persisted vitamins
	 * @param end the upper bound of the range of persisted vitamins (not inclusive)
	 * @return the range of matching persisted vitamins
	 */
	@Override
	public List<PersistedVitamin> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the persisted vitamins where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedVitaminModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of persisted vitamins
	 * @param end the upper bound of the range of persisted vitamins (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching persisted vitamins
	 */
	@Override
	public List<PersistedVitamin> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PersistedVitamin> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the persisted vitamins where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedVitaminModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of persisted vitamins
	 * @param end the upper bound of the range of persisted vitamins (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching persisted vitamins
	 */
	@Override
	public List<PersistedVitamin> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PersistedVitamin> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<PersistedVitamin> list = null;

		if (useFinderCache) {
			list = (List<PersistedVitamin>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PersistedVitamin persistedVitamin : list) {
					if (!uuid.equals(persistedVitamin.getUuid()) ||
						(companyId != persistedVitamin.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_PERSISTEDVITAMIN_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(PersistedVitaminModelImpl.ORDER_BY_JPQL);
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

				qPos.add(companyId);

				if (!pagination) {
					list = (List<PersistedVitamin>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<PersistedVitamin>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception e) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first persisted vitamin in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted vitamin
	 * @throws NoSuchPersistedVitaminException if a matching persisted vitamin could not be found
	 */
	@Override
	public PersistedVitamin findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<PersistedVitamin> orderByComparator)
		throws NoSuchPersistedVitaminException {

		PersistedVitamin persistedVitamin = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (persistedVitamin != null) {
			return persistedVitamin;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchPersistedVitaminException(msg.toString());
	}

	/**
	 * Returns the first persisted vitamin in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted vitamin, or <code>null</code> if a matching persisted vitamin could not be found
	 */
	@Override
	public PersistedVitamin fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<PersistedVitamin> orderByComparator) {

		List<PersistedVitamin> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last persisted vitamin in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted vitamin
	 * @throws NoSuchPersistedVitaminException if a matching persisted vitamin could not be found
	 */
	@Override
	public PersistedVitamin findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<PersistedVitamin> orderByComparator)
		throws NoSuchPersistedVitaminException {

		PersistedVitamin persistedVitamin = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (persistedVitamin != null) {
			return persistedVitamin;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchPersistedVitaminException(msg.toString());
	}

	/**
	 * Returns the last persisted vitamin in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted vitamin, or <code>null</code> if a matching persisted vitamin could not be found
	 */
	@Override
	public PersistedVitamin fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<PersistedVitamin> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<PersistedVitamin> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the persisted vitamins before and after the current persisted vitamin in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param persistedVitaminId the primary key of the current persisted vitamin
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next persisted vitamin
	 * @throws NoSuchPersistedVitaminException if a persisted vitamin with the primary key could not be found
	 */
	@Override
	public PersistedVitamin[] findByUuid_C_PrevAndNext(
			long persistedVitaminId, String uuid, long companyId,
			OrderByComparator<PersistedVitamin> orderByComparator)
		throws NoSuchPersistedVitaminException {

		uuid = Objects.toString(uuid, "");

		PersistedVitamin persistedVitamin = findByPrimaryKey(
			persistedVitaminId);

		Session session = null;

		try {
			session = openSession();

			PersistedVitamin[] array = new PersistedVitaminImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, persistedVitamin, uuid, companyId, orderByComparator,
				true);

			array[1] = persistedVitamin;

			array[2] = getByUuid_C_PrevAndNext(
				session, persistedVitamin, uuid, companyId, orderByComparator,
				false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PersistedVitamin getByUuid_C_PrevAndNext(
		Session session, PersistedVitamin persistedVitamin, String uuid,
		long companyId, OrderByComparator<PersistedVitamin> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_PERSISTEDVITAMIN_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

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
			query.append(PersistedVitaminModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						persistedVitamin)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<PersistedVitamin> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the persisted vitamins where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (PersistedVitamin persistedVitamin :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(persistedVitamin);
		}
	}

	/**
	 * Returns the number of persisted vitamins where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching persisted vitamins
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PERSISTEDVITAMIN_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"persistedVitamin.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(persistedVitamin.uuid IS NULL OR persistedVitamin.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"persistedVitamin.companyId = ?";

	private FinderPath _finderPathFetchBySurrogateId;
	private FinderPath _finderPathCountBySurrogateId;

	/**
	 * Returns the persisted vitamin where surrogateId = &#63; or throws a <code>NoSuchPersistedVitaminException</code> if it could not be found.
	 *
	 * @param surrogateId the surrogate ID
	 * @return the matching persisted vitamin
	 * @throws NoSuchPersistedVitaminException if a matching persisted vitamin could not be found
	 */
	@Override
	public PersistedVitamin findBySurrogateId(String surrogateId)
		throws NoSuchPersistedVitaminException {

		PersistedVitamin persistedVitamin = fetchBySurrogateId(surrogateId);

		if (persistedVitamin == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("surrogateId=");
			msg.append(surrogateId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchPersistedVitaminException(msg.toString());
		}

		return persistedVitamin;
	}

	/**
	 * Returns the persisted vitamin where surrogateId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param surrogateId the surrogate ID
	 * @return the matching persisted vitamin, or <code>null</code> if a matching persisted vitamin could not be found
	 */
	@Override
	public PersistedVitamin fetchBySurrogateId(String surrogateId) {
		return fetchBySurrogateId(surrogateId, true);
	}

	/**
	 * Returns the persisted vitamin where surrogateId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param surrogateId the surrogate ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching persisted vitamin, or <code>null</code> if a matching persisted vitamin could not be found
	 */
	@Override
	public PersistedVitamin fetchBySurrogateId(
		String surrogateId, boolean useFinderCache) {

		surrogateId = Objects.toString(surrogateId, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {surrogateId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBySurrogateId, finderArgs, this);
		}

		if (result instanceof PersistedVitamin) {
			PersistedVitamin persistedVitamin = (PersistedVitamin)result;

			if (!Objects.equals(
					surrogateId, persistedVitamin.getSurrogateId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_PERSISTEDVITAMIN_WHERE);

			boolean bindSurrogateId = false;

			if (surrogateId.isEmpty()) {
				query.append(_FINDER_COLUMN_SURROGATEID_SURROGATEID_3);
			}
			else {
				bindSurrogateId = true;

				query.append(_FINDER_COLUMN_SURROGATEID_SURROGATEID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindSurrogateId) {
					qPos.add(surrogateId);
				}

				List<PersistedVitamin> list = q.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBySurrogateId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {surrogateId};
							}

							_log.warn(
								"PersistedVitaminPersistenceImpl.fetchBySurrogateId(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					PersistedVitamin persistedVitamin = list.get(0);

					result = persistedVitamin;

					cacheResult(persistedVitamin);
				}
			}
			catch (Exception e) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchBySurrogateId, finderArgs);
				}

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
			return (PersistedVitamin)result;
		}
	}

	/**
	 * Removes the persisted vitamin where surrogateId = &#63; from the database.
	 *
	 * @param surrogateId the surrogate ID
	 * @return the persisted vitamin that was removed
	 */
	@Override
	public PersistedVitamin removeBySurrogateId(String surrogateId)
		throws NoSuchPersistedVitaminException {

		PersistedVitamin persistedVitamin = findBySurrogateId(surrogateId);

		return remove(persistedVitamin);
	}

	/**
	 * Returns the number of persisted vitamins where surrogateId = &#63;.
	 *
	 * @param surrogateId the surrogate ID
	 * @return the number of matching persisted vitamins
	 */
	@Override
	public int countBySurrogateId(String surrogateId) {
		surrogateId = Objects.toString(surrogateId, "");

		FinderPath finderPath = _finderPathCountBySurrogateId;

		Object[] finderArgs = new Object[] {surrogateId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PERSISTEDVITAMIN_WHERE);

			boolean bindSurrogateId = false;

			if (surrogateId.isEmpty()) {
				query.append(_FINDER_COLUMN_SURROGATEID_SURROGATEID_3);
			}
			else {
				bindSurrogateId = true;

				query.append(_FINDER_COLUMN_SURROGATEID_SURROGATEID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindSurrogateId) {
					qPos.add(surrogateId);
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

	private static final String _FINDER_COLUMN_SURROGATEID_SURROGATEID_2 =
		"persistedVitamin.surrogateId = ?";

	private static final String _FINDER_COLUMN_SURROGATEID_SURROGATEID_3 =
		"(persistedVitamin.surrogateId IS NULL OR persistedVitamin.surrogateId = '')";

	private FinderPath _finderPathFetchByName;
	private FinderPath _finderPathCountByName;

	/**
	 * Returns the persisted vitamin where name = &#63; or throws a <code>NoSuchPersistedVitaminException</code> if it could not be found.
	 *
	 * @param name the name
	 * @return the matching persisted vitamin
	 * @throws NoSuchPersistedVitaminException if a matching persisted vitamin could not be found
	 */
	@Override
	public PersistedVitamin findByName(String name)
		throws NoSuchPersistedVitaminException {

		PersistedVitamin persistedVitamin = fetchByName(name);

		if (persistedVitamin == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("name=");
			msg.append(name);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchPersistedVitaminException(msg.toString());
		}

		return persistedVitamin;
	}

	/**
	 * Returns the persisted vitamin where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching persisted vitamin, or <code>null</code> if a matching persisted vitamin could not be found
	 */
	@Override
	public PersistedVitamin fetchByName(String name) {
		return fetchByName(name, true);
	}

	/**
	 * Returns the persisted vitamin where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching persisted vitamin, or <code>null</code> if a matching persisted vitamin could not be found
	 */
	@Override
	public PersistedVitamin fetchByName(String name, boolean useFinderCache) {
		name = Objects.toString(name, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {name};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByName, finderArgs, this);
		}

		if (result instanceof PersistedVitamin) {
			PersistedVitamin persistedVitamin = (PersistedVitamin)result;

			if (!Objects.equals(name, persistedVitamin.getName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_PERSISTEDVITAMIN_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				List<PersistedVitamin> list = q.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByName, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {name};
							}

							_log.warn(
								"PersistedVitaminPersistenceImpl.fetchByName(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					PersistedVitamin persistedVitamin = list.get(0);

					result = persistedVitamin;

					cacheResult(persistedVitamin);
				}
			}
			catch (Exception e) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByName, finderArgs);
				}

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
			return (PersistedVitamin)result;
		}
	}

	/**
	 * Removes the persisted vitamin where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the persisted vitamin that was removed
	 */
	@Override
	public PersistedVitamin removeByName(String name)
		throws NoSuchPersistedVitaminException {

		PersistedVitamin persistedVitamin = findByName(name);

		return remove(persistedVitamin);
	}

	/**
	 * Returns the number of persisted vitamins where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching persisted vitamins
	 */
	@Override
	public int countByName(String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByName;

		Object[] finderArgs = new Object[] {name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PERSISTEDVITAMIN_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
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

	private static final String _FINDER_COLUMN_NAME_NAME_2 =
		"persistedVitamin.name = ?";

	private static final String _FINDER_COLUMN_NAME_NAME_3 =
		"(persistedVitamin.name IS NULL OR persistedVitamin.name = '')";

	public PersistedVitaminPersistenceImpl() {
		setModelClass(PersistedVitamin.class);

		setModelImplClass(PersistedVitaminImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("type", "type_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the persisted vitamin in the entity cache if it is enabled.
	 *
	 * @param persistedVitamin the persisted vitamin
	 */
	@Override
	public void cacheResult(PersistedVitamin persistedVitamin) {
		entityCache.putResult(
			entityCacheEnabled, PersistedVitaminImpl.class,
			persistedVitamin.getPrimaryKey(), persistedVitamin);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				persistedVitamin.getUuid(), persistedVitamin.getGroupId()
			},
			persistedVitamin);

		finderCache.putResult(
			_finderPathFetchBySurrogateId,
			new Object[] {persistedVitamin.getSurrogateId()}, persistedVitamin);

		finderCache.putResult(
			_finderPathFetchByName, new Object[] {persistedVitamin.getName()},
			persistedVitamin);

		persistedVitamin.resetOriginalValues();
	}

	/**
	 * Caches the persisted vitamins in the entity cache if it is enabled.
	 *
	 * @param persistedVitamins the persisted vitamins
	 */
	@Override
	public void cacheResult(List<PersistedVitamin> persistedVitamins) {
		for (PersistedVitamin persistedVitamin : persistedVitamins) {
			if (entityCache.getResult(
					entityCacheEnabled, PersistedVitaminImpl.class,
					persistedVitamin.getPrimaryKey()) == null) {

				cacheResult(persistedVitamin);
			}
			else {
				persistedVitamin.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all persisted vitamins.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PersistedVitaminImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the persisted vitamin.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PersistedVitamin persistedVitamin) {
		entityCache.removeResult(
			entityCacheEnabled, PersistedVitaminImpl.class,
			persistedVitamin.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(
			(PersistedVitaminModelImpl)persistedVitamin, true);
	}

	@Override
	public void clearCache(List<PersistedVitamin> persistedVitamins) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PersistedVitamin persistedVitamin : persistedVitamins) {
			entityCache.removeResult(
				entityCacheEnabled, PersistedVitaminImpl.class,
				persistedVitamin.getPrimaryKey());

			clearUniqueFindersCache(
				(PersistedVitaminModelImpl)persistedVitamin, true);
		}
	}

	protected void cacheUniqueFindersCache(
		PersistedVitaminModelImpl persistedVitaminModelImpl) {

		Object[] args = new Object[] {
			persistedVitaminModelImpl.getUuid(),
			persistedVitaminModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, persistedVitaminModelImpl, false);

		args = new Object[] {persistedVitaminModelImpl.getSurrogateId()};

		finderCache.putResult(
			_finderPathCountBySurrogateId, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchBySurrogateId, args, persistedVitaminModelImpl,
			false);

		args = new Object[] {persistedVitaminModelImpl.getName()};

		finderCache.putResult(
			_finderPathCountByName, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByName, args, persistedVitaminModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		PersistedVitaminModelImpl persistedVitaminModelImpl,
		boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				persistedVitaminModelImpl.getUuid(),
				persistedVitaminModelImpl.getGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if ((persistedVitaminModelImpl.getColumnBitmask() &
			 _finderPathFetchByUUID_G.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				persistedVitaminModelImpl.getOriginalUuid(),
				persistedVitaminModelImpl.getOriginalGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
				persistedVitaminModelImpl.getSurrogateId()
			};

			finderCache.removeResult(_finderPathCountBySurrogateId, args);
			finderCache.removeResult(_finderPathFetchBySurrogateId, args);
		}

		if ((persistedVitaminModelImpl.getColumnBitmask() &
			 _finderPathFetchBySurrogateId.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				persistedVitaminModelImpl.getOriginalSurrogateId()
			};

			finderCache.removeResult(_finderPathCountBySurrogateId, args);
			finderCache.removeResult(_finderPathFetchBySurrogateId, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {persistedVitaminModelImpl.getName()};

			finderCache.removeResult(_finderPathCountByName, args);
			finderCache.removeResult(_finderPathFetchByName, args);
		}

		if ((persistedVitaminModelImpl.getColumnBitmask() &
			 _finderPathFetchByName.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				persistedVitaminModelImpl.getOriginalName()
			};

			finderCache.removeResult(_finderPathCountByName, args);
			finderCache.removeResult(_finderPathFetchByName, args);
		}
	}

	/**
	 * Creates a new persisted vitamin with the primary key. Does not add the persisted vitamin to the database.
	 *
	 * @param persistedVitaminId the primary key for the new persisted vitamin
	 * @return the new persisted vitamin
	 */
	@Override
	public PersistedVitamin create(long persistedVitaminId) {
		PersistedVitamin persistedVitamin = new PersistedVitaminImpl();

		persistedVitamin.setNew(true);
		persistedVitamin.setPrimaryKey(persistedVitaminId);

		String uuid = PortalUUIDUtil.generate();

		persistedVitamin.setUuid(uuid);

		persistedVitamin.setCompanyId(CompanyThreadLocal.getCompanyId());

		return persistedVitamin;
	}

	/**
	 * Removes the persisted vitamin with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param persistedVitaminId the primary key of the persisted vitamin
	 * @return the persisted vitamin that was removed
	 * @throws NoSuchPersistedVitaminException if a persisted vitamin with the primary key could not be found
	 */
	@Override
	public PersistedVitamin remove(long persistedVitaminId)
		throws NoSuchPersistedVitaminException {

		return remove((Serializable)persistedVitaminId);
	}

	/**
	 * Removes the persisted vitamin with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the persisted vitamin
	 * @return the persisted vitamin that was removed
	 * @throws NoSuchPersistedVitaminException if a persisted vitamin with the primary key could not be found
	 */
	@Override
	public PersistedVitamin remove(Serializable primaryKey)
		throws NoSuchPersistedVitaminException {

		Session session = null;

		try {
			session = openSession();

			PersistedVitamin persistedVitamin = (PersistedVitamin)session.get(
				PersistedVitaminImpl.class, primaryKey);

			if (persistedVitamin == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPersistedVitaminException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(persistedVitamin);
		}
		catch (NoSuchPersistedVitaminException nsee) {
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
	protected PersistedVitamin removeImpl(PersistedVitamin persistedVitamin) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(persistedVitamin)) {
				persistedVitamin = (PersistedVitamin)session.get(
					PersistedVitaminImpl.class,
					persistedVitamin.getPrimaryKeyObj());
			}

			if (persistedVitamin != null) {
				session.delete(persistedVitamin);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (persistedVitamin != null) {
			clearCache(persistedVitamin);
		}

		return persistedVitamin;
	}

	@Override
	public PersistedVitamin updateImpl(PersistedVitamin persistedVitamin) {
		boolean isNew = persistedVitamin.isNew();

		if (!(persistedVitamin instanceof PersistedVitaminModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(persistedVitamin.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					persistedVitamin);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in persistedVitamin proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PersistedVitamin implementation " +
					persistedVitamin.getClass());
		}

		PersistedVitaminModelImpl persistedVitaminModelImpl =
			(PersistedVitaminModelImpl)persistedVitamin;

		if (Validator.isNull(persistedVitamin.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			persistedVitamin.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (persistedVitamin.getCreateDate() == null)) {
			if (serviceContext == null) {
				persistedVitamin.setCreateDate(now);
			}
			else {
				persistedVitamin.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!persistedVitaminModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				persistedVitamin.setModifiedDate(now);
			}
			else {
				persistedVitamin.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		long userId = GetterUtil.getLong(PrincipalThreadLocal.getName());

		if (userId > 0) {
			long companyId = persistedVitamin.getCompanyId();

			long groupId = persistedVitamin.getGroupId();

			long persistedVitaminId = 0;

			if (!isNew) {
				persistedVitaminId = persistedVitamin.getPrimaryKey();
			}

			try {
				persistedVitamin.setGroupName(
					SanitizerUtil.sanitize(
						companyId, groupId, userId,
						PersistedVitamin.class.getName(), persistedVitaminId,
						ContentTypes.TEXT_PLAIN, Sanitizer.MODE_ALL,
						persistedVitamin.getGroupName(), null));

				persistedVitamin.setDescription(
					SanitizerUtil.sanitize(
						companyId, groupId, userId,
						PersistedVitamin.class.getName(), persistedVitaminId,
						ContentTypes.TEXT_PLAIN, Sanitizer.MODE_ALL,
						persistedVitamin.getDescription(), null));

				persistedVitamin.setName(
					SanitizerUtil.sanitize(
						companyId, groupId, userId,
						PersistedVitamin.class.getName(), persistedVitaminId,
						ContentTypes.TEXT_PLAIN, Sanitizer.MODE_ALL,
						persistedVitamin.getName(), null));
			}
			catch (SanitizerException se) {
				throw new SystemException(se);
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (persistedVitamin.isNew()) {
				session.save(persistedVitamin);

				persistedVitamin.setNew(false);
			}
			else {
				persistedVitamin = (PersistedVitamin)session.merge(
					persistedVitamin);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!_columnBitmaskEnabled) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {persistedVitaminModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {
				persistedVitaminModelImpl.getUuid(),
				persistedVitaminModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByUuid_C, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid_C, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((persistedVitaminModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					persistedVitaminModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {persistedVitaminModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((persistedVitaminModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid_C.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					persistedVitaminModelImpl.getOriginalUuid(),
					persistedVitaminModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);

				args = new Object[] {
					persistedVitaminModelImpl.getUuid(),
					persistedVitaminModelImpl.getCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, PersistedVitaminImpl.class,
			persistedVitamin.getPrimaryKey(), persistedVitamin, false);

		clearUniqueFindersCache(persistedVitaminModelImpl, false);
		cacheUniqueFindersCache(persistedVitaminModelImpl);

		persistedVitamin.resetOriginalValues();

		return persistedVitamin;
	}

	/**
	 * Returns the persisted vitamin with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the persisted vitamin
	 * @return the persisted vitamin
	 * @throws NoSuchPersistedVitaminException if a persisted vitamin with the primary key could not be found
	 */
	@Override
	public PersistedVitamin findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPersistedVitaminException {

		PersistedVitamin persistedVitamin = fetchByPrimaryKey(primaryKey);

		if (persistedVitamin == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPersistedVitaminException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return persistedVitamin;
	}

	/**
	 * Returns the persisted vitamin with the primary key or throws a <code>NoSuchPersistedVitaminException</code> if it could not be found.
	 *
	 * @param persistedVitaminId the primary key of the persisted vitamin
	 * @return the persisted vitamin
	 * @throws NoSuchPersistedVitaminException if a persisted vitamin with the primary key could not be found
	 */
	@Override
	public PersistedVitamin findByPrimaryKey(long persistedVitaminId)
		throws NoSuchPersistedVitaminException {

		return findByPrimaryKey((Serializable)persistedVitaminId);
	}

	/**
	 * Returns the persisted vitamin with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param persistedVitaminId the primary key of the persisted vitamin
	 * @return the persisted vitamin, or <code>null</code> if a persisted vitamin with the primary key could not be found
	 */
	@Override
	public PersistedVitamin fetchByPrimaryKey(long persistedVitaminId) {
		return fetchByPrimaryKey((Serializable)persistedVitaminId);
	}

	/**
	 * Returns all the persisted vitamins.
	 *
	 * @return the persisted vitamins
	 */
	@Override
	public List<PersistedVitamin> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the persisted vitamins.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedVitaminModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted vitamins
	 * @param end the upper bound of the range of persisted vitamins (not inclusive)
	 * @return the range of persisted vitamins
	 */
	@Override
	public List<PersistedVitamin> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the persisted vitamins.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedVitaminModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted vitamins
	 * @param end the upper bound of the range of persisted vitamins (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of persisted vitamins
	 */
	@Override
	public List<PersistedVitamin> findAll(
		int start, int end,
		OrderByComparator<PersistedVitamin> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the persisted vitamins.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedVitaminModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted vitamins
	 * @param end the upper bound of the range of persisted vitamins (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of persisted vitamins
	 */
	@Override
	public List<PersistedVitamin> findAll(
		int start, int end,
		OrderByComparator<PersistedVitamin> orderByComparator,
		boolean useFinderCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<PersistedVitamin> list = null;

		if (useFinderCache) {
			list = (List<PersistedVitamin>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PERSISTEDVITAMIN);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PERSISTEDVITAMIN;

				if (pagination) {
					sql = sql.concat(PersistedVitaminModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<PersistedVitamin>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<PersistedVitamin>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception e) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the persisted vitamins from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PersistedVitamin persistedVitamin : findAll()) {
			remove(persistedVitamin);
		}
	}

	/**
	 * Returns the number of persisted vitamins.
	 *
	 * @return the number of persisted vitamins
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PERSISTEDVITAMIN);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

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
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "persistedVitaminId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PERSISTEDVITAMIN;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PersistedVitaminModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the persisted vitamin persistence.
	 */
	@Activate
	public void activate() {
		PersistedVitaminModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		PersistedVitaminModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, PersistedVitaminImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, PersistedVitaminImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, PersistedVitaminImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, PersistedVitaminImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			PersistedVitaminModelImpl.UUID_COLUMN_BITMASK |
			PersistedVitaminModelImpl.NAME_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathFetchByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, PersistedVitaminImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			PersistedVitaminModelImpl.UUID_COLUMN_BITMASK |
			PersistedVitaminModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, PersistedVitaminImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, PersistedVitaminImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			PersistedVitaminModelImpl.UUID_COLUMN_BITMASK |
			PersistedVitaminModelImpl.COMPANYID_COLUMN_BITMASK |
			PersistedVitaminModelImpl.NAME_COLUMN_BITMASK);

		_finderPathCountByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathFetchBySurrogateId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, PersistedVitaminImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchBySurrogateId",
			new String[] {String.class.getName()},
			PersistedVitaminModelImpl.SURROGATEID_COLUMN_BITMASK);

		_finderPathCountBySurrogateId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySurrogateId",
			new String[] {String.class.getName()});

		_finderPathFetchByName = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, PersistedVitaminImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByName",
			new String[] {String.class.getName()},
			PersistedVitaminModelImpl.NAME_COLUMN_BITMASK);

		_finderPathCountByName = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] {String.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(PersistedVitaminImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = NEBPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.dnebinger.vitamins.model.PersistedVitamin"),
			true);
	}

	@Override
	@Reference(
		target = NEBPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = NEBPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private boolean _columnBitmaskEnabled;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_PERSISTEDVITAMIN =
		"SELECT persistedVitamin FROM PersistedVitamin persistedVitamin";

	private static final String _SQL_SELECT_PERSISTEDVITAMIN_WHERE =
		"SELECT persistedVitamin FROM PersistedVitamin persistedVitamin WHERE ";

	private static final String _SQL_COUNT_PERSISTEDVITAMIN =
		"SELECT COUNT(persistedVitamin) FROM PersistedVitamin persistedVitamin";

	private static final String _SQL_COUNT_PERSISTEDVITAMIN_WHERE =
		"SELECT COUNT(persistedVitamin) FROM PersistedVitamin persistedVitamin WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "persistedVitamin.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PersistedVitamin exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No PersistedVitamin exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PersistedVitaminPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "type"});

	static {
		try {
			Class.forName(NEBPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException cnfe) {
			throw new ExceptionInInitializerError(cnfe);
		}
	}

}