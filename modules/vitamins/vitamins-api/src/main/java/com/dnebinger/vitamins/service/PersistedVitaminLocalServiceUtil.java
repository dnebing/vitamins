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
 * Provides the local service utility for PersistedVitamin. This utility wraps
 * <code>com.dnebinger.vitamins.service.impl.PersistedVitaminLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see PersistedVitaminLocalService
 * @generated
 */
@ProviderType
public class PersistedVitaminLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.dnebinger.vitamins.service.impl.PersistedVitaminLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the persisted vitamin to the database. Also notifies the appropriate model listeners.
	 *
	 * @param persistedVitamin the persisted vitamin
	 * @return the persisted vitamin that was added
	 */
	public static com.dnebinger.vitamins.model.PersistedVitamin
		addPersistedVitamin(
			com.dnebinger.vitamins.model.PersistedVitamin persistedVitamin) {

		return getService().addPersistedVitamin(persistedVitamin);
	}

	public static com.dnebinger.vitamins.model.PersistedVitamin
			addPersistedVitamin(
				String id, String name, String groupName, String description,
				int typeCode, String articleId, String[] chemicalNames,
				String[] properties, String[] attributes, String[] symptoms,
				String[] risks,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addPersistedVitamin(
			id, name, groupName, description, typeCode, articleId,
			chemicalNames, properties, attributes, symptoms, risks,
			serviceContext);
	}

	/**
	 * Creates a new persisted vitamin with the primary key. Does not add the persisted vitamin to the database.
	 *
	 * @param persistedVitaminId the primary key for the new persisted vitamin
	 * @return the new persisted vitamin
	 */
	public static com.dnebinger.vitamins.model.PersistedVitamin
		createPersistedVitamin(long persistedVitaminId) {

		return getService().createPersistedVitamin(persistedVitaminId);
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
	 * Deletes the persisted vitamin with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param persistedVitaminId the primary key of the persisted vitamin
	 * @return the persisted vitamin that was removed
	 * @throws PortalException if a persisted vitamin with the primary key could not be found
	 */
	public static com.dnebinger.vitamins.model.PersistedVitamin
			deletePersistedVitamin(long persistedVitaminId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedVitamin(persistedVitaminId);
	}

	/**
	 * Deletes the persisted vitamin from the database. Also notifies the appropriate model listeners.
	 *
	 * @param persistedVitamin the persisted vitamin
	 * @return the persisted vitamin that was removed
	 */
	public static com.dnebinger.vitamins.model.PersistedVitamin
		deletePersistedVitamin(
			com.dnebinger.vitamins.model.PersistedVitamin persistedVitamin) {

		return getService().deletePersistedVitamin(persistedVitamin);
	}

	public static void deletePersistedVitamin(String surrogateId) {
		getService().deletePersistedVitamin(surrogateId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.dnebinger.vitamins.model.impl.PersistedVitaminModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.dnebinger.vitamins.model.impl.PersistedVitaminModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.dnebinger.vitamins.model.PersistedVitamin
		fetchPersistedVitamin(long persistedVitaminId) {

		return getService().fetchPersistedVitamin(persistedVitaminId);
	}

	/**
	 * Returns the persisted vitamin matching the UUID and group.
	 *
	 * @param uuid the persisted vitamin's UUID
	 * @param groupId the primary key of the group
	 * @return the matching persisted vitamin, or <code>null</code> if a matching persisted vitamin could not be found
	 */
	public static com.dnebinger.vitamins.model.PersistedVitamin
		fetchPersistedVitaminByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchPersistedVitaminByUuidAndGroupId(
			uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
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
	 * Returns the persisted vitamin with the primary key.
	 *
	 * @param persistedVitaminId the primary key of the persisted vitamin
	 * @return the persisted vitamin
	 * @throws PortalException if a persisted vitamin with the primary key could not be found
	 */
	public static com.dnebinger.vitamins.model.PersistedVitamin
			getPersistedVitamin(long persistedVitaminId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedVitamin(persistedVitaminId);
	}

	public static com.dnebinger.vitamins.model.PersistedVitamin
		getPersistedVitamin(String surrogateId) {

		return getService().getPersistedVitamin(surrogateId);
	}

	/**
	 * Returns the persisted vitamin matching the UUID and group.
	 *
	 * @param uuid the persisted vitamin's UUID
	 * @param groupId the primary key of the group
	 * @return the matching persisted vitamin
	 * @throws PortalException if a matching persisted vitamin could not be found
	 */
	public static com.dnebinger.vitamins.model.PersistedVitamin
			getPersistedVitaminByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedVitaminByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the persisted vitamins.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.dnebinger.vitamins.model.impl.PersistedVitaminModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted vitamins
	 * @param end the upper bound of the range of persisted vitamins (not inclusive)
	 * @return the range of persisted vitamins
	 */
	public static java.util.List<com.dnebinger.vitamins.model.PersistedVitamin>
		getPersistedVitamins(int start, int end) {

		return getService().getPersistedVitamins(start, end);
	}

	/**
	 * Returns all the persisted vitamins matching the UUID and company.
	 *
	 * @param uuid the UUID of the persisted vitamins
	 * @param companyId the primary key of the company
	 * @return the matching persisted vitamins, or an empty list if no matches were found
	 */
	public static java.util.List<com.dnebinger.vitamins.model.PersistedVitamin>
		getPersistedVitaminsByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getPersistedVitaminsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of persisted vitamins matching the UUID and company.
	 *
	 * @param uuid the UUID of the persisted vitamins
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of persisted vitamins
	 * @param end the upper bound of the range of persisted vitamins (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching persisted vitamins, or an empty list if no matches were found
	 */
	public static java.util.List<com.dnebinger.vitamins.model.PersistedVitamin>
		getPersistedVitaminsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.dnebinger.vitamins.model.PersistedVitamin>
					orderByComparator) {

		return getService().getPersistedVitaminsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of persisted vitamins.
	 *
	 * @return the number of persisted vitamins
	 */
	public static int getPersistedVitaminsCount() {
		return getService().getPersistedVitaminsCount();
	}

	public static com.dnebinger.vitamins.model.PersistedVitamin
			patchPersistedVitamin(
				String oldId, String id, String name, String groupName,
				String description, int typeCode, String articleId,
				String[] chemicalNames, String[] properties,
				String[] attributes, String[] symptoms, String[] risks,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().patchPersistedVitamin(
			oldId, id, name, groupName, description, typeCode, articleId,
			chemicalNames, properties, attributes, symptoms, risks,
			serviceContext);
	}

	/**
	 * Updates the persisted vitamin in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param persistedVitamin the persisted vitamin
	 * @return the persisted vitamin that was updated
	 */
	public static com.dnebinger.vitamins.model.PersistedVitamin
		updatePersistedVitamin(
			com.dnebinger.vitamins.model.PersistedVitamin persistedVitamin) {

		return getService().updatePersistedVitamin(persistedVitamin);
	}

	public static com.dnebinger.vitamins.model.PersistedVitamin
			updatePersistedVitamin(
				String oldId, String id, String name, String groupName,
				String description, int typeCode, String articleId,
				String[] chemicalNames, String[] properties,
				String[] attributes, String[] symptoms, String[] risks,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updatePersistedVitamin(
			oldId, id, name, groupName, description, typeCode, articleId,
			chemicalNames, properties, attributes, symptoms, risks,
			serviceContext);
	}

	public static PersistedVitaminLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<PersistedVitaminLocalService, PersistedVitaminLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			PersistedVitaminLocalService.class);

		ServiceTracker
			<PersistedVitaminLocalService, PersistedVitaminLocalService>
				serviceTracker =
					new ServiceTracker
						<PersistedVitaminLocalService,
						 PersistedVitaminLocalService>(
							 bundle.getBundleContext(),
							 PersistedVitaminLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}