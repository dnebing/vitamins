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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * This class is used by SOAP remote services, specifically {@link com.dnebinger.vitamins.service.http.PersistedVitaminServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class PersistedVitaminSoap implements Serializable {

	public static PersistedVitaminSoap toSoapModel(PersistedVitamin model) {
		PersistedVitaminSoap soapModel = new PersistedVitaminSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setPersistedVitaminId(model.getPersistedVitaminId());
		soapModel.setSurrogateId(model.getSurrogateId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setGroupName(model.getGroupName());
		soapModel.setArticleId(model.getArticleId());
		soapModel.setDescription(model.getDescription());
		soapModel.setName(model.getName());
		soapModel.setType(model.getType());

		return soapModel;
	}

	public static PersistedVitaminSoap[] toSoapModels(
		PersistedVitamin[] models) {

		PersistedVitaminSoap[] soapModels =
			new PersistedVitaminSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PersistedVitaminSoap[][] toSoapModels(
		PersistedVitamin[][] models) {

		PersistedVitaminSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new PersistedVitaminSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PersistedVitaminSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PersistedVitaminSoap[] toSoapModels(
		List<PersistedVitamin> models) {

		List<PersistedVitaminSoap> soapModels =
			new ArrayList<PersistedVitaminSoap>(models.size());

		for (PersistedVitamin model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PersistedVitaminSoap[soapModels.size()]);
	}

	public PersistedVitaminSoap() {
	}

	public long getPrimaryKey() {
		return _persistedVitaminId;
	}

	public void setPrimaryKey(long pk) {
		setPersistedVitaminId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getPersistedVitaminId() {
		return _persistedVitaminId;
	}

	public void setPersistedVitaminId(long persistedVitaminId) {
		_persistedVitaminId = persistedVitaminId;
	}

	public String getSurrogateId() {
		return _surrogateId;
	}

	public void setSurrogateId(String surrogateId) {
		_surrogateId = surrogateId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getGroupName() {
		return _groupName;
	}

	public void setGroupName(String groupName) {
		_groupName = groupName;
	}

	public String getArticleId() {
		return _articleId;
	}

	public void setArticleId(String articleId) {
		_articleId = articleId;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public int getType() {
		return _type;
	}

	public void setType(int type) {
		_type = type;
	}

	private String _uuid;
	private long _persistedVitaminId;
	private String _surrogateId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _groupName;
	private String _articleId;
	private String _description;
	private String _name;
	private int _type;

}