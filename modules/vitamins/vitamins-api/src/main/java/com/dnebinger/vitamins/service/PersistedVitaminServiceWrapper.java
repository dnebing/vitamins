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
 * Provides a wrapper for {@link PersistedVitaminService}.
 *
 * @author Brian Wing Shun Chan
 * @see PersistedVitaminService
 * @generated
 */
@ProviderType
public class PersistedVitaminServiceWrapper
	implements PersistedVitaminService,
			   ServiceWrapper<PersistedVitaminService> {

	public PersistedVitaminServiceWrapper(
		PersistedVitaminService persistedVitaminService) {

		_persistedVitaminService = persistedVitaminService;
	}

	@Override
	public com.dnebinger.vitamins.model.PersistedVitamin addPersistedVitamin(
			String id, String name, String groupName, String description,
			int typeCode, String articleId, String[] chemicalNames,
			String[] properties, String[] attributes, String[] symptoms,
			String[] risks,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedVitaminService.addPersistedVitamin(
			id, name, groupName, description, typeCode, articleId,
			chemicalNames, properties, attributes, symptoms, risks,
			serviceContext);
	}

	@Override
	public void deletePersistedVitamin(String surrogateId)
		throws com.liferay.portal.kernel.exception.PortalException {

		_persistedVitaminService.deletePersistedVitamin(surrogateId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _persistedVitaminService.getOSGiServiceIdentifier();
	}

	@Override
	public com.dnebinger.vitamins.model.PersistedVitamin getPersistedVitamin(
			long persistedVitaminId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedVitaminService.getPersistedVitamin(persistedVitaminId);
	}

	@Override
	public com.dnebinger.vitamins.model.PersistedVitamin getPersistedVitamin(
			String surrogateId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedVitaminService.getPersistedVitamin(surrogateId);
	}

	@Override
	public com.dnebinger.vitamins.model.PersistedVitamin patchPersistedVitamin(
			String oldId, String id, String name, String groupName,
			String description, int typeCode, String articleId,
			String[] chemicalNames, String[] properties, String[] attributes,
			String[] symptoms, String[] risks,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedVitaminService.patchPersistedVitamin(
			oldId, id, name, groupName, description, typeCode, articleId,
			chemicalNames, properties, attributes, symptoms, risks,
			serviceContext);
	}

	@Override
	public com.dnebinger.vitamins.model.PersistedVitamin updatePersistedVitamin(
			String oldId, String id, String name, String groupName,
			String description, int typeCode, String articleId,
			String[] chemicalNames, String[] properties, String[] attributes,
			String[] symptoms, String[] risks,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedVitaminService.updatePersistedVitamin(
			oldId, id, name, groupName, description, typeCode, articleId,
			chemicalNames, properties, attributes, symptoms, risks,
			serviceContext);
	}

	@Override
	public PersistedVitaminService getWrappedService() {
		return _persistedVitaminService;
	}

	@Override
	public void setWrappedService(
		PersistedVitaminService persistedVitaminService) {

		_persistedVitaminService = persistedVitaminService;
	}

	private PersistedVitaminService _persistedVitaminService;

}