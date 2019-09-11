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

package com.dnebinger.vitamins.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * <p>
 * This class is a wrapper for {@link PersistedVitamin}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersistedVitamin
 * @generated
 */
@ProviderType
public class PersistedVitaminWrapper
	extends BaseModelWrapper<PersistedVitamin>
	implements PersistedVitamin, ModelWrapper<PersistedVitamin> {

	public PersistedVitaminWrapper(PersistedVitamin persistedVitamin) {
		super(persistedVitamin);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("persistedVitaminId", getPersistedVitaminId());
		attributes.put("surrogateId", getSurrogateId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("groupName", getGroupName());
		attributes.put("articleId", getArticleId());
		attributes.put("description", getDescription());
		attributes.put("name", getName());
		attributes.put("type", getType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long persistedVitaminId = (Long)attributes.get("persistedVitaminId");

		if (persistedVitaminId != null) {
			setPersistedVitaminId(persistedVitaminId);
		}

		String surrogateId = (String)attributes.get("surrogateId");

		if (surrogateId != null) {
			setSurrogateId(surrogateId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String groupName = (String)attributes.get("groupName");

		if (groupName != null) {
			setGroupName(groupName);
		}

		String articleId = (String)attributes.get("articleId");

		if (articleId != null) {
			setArticleId(articleId);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Integer type = (Integer)attributes.get("type");

		if (type != null) {
			setType(type);
		}
	}

	@Override
	public java.util.List<VitaminDetail> getAllVitaminDetails() {
		return model.getAllVitaminDetails();
	}

	/**
	 * Returns the article ID of this persisted vitamin.
	 *
	 * @return the article ID of this persisted vitamin
	 */
	@Override
	public String getArticleId() {
		return model.getArticleId();
	}

	/**
	 * getAttributes: Returns the list of attribute details.
	 *
	 * @return List
	 */
	@Override
	public java.util.List<VitaminDetail> getAttributes() {
		return model.getAttributes();
	}

	/**
	 * getChemicalNames: Returns the list of chemical name details.
	 *
	 * @return List
	 */
	@Override
	public java.util.List<VitaminDetail> getChemicalNames() {
		return model.getChemicalNames();
	}

	/**
	 * Returns the company ID of this persisted vitamin.
	 *
	 * @return the company ID of this persisted vitamin
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this persisted vitamin.
	 *
	 * @return the create date of this persisted vitamin
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the description of this persisted vitamin.
	 *
	 * @return the description of this persisted vitamin
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the group ID of this persisted vitamin.
	 *
	 * @return the group ID of this persisted vitamin
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the group name of this persisted vitamin.
	 *
	 * @return the group name of this persisted vitamin
	 */
	@Override
	public String getGroupName() {
		return model.getGroupName();
	}

	/**
	 * Returns the modified date of this persisted vitamin.
	 *
	 * @return the modified date of this persisted vitamin
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this persisted vitamin.
	 *
	 * @return the name of this persisted vitamin
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the persisted vitamin ID of this persisted vitamin.
	 *
	 * @return the persisted vitamin ID of this persisted vitamin
	 */
	@Override
	public long getPersistedVitaminId() {
		return model.getPersistedVitaminId();
	}

	/**
	 * Returns the primary key of this persisted vitamin.
	 *
	 * @return the primary key of this persisted vitamin
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * getProperties: Returns the list of property details.
	 *
	 * @return List
	 */
	@Override
	public java.util.List<VitaminDetail> getProperties() {
		return model.getProperties();
	}

	/**
	 * getRisks: Returns the list of risk details.
	 *
	 * @return List
	 */
	@Override
	public java.util.List<VitaminDetail> getRisks() {
		return model.getRisks();
	}

	/**
	 * Returns the surrogate ID of this persisted vitamin.
	 *
	 * @return the surrogate ID of this persisted vitamin
	 */
	@Override
	public String getSurrogateId() {
		return model.getSurrogateId();
	}

	/**
	 * getSymptoms: Returns the list of symptom details.
	 *
	 * @return List
	 */
	@Override
	public java.util.List<VitaminDetail> getSymptoms() {
		return model.getSymptoms();
	}

	/**
	 * Returns the type of this persisted vitamin.
	 *
	 * @return the type of this persisted vitamin
	 */
	@Override
	public int getType() {
		return model.getType();
	}

	/**
	 * Returns the user ID of this persisted vitamin.
	 *
	 * @return the user ID of this persisted vitamin
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this persisted vitamin.
	 *
	 * @return the user name of this persisted vitamin
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this persisted vitamin.
	 *
	 * @return the user uuid of this persisted vitamin
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this persisted vitamin.
	 *
	 * @return the uuid of this persisted vitamin
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the article ID of this persisted vitamin.
	 *
	 * @param articleId the article ID of this persisted vitamin
	 */
	@Override
	public void setArticleId(String articleId) {
		model.setArticleId(articleId);
	}

	/**
	 * Sets the company ID of this persisted vitamin.
	 *
	 * @param companyId the company ID of this persisted vitamin
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this persisted vitamin.
	 *
	 * @param createDate the create date of this persisted vitamin
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this persisted vitamin.
	 *
	 * @param description the description of this persisted vitamin
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the group ID of this persisted vitamin.
	 *
	 * @param groupId the group ID of this persisted vitamin
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the group name of this persisted vitamin.
	 *
	 * @param groupName the group name of this persisted vitamin
	 */
	@Override
	public void setGroupName(String groupName) {
		model.setGroupName(groupName);
	}

	/**
	 * Sets the modified date of this persisted vitamin.
	 *
	 * @param modifiedDate the modified date of this persisted vitamin
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this persisted vitamin.
	 *
	 * @param name the name of this persisted vitamin
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the persisted vitamin ID of this persisted vitamin.
	 *
	 * @param persistedVitaminId the persisted vitamin ID of this persisted vitamin
	 */
	@Override
	public void setPersistedVitaminId(long persistedVitaminId) {
		model.setPersistedVitaminId(persistedVitaminId);
	}

	/**
	 * Sets the primary key of this persisted vitamin.
	 *
	 * @param primaryKey the primary key of this persisted vitamin
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the surrogate ID of this persisted vitamin.
	 *
	 * @param surrogateId the surrogate ID of this persisted vitamin
	 */
	@Override
	public void setSurrogateId(String surrogateId) {
		model.setSurrogateId(surrogateId);
	}

	/**
	 * Sets the type of this persisted vitamin.
	 *
	 * @param type the type of this persisted vitamin
	 */
	@Override
	public void setType(int type) {
		model.setType(type);
	}

	/**
	 * Sets the user ID of this persisted vitamin.
	 *
	 * @param userId the user ID of this persisted vitamin
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this persisted vitamin.
	 *
	 * @param userName the user name of this persisted vitamin
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this persisted vitamin.
	 *
	 * @param userUuid the user uuid of this persisted vitamin
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this persisted vitamin.
	 *
	 * @param uuid the uuid of this persisted vitamin
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected PersistedVitaminWrapper wrap(PersistedVitamin persistedVitamin) {
		return new PersistedVitaminWrapper(persistedVitamin);
	}

}