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

package com.dnebinger.vitamins.service.impl;

import com.dnebinger.vitamins.model.PersistedVitamin;
import com.dnebinger.vitamins.model.VitaminDetail;
import com.dnebinger.vitamins.service.base.VitaminDetailLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the vitamin detail local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.dnebinger.vitamins.service.VitaminDetailLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see VitaminDetailLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.dnebinger.vitamins.model.VitaminDetail",
	service = AopService.class
)
public class VitaminDetailLocalServiceImpl
	extends VitaminDetailLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.dnebinger.vitamins.service.VitaminDetailLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.dnebinger.vitamins.service.VitaminDetailLocalServiceUtil</code>.
	 */

	/**
	 * addVitaminDetail: Adds a new vitamin detail record.
	 * @param persistedVitaminId
	 * @param typeCode
	 * @param value
	 * @return VitaminDetail: The new instance.
	 */
	public VitaminDetail addVitaminDetail(final long persistedVitaminId, final int typeCode, final String value, final ServiceContext serviceContext) throws PortalException {
		VitaminDetail detail = createVitaminDetail(counterLocalService.increment(VitaminDetail.class.getName()));

		detail.setPersistedVitaminId(persistedVitaminId);
		detail.setType(typeCode);
		detail.setValue(value);

		Date current = new Date();
		detail.setCompanyId(serviceContext.getCompanyId());
		detail.setCreateDate(serviceContext.getCreateDate(current));
		detail.setGroupId(serviceContext.getScopeGroupId());
		detail.setModifiedDate(serviceContext.getModifiedDate(current));
		detail.setUserId(serviceContext.getUserId());

		User user = userLocalService.fetchUser(serviceContext.getUserId());
		if (user != null) {
			detail.setUserName(user.getFullName());
			detail.setUserUuid(user.getUserUuid());
		}

		detail = addVitaminDetail(detail);

		resourceLocalService.addResources(
				serviceContext.getCompanyId(), serviceContext.getScopeGroupId(), serviceContext.getUserId(),
				VitaminDetail.class.getName(), detail.getVitaminDetailId(), false,
				serviceContext.isAddGroupPermissions(), serviceContext.isAddGuestPermissions());

		return detail;
	}

	/**
	 * deleteAllVitaminDetails: Deletes all of the vitamin details.
	 * @param persistedVitaminId
	 */
	public void deleteAllVitaminDetails(final long persistedVitaminId) {
		List<VitaminDetail> details = getAllVitaminDetails(persistedVitaminId);

		if ((details != null) && (! details.isEmpty())) {
			for (VitaminDetail detail : details) {
				deleteVitaminDetail(detail);
			}
		}
	}

	public void deleteVitaminDetailsByType(final long persistedVitaminId, final int typeCode) {
		List<VitaminDetail> details = getVitaminDetailsByType(persistedVitaminId, typeCode);

		if ((details != null) && (! details.isEmpty())) {
			for (VitaminDetail detail : details) {
				deleteVitaminDetail(detail);
			}
		}
	}

	@Override
	public VitaminDetail deleteVitaminDetail(long vitaminDetailId) throws PortalException {
		VitaminDetail detail = fetchVitaminDetail(vitaminDetailId);

		if (detail != null) {
			resourceLocalService.deleteResource(
					detail.getCompanyId(), VitaminDetail.class.getName(),
					ResourceConstants.SCOPE_INDIVIDUAL, detail.getVitaminDetailId());
		}

		return super.deleteVitaminDetail(vitaminDetailId);
	}

	@Override
	public VitaminDetail deleteVitaminDetail(VitaminDetail vitaminDetail) {
		try {
		resourceLocalService.deleteResource(
				vitaminDetail.getCompanyId(), VitaminDetail.class.getName(),
				ResourceConstants.SCOPE_INDIVIDUAL, vitaminDetail.getVitaminDetailId());
		} catch (PortalException e) {
			_log.warn("Error deleting vitamin detail permissions: " + e.getMessage(), e);
		}

		return super.deleteVitaminDetail(vitaminDetail);
	}

	/**
	 * getAllVitaminDetails: Returns the full list of details for the given persisted vitamin id.
	 * @param persistedVitaminId
	 * @return List The list of vitamin details.
	 */
	public List<VitaminDetail> getAllVitaminDetails(final long persistedVitaminId) {
		return vitaminDetailPersistence.findByPersistedVitaminId(persistedVitaminId);
	}

	/**
	 * getVitaminDetailsByType: Returns the list of details for the given persisted vitamin id and type.
	 * @param persistedVitaminId
	 * @param typeCode
	 * @return List The list of vitamin details.
	 */
	public List<VitaminDetail> getVitaminDetailsByType(final long persistedVitaminId, final int typeCode) {
		return vitaminDetailPersistence.findByPersistedVitaminIdType(persistedVitaminId, typeCode);
	}

	private static final Logger _log = LoggerFactory.getLogger(VitaminDetailLocalServiceImpl.class);
}

