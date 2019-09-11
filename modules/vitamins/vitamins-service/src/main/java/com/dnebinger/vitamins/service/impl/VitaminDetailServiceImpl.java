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

import com.dnebinger.vitamins.model.VitaminDetail;
import com.dnebinger.vitamins.service.base.VitaminDetailServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import org.osgi.service.component.annotations.Component;

import java.util.List;

/**
 * The implementation of the vitamin detail remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.dnebinger.vitamins.service.VitaminDetailService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see VitaminDetailServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=neb",
		"json.web.service.context.path=VitaminDetail"
	},
	service = AopService.class
)
public class VitaminDetailServiceImpl extends VitaminDetailServiceBaseImpl {
	/**
	 * addVitaminDetail: Adds a new vitamin detail record.
	 * @param persistedVitaminId
	 * @param typeCode
	 * @param value
	 * @return VitaminDetail: The new instance.
	 */
	public VitaminDetail addVitaminDetail(final long persistedVitaminId, final int typeCode, final String value, final ServiceContext serviceContext) throws PortalException {
		VitaminDetail detail = null;


		return detail;
	}

	/**
	 * deleteAllVitaminDetails: Deletes all of the vitamin details.
	 * @param persistedVitaminId
	 */
	public void deleteAllVitaminDetails(final long persistedVitaminId) {

	}

	public void deleteVitaminDetailsByType(final long persistedVitaminId, final int typeCode) {

	}

	public VitaminDetail deleteVitaminDetail(long vitaminDetailId) throws PortalException {
		VitaminDetail detail = null;

		return detail;
	}

	public VitaminDetail deleteVitaminDetail(VitaminDetail vitaminDetail) {
		VitaminDetail detail = null;

		return detail;
	}

	/**
	 * getAllVitaminDetails: Returns the full list of details for the given persisted vitamin id.
	 * @param persistedVitaminId
	 * @return List The list of vitamin details.
	 */
	public List<VitaminDetail> getAllVitaminDetails(final long persistedVitaminId) {
		return null;
	}

	/**
	 * getVitaminDetailsByType: Returns the list of details for the given persisted vitamin id and type.
	 * @param persistedVitaminId
	 * @param typeCode
	 * @return List The list of vitamin details.
	 */
	public List<VitaminDetail> getVitaminDetailsByType(final long persistedVitaminId, final int typeCode) {
		return null;
	}
}