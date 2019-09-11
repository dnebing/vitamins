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

package com.dnebinger.vitamins.service;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for VitaminDetail. This utility wraps
 * <code>com.dnebinger.vitamins.service.impl.VitaminDetailLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see VitaminDetailLocalService
 * @generated
 */
@ProviderType
public class VitaminDetailLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.dnebinger.vitamins.service.impl.VitaminDetailLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * addVitaminDetail: Adds a new vitamin detail record.
	 *
	 * @param persistedVitaminId
	 * @param typeCode
	 * @param value
	 * @return VitaminDetail: The new instance.
	 */
	public static com.dnebinger.vitamins.model.VitaminDetail addVitaminDetail(
			long persistedVitaminId, int typeCode, String value,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addVitaminDetail(
			persistedVitaminId, typeCode, value, serviceContext);
	}

	/**
	 * Adds the vitamin detail to the database. Also notifies the appropriate model listeners.
	 *
	 * @param vitaminDetail the vitamin detail
	 * @return the vitamin detail that was added
	 */
	public static com.dnebinger.vitamins.model.VitaminDetail addVitaminDetail(
		com.dnebinger.vitamins.model.VitaminDetail vitaminDetail) {

		return getService().addVitaminDetail(vitaminDetail);
	}

	/**
	 * Creates a new vitamin detail with the primary key. Does not add the vitamin detail to the database.
	 *
	 * @param vitaminDetailId the primary key for the new vitamin detail
	 * @return the new vitamin detail
	 */
	public static com.dnebinger.vitamins.model.VitaminDetail
		createVitaminDetail(long vitaminDetailId) {

		return getService().createVitaminDetail(vitaminDetailId);
	}

	/**
	 * deleteAllVitaminDetails: Deletes all of the vitamin details.
	 *
	 * @param persistedVitaminId
	 */
	public static void deleteAllVitaminDetails(long persistedVitaminId) {
		getService().deleteAllVitaminDetails(persistedVitaminId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the vitamin detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param vitaminDetailId the primary key of the vitamin detail
	 * @return the vitamin detail that was removed
	 * @throws PortalException if a vitamin detail with the primary key could not be found
	 */
	public static com.dnebinger.vitamins.model.VitaminDetail
			deleteVitaminDetail(long vitaminDetailId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteVitaminDetail(vitaminDetailId);
	}

	/**
	 * Deletes the vitamin detail from the database. Also notifies the appropriate model listeners.
	 *
	 * @param vitaminDetail the vitamin detail
	 * @return the vitamin detail that was removed
	 */
	public static com.dnebinger.vitamins.model.VitaminDetail
		deleteVitaminDetail(
			com.dnebinger.vitamins.model.VitaminDetail vitaminDetail) {

		return getService().deleteVitaminDetail(vitaminDetail);
	}

	public static void deleteVitaminDetailsByType(
		long persistedVitaminId, int typeCode) {

		getService().deleteVitaminDetailsByType(persistedVitaminId, typeCode);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.dnebinger.vitamins.model.impl.VitaminDetailModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.dnebinger.vitamins.model.impl.VitaminDetailModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.dnebinger.vitamins.model.VitaminDetail fetchVitaminDetail(
		long vitaminDetailId) {

		return getService().fetchVitaminDetail(vitaminDetailId);
	}

	/**
	 * Returns the vitamin detail matching the UUID and group.
	 *
	 * @param uuid the vitamin detail's UUID
	 * @param groupId the primary key of the group
	 * @return the matching vitamin detail, or <code>null</code> if a matching vitamin detail could not be found
	 */
	public static com.dnebinger.vitamins.model.VitaminDetail
		fetchVitaminDetailByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchVitaminDetailByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * getAllVitaminDetails: Returns the full list of details for the given persisted vitamin id.
	 *
	 * @param persistedVitaminId
	 * @return List The list of vitamin details.
	 */
	public static java.util.List<com.dnebinger.vitamins.model.VitaminDetail>
		getAllVitaminDetails(long persistedVitaminId) {

		return getService().getAllVitaminDetails(persistedVitaminId);
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the vitamin detail with the primary key.
	 *
	 * @param vitaminDetailId the primary key of the vitamin detail
	 * @return the vitamin detail
	 * @throws PortalException if a vitamin detail with the primary key could not be found
	 */
	public static com.dnebinger.vitamins.model.VitaminDetail getVitaminDetail(
			long vitaminDetailId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getVitaminDetail(vitaminDetailId);
	}

	/**
	 * Returns the vitamin detail matching the UUID and group.
	 *
	 * @param uuid the vitamin detail's UUID
	 * @param groupId the primary key of the group
	 * @return the matching vitamin detail
	 * @throws PortalException if a matching vitamin detail could not be found
	 */
	public static com.dnebinger.vitamins.model.VitaminDetail
			getVitaminDetailByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getVitaminDetailByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the vitamin details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.dnebinger.vitamins.model.impl.VitaminDetailModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of vitamin details
	 * @param end the upper bound of the range of vitamin details (not inclusive)
	 * @return the range of vitamin details
	 */
	public static java.util.List<com.dnebinger.vitamins.model.VitaminDetail>
		getVitaminDetails(int start, int end) {

		return getService().getVitaminDetails(start, end);
	}

	/**
	 * getVitaminDetailsByType: Returns the list of details for the given persisted vitamin id and type.
	 *
	 * @param persistedVitaminId
	 * @param typeCode
	 * @return List The list of vitamin details.
	 */
	public static java.util.List<com.dnebinger.vitamins.model.VitaminDetail>
		getVitaminDetailsByType(long persistedVitaminId, int typeCode) {

		return getService().getVitaminDetailsByType(
			persistedVitaminId, typeCode);
	}

	/**
	 * Returns all the vitamin details matching the UUID and company.
	 *
	 * @param uuid the UUID of the vitamin details
	 * @param companyId the primary key of the company
	 * @return the matching vitamin details, or an empty list if no matches were found
	 */
	public static java.util.List<com.dnebinger.vitamins.model.VitaminDetail>
		getVitaminDetailsByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getVitaminDetailsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of vitamin details matching the UUID and company.
	 *
	 * @param uuid the UUID of the vitamin details
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of vitamin details
	 * @param end the upper bound of the range of vitamin details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching vitamin details, or an empty list if no matches were found
	 */
	public static java.util.List<com.dnebinger.vitamins.model.VitaminDetail>
		getVitaminDetailsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.dnebinger.vitamins.model.VitaminDetail>
					orderByComparator) {

		return getService().getVitaminDetailsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of vitamin details.
	 *
	 * @return the number of vitamin details
	 */
	public static int getVitaminDetailsCount() {
		return getService().getVitaminDetailsCount();
	}

	/**
	 * Updates the vitamin detail in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param vitaminDetail the vitamin detail
	 * @return the vitamin detail that was updated
	 */
	public static com.dnebinger.vitamins.model.VitaminDetail
		updateVitaminDetail(
			com.dnebinger.vitamins.model.VitaminDetail vitaminDetail) {

		return getService().updateVitaminDetail(vitaminDetail);
	}

	public static VitaminDetailLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<VitaminDetailLocalService, VitaminDetailLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			VitaminDetailLocalService.class);

		ServiceTracker<VitaminDetailLocalService, VitaminDetailLocalService>
			serviceTracker =
				new ServiceTracker
					<VitaminDetailLocalService, VitaminDetailLocalService>(
						bundle.getBundleContext(),
						VitaminDetailLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}