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

import com.dnebinger.vitamins.model.VitaminDetail;

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
 * The persistence utility for the vitamin detail service. This utility wraps <code>com.dnebinger.vitamins.service.persistence.impl.VitaminDetailPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see VitaminDetailPersistence
 * @generated
 */
@ProviderType
public class VitaminDetailUtil {

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
	public static void clearCache(VitaminDetail vitaminDetail) {
		getPersistence().clearCache(vitaminDetail);
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
	public static Map<Serializable, VitaminDetail> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<VitaminDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<VitaminDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<VitaminDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<VitaminDetail> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static VitaminDetail update(VitaminDetail vitaminDetail) {
		return getPersistence().update(vitaminDetail);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static VitaminDetail update(
		VitaminDetail vitaminDetail, ServiceContext serviceContext) {

		return getPersistence().update(vitaminDetail, serviceContext);
	}

	/**
	 * Returns all the vitamin details where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching vitamin details
	 */
	public static List<VitaminDetail> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
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
	public static List<VitaminDetail> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
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
	public static List<VitaminDetail> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<VitaminDetail> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
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
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching vitamin details
	 */
	public static List<VitaminDetail> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<VitaminDetail> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first vitamin detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vitamin detail
	 * @throws NoSuchVitaminDetailException if a matching vitamin detail could not be found
	 */
	public static VitaminDetail findByUuid_First(
			String uuid, OrderByComparator<VitaminDetail> orderByComparator)
		throws com.dnebinger.vitamins.exception.NoSuchVitaminDetailException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first vitamin detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vitamin detail, or <code>null</code> if a matching vitamin detail could not be found
	 */
	public static VitaminDetail fetchByUuid_First(
		String uuid, OrderByComparator<VitaminDetail> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last vitamin detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vitamin detail
	 * @throws NoSuchVitaminDetailException if a matching vitamin detail could not be found
	 */
	public static VitaminDetail findByUuid_Last(
			String uuid, OrderByComparator<VitaminDetail> orderByComparator)
		throws com.dnebinger.vitamins.exception.NoSuchVitaminDetailException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last vitamin detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vitamin detail, or <code>null</code> if a matching vitamin detail could not be found
	 */
	public static VitaminDetail fetchByUuid_Last(
		String uuid, OrderByComparator<VitaminDetail> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
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
	public static VitaminDetail[] findByUuid_PrevAndNext(
			long vitaminDetailId, String uuid,
			OrderByComparator<VitaminDetail> orderByComparator)
		throws com.dnebinger.vitamins.exception.NoSuchVitaminDetailException {

		return getPersistence().findByUuid_PrevAndNext(
			vitaminDetailId, uuid, orderByComparator);
	}

	/**
	 * Removes all the vitamin details where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of vitamin details where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching vitamin details
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the vitamin detail where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchVitaminDetailException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching vitamin detail
	 * @throws NoSuchVitaminDetailException if a matching vitamin detail could not be found
	 */
	public static VitaminDetail findByUUID_G(String uuid, long groupId)
		throws com.dnebinger.vitamins.exception.NoSuchVitaminDetailException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the vitamin detail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching vitamin detail, or <code>null</code> if a matching vitamin detail could not be found
	 */
	public static VitaminDetail fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the vitamin detail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching vitamin detail, or <code>null</code> if a matching vitamin detail could not be found
	 */
	public static VitaminDetail fetchByUUID_G(
		String uuid, long groupId, boolean retrieveFromCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	 * Removes the vitamin detail where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the vitamin detail that was removed
	 */
	public static VitaminDetail removeByUUID_G(String uuid, long groupId)
		throws com.dnebinger.vitamins.exception.NoSuchVitaminDetailException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of vitamin details where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching vitamin details
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the vitamin details where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching vitamin details
	 */
	public static List<VitaminDetail> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
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
	public static List<VitaminDetail> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
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
	public static List<VitaminDetail> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<VitaminDetail> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
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
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching vitamin details
	 */
	public static List<VitaminDetail> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<VitaminDetail> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, retrieveFromCache);
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
	public static VitaminDetail findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<VitaminDetail> orderByComparator)
		throws com.dnebinger.vitamins.exception.NoSuchVitaminDetailException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first vitamin detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vitamin detail, or <code>null</code> if a matching vitamin detail could not be found
	 */
	public static VitaminDetail fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<VitaminDetail> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
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
	public static VitaminDetail findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<VitaminDetail> orderByComparator)
		throws com.dnebinger.vitamins.exception.NoSuchVitaminDetailException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last vitamin detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vitamin detail, or <code>null</code> if a matching vitamin detail could not be found
	 */
	public static VitaminDetail fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<VitaminDetail> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
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
	public static VitaminDetail[] findByUuid_C_PrevAndNext(
			long vitaminDetailId, String uuid, long companyId,
			OrderByComparator<VitaminDetail> orderByComparator)
		throws com.dnebinger.vitamins.exception.NoSuchVitaminDetailException {

		return getPersistence().findByUuid_C_PrevAndNext(
			vitaminDetailId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the vitamin details where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of vitamin details where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching vitamin details
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the vitamin details where persistedVitaminId = &#63;.
	 *
	 * @param persistedVitaminId the persisted vitamin ID
	 * @return the matching vitamin details
	 */
	public static List<VitaminDetail> findByPersistedVitaminId(
		long persistedVitaminId) {

		return getPersistence().findByPersistedVitaminId(persistedVitaminId);
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
	public static List<VitaminDetail> findByPersistedVitaminId(
		long persistedVitaminId, int start, int end) {

		return getPersistence().findByPersistedVitaminId(
			persistedVitaminId, start, end);
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
	public static List<VitaminDetail> findByPersistedVitaminId(
		long persistedVitaminId, int start, int end,
		OrderByComparator<VitaminDetail> orderByComparator) {

		return getPersistence().findByPersistedVitaminId(
			persistedVitaminId, start, end, orderByComparator);
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
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching vitamin details
	 */
	public static List<VitaminDetail> findByPersistedVitaminId(
		long persistedVitaminId, int start, int end,
		OrderByComparator<VitaminDetail> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByPersistedVitaminId(
			persistedVitaminId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	 * Returns the first vitamin detail in the ordered set where persistedVitaminId = &#63;.
	 *
	 * @param persistedVitaminId the persisted vitamin ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vitamin detail
	 * @throws NoSuchVitaminDetailException if a matching vitamin detail could not be found
	 */
	public static VitaminDetail findByPersistedVitaminId_First(
			long persistedVitaminId,
			OrderByComparator<VitaminDetail> orderByComparator)
		throws com.dnebinger.vitamins.exception.NoSuchVitaminDetailException {

		return getPersistence().findByPersistedVitaminId_First(
			persistedVitaminId, orderByComparator);
	}

	/**
	 * Returns the first vitamin detail in the ordered set where persistedVitaminId = &#63;.
	 *
	 * @param persistedVitaminId the persisted vitamin ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vitamin detail, or <code>null</code> if a matching vitamin detail could not be found
	 */
	public static VitaminDetail fetchByPersistedVitaminId_First(
		long persistedVitaminId,
		OrderByComparator<VitaminDetail> orderByComparator) {

		return getPersistence().fetchByPersistedVitaminId_First(
			persistedVitaminId, orderByComparator);
	}

	/**
	 * Returns the last vitamin detail in the ordered set where persistedVitaminId = &#63;.
	 *
	 * @param persistedVitaminId the persisted vitamin ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vitamin detail
	 * @throws NoSuchVitaminDetailException if a matching vitamin detail could not be found
	 */
	public static VitaminDetail findByPersistedVitaminId_Last(
			long persistedVitaminId,
			OrderByComparator<VitaminDetail> orderByComparator)
		throws com.dnebinger.vitamins.exception.NoSuchVitaminDetailException {

		return getPersistence().findByPersistedVitaminId_Last(
			persistedVitaminId, orderByComparator);
	}

	/**
	 * Returns the last vitamin detail in the ordered set where persistedVitaminId = &#63;.
	 *
	 * @param persistedVitaminId the persisted vitamin ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vitamin detail, or <code>null</code> if a matching vitamin detail could not be found
	 */
	public static VitaminDetail fetchByPersistedVitaminId_Last(
		long persistedVitaminId,
		OrderByComparator<VitaminDetail> orderByComparator) {

		return getPersistence().fetchByPersistedVitaminId_Last(
			persistedVitaminId, orderByComparator);
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
	public static VitaminDetail[] findByPersistedVitaminId_PrevAndNext(
			long vitaminDetailId, long persistedVitaminId,
			OrderByComparator<VitaminDetail> orderByComparator)
		throws com.dnebinger.vitamins.exception.NoSuchVitaminDetailException {

		return getPersistence().findByPersistedVitaminId_PrevAndNext(
			vitaminDetailId, persistedVitaminId, orderByComparator);
	}

	/**
	 * Removes all the vitamin details where persistedVitaminId = &#63; from the database.
	 *
	 * @param persistedVitaminId the persisted vitamin ID
	 */
	public static void removeByPersistedVitaminId(long persistedVitaminId) {
		getPersistence().removeByPersistedVitaminId(persistedVitaminId);
	}

	/**
	 * Returns the number of vitamin details where persistedVitaminId = &#63;.
	 *
	 * @param persistedVitaminId the persisted vitamin ID
	 * @return the number of matching vitamin details
	 */
	public static int countByPersistedVitaminId(long persistedVitaminId) {
		return getPersistence().countByPersistedVitaminId(persistedVitaminId);
	}

	/**
	 * Returns all the vitamin details where persistedVitaminId = &#63; and type = &#63;.
	 *
	 * @param persistedVitaminId the persisted vitamin ID
	 * @param type the type
	 * @return the matching vitamin details
	 */
	public static List<VitaminDetail> findByPersistedVitaminIdType(
		long persistedVitaminId, int type) {

		return getPersistence().findByPersistedVitaminIdType(
			persistedVitaminId, type);
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
	public static List<VitaminDetail> findByPersistedVitaminIdType(
		long persistedVitaminId, int type, int start, int end) {

		return getPersistence().findByPersistedVitaminIdType(
			persistedVitaminId, type, start, end);
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
	public static List<VitaminDetail> findByPersistedVitaminIdType(
		long persistedVitaminId, int type, int start, int end,
		OrderByComparator<VitaminDetail> orderByComparator) {

		return getPersistence().findByPersistedVitaminIdType(
			persistedVitaminId, type, start, end, orderByComparator);
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
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching vitamin details
	 */
	public static List<VitaminDetail> findByPersistedVitaminIdType(
		long persistedVitaminId, int type, int start, int end,
		OrderByComparator<VitaminDetail> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByPersistedVitaminIdType(
			persistedVitaminId, type, start, end, orderByComparator,
			retrieveFromCache);
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
	public static VitaminDetail findByPersistedVitaminIdType_First(
			long persistedVitaminId, int type,
			OrderByComparator<VitaminDetail> orderByComparator)
		throws com.dnebinger.vitamins.exception.NoSuchVitaminDetailException {

		return getPersistence().findByPersistedVitaminIdType_First(
			persistedVitaminId, type, orderByComparator);
	}

	/**
	 * Returns the first vitamin detail in the ordered set where persistedVitaminId = &#63; and type = &#63;.
	 *
	 * @param persistedVitaminId the persisted vitamin ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vitamin detail, or <code>null</code> if a matching vitamin detail could not be found
	 */
	public static VitaminDetail fetchByPersistedVitaminIdType_First(
		long persistedVitaminId, int type,
		OrderByComparator<VitaminDetail> orderByComparator) {

		return getPersistence().fetchByPersistedVitaminIdType_First(
			persistedVitaminId, type, orderByComparator);
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
	public static VitaminDetail findByPersistedVitaminIdType_Last(
			long persistedVitaminId, int type,
			OrderByComparator<VitaminDetail> orderByComparator)
		throws com.dnebinger.vitamins.exception.NoSuchVitaminDetailException {

		return getPersistence().findByPersistedVitaminIdType_Last(
			persistedVitaminId, type, orderByComparator);
	}

	/**
	 * Returns the last vitamin detail in the ordered set where persistedVitaminId = &#63; and type = &#63;.
	 *
	 * @param persistedVitaminId the persisted vitamin ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vitamin detail, or <code>null</code> if a matching vitamin detail could not be found
	 */
	public static VitaminDetail fetchByPersistedVitaminIdType_Last(
		long persistedVitaminId, int type,
		OrderByComparator<VitaminDetail> orderByComparator) {

		return getPersistence().fetchByPersistedVitaminIdType_Last(
			persistedVitaminId, type, orderByComparator);
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
	public static VitaminDetail[] findByPersistedVitaminIdType_PrevAndNext(
			long vitaminDetailId, long persistedVitaminId, int type,
			OrderByComparator<VitaminDetail> orderByComparator)
		throws com.dnebinger.vitamins.exception.NoSuchVitaminDetailException {

		return getPersistence().findByPersistedVitaminIdType_PrevAndNext(
			vitaminDetailId, persistedVitaminId, type, orderByComparator);
	}

	/**
	 * Removes all the vitamin details where persistedVitaminId = &#63; and type = &#63; from the database.
	 *
	 * @param persistedVitaminId the persisted vitamin ID
	 * @param type the type
	 */
	public static void removeByPersistedVitaminIdType(
		long persistedVitaminId, int type) {

		getPersistence().removeByPersistedVitaminIdType(
			persistedVitaminId, type);
	}

	/**
	 * Returns the number of vitamin details where persistedVitaminId = &#63; and type = &#63;.
	 *
	 * @param persistedVitaminId the persisted vitamin ID
	 * @param type the type
	 * @return the number of matching vitamin details
	 */
	public static int countByPersistedVitaminIdType(
		long persistedVitaminId, int type) {

		return getPersistence().countByPersistedVitaminIdType(
			persistedVitaminId, type);
	}

	/**
	 * Caches the vitamin detail in the entity cache if it is enabled.
	 *
	 * @param vitaminDetail the vitamin detail
	 */
	public static void cacheResult(VitaminDetail vitaminDetail) {
		getPersistence().cacheResult(vitaminDetail);
	}

	/**
	 * Caches the vitamin details in the entity cache if it is enabled.
	 *
	 * @param vitaminDetails the vitamin details
	 */
	public static void cacheResult(List<VitaminDetail> vitaminDetails) {
		getPersistence().cacheResult(vitaminDetails);
	}

	/**
	 * Creates a new vitamin detail with the primary key. Does not add the vitamin detail to the database.
	 *
	 * @param vitaminDetailId the primary key for the new vitamin detail
	 * @return the new vitamin detail
	 */
	public static VitaminDetail create(long vitaminDetailId) {
		return getPersistence().create(vitaminDetailId);
	}

	/**
	 * Removes the vitamin detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param vitaminDetailId the primary key of the vitamin detail
	 * @return the vitamin detail that was removed
	 * @throws NoSuchVitaminDetailException if a vitamin detail with the primary key could not be found
	 */
	public static VitaminDetail remove(long vitaminDetailId)
		throws com.dnebinger.vitamins.exception.NoSuchVitaminDetailException {

		return getPersistence().remove(vitaminDetailId);
	}

	public static VitaminDetail updateImpl(VitaminDetail vitaminDetail) {
		return getPersistence().updateImpl(vitaminDetail);
	}

	/**
	 * Returns the vitamin detail with the primary key or throws a <code>NoSuchVitaminDetailException</code> if it could not be found.
	 *
	 * @param vitaminDetailId the primary key of the vitamin detail
	 * @return the vitamin detail
	 * @throws NoSuchVitaminDetailException if a vitamin detail with the primary key could not be found
	 */
	public static VitaminDetail findByPrimaryKey(long vitaminDetailId)
		throws com.dnebinger.vitamins.exception.NoSuchVitaminDetailException {

		return getPersistence().findByPrimaryKey(vitaminDetailId);
	}

	/**
	 * Returns the vitamin detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param vitaminDetailId the primary key of the vitamin detail
	 * @return the vitamin detail, or <code>null</code> if a vitamin detail with the primary key could not be found
	 */
	public static VitaminDetail fetchByPrimaryKey(long vitaminDetailId) {
		return getPersistence().fetchByPrimaryKey(vitaminDetailId);
	}

	/**
	 * Returns all the vitamin details.
	 *
	 * @return the vitamin details
	 */
	public static List<VitaminDetail> findAll() {
		return getPersistence().findAll();
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
	public static List<VitaminDetail> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<VitaminDetail> findAll(
		int start, int end,
		OrderByComparator<VitaminDetail> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of vitamin details
	 */
	public static List<VitaminDetail> findAll(
		int start, int end, OrderByComparator<VitaminDetail> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the vitamin details from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of vitamin details.
	 *
	 * @return the number of vitamin details
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static VitaminDetailPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<VitaminDetailPersistence, VitaminDetailPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(VitaminDetailPersistence.class);

		ServiceTracker<VitaminDetailPersistence, VitaminDetailPersistence>
			serviceTracker =
				new ServiceTracker
					<VitaminDetailPersistence, VitaminDetailPersistence>(
						bundle.getBundleContext(),
						VitaminDetailPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}