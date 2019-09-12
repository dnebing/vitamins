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

import com.dnebinger.vitamins.exception.NoSuchVitaminDetailException;
import com.dnebinger.vitamins.model.VitaminDetail;
import com.dnebinger.vitamins.model.impl.VitaminDetailImpl;
import com.dnebinger.vitamins.model.impl.VitaminDetailModelImpl;
import com.dnebinger.vitamins.service.persistence.VitaminDetailPersistence;
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
 * The persistence implementation for the vitamin detail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = VitaminDetailPersistence.class)
@ProviderType
public class VitaminDetailPersistenceImpl
	extends BasePersistenceImpl<VitaminDetail>
	implements VitaminDetailPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>VitaminDetailUtil</code> to access the vitamin detail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		VitaminDetailImpl.class.getName();

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
	 * Returns all the vitamin details where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching vitamin details
	 */
	@Override
	public List<VitaminDetail> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vitamin details where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VitaminDetailModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of vitamin details
	 * @param end the upper bound of the range of vitamin details (not inclusive)
	 * @return the range of matching vitamin details
	 */
	@Override
	public List<VitaminDetail> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vitamin details where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VitaminDetailModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of vitamin details
	 * @param end the upper bound of the range of vitamin details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vitamin details
	 */
	@Override
	public List<VitaminDetail> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<VitaminDetail> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the vitamin details where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VitaminDetailModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of vitamin details
	 * @param end the upper bound of the range of vitamin details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching vitamin details
	 */
	@Override
	public List<VitaminDetail> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<VitaminDetail> orderByComparator,
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

		List<VitaminDetail> list = null;

		if (useFinderCache) {
			list = (List<VitaminDetail>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (VitaminDetail vitaminDetail : list) {
					if (!uuid.equals(vitaminDetail.getUuid())) {
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

			query.append(_SQL_SELECT_VITAMINDETAIL_WHERE);

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
				query.append(VitaminDetailModelImpl.ORDER_BY_JPQL);
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
					list = (List<VitaminDetail>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<VitaminDetail>)QueryUtil.list(
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
	 * Returns the first vitamin detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vitamin detail
	 * @throws NoSuchVitaminDetailException if a matching vitamin detail could not be found
	 */
	@Override
	public VitaminDetail findByUuid_First(
			String uuid, OrderByComparator<VitaminDetail> orderByComparator)
		throws NoSuchVitaminDetailException {

		VitaminDetail vitaminDetail = fetchByUuid_First(
			uuid, orderByComparator);

		if (vitaminDetail != null) {
			return vitaminDetail;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchVitaminDetailException(msg.toString());
	}

	/**
	 * Returns the first vitamin detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vitamin detail, or <code>null</code> if a matching vitamin detail could not be found
	 */
	@Override
	public VitaminDetail fetchByUuid_First(
		String uuid, OrderByComparator<VitaminDetail> orderByComparator) {

		List<VitaminDetail> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last vitamin detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vitamin detail
	 * @throws NoSuchVitaminDetailException if a matching vitamin detail could not be found
	 */
	@Override
	public VitaminDetail findByUuid_Last(
			String uuid, OrderByComparator<VitaminDetail> orderByComparator)
		throws NoSuchVitaminDetailException {

		VitaminDetail vitaminDetail = fetchByUuid_Last(uuid, orderByComparator);

		if (vitaminDetail != null) {
			return vitaminDetail;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchVitaminDetailException(msg.toString());
	}

	/**
	 * Returns the last vitamin detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vitamin detail, or <code>null</code> if a matching vitamin detail could not be found
	 */
	@Override
	public VitaminDetail fetchByUuid_Last(
		String uuid, OrderByComparator<VitaminDetail> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<VitaminDetail> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the vitamin details before and after the current vitamin detail in the ordered set where uuid = &#63;.
	 *
	 * @param vitaminDetailId the primary key of the current vitamin detail
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vitamin detail
	 * @throws NoSuchVitaminDetailException if a vitamin detail with the primary key could not be found
	 */
	@Override
	public VitaminDetail[] findByUuid_PrevAndNext(
			long vitaminDetailId, String uuid,
			OrderByComparator<VitaminDetail> orderByComparator)
		throws NoSuchVitaminDetailException {

		uuid = Objects.toString(uuid, "");

		VitaminDetail vitaminDetail = findByPrimaryKey(vitaminDetailId);

		Session session = null;

		try {
			session = openSession();

			VitaminDetail[] array = new VitaminDetailImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, vitaminDetail, uuid, orderByComparator, true);

			array[1] = vitaminDetail;

			array[2] = getByUuid_PrevAndNext(
				session, vitaminDetail, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VitaminDetail getByUuid_PrevAndNext(
		Session session, VitaminDetail vitaminDetail, String uuid,
		OrderByComparator<VitaminDetail> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VITAMINDETAIL_WHERE);

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
			query.append(VitaminDetailModelImpl.ORDER_BY_JPQL);
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
						vitaminDetail)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<VitaminDetail> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the vitamin details where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (VitaminDetail vitaminDetail :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(vitaminDetail);
		}
	}

	/**
	 * Returns the number of vitamin details where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching vitamin details
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VITAMINDETAIL_WHERE);

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
		"vitaminDetail.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(vitaminDetail.uuid IS NULL OR vitaminDetail.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the vitamin detail where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchVitaminDetailException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching vitamin detail
	 * @throws NoSuchVitaminDetailException if a matching vitamin detail could not be found
	 */
	@Override
	public VitaminDetail findByUUID_G(String uuid, long groupId)
		throws NoSuchVitaminDetailException {

		VitaminDetail vitaminDetail = fetchByUUID_G(uuid, groupId);

		if (vitaminDetail == null) {
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

			throw new NoSuchVitaminDetailException(msg.toString());
		}

		return vitaminDetail;
	}

	/**
	 * Returns the vitamin detail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching vitamin detail, or <code>null</code> if a matching vitamin detail could not be found
	 */
	@Override
	public VitaminDetail fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the vitamin detail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching vitamin detail, or <code>null</code> if a matching vitamin detail could not be found
	 */
	@Override
	public VitaminDetail fetchByUUID_G(
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

		if (result instanceof VitaminDetail) {
			VitaminDetail vitaminDetail = (VitaminDetail)result;

			if (!Objects.equals(uuid, vitaminDetail.getUuid()) ||
				(groupId != vitaminDetail.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_VITAMINDETAIL_WHERE);

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

				List<VitaminDetail> list = q.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					VitaminDetail vitaminDetail = list.get(0);

					result = vitaminDetail;

					cacheResult(vitaminDetail);
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
			return (VitaminDetail)result;
		}
	}

	/**
	 * Removes the vitamin detail where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the vitamin detail that was removed
	 */
	@Override
	public VitaminDetail removeByUUID_G(String uuid, long groupId)
		throws NoSuchVitaminDetailException {

		VitaminDetail vitaminDetail = findByUUID_G(uuid, groupId);

		return remove(vitaminDetail);
	}

	/**
	 * Returns the number of vitamin details where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching vitamin details
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VITAMINDETAIL_WHERE);

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
		"vitaminDetail.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(vitaminDetail.uuid IS NULL OR vitaminDetail.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"vitaminDetail.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the vitamin details where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching vitamin details
	 */
	@Override
	public List<VitaminDetail> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vitamin details where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VitaminDetailModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of vitamin details
	 * @param end the upper bound of the range of vitamin details (not inclusive)
	 * @return the range of matching vitamin details
	 */
	@Override
	public List<VitaminDetail> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vitamin details where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VitaminDetailModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of vitamin details
	 * @param end the upper bound of the range of vitamin details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vitamin details
	 */
	@Override
	public List<VitaminDetail> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<VitaminDetail> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the vitamin details where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VitaminDetailModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of vitamin details
	 * @param end the upper bound of the range of vitamin details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching vitamin details
	 */
	@Override
	public List<VitaminDetail> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<VitaminDetail> orderByComparator,
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

		List<VitaminDetail> list = null;

		if (useFinderCache) {
			list = (List<VitaminDetail>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (VitaminDetail vitaminDetail : list) {
					if (!uuid.equals(vitaminDetail.getUuid()) ||
						(companyId != vitaminDetail.getCompanyId())) {

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

			query.append(_SQL_SELECT_VITAMINDETAIL_WHERE);

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
				query.append(VitaminDetailModelImpl.ORDER_BY_JPQL);
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
					list = (List<VitaminDetail>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<VitaminDetail>)QueryUtil.list(
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
	 * Returns the first vitamin detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vitamin detail
	 * @throws NoSuchVitaminDetailException if a matching vitamin detail could not be found
	 */
	@Override
	public VitaminDetail findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<VitaminDetail> orderByComparator)
		throws NoSuchVitaminDetailException {

		VitaminDetail vitaminDetail = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (vitaminDetail != null) {
			return vitaminDetail;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchVitaminDetailException(msg.toString());
	}

	/**
	 * Returns the first vitamin detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vitamin detail, or <code>null</code> if a matching vitamin detail could not be found
	 */
	@Override
	public VitaminDetail fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<VitaminDetail> orderByComparator) {

		List<VitaminDetail> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last vitamin detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vitamin detail
	 * @throws NoSuchVitaminDetailException if a matching vitamin detail could not be found
	 */
	@Override
	public VitaminDetail findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<VitaminDetail> orderByComparator)
		throws NoSuchVitaminDetailException {

		VitaminDetail vitaminDetail = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (vitaminDetail != null) {
			return vitaminDetail;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchVitaminDetailException(msg.toString());
	}

	/**
	 * Returns the last vitamin detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vitamin detail, or <code>null</code> if a matching vitamin detail could not be found
	 */
	@Override
	public VitaminDetail fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<VitaminDetail> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<VitaminDetail> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the vitamin details before and after the current vitamin detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param vitaminDetailId the primary key of the current vitamin detail
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vitamin detail
	 * @throws NoSuchVitaminDetailException if a vitamin detail with the primary key could not be found
	 */
	@Override
	public VitaminDetail[] findByUuid_C_PrevAndNext(
			long vitaminDetailId, String uuid, long companyId,
			OrderByComparator<VitaminDetail> orderByComparator)
		throws NoSuchVitaminDetailException {

		uuid = Objects.toString(uuid, "");

		VitaminDetail vitaminDetail = findByPrimaryKey(vitaminDetailId);

		Session session = null;

		try {
			session = openSession();

			VitaminDetail[] array = new VitaminDetailImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, vitaminDetail, uuid, companyId, orderByComparator,
				true);

			array[1] = vitaminDetail;

			array[2] = getByUuid_C_PrevAndNext(
				session, vitaminDetail, uuid, companyId, orderByComparator,
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

	protected VitaminDetail getByUuid_C_PrevAndNext(
		Session session, VitaminDetail vitaminDetail, String uuid,
		long companyId, OrderByComparator<VitaminDetail> orderByComparator,
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

		query.append(_SQL_SELECT_VITAMINDETAIL_WHERE);

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
			query.append(VitaminDetailModelImpl.ORDER_BY_JPQL);
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
						vitaminDetail)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<VitaminDetail> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the vitamin details where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (VitaminDetail vitaminDetail :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(vitaminDetail);
		}
	}

	/**
	 * Returns the number of vitamin details where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching vitamin details
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VITAMINDETAIL_WHERE);

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
		"vitaminDetail.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(vitaminDetail.uuid IS NULL OR vitaminDetail.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"vitaminDetail.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByPersistedVitaminId;
	private FinderPath _finderPathWithoutPaginationFindByPersistedVitaminId;
	private FinderPath _finderPathCountByPersistedVitaminId;

	/**
	 * Returns all the vitamin details where persistedVitaminId = &#63;.
	 *
	 * @param persistedVitaminId the persisted vitamin ID
	 * @return the matching vitamin details
	 */
	@Override
	public List<VitaminDetail> findByPersistedVitaminId(
		long persistedVitaminId) {

		return findByPersistedVitaminId(
			persistedVitaminId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vitamin details where persistedVitaminId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VitaminDetailModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param persistedVitaminId the persisted vitamin ID
	 * @param start the lower bound of the range of vitamin details
	 * @param end the upper bound of the range of vitamin details (not inclusive)
	 * @return the range of matching vitamin details
	 */
	@Override
	public List<VitaminDetail> findByPersistedVitaminId(
		long persistedVitaminId, int start, int end) {

		return findByPersistedVitaminId(persistedVitaminId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vitamin details where persistedVitaminId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VitaminDetailModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param persistedVitaminId the persisted vitamin ID
	 * @param start the lower bound of the range of vitamin details
	 * @param end the upper bound of the range of vitamin details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vitamin details
	 */
	@Override
	public List<VitaminDetail> findByPersistedVitaminId(
		long persistedVitaminId, int start, int end,
		OrderByComparator<VitaminDetail> orderByComparator) {

		return findByPersistedVitaminId(
			persistedVitaminId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the vitamin details where persistedVitaminId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VitaminDetailModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param persistedVitaminId the persisted vitamin ID
	 * @param start the lower bound of the range of vitamin details
	 * @param end the upper bound of the range of vitamin details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching vitamin details
	 */
	@Override
	public List<VitaminDetail> findByPersistedVitaminId(
		long persistedVitaminId, int start, int end,
		OrderByComparator<VitaminDetail> orderByComparator,
		boolean useFinderCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByPersistedVitaminId;
				finderArgs = new Object[] {persistedVitaminId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByPersistedVitaminId;
			finderArgs = new Object[] {
				persistedVitaminId, start, end, orderByComparator
			};
		}

		List<VitaminDetail> list = null;

		if (useFinderCache) {
			list = (List<VitaminDetail>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (VitaminDetail vitaminDetail : list) {
					if ((persistedVitaminId !=
							vitaminDetail.getPersistedVitaminId())) {

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

			query.append(_SQL_SELECT_VITAMINDETAIL_WHERE);

			query.append(
				_FINDER_COLUMN_PERSISTEDVITAMINID_PERSISTEDVITAMINID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(VitaminDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(persistedVitaminId);

				if (!pagination) {
					list = (List<VitaminDetail>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<VitaminDetail>)QueryUtil.list(
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
	 * Returns the first vitamin detail in the ordered set where persistedVitaminId = &#63;.
	 *
	 * @param persistedVitaminId the persisted vitamin ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vitamin detail
	 * @throws NoSuchVitaminDetailException if a matching vitamin detail could not be found
	 */
	@Override
	public VitaminDetail findByPersistedVitaminId_First(
			long persistedVitaminId,
			OrderByComparator<VitaminDetail> orderByComparator)
		throws NoSuchVitaminDetailException {

		VitaminDetail vitaminDetail = fetchByPersistedVitaminId_First(
			persistedVitaminId, orderByComparator);

		if (vitaminDetail != null) {
			return vitaminDetail;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("persistedVitaminId=");
		msg.append(persistedVitaminId);

		msg.append("}");

		throw new NoSuchVitaminDetailException(msg.toString());
	}

	/**
	 * Returns the first vitamin detail in the ordered set where persistedVitaminId = &#63;.
	 *
	 * @param persistedVitaminId the persisted vitamin ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vitamin detail, or <code>null</code> if a matching vitamin detail could not be found
	 */
	@Override
	public VitaminDetail fetchByPersistedVitaminId_First(
		long persistedVitaminId,
		OrderByComparator<VitaminDetail> orderByComparator) {

		List<VitaminDetail> list = findByPersistedVitaminId(
			persistedVitaminId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last vitamin detail in the ordered set where persistedVitaminId = &#63;.
	 *
	 * @param persistedVitaminId the persisted vitamin ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vitamin detail
	 * @throws NoSuchVitaminDetailException if a matching vitamin detail could not be found
	 */
	@Override
	public VitaminDetail findByPersistedVitaminId_Last(
			long persistedVitaminId,
			OrderByComparator<VitaminDetail> orderByComparator)
		throws NoSuchVitaminDetailException {

		VitaminDetail vitaminDetail = fetchByPersistedVitaminId_Last(
			persistedVitaminId, orderByComparator);

		if (vitaminDetail != null) {
			return vitaminDetail;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("persistedVitaminId=");
		msg.append(persistedVitaminId);

		msg.append("}");

		throw new NoSuchVitaminDetailException(msg.toString());
	}

	/**
	 * Returns the last vitamin detail in the ordered set where persistedVitaminId = &#63;.
	 *
	 * @param persistedVitaminId the persisted vitamin ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vitamin detail, or <code>null</code> if a matching vitamin detail could not be found
	 */
	@Override
	public VitaminDetail fetchByPersistedVitaminId_Last(
		long persistedVitaminId,
		OrderByComparator<VitaminDetail> orderByComparator) {

		int count = countByPersistedVitaminId(persistedVitaminId);

		if (count == 0) {
			return null;
		}

		List<VitaminDetail> list = findByPersistedVitaminId(
			persistedVitaminId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the vitamin details before and after the current vitamin detail in the ordered set where persistedVitaminId = &#63;.
	 *
	 * @param vitaminDetailId the primary key of the current vitamin detail
	 * @param persistedVitaminId the persisted vitamin ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vitamin detail
	 * @throws NoSuchVitaminDetailException if a vitamin detail with the primary key could not be found
	 */
	@Override
	public VitaminDetail[] findByPersistedVitaminId_PrevAndNext(
			long vitaminDetailId, long persistedVitaminId,
			OrderByComparator<VitaminDetail> orderByComparator)
		throws NoSuchVitaminDetailException {

		VitaminDetail vitaminDetail = findByPrimaryKey(vitaminDetailId);

		Session session = null;

		try {
			session = openSession();

			VitaminDetail[] array = new VitaminDetailImpl[3];

			array[0] = getByPersistedVitaminId_PrevAndNext(
				session, vitaminDetail, persistedVitaminId, orderByComparator,
				true);

			array[1] = vitaminDetail;

			array[2] = getByPersistedVitaminId_PrevAndNext(
				session, vitaminDetail, persistedVitaminId, orderByComparator,
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

	protected VitaminDetail getByPersistedVitaminId_PrevAndNext(
		Session session, VitaminDetail vitaminDetail, long persistedVitaminId,
		OrderByComparator<VitaminDetail> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VITAMINDETAIL_WHERE);

		query.append(_FINDER_COLUMN_PERSISTEDVITAMINID_PERSISTEDVITAMINID_2);

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
			query.append(VitaminDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(persistedVitaminId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						vitaminDetail)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<VitaminDetail> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the vitamin details where persistedVitaminId = &#63; from the database.
	 *
	 * @param persistedVitaminId the persisted vitamin ID
	 */
	@Override
	public void removeByPersistedVitaminId(long persistedVitaminId) {
		for (VitaminDetail vitaminDetail :
				findByPersistedVitaminId(
					persistedVitaminId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(vitaminDetail);
		}
	}

	/**
	 * Returns the number of vitamin details where persistedVitaminId = &#63;.
	 *
	 * @param persistedVitaminId the persisted vitamin ID
	 * @return the number of matching vitamin details
	 */
	@Override
	public int countByPersistedVitaminId(long persistedVitaminId) {
		FinderPath finderPath = _finderPathCountByPersistedVitaminId;

		Object[] finderArgs = new Object[] {persistedVitaminId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VITAMINDETAIL_WHERE);

			query.append(
				_FINDER_COLUMN_PERSISTEDVITAMINID_PERSISTEDVITAMINID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(persistedVitaminId);

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

	private static final String
		_FINDER_COLUMN_PERSISTEDVITAMINID_PERSISTEDVITAMINID_2 =
			"vitaminDetail.persistedVitaminId = ?";

	private FinderPath _finderPathWithPaginationFindByPersistedVitaminIdType;
	private FinderPath _finderPathWithoutPaginationFindByPersistedVitaminIdType;
	private FinderPath _finderPathCountByPersistedVitaminIdType;

	/**
	 * Returns all the vitamin details where persistedVitaminId = &#63; and type = &#63;.
	 *
	 * @param persistedVitaminId the persisted vitamin ID
	 * @param type the type
	 * @return the matching vitamin details
	 */
	@Override
	public List<VitaminDetail> findByPersistedVitaminIdType(
		long persistedVitaminId, int type) {

		return findByPersistedVitaminIdType(
			persistedVitaminId, type, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the vitamin details where persistedVitaminId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VitaminDetailModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param persistedVitaminId the persisted vitamin ID
	 * @param type the type
	 * @param start the lower bound of the range of vitamin details
	 * @param end the upper bound of the range of vitamin details (not inclusive)
	 * @return the range of matching vitamin details
	 */
	@Override
	public List<VitaminDetail> findByPersistedVitaminIdType(
		long persistedVitaminId, int type, int start, int end) {

		return findByPersistedVitaminIdType(
			persistedVitaminId, type, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vitamin details where persistedVitaminId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VitaminDetailModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param persistedVitaminId the persisted vitamin ID
	 * @param type the type
	 * @param start the lower bound of the range of vitamin details
	 * @param end the upper bound of the range of vitamin details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vitamin details
	 */
	@Override
	public List<VitaminDetail> findByPersistedVitaminIdType(
		long persistedVitaminId, int type, int start, int end,
		OrderByComparator<VitaminDetail> orderByComparator) {

		return findByPersistedVitaminIdType(
			persistedVitaminId, type, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the vitamin details where persistedVitaminId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VitaminDetailModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param persistedVitaminId the persisted vitamin ID
	 * @param type the type
	 * @param start the lower bound of the range of vitamin details
	 * @param end the upper bound of the range of vitamin details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching vitamin details
	 */
	@Override
	public List<VitaminDetail> findByPersistedVitaminIdType(
		long persistedVitaminId, int type, int start, int end,
		OrderByComparator<VitaminDetail> orderByComparator,
		boolean useFinderCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByPersistedVitaminIdType;
				finderArgs = new Object[] {persistedVitaminId, type};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByPersistedVitaminIdType;
			finderArgs = new Object[] {
				persistedVitaminId, type, start, end, orderByComparator
			};
		}

		List<VitaminDetail> list = null;

		if (useFinderCache) {
			list = (List<VitaminDetail>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (VitaminDetail vitaminDetail : list) {
					if ((persistedVitaminId !=
							vitaminDetail.getPersistedVitaminId()) ||
						(type != vitaminDetail.getType())) {

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

			query.append(_SQL_SELECT_VITAMINDETAIL_WHERE);

			query.append(
				_FINDER_COLUMN_PERSISTEDVITAMINIDTYPE_PERSISTEDVITAMINID_2);

			query.append(_FINDER_COLUMN_PERSISTEDVITAMINIDTYPE_TYPE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(VitaminDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(persistedVitaminId);

				qPos.add(type);

				if (!pagination) {
					list = (List<VitaminDetail>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<VitaminDetail>)QueryUtil.list(
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
	 * Returns the first vitamin detail in the ordered set where persistedVitaminId = &#63; and type = &#63;.
	 *
	 * @param persistedVitaminId the persisted vitamin ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vitamin detail
	 * @throws NoSuchVitaminDetailException if a matching vitamin detail could not be found
	 */
	@Override
	public VitaminDetail findByPersistedVitaminIdType_First(
			long persistedVitaminId, int type,
			OrderByComparator<VitaminDetail> orderByComparator)
		throws NoSuchVitaminDetailException {

		VitaminDetail vitaminDetail = fetchByPersistedVitaminIdType_First(
			persistedVitaminId, type, orderByComparator);

		if (vitaminDetail != null) {
			return vitaminDetail;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("persistedVitaminId=");
		msg.append(persistedVitaminId);

		msg.append(", type=");
		msg.append(type);

		msg.append("}");

		throw new NoSuchVitaminDetailException(msg.toString());
	}

	/**
	 * Returns the first vitamin detail in the ordered set where persistedVitaminId = &#63; and type = &#63;.
	 *
	 * @param persistedVitaminId the persisted vitamin ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vitamin detail, or <code>null</code> if a matching vitamin detail could not be found
	 */
	@Override
	public VitaminDetail fetchByPersistedVitaminIdType_First(
		long persistedVitaminId, int type,
		OrderByComparator<VitaminDetail> orderByComparator) {

		List<VitaminDetail> list = findByPersistedVitaminIdType(
			persistedVitaminId, type, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last vitamin detail in the ordered set where persistedVitaminId = &#63; and type = &#63;.
	 *
	 * @param persistedVitaminId the persisted vitamin ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vitamin detail
	 * @throws NoSuchVitaminDetailException if a matching vitamin detail could not be found
	 */
	@Override
	public VitaminDetail findByPersistedVitaminIdType_Last(
			long persistedVitaminId, int type,
			OrderByComparator<VitaminDetail> orderByComparator)
		throws NoSuchVitaminDetailException {

		VitaminDetail vitaminDetail = fetchByPersistedVitaminIdType_Last(
			persistedVitaminId, type, orderByComparator);

		if (vitaminDetail != null) {
			return vitaminDetail;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("persistedVitaminId=");
		msg.append(persistedVitaminId);

		msg.append(", type=");
		msg.append(type);

		msg.append("}");

		throw new NoSuchVitaminDetailException(msg.toString());
	}

	/**
	 * Returns the last vitamin detail in the ordered set where persistedVitaminId = &#63; and type = &#63;.
	 *
	 * @param persistedVitaminId the persisted vitamin ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vitamin detail, or <code>null</code> if a matching vitamin detail could not be found
	 */
	@Override
	public VitaminDetail fetchByPersistedVitaminIdType_Last(
		long persistedVitaminId, int type,
		OrderByComparator<VitaminDetail> orderByComparator) {

		int count = countByPersistedVitaminIdType(persistedVitaminId, type);

		if (count == 0) {
			return null;
		}

		List<VitaminDetail> list = findByPersistedVitaminIdType(
			persistedVitaminId, type, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the vitamin details before and after the current vitamin detail in the ordered set where persistedVitaminId = &#63; and type = &#63;.
	 *
	 * @param vitaminDetailId the primary key of the current vitamin detail
	 * @param persistedVitaminId the persisted vitamin ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vitamin detail
	 * @throws NoSuchVitaminDetailException if a vitamin detail with the primary key could not be found
	 */
	@Override
	public VitaminDetail[] findByPersistedVitaminIdType_PrevAndNext(
			long vitaminDetailId, long persistedVitaminId, int type,
			OrderByComparator<VitaminDetail> orderByComparator)
		throws NoSuchVitaminDetailException {

		VitaminDetail vitaminDetail = findByPrimaryKey(vitaminDetailId);

		Session session = null;

		try {
			session = openSession();

			VitaminDetail[] array = new VitaminDetailImpl[3];

			array[0] = getByPersistedVitaminIdType_PrevAndNext(
				session, vitaminDetail, persistedVitaminId, type,
				orderByComparator, true);

			array[1] = vitaminDetail;

			array[2] = getByPersistedVitaminIdType_PrevAndNext(
				session, vitaminDetail, persistedVitaminId, type,
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

	protected VitaminDetail getByPersistedVitaminIdType_PrevAndNext(
		Session session, VitaminDetail vitaminDetail, long persistedVitaminId,
		int type, OrderByComparator<VitaminDetail> orderByComparator,
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

		query.append(_SQL_SELECT_VITAMINDETAIL_WHERE);

		query.append(
			_FINDER_COLUMN_PERSISTEDVITAMINIDTYPE_PERSISTEDVITAMINID_2);

		query.append(_FINDER_COLUMN_PERSISTEDVITAMINIDTYPE_TYPE_2);

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
			query.append(VitaminDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(persistedVitaminId);

		qPos.add(type);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						vitaminDetail)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<VitaminDetail> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the vitamin details where persistedVitaminId = &#63; and type = &#63; from the database.
	 *
	 * @param persistedVitaminId the persisted vitamin ID
	 * @param type the type
	 */
	@Override
	public void removeByPersistedVitaminIdType(
		long persistedVitaminId, int type) {

		for (VitaminDetail vitaminDetail :
				findByPersistedVitaminIdType(
					persistedVitaminId, type, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(vitaminDetail);
		}
	}

	/**
	 * Returns the number of vitamin details where persistedVitaminId = &#63; and type = &#63;.
	 *
	 * @param persistedVitaminId the persisted vitamin ID
	 * @param type the type
	 * @return the number of matching vitamin details
	 */
	@Override
	public int countByPersistedVitaminIdType(
		long persistedVitaminId, int type) {

		FinderPath finderPath = _finderPathCountByPersistedVitaminIdType;

		Object[] finderArgs = new Object[] {persistedVitaminId, type};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VITAMINDETAIL_WHERE);

			query.append(
				_FINDER_COLUMN_PERSISTEDVITAMINIDTYPE_PERSISTEDVITAMINID_2);

			query.append(_FINDER_COLUMN_PERSISTEDVITAMINIDTYPE_TYPE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(persistedVitaminId);

				qPos.add(type);

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

	private static final String
		_FINDER_COLUMN_PERSISTEDVITAMINIDTYPE_PERSISTEDVITAMINID_2 =
			"vitaminDetail.persistedVitaminId = ? AND ";

	private static final String _FINDER_COLUMN_PERSISTEDVITAMINIDTYPE_TYPE_2 =
		"vitaminDetail.type = ?";

	public VitaminDetailPersistenceImpl() {
		setModelClass(VitaminDetail.class);

		setModelImplClass(VitaminDetailImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("type", "type_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the vitamin detail in the entity cache if it is enabled.
	 *
	 * @param vitaminDetail the vitamin detail
	 */
	@Override
	public void cacheResult(VitaminDetail vitaminDetail) {
		entityCache.putResult(
			entityCacheEnabled, VitaminDetailImpl.class,
			vitaminDetail.getPrimaryKey(), vitaminDetail);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {vitaminDetail.getUuid(), vitaminDetail.getGroupId()},
			vitaminDetail);

		vitaminDetail.resetOriginalValues();
	}

	/**
	 * Caches the vitamin details in the entity cache if it is enabled.
	 *
	 * @param vitaminDetails the vitamin details
	 */
	@Override
	public void cacheResult(List<VitaminDetail> vitaminDetails) {
		for (VitaminDetail vitaminDetail : vitaminDetails) {
			if (entityCache.getResult(
					entityCacheEnabled, VitaminDetailImpl.class,
					vitaminDetail.getPrimaryKey()) == null) {

				cacheResult(vitaminDetail);
			}
			else {
				vitaminDetail.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all vitamin details.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(VitaminDetailImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the vitamin detail.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VitaminDetail vitaminDetail) {
		entityCache.removeResult(
			entityCacheEnabled, VitaminDetailImpl.class,
			vitaminDetail.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((VitaminDetailModelImpl)vitaminDetail, true);
	}

	@Override
	public void clearCache(List<VitaminDetail> vitaminDetails) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VitaminDetail vitaminDetail : vitaminDetails) {
			entityCache.removeResult(
				entityCacheEnabled, VitaminDetailImpl.class,
				vitaminDetail.getPrimaryKey());

			clearUniqueFindersCache(
				(VitaminDetailModelImpl)vitaminDetail, true);
		}
	}

	protected void cacheUniqueFindersCache(
		VitaminDetailModelImpl vitaminDetailModelImpl) {

		Object[] args = new Object[] {
			vitaminDetailModelImpl.getUuid(),
			vitaminDetailModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, vitaminDetailModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		VitaminDetailModelImpl vitaminDetailModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				vitaminDetailModelImpl.getUuid(),
				vitaminDetailModelImpl.getGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if ((vitaminDetailModelImpl.getColumnBitmask() &
			 _finderPathFetchByUUID_G.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				vitaminDetailModelImpl.getOriginalUuid(),
				vitaminDetailModelImpl.getOriginalGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}
	}

	/**
	 * Creates a new vitamin detail with the primary key. Does not add the vitamin detail to the database.
	 *
	 * @param vitaminDetailId the primary key for the new vitamin detail
	 * @return the new vitamin detail
	 */
	@Override
	public VitaminDetail create(long vitaminDetailId) {
		VitaminDetail vitaminDetail = new VitaminDetailImpl();

		vitaminDetail.setNew(true);
		vitaminDetail.setPrimaryKey(vitaminDetailId);

		String uuid = PortalUUIDUtil.generate();

		vitaminDetail.setUuid(uuid);

		vitaminDetail.setCompanyId(CompanyThreadLocal.getCompanyId());

		return vitaminDetail;
	}

	/**
	 * Removes the vitamin detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param vitaminDetailId the primary key of the vitamin detail
	 * @return the vitamin detail that was removed
	 * @throws NoSuchVitaminDetailException if a vitamin detail with the primary key could not be found
	 */
	@Override
	public VitaminDetail remove(long vitaminDetailId)
		throws NoSuchVitaminDetailException {

		return remove((Serializable)vitaminDetailId);
	}

	/**
	 * Removes the vitamin detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the vitamin detail
	 * @return the vitamin detail that was removed
	 * @throws NoSuchVitaminDetailException if a vitamin detail with the primary key could not be found
	 */
	@Override
	public VitaminDetail remove(Serializable primaryKey)
		throws NoSuchVitaminDetailException {

		Session session = null;

		try {
			session = openSession();

			VitaminDetail vitaminDetail = (VitaminDetail)session.get(
				VitaminDetailImpl.class, primaryKey);

			if (vitaminDetail == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVitaminDetailException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(vitaminDetail);
		}
		catch (NoSuchVitaminDetailException nsee) {
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
	protected VitaminDetail removeImpl(VitaminDetail vitaminDetail) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(vitaminDetail)) {
				vitaminDetail = (VitaminDetail)session.get(
					VitaminDetailImpl.class, vitaminDetail.getPrimaryKeyObj());
			}

			if (vitaminDetail != null) {
				session.delete(vitaminDetail);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (vitaminDetail != null) {
			clearCache(vitaminDetail);
		}

		return vitaminDetail;
	}

	@Override
	public VitaminDetail updateImpl(VitaminDetail vitaminDetail) {
		boolean isNew = vitaminDetail.isNew();

		if (!(vitaminDetail instanceof VitaminDetailModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(vitaminDetail.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					vitaminDetail);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in vitaminDetail proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom VitaminDetail implementation " +
					vitaminDetail.getClass());
		}

		VitaminDetailModelImpl vitaminDetailModelImpl =
			(VitaminDetailModelImpl)vitaminDetail;

		if (Validator.isNull(vitaminDetail.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			vitaminDetail.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (vitaminDetail.getCreateDate() == null)) {
			if (serviceContext == null) {
				vitaminDetail.setCreateDate(now);
			}
			else {
				vitaminDetail.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!vitaminDetailModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				vitaminDetail.setModifiedDate(now);
			}
			else {
				vitaminDetail.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		long userId = GetterUtil.getLong(PrincipalThreadLocal.getName());

		if (userId > 0) {
			long companyId = vitaminDetail.getCompanyId();

			long groupId = vitaminDetail.getGroupId();

			long vitaminDetailId = 0;

			if (!isNew) {
				vitaminDetailId = vitaminDetail.getPrimaryKey();
			}

			try {
				vitaminDetail.setValue(
					SanitizerUtil.sanitize(
						companyId, groupId, userId,
						VitaminDetail.class.getName(), vitaminDetailId,
						ContentTypes.TEXT_PLAIN, Sanitizer.MODE_ALL,
						vitaminDetail.getValue(), null));
			}
			catch (SanitizerException se) {
				throw new SystemException(se);
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (vitaminDetail.isNew()) {
				session.save(vitaminDetail);

				vitaminDetail.setNew(false);
			}
			else {
				vitaminDetail = (VitaminDetail)session.merge(vitaminDetail);
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
			Object[] args = new Object[] {vitaminDetailModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {
				vitaminDetailModelImpl.getUuid(),
				vitaminDetailModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByUuid_C, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid_C, args);

			args = new Object[] {
				vitaminDetailModelImpl.getPersistedVitaminId()
			};

			finderCache.removeResult(
				_finderPathCountByPersistedVitaminId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByPersistedVitaminId, args);

			args = new Object[] {
				vitaminDetailModelImpl.getPersistedVitaminId(),
				vitaminDetailModelImpl.getType()
			};

			finderCache.removeResult(
				_finderPathCountByPersistedVitaminIdType, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByPersistedVitaminIdType, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((vitaminDetailModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					vitaminDetailModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {vitaminDetailModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((vitaminDetailModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid_C.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					vitaminDetailModelImpl.getOriginalUuid(),
					vitaminDetailModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);

				args = new Object[] {
					vitaminDetailModelImpl.getUuid(),
					vitaminDetailModelImpl.getCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);
			}

			if ((vitaminDetailModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByPersistedVitaminId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					vitaminDetailModelImpl.getOriginalPersistedVitaminId()
				};

				finderCache.removeResult(
					_finderPathCountByPersistedVitaminId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByPersistedVitaminId, args);

				args = new Object[] {
					vitaminDetailModelImpl.getPersistedVitaminId()
				};

				finderCache.removeResult(
					_finderPathCountByPersistedVitaminId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByPersistedVitaminId, args);
			}

			if ((vitaminDetailModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByPersistedVitaminIdType.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					vitaminDetailModelImpl.getOriginalPersistedVitaminId(),
					vitaminDetailModelImpl.getOriginalType()
				};

				finderCache.removeResult(
					_finderPathCountByPersistedVitaminIdType, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByPersistedVitaminIdType,
					args);

				args = new Object[] {
					vitaminDetailModelImpl.getPersistedVitaminId(),
					vitaminDetailModelImpl.getType()
				};

				finderCache.removeResult(
					_finderPathCountByPersistedVitaminIdType, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByPersistedVitaminIdType,
					args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, VitaminDetailImpl.class,
			vitaminDetail.getPrimaryKey(), vitaminDetail, false);

		clearUniqueFindersCache(vitaminDetailModelImpl, false);
		cacheUniqueFindersCache(vitaminDetailModelImpl);

		vitaminDetail.resetOriginalValues();

		return vitaminDetail;
	}

	/**
	 * Returns the vitamin detail with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the vitamin detail
	 * @return the vitamin detail
	 * @throws NoSuchVitaminDetailException if a vitamin detail with the primary key could not be found
	 */
	@Override
	public VitaminDetail findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVitaminDetailException {

		VitaminDetail vitaminDetail = fetchByPrimaryKey(primaryKey);

		if (vitaminDetail == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVitaminDetailException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return vitaminDetail;
	}

	/**
	 * Returns the vitamin detail with the primary key or throws a <code>NoSuchVitaminDetailException</code> if it could not be found.
	 *
	 * @param vitaminDetailId the primary key of the vitamin detail
	 * @return the vitamin detail
	 * @throws NoSuchVitaminDetailException if a vitamin detail with the primary key could not be found
	 */
	@Override
	public VitaminDetail findByPrimaryKey(long vitaminDetailId)
		throws NoSuchVitaminDetailException {

		return findByPrimaryKey((Serializable)vitaminDetailId);
	}

	/**
	 * Returns the vitamin detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param vitaminDetailId the primary key of the vitamin detail
	 * @return the vitamin detail, or <code>null</code> if a vitamin detail with the primary key could not be found
	 */
	@Override
	public VitaminDetail fetchByPrimaryKey(long vitaminDetailId) {
		return fetchByPrimaryKey((Serializable)vitaminDetailId);
	}

	/**
	 * Returns all the vitamin details.
	 *
	 * @return the vitamin details
	 */
	@Override
	public List<VitaminDetail> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vitamin details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VitaminDetailModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of vitamin details
	 * @param end the upper bound of the range of vitamin details (not inclusive)
	 * @return the range of vitamin details
	 */
	@Override
	public List<VitaminDetail> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the vitamin details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VitaminDetailModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of vitamin details
	 * @param end the upper bound of the range of vitamin details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of vitamin details
	 */
	@Override
	public List<VitaminDetail> findAll(
		int start, int end,
		OrderByComparator<VitaminDetail> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the vitamin details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VitaminDetailModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of vitamin details
	 * @param end the upper bound of the range of vitamin details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of vitamin details
	 */
	@Override
	public List<VitaminDetail> findAll(
		int start, int end, OrderByComparator<VitaminDetail> orderByComparator,
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

		List<VitaminDetail> list = null;

		if (useFinderCache) {
			list = (List<VitaminDetail>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_VITAMINDETAIL);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VITAMINDETAIL;

				if (pagination) {
					sql = sql.concat(VitaminDetailModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<VitaminDetail>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<VitaminDetail>)QueryUtil.list(
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
	 * Removes all the vitamin details from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (VitaminDetail vitaminDetail : findAll()) {
			remove(vitaminDetail);
		}
	}

	/**
	 * Returns the number of vitamin details.
	 *
	 * @return the number of vitamin details
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_VITAMINDETAIL);

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
		return "vitaminDetailId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_VITAMINDETAIL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return VitaminDetailModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the vitamin detail persistence.
	 */
	@Activate
	public void activate() {
		VitaminDetailModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		VitaminDetailModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, VitaminDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, VitaminDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, VitaminDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, VitaminDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			VitaminDetailModelImpl.UUID_COLUMN_BITMASK |
			VitaminDetailModelImpl.TYPE_COLUMN_BITMASK |
			VitaminDetailModelImpl.VALUE_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathFetchByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, VitaminDetailImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			VitaminDetailModelImpl.UUID_COLUMN_BITMASK |
			VitaminDetailModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, VitaminDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, VitaminDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			VitaminDetailModelImpl.UUID_COLUMN_BITMASK |
			VitaminDetailModelImpl.COMPANYID_COLUMN_BITMASK |
			VitaminDetailModelImpl.TYPE_COLUMN_BITMASK |
			VitaminDetailModelImpl.VALUE_COLUMN_BITMASK);

		_finderPathCountByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByPersistedVitaminId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, VitaminDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPersistedVitaminId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByPersistedVitaminId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, VitaminDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByPersistedVitaminId", new String[] {Long.class.getName()},
			VitaminDetailModelImpl.PERSISTEDVITAMINID_COLUMN_BITMASK |
			VitaminDetailModelImpl.TYPE_COLUMN_BITMASK |
			VitaminDetailModelImpl.VALUE_COLUMN_BITMASK);

		_finderPathCountByPersistedVitaminId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPersistedVitaminId", new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByPersistedVitaminIdType = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, VitaminDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPersistedVitaminIdType",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByPersistedVitaminIdType =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled, VitaminDetailImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByPersistedVitaminIdType",
				new String[] {Long.class.getName(), Integer.class.getName()},
				VitaminDetailModelImpl.PERSISTEDVITAMINID_COLUMN_BITMASK |
				VitaminDetailModelImpl.TYPE_COLUMN_BITMASK |
				VitaminDetailModelImpl.VALUE_COLUMN_BITMASK);

		_finderPathCountByPersistedVitaminIdType = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPersistedVitaminIdType",
			new String[] {Long.class.getName(), Integer.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(VitaminDetailImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.dnebinger.vitamins.model.VitaminDetail"),
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

	private static final String _SQL_SELECT_VITAMINDETAIL =
		"SELECT vitaminDetail FROM VitaminDetail vitaminDetail";

	private static final String _SQL_SELECT_VITAMINDETAIL_WHERE =
		"SELECT vitaminDetail FROM VitaminDetail vitaminDetail WHERE ";

	private static final String _SQL_COUNT_VITAMINDETAIL =
		"SELECT COUNT(vitaminDetail) FROM VitaminDetail vitaminDetail";

	private static final String _SQL_COUNT_VITAMINDETAIL_WHERE =
		"SELECT COUNT(vitaminDetail) FROM VitaminDetail vitaminDetail WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "vitaminDetail.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No VitaminDetail exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No VitaminDetail exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		VitaminDetailPersistenceImpl.class);

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