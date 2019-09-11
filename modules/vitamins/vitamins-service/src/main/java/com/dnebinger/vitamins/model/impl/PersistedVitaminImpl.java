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

import com.dnebinger.vitamins.constants.VitaminDetailType;
import com.dnebinger.vitamins.model.VitaminDetail;
import com.dnebinger.vitamins.service.VitaminDetailLocalServiceUtil;
import org.osgi.annotation.versioning.ProviderType;

import java.util.List;

/**
 * The extended model implementation for the PersistedVitamin service. Represents a row in the &quot;NEB_PersistedVitamin&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.dnebinger.vitamins.model.PersistedVitamin<code> interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
@ProviderType
public class PersistedVitaminImpl extends PersistedVitaminBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a persisted vitamin model instance should use the {@link com.dnebinger.vitamins.model.PersistedVitamin} interface instead.
	 */
	public PersistedVitaminImpl() {
	}

	public List<VitaminDetail> getAllVitaminDetails() {
		return VitaminDetailLocalServiceUtil.getAllVitaminDetails(getPersistedVitaminId());
	}

	/**
	 * getSymptoms: Returns the list of symptom details.
	 * @return List
	 */
	public List<VitaminDetail> getSymptoms() {
		return VitaminDetailLocalServiceUtil.getVitaminDetailsByType(getPersistedVitaminId(), VitaminDetailType.SYMPTOM);
	}
	/**
	 * getAttributes: Returns the list of attribute details.
	 * @return List
	 */
	public List<VitaminDetail> getAttributes() {
		return VitaminDetailLocalServiceUtil.getVitaminDetailsByType(getPersistedVitaminId(), VitaminDetailType.ATTRIBUTE);
	}
	/**
	 * getProperties: Returns the list of property details.
	 * @return List
	 */
	public List<VitaminDetail> getProperties() {
		return VitaminDetailLocalServiceUtil.getVitaminDetailsByType(getPersistedVitaminId(), VitaminDetailType.PROPERTY);
	}
	/**
	 * getChemicalNames: Returns the list of chemical name details.
	 * @return List
	 */
	public List<VitaminDetail> getChemicalNames() {
		return VitaminDetailLocalServiceUtil.getVitaminDetailsByType(getPersistedVitaminId(), VitaminDetailType.CHEMICAL_NAME);
	}

	/**
	 * getRisks: Returns the list of risk details.
	 * @return List
	 */
	public List<VitaminDetail> getRisks() {
		return VitaminDetailLocalServiceUtil.getVitaminDetailsByType(getPersistedVitaminId(), VitaminDetailType.RISK);
	}
}