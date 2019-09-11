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

package com.dnebinger.vitamins.model.impl;

import com.dnebinger.vitamins.model.PersistedVitamin;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing PersistedVitamin in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class PersistedVitaminCacheModel
	implements CacheModel<PersistedVitamin>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PersistedVitaminCacheModel)) {
			return false;
		}

		PersistedVitaminCacheModel persistedVitaminCacheModel =
			(PersistedVitaminCacheModel)obj;

		if (persistedVitaminId ==
				persistedVitaminCacheModel.persistedVitaminId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, persistedVitaminId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", persistedVitaminId=");
		sb.append(persistedVitaminId);
		sb.append(", surrogateId=");
		sb.append(surrogateId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", groupName=");
		sb.append(groupName);
		sb.append(", articleId=");
		sb.append(articleId);
		sb.append(", description=");
		sb.append(description);
		sb.append(", name=");
		sb.append(name);
		sb.append(", type=");
		sb.append(type);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PersistedVitamin toEntityModel() {
		PersistedVitaminImpl persistedVitaminImpl = new PersistedVitaminImpl();

		if (uuid == null) {
			persistedVitaminImpl.setUuid("");
		}
		else {
			persistedVitaminImpl.setUuid(uuid);
		}

		persistedVitaminImpl.setPersistedVitaminId(persistedVitaminId);

		if (surrogateId == null) {
			persistedVitaminImpl.setSurrogateId("");
		}
		else {
			persistedVitaminImpl.setSurrogateId(surrogateId);
		}

		persistedVitaminImpl.setGroupId(groupId);
		persistedVitaminImpl.setCompanyId(companyId);
		persistedVitaminImpl.setUserId(userId);

		if (userName == null) {
			persistedVitaminImpl.setUserName("");
		}
		else {
			persistedVitaminImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			persistedVitaminImpl.setCreateDate(null);
		}
		else {
			persistedVitaminImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			persistedVitaminImpl.setModifiedDate(null);
		}
		else {
			persistedVitaminImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (groupName == null) {
			persistedVitaminImpl.setGroupName("");
		}
		else {
			persistedVitaminImpl.setGroupName(groupName);
		}

		if (articleId == null) {
			persistedVitaminImpl.setArticleId("");
		}
		else {
			persistedVitaminImpl.setArticleId(articleId);
		}

		if (description == null) {
			persistedVitaminImpl.setDescription("");
		}
		else {
			persistedVitaminImpl.setDescription(description);
		}

		if (name == null) {
			persistedVitaminImpl.setName("");
		}
		else {
			persistedVitaminImpl.setName(name);
		}

		persistedVitaminImpl.setType(type);

		persistedVitaminImpl.resetOriginalValues();

		return persistedVitaminImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		persistedVitaminId = objectInput.readLong();
		surrogateId = objectInput.readUTF();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		groupName = objectInput.readUTF();
		articleId = objectInput.readUTF();
		description = objectInput.readUTF();
		name = objectInput.readUTF();

		type = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(persistedVitaminId);

		if (surrogateId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(surrogateId);
		}

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (groupName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(groupName);
		}

		if (articleId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(articleId);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeInt(type);
	}

	public String uuid;
	public long persistedVitaminId;
	public String surrogateId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String groupName;
	public String articleId;
	public String description;
	public String name;
	public int type;

}