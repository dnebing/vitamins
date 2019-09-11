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

import com.dnebinger.vitamins.constants.VitaminDetailType;
import com.dnebinger.vitamins.exception.NoSuchPersistedVitaminException;
import com.dnebinger.vitamins.model.PersistedVitamin;
import com.dnebinger.vitamins.model.VitaminDetail;
import com.dnebinger.vitamins.service.base.PersistedVitaminServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.SystemEventConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermissionFactory;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermissionHelper;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermissionFactory;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.systemevent.SystemEvent;
import org.apache.commons.lang.RandomStringUtils;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the persisted vitamin remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.dnebinger.vitamins.service.PersistedVitaminService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersistedVitaminServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=neb",
		"json.web.service.context.path=PersistedVitamin"
	},
	service = AopService.class
)
public class PersistedVitaminServiceImpl
	extends PersistedVitaminServiceBaseImpl {

	@Reference(
			policy = ReferencePolicy.DYNAMIC,
			policyOption = ReferencePolicyOption.GREEDY,
			target = "(model.class.name=com.dnebinger.vitamins.model.PersistedVitamin)"
	)
	private volatile ModelResourcePermission<PersistedVitamin>
			_persistedVitaminModelResourcePermission;

	public PersistedVitamin getPersistedVitamin(final String surrogateId) throws PortalException {
		PersistedVitamin vitamin = persistedVitaminLocalService.getPersistedVitamin(
				surrogateId);

		_persistedVitaminModelResourcePermission.check(
				getPermissionChecker(), vitamin, ActionKeys.VIEW);

		return vitamin;
	}

	public PersistedVitamin getPersistedVitamin(final long persistedVitaminId) throws PortalException {
		PersistedVitamin vitamin = persistedVitaminLocalService.getPersistedVitamin(
				persistedVitaminId);

		_persistedVitaminModelResourcePermission.check(
				getPermissionChecker(), vitamin, ActionKeys.VIEW);

		return vitamin;
	}

	public PersistedVitamin addPersistedVitamin(final String id, final String name, final String groupName, final String description,
	                                            final int typeCode, final String articleId, final String[] chemicalNames, final String[] properties,
	                                            final String[] attributes, final String[] symptoms, final String[] risks, final ServiceContext serviceContext) throws PortalException {

		ModelResourcePermissionHelper.check(
				_persistedVitaminModelResourcePermission, getPermissionChecker(),
				serviceContext.getScopeGroupId(), 0,
				ActionKeys.ADD_ENTRY);

		return persistedVitaminLocalService.addPersistedVitamin(id, name, groupName, description, typeCode, articleId, chemicalNames, properties, attributes, symptoms, risks, serviceContext);
	}

	public PersistedVitamin updatePersistedVitamin(final String oldId, final String id, final String name, final String groupName, final String description,
	                                                  final int typeCode, final String articleId, final String[] chemicalNames, final String[] properties,
	                                                  final String[] attributes, final String[] symptoms, final String[] risks, final ServiceContext serviceContext) throws PortalException {
		_persistedVitaminModelResourcePermission.check(
				getPermissionChecker(),
				persistedVitaminLocalService.getPersistedVitamin(oldId), ActionKeys.UPDATE);

		return persistedVitaminLocalService.updatePersistedVitamin(oldId, id, name, groupName, description, typeCode, articleId, chemicalNames, properties, attributes, symptoms, risks, serviceContext);
	}

	public PersistedVitamin patchPersistedVitamin(final String oldId, final String id, final String name, final String groupName, final String description,
	                                              final int typeCode, final String articleId, final String[] chemicalNames, final String[] properties,
	                                              final String[] attributes, final String[] symptoms, final String[] risks, final ServiceContext serviceContext) throws PortalException {

		_persistedVitaminModelResourcePermission.check(
				getPermissionChecker(),
				persistedVitaminLocalService.getPersistedVitamin(oldId), ActionKeys.UPDATE);

		return persistedVitaminLocalService.patchPersistedVitamin(oldId, id, name, groupName, description, typeCode, articleId, chemicalNames, properties, attributes, symptoms, risks, serviceContext);
	}

	public void deletePersistedVitamin(final String surrogateId) throws PortalException {
		_persistedVitaminModelResourcePermission.check(
				getPermissionChecker(),
				persistedVitaminLocalService.getPersistedVitamin(surrogateId), ActionKeys.DELETE);

		persistedVitaminLocalService.deletePersistedVitamin(surrogateId);
	}

	private static final Logger _log = LoggerFactory.getLogger(PersistedVitaminServiceImpl.class);
}

