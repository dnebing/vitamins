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

import com.dnebinger.vitamins.exception.NoSuchVitaminDetailException;
import com.dnebinger.vitamins.model.VitaminDetail;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the vitamin detail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see VitaminDetailUtil
 * @generated
 */
@ProviderType
public interface VitaminDetailPersistence
	extends BasePersistence<VitaminDetail> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VitaminDetailUtil} to access the vitamin detail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the vitamin details where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching vitamin details
	 */
	public java.util.List<VitaminDetail> findByUuid(String uuid);

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
	public java.util.List<VitaminDetail> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<VitaminDetail> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VitaminDetail>
			orderByComparator);

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
	public java.util.List<VitaminDetail> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VitaminDetail>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first vitamin detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vitamin detail
	 * @throws NoSuchVitaminDetailException if a matching vitamin detail could not be found
	 */
	public VitaminDetail findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<VitaminDetail>
				orderByComparator)
		throws NoSuchVitaminDetailException;

	/**
	 * Returns the first vitamin detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vitamin detail, or <code>null</code> if a matching vitamin detail could not be found
	 */
	public VitaminDetail fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<VitaminDetail>
			orderByComparator);

	/**
	 * Returns the last vitamin detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vitamin detail
	 * @throws NoSuchVitaminDetailException if a matching vitamin detail could not be found
	 */
	public VitaminDetail findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<VitaminDetail>
				orderByComparator)
		throws NoSuchVitaminDetailException;

	/**
	 * Returns the last vitamin detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vitamin detail, or <code>null</code> if a matching vitamin detail could not be found
	 */
	public VitaminDetail fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<VitaminDetail>
			orderByComparator);

	/**
	 * Returns the vitamin details before and after the current vitamin detail in the ordered set where uuid = &#63;.
	 *
	 * @param vitaminDetailId the primary key of the current vitamin detail
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vitamin detail
	 * @throws NoSuchVitaminDetailException if a vitamin detail with the primary key could not be found
	 */
	public VitaminDetail[] findByUuid_PrevAndNext(
			long vitaminDetailId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<VitaminDetail>
				orderByComparator)
		throws NoSuchVitaminDetailException;

	/**
	 * Removes all the vitamin details where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of vitamin details where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching vitamin details
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the vitamin detail where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchVitaminDetailException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching vitamin detail
	 * @throws NoSuchVitaminDetailException if a matching vitamin detail could not be found
	 */
	public VitaminDetail findByUUID_G(String uuid, long groupId)
		throws NoSuchVitaminDetailException;

	/**
	 * Returns the vitamin detail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching vitamin detail, or <code>null</code> if a matching vitamin detail could not be found
	 */
	public VitaminDetail fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the vitamin detail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching vitamin detail, or <code>null</code> if a matching vitamin detail could not be found
	 */
	public VitaminDetail fetchByUUID_G(
		String uuid, long groupId, boolean retrieveFromCache);

	/**
	 * Removes the vitamin detail where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the vitamin detail that was removed
	 */
	public VitaminDetail removeByUUID_G(String uuid, long groupId)
		throws NoSuchVitaminDetailException;

	/**
	 * Returns the number of vitamin details where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching vitamin details
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the vitamin details where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching vitamin details
	 */
	public java.util.List<VitaminDetail> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<VitaminDetail> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<VitaminDetail> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VitaminDetail>
			orderByComparator);

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
	public java.util.List<VitaminDetail> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VitaminDetail>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first vitamin detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vitamin detail
	 * @throws NoSuchVitaminDetailException if a matching vitamin detail could not be found
	 */
	public VitaminDetail findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<VitaminDetail>
				orderByComparator)
		throws NoSuchVitaminDetailException;

	/**
	 * Returns the first vitamin detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vitamin detail, or <code>null</code> if a matching vitamin detail could not be found
	 */
	public VitaminDetail fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<VitaminDetail>
			orderByComparator);

	/**
	 * Returns the last vitamin detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vitamin detail
	 * @throws NoSuchVitaminDetailException if a matching vitamin detail could not be found
	 */
	public VitaminDetail findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<VitaminDetail>
				orderByComparator)
		throws NoSuchVitaminDetailException;

	/**
	 * Returns the last vitamin detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vitamin detail, or <code>null</code> if a matching vitamin detail could not be found
	 */
	public VitaminDetail fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<VitaminDetail>
			orderByComparator);

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
	public VitaminDetail[] findByUuid_C_PrevAndNext(
			long vitaminDetailId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<VitaminDetail>
				orderByComparator)
		throws NoSuchVitaminDetailException;

	/**
	 * Removes all the vitamin details where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of vitamin details where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching vitamin details
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the vitamin details where persistedVitaminId = &#63;.
	 *
	 * @param persistedVitaminId the persisted vitamin ID
	 * @return the matching vitamin details
	 */
	public java.util.List<VitaminDetail> findByPersistedVitaminId(
		long persistedVitaminId);

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
	public java.util.List<VitaminDetail> findByPersistedVitaminId(
		long persistedVitaminId, int start, int end);

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
	public java.util.List<VitaminDetail> findByPersistedVitaminId(
		long persistedVitaminId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VitaminDetail>
			orderByComparator);

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
	public java.util.List<VitaminDetail> findByPersistedVitaminId(
		long persistedVitaminId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VitaminDetail>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first vitamin detail in the ordered set where persistedVitaminId = &#63;.
	 *
	 * @param persistedVitaminId the persisted vitamin ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vitamin detail
	 * @throws NoSuchVitaminDetailException if a matching vitamin detail could not be found
	 */
	public VitaminDetail findByPersistedVitaminId_First(
			long persistedVitaminId,
			com.liferay.portal.kernel.util.OrderByComparator<VitaminDetail>
				orderByComparator)
		throws NoSuchVitaminDetailException;

	/**
	 * Returns the first vitamin detail in the ordered set where persistedVitaminId = &#63;.
	 *
	 * @param persistedVitaminId the persisted vitamin ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vitamin detail, or <code>null</code> if a matching vitamin detail could not be found
	 */
	public VitaminDetail fetchByPersistedVitaminId_First(
		long persistedVitaminId,
		com.liferay.portal.kernel.util.OrderByComparator<VitaminDetail>
			orderByComparator);

	/**
	 * Returns the last vitamin detail in the ordered set where persistedVitaminId = &#63;.
	 *
	 * @param persistedVitaminId the persisted vitamin ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vitamin detail
	 * @throws NoSuchVitaminDetailException if a matching vitamin detail could not be found
	 */
	public VitaminDetail findByPersistedVitaminId_Last(
			long persistedVitaminId,
			com.liferay.portal.kernel.util.OrderByComparator<VitaminDetail>
				orderByComparator)
		throws NoSuchVitaminDetailException;

	/**
	 * Returns the last vitamin detail in the ordered set where persistedVitaminId = &#63;.
	 *
	 * @param persistedVitaminId the persisted vitamin ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vitamin detail, or <code>null</code> if a matching vitamin detail could not be found
	 */
	public VitaminDetail fetchByPersistedVitaminId_Last(
		long persistedVitaminId,
		com.liferay.portal.kernel.util.OrderByComparator<VitaminDetail>
			orderByComparator);

	/**
	 * Returns the vitamin details before and after the current vitamin detail in the ordered set where persistedVitaminId = &#63;.
	 *
	 * @param vitaminDetailId the primary key of the current vitamin detail
	 * @param persistedVitaminId the persisted vitamin ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vitamin detail
	 * @throws NoSuchVitaminDetailException if a vitamin detail with the primary key could not be found
	 */
	public VitaminDetail[] findByPersistedVitaminId_PrevAndNext(
			long vitaminDetailId, long persistedVitaminId,
			com.liferay.portal.kernel.util.OrderByComparator<VitaminDetail>
				orderByComparator)
		throws NoSuchVitaminDetailException;

	/**
	 * Removes all the vitamin details where persistedVitaminId = &#63; from the database.
	 *
	 * @param persistedVitaminId the persisted vitamin ID
	 */
	public void removeByPersistedVitaminId(long persistedVitaminId);

	/**
	 * Returns the number of vitamin details where persistedVitaminId = &#63;.
	 *
	 * @param persistedVitaminId the persisted vitamin ID
	 * @return the number of matching vitamin details
	 */
	public int countByPersistedVitaminId(long persistedVitaminId);

	/**
	 * Returns all the vitamin details where persistedVitaminId = &#63; and type = &#63;.
	 *
	 * @param persistedVitaminId the persisted vitamin ID
	 * @param type the type
	 * @return the matching vitamin details
	 */
	public java.util.List<VitaminDetail> findByPersistedVitaminIdType(
		long persistedVitaminId, int type);

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
	public java.util.List<VitaminDetail> findByPersistedVitaminIdType(
		long persistedVitaminId, int type, int start, int end);

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
	public java.util.List<VitaminDetail> findByPersistedVitaminIdType(
		long persistedVitaminId, int type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VitaminDetail>
			orderByComparator);

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
	public java.util.List<VitaminDetail> findByPersistedVitaminIdType(
		long persistedVitaminId, int type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VitaminDetail>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first vitamin detail in the ordered set where persistedVitaminId = &#63; and type = &#63;.
	 *
	 * @param persistedVitaminId the persisted vitamin ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vitamin detail
	 * @throws NoSuchVitaminDetailException if a matching vitamin detail could not be found
	 */
	public VitaminDetail findByPersistedVitaminIdType_First(
			long persistedVitaminId, int type,
			com.liferay.portal.kernel.util.OrderByComparator<VitaminDetail>
				orderByComparator)
		throws NoSuchVitaminDetailException;

	/**
	 * Returns the first vitamin detail in the ordered set where persistedVitaminId = &#63; and type = &#63;.
	 *
	 * @param persistedVitaminId the persisted vitamin ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vitamin detail, or <code>null</code> if a matching vitamin detail could not be found
	 */
	public VitaminDetail fetchByPersistedVitaminIdType_First(
		long persistedVitaminId, int type,
		com.liferay.portal.kernel.util.OrderByComparator<VitaminDetail>
			orderByComparator);

	/**
	 * Returns the last vitamin detail in the ordered set where persistedVitaminId = &#63; and type = &#63;.
	 *
	 * @param persistedVitaminId the persisted vitamin ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vitamin detail
	 * @throws NoSuchVitaminDetailException if a matching vitamin detail could not be found
	 */
	public VitaminDetail findByPersistedVitaminIdType_Last(
			long persistedVitaminId, int type,
			com.liferay.portal.kernel.util.OrderByComparator<VitaminDetail>
				orderByComparator)
		throws NoSuchVitaminDetailException;

	/**
	 * Returns the last vitamin detail in the ordered set where persistedVitaminId = &#63; and type = &#63;.
	 *
	 * @param persistedVitaminId the persisted vitamin ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vitamin detail, or <code>null</code> if a matching vitamin detail could not be found
	 */
	public VitaminDetail fetchByPersistedVitaminIdType_Last(
		long persistedVitaminId, int type,
		com.liferay.portal.kernel.util.OrderByComparator<VitaminDetail>
			orderByComparator);

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
	public VitaminDetail[] findByPersistedVitaminIdType_PrevAndNext(
			long vitaminDetailId, long persistedVitaminId, int type,
			com.liferay.portal.kernel.util.OrderByComparator<VitaminDetail>
				orderByComparator)
		throws NoSuchVitaminDetailException;

	/**
	 * Removes all the vitamin details where persistedVitaminId = &#63; and type = &#63; from the database.
	 *
	 * @param persistedVitaminId the persisted vitamin ID
	 * @param type the type
	 */
	public void removeByPersistedVitaminIdType(
		long persistedVitaminId, int type);

	/**
	 * Returns the number of vitamin details where persistedVitaminId = &#63; and type = &#63;.
	 *
	 * @param persistedVitaminId the persisted vitamin ID
	 * @param type the type
	 * @return the number of matching vitamin details
	 */
	public int countByPersistedVitaminIdType(long persistedVitaminId, int type);

	/**
	 * Caches the vitamin detail in the entity cache if it is enabled.
	 *
	 * @param vitaminDetail the vitamin detail
	 */
	public void cacheResult(VitaminDetail vitaminDetail);

	/**
	 * Caches the vitamin details in the entity cache if it is enabled.
	 *
	 * @param vitaminDetails the vitamin details
	 */
	public void cacheResult(java.util.List<VitaminDetail> vitaminDetails);

	/**
	 * Creates a new vitamin detail with the primary key. Does not add the vitamin detail to the database.
	 *
	 * @param vitaminDetailId the primary key for the new vitamin detail
	 * @return the new vitamin detail
	 */
	public VitaminDetail create(long vitaminDetailId);

	/**
	 * Removes the vitamin detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param vitaminDetailId the primary key of the vitamin detail
	 * @return the vitamin detail that was removed
	 * @throws NoSuchVitaminDetailException if a vitamin detail with the primary key could not be found
	 */
	public VitaminDetail remove(long vitaminDetailId)
		throws NoSuchVitaminDetailException;

	public VitaminDetail updateImpl(VitaminDetail vitaminDetail);

	/**
	 * Returns the vitamin detail with the primary key or throws a <code>NoSuchVitaminDetailException</code> if it could not be found.
	 *
	 * @param vitaminDetailId the primary key of the vitamin detail
	 * @return the vitamin detail
	 * @throws NoSuchVitaminDetailException if a vitamin detail with the primary key could not be found
	 */
	public VitaminDetail findByPrimaryKey(long vitaminDetailId)
		throws NoSuchVitaminDetailException;

	/**
	 * Returns the vitamin detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param vitaminDetailId the primary key of the vitamin detail
	 * @return the vitamin detail, or <code>null</code> if a vitamin detail with the primary key could not be found
	 */
	public VitaminDetail fetchByPrimaryKey(long vitaminDetailId);

	/**
	 * Returns all the vitamin details.
	 *
	 * @return the vitamin details
	 */
	public java.util.List<VitaminDetail> findAll();

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
	public java.util.List<VitaminDetail> findAll(int start, int end);

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
	public java.util.List<VitaminDetail> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VitaminDetail>
			orderByComparator);

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
	public java.util.List<VitaminDetail> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VitaminDetail>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the vitamin details from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of vitamin details.
	 *
	 * @return the number of vitamin details
	 */
	public int countAll();

}