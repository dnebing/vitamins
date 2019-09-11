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
 * This class is a wrapper for {@link VitaminDetail}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see VitaminDetail
 * @generated
 */
@ProviderType
public class VitaminDetailWrapper
	extends BaseModelWrapper<VitaminDetail>
	implements VitaminDetail, ModelWrapper<VitaminDetail> {

	public VitaminDetailWrapper(VitaminDetail vitaminDetail) {
		super(vitaminDetail);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("vitaminDetailId", getVitaminDetailId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("persistedVitaminId", getPersistedVitaminId());
		attributes.put("type", getType());
		attributes.put("value", getValue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long vitaminDetailId = (Long)attributes.get("vitaminDetailId");

		if (vitaminDetailId != null) {
			setVitaminDetailId(vitaminDetailId);
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

		Long persistedVitaminId = (Long)attributes.get("persistedVitaminId");

		if (persistedVitaminId != null) {
			setPersistedVitaminId(persistedVitaminId);
		}

		Integer type = (Integer)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String value = (String)attributes.get("value");

		if (value != null) {
			setValue(value);
		}
	}

	/**
	 * Returns the company ID of this vitamin detail.
	 *
	 * @return the company ID of this vitamin detail
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this vitamin detail.
	 *
	 * @return the create date of this vitamin detail
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this vitamin detail.
	 *
	 * @return the group ID of this vitamin detail
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this vitamin detail.
	 *
	 * @return the modified date of this vitamin detail
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the persisted vitamin ID of this vitamin detail.
	 *
	 * @return the persisted vitamin ID of this vitamin detail
	 */
	@Override
	public long getPersistedVitaminId() {
		return model.getPersistedVitaminId();
	}

	/**
	 * Returns the primary key of this vitamin detail.
	 *
	 * @return the primary key of this vitamin detail
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the type of this vitamin detail.
	 *
	 * @return the type of this vitamin detail
	 */
	@Override
	public int getType() {
		return model.getType();
	}

	/**
	 * Returns the user ID of this vitamin detail.
	 *
	 * @return the user ID of this vitamin detail
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this vitamin detail.
	 *
	 * @return the user name of this vitamin detail
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this vitamin detail.
	 *
	 * @return the user uuid of this vitamin detail
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this vitamin detail.
	 *
	 * @return the uuid of this vitamin detail
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the value of this vitamin detail.
	 *
	 * @return the value of this vitamin detail
	 */
	@Override
	public String getValue() {
		return model.getValue();
	}

	/**
	 * Returns the vitamin detail ID of this vitamin detail.
	 *
	 * @return the vitamin detail ID of this vitamin detail
	 */
	@Override
	public long getVitaminDetailId() {
		return model.getVitaminDetailId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this vitamin detail.
	 *
	 * @param companyId the company ID of this vitamin detail
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this vitamin detail.
	 *
	 * @param createDate the create date of this vitamin detail
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this vitamin detail.
	 *
	 * @param groupId the group ID of this vitamin detail
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this vitamin detail.
	 *
	 * @param modifiedDate the modified date of this vitamin detail
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the persisted vitamin ID of this vitamin detail.
	 *
	 * @param persistedVitaminId the persisted vitamin ID of this vitamin detail
	 */
	@Override
	public void setPersistedVitaminId(long persistedVitaminId) {
		model.setPersistedVitaminId(persistedVitaminId);
	}

	/**
	 * Sets the primary key of this vitamin detail.
	 *
	 * @param primaryKey the primary key of this vitamin detail
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the type of this vitamin detail.
	 *
	 * @param type the type of this vitamin detail
	 */
	@Override
	public void setType(int type) {
		model.setType(type);
	}

	/**
	 * Sets the user ID of this vitamin detail.
	 *
	 * @param userId the user ID of this vitamin detail
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this vitamin detail.
	 *
	 * @param userName the user name of this vitamin detail
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this vitamin detail.
	 *
	 * @param userUuid the user uuid of this vitamin detail
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this vitamin detail.
	 *
	 * @param uuid the uuid of this vitamin detail
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the value of this vitamin detail.
	 *
	 * @param value the value of this vitamin detail
	 */
	@Override
	public void setValue(String value) {
		model.setValue(value);
	}

	/**
	 * Sets the vitamin detail ID of this vitamin detail.
	 *
	 * @param vitaminDetailId the vitamin detail ID of this vitamin detail
	 */
	@Override
	public void setVitaminDetailId(long vitaminDetailId) {
		model.setVitaminDetailId(vitaminDetailId);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected VitaminDetailWrapper wrap(VitaminDetail vitaminDetail) {
		return new VitaminDetailWrapper(vitaminDetail);
	}

}