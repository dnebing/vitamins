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

package com.dnebinger.vitamins.service.persistence;

import com.dnebinger.vitamins.model.PersistedVitamin;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the persisted vitamin service. This utility wraps <code>com.dnebinger.vitamins.service.persistence.impl.PersistedVitaminPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersistedVitaminPersistence
 * @generated
 */
@ProviderType
public class PersistedVitaminUtil {

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
	public static void clearCache(PersistedVitamin persistedVitamin) {
		getPersistence().clearCache(persistedVitamin);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, PersistedVitamin> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PersistedVitamin> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PersistedVitamin> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PersistedVitamin> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PersistedVitamin> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PersistedVitamin update(PersistedVitamin persistedVitamin) {
		return getPersistence().update(persistedVitamin);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PersistedVitamin update(
		PersistedVitamin persistedVitamin, ServiceContext serviceContext) {

		return getPersistence().update(persistedVitamin, serviceContext);
	}

	/**
	 * Returns all the persisted vitamins where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching persisted vitamins
	 */
	public static List<PersistedVitamin> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
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
	public static List<PersistedVitamin> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
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
	public static List<PersistedVitamin> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PersistedVitamin> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
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
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching persisted vitamins
	 */
	public static List<PersistedVitamin> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PersistedVitamin> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first persisted vitamin in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted vitamin
	 * @throws NoSuchPersistedVitaminException if a matching persisted vitamin could not be found
	 */
	public static PersistedVitamin findByUuid_First(
			String uuid, OrderByComparator<PersistedVitamin> orderByComparator)
		throws com.dnebinger.vitamins.exception.
			NoSuchPersistedVitaminException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first persisted vitamin in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted vitamin, or <code>null</code> if a matching persisted vitamin could not be found
	 */
	public static PersistedVitamin fetchByUuid_First(
		String uuid, OrderByComparator<PersistedVitamin> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last persisted vitamin in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted vitamin
	 * @throws NoSuchPersistedVitaminException if a matching persisted vitamin could not be found
	 */
	public static PersistedVitamin findByUuid_Last(
			String uuid, OrderByComparator<PersistedVitamin> orderByComparator)
		throws com.dnebinger.vitamins.exception.
			NoSuchPersistedVitaminException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last persisted vitamin in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted vitamin, or <code>null</code> if a matching persisted vitamin could not be found
	 */
	public static PersistedVitamin fetchByUuid_Last(
		String uuid, OrderByComparator<PersistedVitamin> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
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
	public static PersistedVitamin[] findByUuid_PrevAndNext(
			long persistedVitaminId, String uuid,
			OrderByComparator<PersistedVitamin> orderByComparator)
		throws com.dnebinger.vitamins.exception.
			NoSuchPersistedVitaminException {

		return getPersistence().findByUuid_PrevAndNext(
			persistedVitaminId, uuid, orderByComparator);
	}

	/**
	 * Removes all the persisted vitamins where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of persisted vitamins where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching persisted vitamins
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the persisted vitamin where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchPersistedVitaminException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching persisted vitamin
	 * @throws NoSuchPersistedVitaminException if a matching persisted vitamin could not be found
	 */
	public static PersistedVitamin findByUUID_G(String uuid, long groupId)
		throws com.dnebinger.vitamins.exception.
			NoSuchPersistedVitaminException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the persisted vitamin where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching persisted vitamin, or <code>null</code> if a matching persisted vitamin could not be found
	 */
	public static PersistedVitamin fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the persisted vitamin where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching persisted vitamin, or <code>null</code> if a matching persisted vitamin could not be found
	 */
	public static PersistedVitamin fetchByUUID_G(
		String uuid, long groupId, boolean retrieveFromCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	 * Removes the persisted vitamin where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the persisted vitamin that was removed
	 */
	public static PersistedVitamin removeByUUID_G(String uuid, long groupId)
		throws com.dnebinger.vitamins.exception.
			NoSuchPersistedVitaminException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of persisted vitamins where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching persisted vitamins
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the persisted vitamins where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching persisted vitamins
	 */
	public static List<PersistedVitamin> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
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
	public static List<PersistedVitamin> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
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
	public static List<PersistedVitamin> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PersistedVitamin> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
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
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching persisted vitamins
	 */
	public static List<PersistedVitamin> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PersistedVitamin> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, retrieveFromCache);
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
	public static PersistedVitamin findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<PersistedVitamin> orderByComparator)
		throws com.dnebinger.vitamins.exception.
			NoSuchPersistedVitaminException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first persisted vitamin in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted vitamin, or <code>null</code> if a matching persisted vitamin could not be found
	 */
	public static PersistedVitamin fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<PersistedVitamin> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
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
	public static PersistedVitamin findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<PersistedVitamin> orderByComparator)
		throws com.dnebinger.vitamins.exception.
			NoSuchPersistedVitaminException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last persisted vitamin in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted vitamin, or <code>null</code> if a matching persisted vitamin could not be found
	 */
	public static PersistedVitamin fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<PersistedVitamin> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
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
	public static PersistedVitamin[] findByUuid_C_PrevAndNext(
			long persistedVitaminId, String uuid, long companyId,
			OrderByComparator<PersistedVitamin> orderByComparator)
		throws com.dnebinger.vitamins.exception.
			NoSuchPersistedVitaminException {

		return getPersistence().findByUuid_C_PrevAndNext(
			persistedVitaminId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the persisted vitamins where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of persisted vitamins where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching persisted vitamins
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the persisted vitamin where surrogateId = &#63; or throws a <code>NoSuchPersistedVitaminException</code> if it could not be found.
	 *
	 * @param surrogateId the surrogate ID
	 * @return the matching persisted vitamin
	 * @throws NoSuchPersistedVitaminException if a matching persisted vitamin could not be found
	 */
	public static PersistedVitamin findBySurrogateId(String surrogateId)
		throws com.dnebinger.vitamins.exception.
			NoSuchPersistedVitaminException {

		return getPersistence().findBySurrogateId(surrogateId);
	}

	/**
	 * Returns the persisted vitamin where surrogateId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param surrogateId the surrogate ID
	 * @return the matching persisted vitamin, or <code>null</code> if a matching persisted vitamin could not be found
	 */
	public static PersistedVitamin fetchBySurrogateId(String surrogateId) {
		return getPersistence().fetchBySurrogateId(surrogateId);
	}

	/**
	 * Returns the persisted vitamin where surrogateId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param surrogateId the surrogate ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching persisted vitamin, or <code>null</code> if a matching persisted vitamin could not be found
	 */
	public static PersistedVitamin fetchBySurrogateId(
		String surrogateId, boolean retrieveFromCache) {

		return getPersistence().fetchBySurrogateId(
			surrogateId, retrieveFromCache);
	}

	/**
	 * Removes the persisted vitamin where surrogateId = &#63; from the database.
	 *
	 * @param surrogateId the surrogate ID
	 * @return the persisted vitamin that was removed
	 */
	public static PersistedVitamin removeBySurrogateId(String surrogateId)
		throws com.dnebinger.vitamins.exception.
			NoSuchPersistedVitaminException {

		return getPersistence().removeBySurrogateId(surrogateId);
	}

	/**
	 * Returns the number of persisted vitamins where surrogateId = &#63;.
	 *
	 * @param surrogateId the surrogate ID
	 * @return the number of matching persisted vitamins
	 */
	public static int countBySurrogateId(String surrogateId) {
		return getPersistence().countBySurrogateId(surrogateId);
	}

	/**
	 * Returns the persisted vitamin where name = &#63; or throws a <code>NoSuchPersistedVitaminException</code> if it could not be found.
	 *
	 * @param name the name
	 * @return the matching persisted vitamin
	 * @throws NoSuchPersistedVitaminException if a matching persisted vitamin could not be found
	 */
	public static PersistedVitamin findByName(String name)
		throws com.dnebinger.vitamins.exception.
			NoSuchPersistedVitaminException {

		return getPersistence().findByName(name);
	}

	/**
	 * Returns the persisted vitamin where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching persisted vitamin, or <code>null</code> if a matching persisted vitamin could not be found
	 */
	public static PersistedVitamin fetchByName(String name) {
		return getPersistence().fetchByName(name);
	}

	/**
	 * Returns the persisted vitamin where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching persisted vitamin, or <code>null</code> if a matching persisted vitamin could not be found
	 */
	public static PersistedVitamin fetchByName(
		String name, boolean retrieveFromCache) {

		return getPersistence().fetchByName(name, retrieveFromCache);
	}

	/**
	 * Removes the persisted vitamin where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the persisted vitamin that was removed
	 */
	public static PersistedVitamin removeByName(String name)
		throws com.dnebinger.vitamins.exception.
			NoSuchPersistedVitaminException {

		return getPersistence().removeByName(name);
	}

	/**
	 * Returns the number of persisted vitamins where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching persisted vitamins
	 */
	public static int countByName(String name) {
		return getPersistence().countByName(name);
	}

	/**
	 * Caches the persisted vitamin in the entity cache if it is enabled.
	 *
	 * @param persistedVitamin the persisted vitamin
	 */
	public static void cacheResult(PersistedVitamin persistedVitamin) {
		getPersistence().cacheResult(persistedVitamin);
	}

	/**
	 * Caches the persisted vitamins in the entity cache if it is enabled.
	 *
	 * @param persistedVitamins the persisted vitamins
	 */
	public static void cacheResult(List<PersistedVitamin> persistedVitamins) {
		getPersistence().cacheResult(persistedVitamins);
	}

	/**
	 * Creates a new persisted vitamin with the primary key. Does not add the persisted vitamin to the database.
	 *
	 * @param persistedVitaminId the primary key for the new persisted vitamin
	 * @return the new persisted vitamin
	 */
	public static PersistedVitamin create(long persistedVitaminId) {
		return getPersistence().create(persistedVitaminId);
	}

	/**
	 * Removes the persisted vitamin with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param persistedVitaminId the primary key of the persisted vitamin
	 * @return the persisted vitamin that was removed
	 * @throws NoSuchPersistedVitaminException if a persisted vitamin with the primary key could not be found
	 */
	public static PersistedVitamin remove(long persistedVitaminId)
		throws com.dnebinger.vitamins.exception.
			NoSuchPersistedVitaminException {

		return getPersistence().remove(persistedVitaminId);
	}

	public static PersistedVitamin updateImpl(
		PersistedVitamin persistedVitamin) {

		return getPersistence().updateImpl(persistedVitamin);
	}

	/**
	 * Returns the persisted vitamin with the primary key or throws a <code>NoSuchPersistedVitaminException</code> if it could not be found.
	 *
	 * @param persistedVitaminId the primary key of the persisted vitamin
	 * @return the persisted vitamin
	 * @throws NoSuchPersistedVitaminException if a persisted vitamin with the primary key could not be found
	 */
	public static PersistedVitamin findByPrimaryKey(long persistedVitaminId)
		throws com.dnebinger.vitamins.exception.
			NoSuchPersistedVitaminException {

		return getPersistence().findByPrimaryKey(persistedVitaminId);
	}

	/**
	 * Returns the persisted vitamin with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param persistedVitaminId the primary key of the persisted vitamin
	 * @return the persisted vitamin, or <code>null</code> if a persisted vitamin with the primary key could not be found
	 */
	public static PersistedVitamin fetchByPrimaryKey(long persistedVitaminId) {
		return getPersistence().fetchByPrimaryKey(persistedVitaminId);
	}

	/**
	 * Returns all the persisted vitamins.
	 *
	 * @return the persisted vitamins
	 */
	public static List<PersistedVitamin> findAll() {
		return getPersistence().findAll();
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
	public static List<PersistedVitamin> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<PersistedVitamin> findAll(
		int start, int end,
		OrderByComparator<PersistedVitamin> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of persisted vitamins
	 */
	public static List<PersistedVitamin> findAll(
		int start, int end,
		OrderByComparator<PersistedVitamin> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the persisted vitamins from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of persisted vitamins.
	 *
	 * @return the number of persisted vitamins
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PersistedVitaminPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<PersistedVitaminPersistence, PersistedVitaminPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			PersistedVitaminPersistence.class);

		ServiceTracker<PersistedVitaminPersistence, PersistedVitaminPersistence>
			serviceTracker =
				new ServiceTracker
					<PersistedVitaminPersistence, PersistedVitaminPersistence>(
						bundle.getBundleContext(),
						PersistedVitaminPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}