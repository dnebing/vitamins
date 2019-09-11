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

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link VitaminDetailLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see VitaminDetailLocalService
 * @generated
 */
@ProviderType
public class VitaminDetailLocalServiceWrapper
	implements VitaminDetailLocalService,
			   ServiceWrapper<VitaminDetailLocalService> {

	public VitaminDetailLocalServiceWrapper(
		VitaminDetailLocalService vitaminDetailLocalService) {

		_vitaminDetailLocalService = vitaminDetailLocalService;
	}

	/**
	 * addVitaminDetail: Adds a new vitamin detail record.
	 *
	 * @param persistedVitaminId
	 * @param typeCode
	 * @param value
	 * @return VitaminDetail: The new instance.
	 */
	@Override
	public com.dnebinger.vitamins.model.VitaminDetail addVitaminDetail(
			long persistedVitaminId, int typeCode, String value,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _vitaminDetailLocalService.addVitaminDetail(
			persistedVitaminId, typeCode, value, serviceContext);
	}

	/**
	 * Adds the vitamin detail to the database. Also notifies the appropriate model listeners.
	 *
	 * @param vitaminDetail the vitamin detail
	 * @return the vitamin detail that was added
	 */
	@Override
	public com.dnebinger.vitamins.model.VitaminDetail addVitaminDetail(
		com.dnebinger.vitamins.model.VitaminDetail vitaminDetail) {

		return _vitaminDetailLocalService.addVitaminDetail(vitaminDetail);
	}

	/**
	 * Creates a new vitamin detail with the primary key. Does not add the vitamin detail to the database.
	 *
	 * @param vitaminDetailId the primary key for the new vitamin detail
	 * @return the new vitamin detail
	 */
	@Override
	public com.dnebinger.vitamins.model.VitaminDetail createVitaminDetail(
		long vitaminDetailId) {

		return _vitaminDetailLocalService.createVitaminDetail(vitaminDetailId);
	}

	/**
	 * deleteAllVitaminDetails: Deletes all of the vitamin details.
	 *
	 * @param persistedVitaminId
	 */
	@Override
	public void deleteAllVitaminDetails(long persistedVitaminId) {
		_vitaminDetailLocalService.deleteAllVitaminDetails(persistedVitaminId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _vitaminDetailLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the vitamin detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param vitaminDetailId the primary key of the vitamin detail
	 * @return the vitamin detail that was removed
	 * @throws PortalException if a vitamin detail with the primary key could not be found
	 */
	@Override
	public com.dnebinger.vitamins.model.VitaminDetail deleteVitaminDetail(
			long vitaminDetailId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _vitaminDetailLocalService.deleteVitaminDetail(vitaminDetailId);
	}

	/**
	 * Deletes the vitamin detail from the database. Also notifies the appropriate model listeners.
	 *
	 * @param vitaminDetail the vitamin detail
	 * @return the vitamin detail that was removed
	 */
	@Override
	public com.dnebinger.vitamins.model.VitaminDetail deleteVitaminDetail(
		com.dnebinger.vitamins.model.VitaminDetail vitaminDetail) {

		return _vitaminDetailLocalService.deleteVitaminDetail(vitaminDetail);
	}

	@Override
	public void deleteVitaminDetailsByType(
		long persistedVitaminId, int typeCode) {

		_vitaminDetailLocalService.deleteVitaminDetailsByType(
			persistedVitaminId, typeCode);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _vitaminDetailLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _vitaminDetailLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _vitaminDetailLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _vitaminDetailLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _vitaminDetailLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _vitaminDetailLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.dnebinger.vitamins.model.VitaminDetail fetchVitaminDetail(
		long vitaminDetailId) {

		return _vitaminDetailLocalService.fetchVitaminDetail(vitaminDetailId);
	}

	/**
	 * Returns the vitamin detail matching the UUID and group.
	 *
	 * @param uuid the vitamin detail's UUID
	 * @param groupId the primary key of the group
	 * @return the matching vitamin detail, or <code>null</code> if a matching vitamin detail could not be found
	 */
	@Override
	public com.dnebinger.vitamins.model.VitaminDetail
		fetchVitaminDetailByUuidAndGroupId(String uuid, long groupId) {

		return _vitaminDetailLocalService.fetchVitaminDetailByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _vitaminDetailLocalService.getActionableDynamicQuery();
	}

	/**
	 * getAllVitaminDetails: Returns the full list of details for the given persisted vitamin id.
	 *
	 * @param persistedVitaminId
	 * @return List The list of vitamin details.
	 */
	@Override
	public java.util.List<com.dnebinger.vitamins.model.VitaminDetail>
		getAllVitaminDetails(long persistedVitaminId) {

		return _vitaminDetailLocalService.getAllVitaminDetails(
			persistedVitaminId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _vitaminDetailLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _vitaminDetailLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _vitaminDetailLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _vitaminDetailLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the vitamin detail with the primary key.
	 *
	 * @param vitaminDetailId the primary key of the vitamin detail
	 * @return the vitamin detail
	 * @throws PortalException if a vitamin detail with the primary key could not be found
	 */
	@Override
	public com.dnebinger.vitamins.model.VitaminDetail getVitaminDetail(
			long vitaminDetailId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _vitaminDetailLocalService.getVitaminDetail(vitaminDetailId);
	}

	/**
	 * Returns the vitamin detail matching the UUID and group.
	 *
	 * @param uuid the vitamin detail's UUID
	 * @param groupId the primary key of the group
	 * @return the matching vitamin detail
	 * @throws PortalException if a matching vitamin detail could not be found
	 */
	@Override
	public com.dnebinger.vitamins.model.VitaminDetail
			getVitaminDetailByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _vitaminDetailLocalService.getVitaminDetailByUuidAndGroupId(
			uuid, groupId);
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
	@Override
	public java.util.List<com.dnebinger.vitamins.model.VitaminDetail>
		getVitaminDetails(int start, int end) {

		return _vitaminDetailLocalService.getVitaminDetails(start, end);
	}

	/**
	 * getVitaminDetailsByType: Returns the list of details for the given persisted vitamin id and type.
	 *
	 * @param persistedVitaminId
	 * @param typeCode
	 * @return List The list of vitamin details.
	 */
	@Override
	public java.util.List<com.dnebinger.vitamins.model.VitaminDetail>
		getVitaminDetailsByType(long persistedVitaminId, int typeCode) {

		return _vitaminDetailLocalService.getVitaminDetailsByType(
			persistedVitaminId, typeCode);
	}

	/**
	 * Returns all the vitamin details matching the UUID and company.
	 *
	 * @param uuid the UUID of the vitamin details
	 * @param companyId the primary key of the company
	 * @return the matching vitamin details, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.dnebinger.vitamins.model.VitaminDetail>
		getVitaminDetailsByUuidAndCompanyId(String uuid, long companyId) {

		return _vitaminDetailLocalService.getVitaminDetailsByUuidAndCompanyId(
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
	@Override
	public java.util.List<com.dnebinger.vitamins.model.VitaminDetail>
		getVitaminDetailsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.dnebinger.vitamins.model.VitaminDetail>
					orderByComparator) {

		return _vitaminDetailLocalService.getVitaminDetailsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of vitamin details.
	 *
	 * @return the number of vitamin details
	 */
	@Override
	public int getVitaminDetailsCount() {
		return _vitaminDetailLocalService.getVitaminDetailsCount();
	}

	/**
	 * Updates the vitamin detail in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param vitaminDetail the vitamin detail
	 * @return the vitamin detail that was updated
	 */
	@Override
	public com.dnebinger.vitamins.model.VitaminDetail updateVitaminDetail(
		com.dnebinger.vitamins.model.VitaminDetail vitaminDetail) {

		return _vitaminDetailLocalService.updateVitaminDetail(vitaminDetail);
	}

	@Override
	public VitaminDetailLocalService getWrappedService() {
		return _vitaminDetailLocalService;
	}

	@Override
	public void setWrappedService(
		VitaminDetailLocalService vitaminDetailLocalService) {

		_vitaminDetailLocalService = vitaminDetailLocalService;
	}

	private VitaminDetailLocalService _vitaminDetailLocalService;

}