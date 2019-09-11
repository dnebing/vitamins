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
 * Provides the remote service utility for VitaminDetail. This utility wraps
 * <code>com.dnebinger.vitamins.service.impl.VitaminDetailServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see VitaminDetailService
 * @generated
 */
@ProviderType
public class VitaminDetailServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.dnebinger.vitamins.service.impl.VitaminDetailServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
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
	 * deleteAllVitaminDetails: Deletes all of the vitamin details.
	 *
	 * @param persistedVitaminId
	 */
	public static void deleteAllVitaminDetails(long persistedVitaminId) {
		getService().deleteAllVitaminDetails(persistedVitaminId);
	}

	public static com.dnebinger.vitamins.model.VitaminDetail
			deleteVitaminDetail(long vitaminDetailId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteVitaminDetail(vitaminDetailId);
	}

	public static com.dnebinger.vitamins.model.VitaminDetail
		deleteVitaminDetail(
			com.dnebinger.vitamins.model.VitaminDetail vitaminDetail) {

		return getService().deleteVitaminDetail(vitaminDetail);
	}

	public static void deleteVitaminDetailsByType(
		long persistedVitaminId, int typeCode) {

		getService().deleteVitaminDetailsByType(persistedVitaminId, typeCode);
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

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
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

	public static VitaminDetailService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<VitaminDetailService, VitaminDetailService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(VitaminDetailService.class);

		ServiceTracker<VitaminDetailService, VitaminDetailService>
			serviceTracker =
				new ServiceTracker<VitaminDetailService, VitaminDetailService>(
					bundle.getBundleContext(), VitaminDetailService.class,
					null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}