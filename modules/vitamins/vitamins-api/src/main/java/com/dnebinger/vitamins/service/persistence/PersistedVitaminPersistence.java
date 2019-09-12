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

import com.dnebinger.vitamins.exception.NoSuchPersistedVitaminException;
import com.dnebinger.vitamins.model.PersistedVitamin;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the persisted vitamin service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersistedVitaminUtil
 * @generated
 */
@ProviderType
public interface PersistedVitaminPersistence
	extends BasePersistence<PersistedVitamin> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PersistedVitaminUtil} to access the persisted vitamin persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the persisted vitamins where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching persisted vitamins
	 */
	public java.util.List<PersistedVitamin> findByUuid(String uuid);

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
	public java.util.List<PersistedVitamin> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<PersistedVitamin> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedVitamin>
			orderByComparator);

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
	public java.util.List<PersistedVitamin> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedVitamin>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first persisted vitamin in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted vitamin
	 * @throws NoSuchPersistedVitaminException if a matching persisted vitamin could not be found
	 */
	public PersistedVitamin findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PersistedVitamin>
				orderByComparator)
		throws NoSuchPersistedVitaminException;

	/**
	 * Returns the first persisted vitamin in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted vitamin, or <code>null</code> if a matching persisted vitamin could not be found
	 */
	public PersistedVitamin fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedVitamin>
			orderByComparator);

	/**
	 * Returns the last persisted vitamin in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted vitamin
	 * @throws NoSuchPersistedVitaminException if a matching persisted vitamin could not be found
	 */
	public PersistedVitamin findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PersistedVitamin>
				orderByComparator)
		throws NoSuchPersistedVitaminException;

	/**
	 * Returns the last persisted vitamin in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted vitamin, or <code>null</code> if a matching persisted vitamin could not be found
	 */
	public PersistedVitamin fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedVitamin>
			orderByComparator);

	/**
	 * Returns the persisted vitamins before and after the current persisted vitamin in the ordered set where uuid = &#63;.
	 *
	 * @param persistedVitaminId the primary key of the current persisted vitamin
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next persisted vitamin
	 * @throws NoSuchPersistedVitaminException if a persisted vitamin with the primary key could not be found
	 */
	public PersistedVitamin[] findByUuid_PrevAndNext(
			long persistedVitaminId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PersistedVitamin>
				orderByComparator)
		throws NoSuchPersistedVitaminException;

	/**
	 * Removes all the persisted vitamins where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of persisted vitamins where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching persisted vitamins
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the persisted vitamin where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchPersistedVitaminException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching persisted vitamin
	 * @throws NoSuchPersistedVitaminException if a matching persisted vitamin could not be found
	 */
	public PersistedVitamin findByUUID_G(String uuid, long groupId)
		throws NoSuchPersistedVitaminException;

	/**
	 * Returns the persisted vitamin where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching persisted vitamin, or <code>null</code> if a matching persisted vitamin could not be found
	 */
	public PersistedVitamin fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the persisted vitamin where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching persisted vitamin, or <code>null</code> if a matching persisted vitamin could not be found
	 */
	public PersistedVitamin fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the persisted vitamin where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the persisted vitamin that was removed
	 */
	public PersistedVitamin removeByUUID_G(String uuid, long groupId)
		throws NoSuchPersistedVitaminException;

	/**
	 * Returns the number of persisted vitamins where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching persisted vitamins
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the persisted vitamins where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching persisted vitamins
	 */
	public java.util.List<PersistedVitamin> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<PersistedVitamin> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<PersistedVitamin> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedVitamin>
			orderByComparator);

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
	public java.util.List<PersistedVitamin> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedVitamin>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first persisted vitamin in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted vitamin
	 * @throws NoSuchPersistedVitaminException if a matching persisted vitamin could not be found
	 */
	public PersistedVitamin findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<PersistedVitamin>
				orderByComparator)
		throws NoSuchPersistedVitaminException;

	/**
	 * Returns the first persisted vitamin in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted vitamin, or <code>null</code> if a matching persisted vitamin could not be found
	 */
	public PersistedVitamin fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedVitamin>
			orderByComparator);

	/**
	 * Returns the last persisted vitamin in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted vitamin
	 * @throws NoSuchPersistedVitaminException if a matching persisted vitamin could not be found
	 */
	public PersistedVitamin findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<PersistedVitamin>
				orderByComparator)
		throws NoSuchPersistedVitaminException;

	/**
	 * Returns the last persisted vitamin in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted vitamin, or <code>null</code> if a matching persisted vitamin could not be found
	 */
	public PersistedVitamin fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedVitamin>
			orderByComparator);

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
	public PersistedVitamin[] findByUuid_C_PrevAndNext(
			long persistedVitaminId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<PersistedVitamin>
				orderByComparator)
		throws NoSuchPersistedVitaminException;

	/**
	 * Removes all the persisted vitamins where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of persisted vitamins where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching persisted vitamins
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the persisted vitamin where surrogateId = &#63; or throws a <code>NoSuchPersistedVitaminException</code> if it could not be found.
	 *
	 * @param surrogateId the surrogate ID
	 * @return the matching persisted vitamin
	 * @throws NoSuchPersistedVitaminException if a matching persisted vitamin could not be found
	 */
	public PersistedVitamin findBySurrogateId(String surrogateId)
		throws NoSuchPersistedVitaminException;

	/**
	 * Returns the persisted vitamin where surrogateId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param surrogateId the surrogate ID
	 * @return the matching persisted vitamin, or <code>null</code> if a matching persisted vitamin could not be found
	 */
	public PersistedVitamin fetchBySurrogateId(String surrogateId);

	/**
	 * Returns the persisted vitamin where surrogateId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param surrogateId the surrogate ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching persisted vitamin, or <code>null</code> if a matching persisted vitamin could not be found
	 */
	public PersistedVitamin fetchBySurrogateId(
		String surrogateId, boolean useFinderCache);

	/**
	 * Removes the persisted vitamin where surrogateId = &#63; from the database.
	 *
	 * @param surrogateId the surrogate ID
	 * @return the persisted vitamin that was removed
	 */
	public PersistedVitamin removeBySurrogateId(String surrogateId)
		throws NoSuchPersistedVitaminException;

	/**
	 * Returns the number of persisted vitamins where surrogateId = &#63;.
	 *
	 * @param surrogateId the surrogate ID
	 * @return the number of matching persisted vitamins
	 */
	public int countBySurrogateId(String surrogateId);

	/**
	 * Returns the persisted vitamin where name = &#63; or throws a <code>NoSuchPersistedVitaminException</code> if it could not be found.
	 *
	 * @param name the name
	 * @return the matching persisted vitamin
	 * @throws NoSuchPersistedVitaminException if a matching persisted vitamin could not be found
	 */
	public PersistedVitamin findByName(String name)
		throws NoSuchPersistedVitaminException;

	/**
	 * Returns the persisted vitamin where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching persisted vitamin, or <code>null</code> if a matching persisted vitamin could not be found
	 */
	public PersistedVitamin fetchByName(String name);

	/**
	 * Returns the persisted vitamin where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching persisted vitamin, or <code>null</code> if a matching persisted vitamin could not be found
	 */
	public PersistedVitamin fetchByName(String name, boolean useFinderCache);

	/**
	 * Removes the persisted vitamin where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the persisted vitamin that was removed
	 */
	public PersistedVitamin removeByName(String name)
		throws NoSuchPersistedVitaminException;

	/**
	 * Returns the number of persisted vitamins where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching persisted vitamins
	 */
	public int countByName(String name);

	/**
	 * Caches the persisted vitamin in the entity cache if it is enabled.
	 *
	 * @param persistedVitamin the persisted vitamin
	 */
	public void cacheResult(PersistedVitamin persistedVitamin);

	/**
	 * Caches the persisted vitamins in the entity cache if it is enabled.
	 *
	 * @param persistedVitamins the persisted vitamins
	 */
	public void cacheResult(java.util.List<PersistedVitamin> persistedVitamins);

	/**
	 * Creates a new persisted vitamin with the primary key. Does not add the persisted vitamin to the database.
	 *
	 * @param persistedVitaminId the primary key for the new persisted vitamin
	 * @return the new persisted vitamin
	 */
	public PersistedVitamin create(long persistedVitaminId);

	/**
	 * Removes the persisted vitamin with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param persistedVitaminId the primary key of the persisted vitamin
	 * @return the persisted vitamin that was removed
	 * @throws NoSuchPersistedVitaminException if a persisted vitamin with the primary key could not be found
	 */
	public PersistedVitamin remove(long persistedVitaminId)
		throws NoSuchPersistedVitaminException;

	public PersistedVitamin updateImpl(PersistedVitamin persistedVitamin);

	/**
	 * Returns the persisted vitamin with the primary key or throws a <code>NoSuchPersistedVitaminException</code> if it could not be found.
	 *
	 * @param persistedVitaminId the primary key of the persisted vitamin
	 * @return the persisted vitamin
	 * @throws NoSuchPersistedVitaminException if a persisted vitamin with the primary key could not be found
	 */
	public PersistedVitamin findByPrimaryKey(long persistedVitaminId)
		throws NoSuchPersistedVitaminException;

	/**
	 * Returns the persisted vitamin with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param persistedVitaminId the primary key of the persisted vitamin
	 * @return the persisted vitamin, or <code>null</code> if a persisted vitamin with the primary key could not be found
	 */
	public PersistedVitamin fetchByPrimaryKey(long persistedVitaminId);

	/**
	 * Returns all the persisted vitamins.
	 *
	 * @return the persisted vitamins
	 */
	public java.util.List<PersistedVitamin> findAll();

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
	public java.util.List<PersistedVitamin> findAll(int start, int end);

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
	public java.util.List<PersistedVitamin> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedVitamin>
			orderByComparator);

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
	public java.util.List<PersistedVitamin> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedVitamin>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the persisted vitamins from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of persisted vitamins.
	 *
	 * @return the number of persisted vitamins
	 */
	public int countAll();

}