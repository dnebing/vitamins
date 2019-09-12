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
import com.dnebinger.vitamins.service.VitaminDetailLocalService;
import com.dnebinger.vitamins.service.base.PersistedVitaminLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.SystemEventConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.systemevent.SystemEvent;
import org.apache.commons.lang.RandomStringUtils;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * The implementation of the persisted vitamin local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.dnebinger.vitamins.service.PersistedVitaminLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersistedVitaminLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.dnebinger.vitamins.model.PersistedVitamin",
	service = AopService.class
)
public class PersistedVitaminLocalServiceImpl
	extends PersistedVitaminLocalServiceBaseImpl {

	public PersistedVitamin getPersistedVitamin(final String surrogateId) {
		return persistedVitaminPersistence.fetchBySurrogateId(surrogateId);
	}

	@Indexable(type = IndexableType.REINDEX)
	@SystemEvent(type = SystemEventConstants.TYPE_DEFAULT)
	public PersistedVitamin addPersistedVitamin(final String id, final String name, final String groupName, final String description,
	                                            final int typeCode, final String articleId, final String[] chemicalNames, final String[] properties,
	                                            final String[] attributes, final String[] symptoms, final String[] risks, final ServiceContext serviceContext) throws PortalException {
		PersistedVitamin vitamin = createPersistedVitamin(counterLocalService.increment(PersistedVitamin.class.getName()));

		Date current = new Date();

		String useId = null;

		if ((id == null) || (id.trim().length() < 1)) {
			useId = RandomStringUtils.random(10, true, true).toUpperCase();
		} else {
			useId = id.trim().toUpperCase();
		}

		vitamin.setArticleId(articleId);
		vitamin.setCompanyId(serviceContext.getCompanyId());
		vitamin.setCreateDate(serviceContext.getCreateDate(current));
		vitamin.setDescription(description);
		vitamin.setGroupId(serviceContext.getScopeGroupId());
		vitamin.setGroupName(groupName);
		vitamin.setModifiedDate(serviceContext.getModifiedDate(current));
		vitamin.setName(name);
		vitamin.setSurrogateId(useId);
		vitamin.setType(typeCode);
		vitamin.setUserId(serviceContext.getUserId());

		User user = userLocalService.fetchUser(serviceContext.getUserId());
		if (user != null) {
			vitamin.setUserName(user.getFullName());
			vitamin.setUserUuid(user.getUserUuid());
		}

		vitamin = addPersistedVitamin(vitamin);

		resourceLocalService.addResources(
				vitamin.getCompanyId(), vitamin.getGroupId(), vitamin.getUserId(),
				PersistedVitamin.class.getName(), vitamin.getPersistedVitaminId(), false,
				serviceContext.isAddGroupPermissions(), serviceContext.isAddGuestPermissions());

		// now add the types...
		if ((chemicalNames != null) && (chemicalNames.length > 0)) {
			for (String value : chemicalNames) {
				vitaminDetailLocalService.addVitaminDetail(vitamin.getPersistedVitaminId(), VitaminDetailType.CHEMICAL_NAME, value, serviceContext);
			}
		}
		if ((properties != null) && (properties.length > 0)) {
			for (String value : properties) {
				vitaminDetailLocalService.addVitaminDetail(vitamin.getPersistedVitaminId(), VitaminDetailType.PROPERTY, value, serviceContext);
			}
		}
		if ((attributes != null) && (attributes.length > 0)) {
			for (String value : attributes) {
				vitaminDetailLocalService.addVitaminDetail(vitamin.getPersistedVitaminId(), VitaminDetailType.ATTRIBUTE, value, serviceContext);
			}
		}
		if ((symptoms != null) && (symptoms.length > 0)) {
			for (String value : symptoms) {
				vitaminDetailLocalService.addVitaminDetail(vitamin.getPersistedVitaminId(), VitaminDetailType.SYMPTOM, value, serviceContext);
			}
		}
		if ((risks != null) && (risks.length > 0)) {
			for (String value : risks) {
				vitaminDetailLocalService.addVitaminDetail(vitamin.getPersistedVitaminId(), VitaminDetailType.RISK, value, serviceContext);
			}
		}

		// good to go
		return vitamin;
	}

	@Indexable(type = IndexableType.REINDEX)
	@SystemEvent(type = SystemEventConstants.TYPE_DEFAULT)
	public PersistedVitamin updatePersistedVitamin(final String oldId, final String id, final String name, final String groupName, final String description,
	                                                  final int typeCode, final String articleId, final String[] chemicalNames, final String[] properties,
	                                                  final String[] attributes, final String[] symptoms, final String[] risks, final ServiceContext serviceContext) throws PortalException {

		// find our instance using the old id
		PersistedVitamin vitamin = persistedVitaminPersistence.fetchBySurrogateId(oldId);

		if (vitamin == null) {
			_log.warn("Failed to find vitamin using id [" + oldId + "].");
			throw new NoSuchPersistedVitaminException("Could not find vitamin [" + oldId + "].");
		}

		String useId = null;

		if ((id == null) || (id.trim().length() < 1)) {
			useId = RandomStringUtils.random(10, true, true).toUpperCase();
		} else {
			useId = id.trim().toUpperCase();
		}

		// an update means that all fields are going to change to match what we are given.
		Date current = new Date();

		vitamin.setArticleId(articleId);
		vitamin.setDescription(description);
		vitamin.setGroupName(groupName);
		vitamin.setModifiedDate(serviceContext.getModifiedDate(current));
		vitamin.setName(name);
		vitamin.setSurrogateId(useId);
		vitamin.setType(typeCode);
		vitamin.setUserId(serviceContext.getUserId());

		User user = userLocalService.fetchUser(serviceContext.getUserId());
		if (user != null) {
			vitamin.setUserName(user.getFullName());
			vitamin.setUserUuid(user.getUserUuid());
		}

		vitamin = updatePersistedVitamin(vitamin);

		// purge all existing types
		vitaminDetailLocalService.deleteAllVitaminDetails(vitamin.getPersistedVitaminId());

		// now add the types...
		if ((chemicalNames != null) && (chemicalNames.length > 0)) {
			for (String value : chemicalNames) {
				vitaminDetailLocalService.addVitaminDetail(vitamin.getPersistedVitaminId(), VitaminDetailType.CHEMICAL_NAME, value, serviceContext);
			}
		}
		if ((properties != null) && (properties.length > 0)) {
			for (String value : properties) {
				vitaminDetailLocalService.addVitaminDetail(vitamin.getPersistedVitaminId(), VitaminDetailType.PROPERTY, value, serviceContext);
			}
		}
		if ((attributes != null) && (attributes.length > 0)) {
			for (String value : attributes) {
				vitaminDetailLocalService.addVitaminDetail(vitamin.getPersistedVitaminId(), VitaminDetailType.ATTRIBUTE, value, serviceContext);
			}
		}
		if ((symptoms != null) && (symptoms.length > 0)) {
			for (String value : symptoms) {
				vitaminDetailLocalService.addVitaminDetail(vitamin.getPersistedVitaminId(), VitaminDetailType.SYMPTOM, value, serviceContext);
			}
		}
		if ((risks != null) && (risks.length > 0)) {
			for (String value : risks) {
				vitaminDetailLocalService.addVitaminDetail(vitamin.getPersistedVitaminId(), VitaminDetailType.RISK, value, serviceContext);
			}
		}

		// good to go
		return vitamin;
	}

	@Indexable(type = IndexableType.REINDEX)
	@SystemEvent(type = SystemEventConstants.TYPE_DEFAULT)
	public PersistedVitamin patchPersistedVitamin(final String oldId, final String id, final String name, final String groupName, final String description,
	                                              final int typeCode, final String articleId, final String[] chemicalNames, final String[] properties,
	                                              final String[] attributes, final String[] symptoms, final String[] risks, final ServiceContext serviceContext) throws PortalException {

		// find our instance using the old id
		PersistedVitamin vitamin = persistedVitaminPersistence.fetchBySurrogateId(oldId);
		boolean changed = false;

		if (vitamin == null) {
			_log.warn("Failed to find vitamin using id [" + oldId + "].");
			throw new NoSuchPersistedVitaminException("Could not find vitamin [" + oldId + "].");
		}

		if ((id != null) && (id.trim().length() > 0)) {
			// replace the id
			vitamin.setSurrogateId(id.trim().toUpperCase());
			changed = true;
		}

		// a patch means that only provided fields are going to change to match what we are given.

		if (articleId != null) {
			vitamin.setArticleId(articleId);
			changed = true;
		}
		if (description != null) {
			vitamin.setDescription(description);
			changed = true;
		}
		if (groupName != null) {
			vitamin.setGroupName(groupName);
			changed = true;
		}
		if (name != null) {
			vitamin.setName(name);
			changed = true;
		}

		if (typeCode != vitamin.getType()) {
			vitamin.setType(typeCode);
			changed = true;
		}

		if ((chemicalNames != null) && (chemicalNames.length > 0)) {
			vitaminDetailLocalService.deleteVitaminDetailsByType(vitamin.getPersistedVitaminId(), VitaminDetailType.CHEMICAL_NAME);
			changed = true;
			for (String value : chemicalNames) {
				vitaminDetailLocalService.addVitaminDetail(vitamin.getPersistedVitaminId(), VitaminDetailType.CHEMICAL_NAME, value, serviceContext);
			}
		}
		if ((properties != null) && (properties.length > 0)) {
			vitaminDetailLocalService.deleteVitaminDetailsByType(vitamin.getPersistedVitaminId(), VitaminDetailType.PROPERTY);
			changed = true;
			for (String value : properties) {
				vitaminDetailLocalService.addVitaminDetail(vitamin.getPersistedVitaminId(), VitaminDetailType.PROPERTY, value, serviceContext);
			}
		}
		if ((attributes != null) && (attributes.length > 0)) {
			vitaminDetailLocalService.deleteVitaminDetailsByType(vitamin.getPersistedVitaminId(), VitaminDetailType.ATTRIBUTE);
			changed = true;
			for (String value : attributes) {
				vitaminDetailLocalService.addVitaminDetail(vitamin.getPersistedVitaminId(), VitaminDetailType.ATTRIBUTE, value, serviceContext);
			}
		}
		if ((symptoms != null) && (symptoms.length > 0)) {
			vitaminDetailLocalService.deleteVitaminDetailsByType(vitamin.getPersistedVitaminId(), VitaminDetailType.SYMPTOM);
			changed = true;
			for (String value : symptoms) {
				vitaminDetailLocalService.addVitaminDetail(vitamin.getPersistedVitaminId(), VitaminDetailType.SYMPTOM, value, serviceContext);
			}
		}
		if ((risks != null) && (risks.length > 0)) {
			vitaminDetailLocalService.deleteVitaminDetailsByType(vitamin.getPersistedVitaminId(), VitaminDetailType.RISK);
			changed = true;
			for (String value : risks) {
				vitaminDetailLocalService.addVitaminDetail(vitamin.getPersistedVitaminId(), VitaminDetailType.RISK, value, serviceContext);
			}
		}

		if (changed) {
			Date current = new Date();

			vitamin.setUserId(serviceContext.getUserId());
			vitamin.setModifiedDate(serviceContext.getModifiedDate(current));

			User user = userLocalService.fetchUser(serviceContext.getUserId());
			if (user != null) {
				vitamin.setUserName(user.getFullName());
				vitamin.setUserUuid(user.getUserUuid());
			}

			vitamin = updatePersistedVitamin(vitamin);
		}

		// good to go
		return vitamin;
	}

	@Indexable(type = IndexableType.DELETE)
	@Override
	public void deleteVitamin(final String surrogateId) {
		PersistedVitamin vitamin = getPersistedVitamin(surrogateId);

		if (vitamin != null) {
			deleteVitamin(vitamin);
		}
	}

	@Indexable(type = IndexableType.DELETE)
	@Override
	public PersistedVitamin deleteVitamin(long persistedVitaminId) throws PortalException {
		PersistedVitamin vitamin = fetchPersistedVitamin(persistedVitaminId);

		if (vitamin != null) {
			return deleteVitamin(vitamin);
		}

		return null;
	}

	@Indexable(type = IndexableType.DELETE)
	@SystemEvent(type = SystemEventConstants.TYPE_DELETE)
	@Override
	public PersistedVitamin deleteVitamin(PersistedVitamin persistedVitamin) {
		try {
			resourceLocalService.deleteResource(
					persistedVitamin.getCompanyId(), PersistedVitamin.class.getName(),
					ResourceConstants.SCOPE_INDIVIDUAL, persistedVitamin.getPersistedVitaminId());
		} catch (PortalException e) {
			_log.warn("Error deleting persisted vitamin permissions: " + e.getMessage(), e);
		}

		vitaminDetailLocalService.deleteAllVitaminDetails(persistedVitamin.getPersistedVitaminId());

		// call the super action method to try the delete.
		return persistedVitaminLocalService.deletePersistedVitamin(persistedVitamin);
	}

	@Reference(unbind = "~")
	protected void setVitaminDetailLocalService(final VitaminDetailLocalService vitaminDetailLocalService) {
		this.vitaminDetailLocalService = vitaminDetailLocalService;
	}

	private VitaminDetailLocalService vitaminDetailLocalService;
	private static final Logger _log = LoggerFactory.getLogger(PersistedVitaminLocalServiceImpl.class);
}