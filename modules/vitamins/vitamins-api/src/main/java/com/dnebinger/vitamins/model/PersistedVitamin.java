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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the PersistedVitamin service. Represents a row in the &quot;NEB_PersistedVitamin&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see PersistedVitaminModel
 * @generated
 */
@ImplementationClassName(
	"com.dnebinger.vitamins.model.impl.PersistedVitaminImpl"
)
@ProviderType
public interface PersistedVitamin
	extends PersistedModel, PersistedVitaminModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.dnebinger.vitamins.model.impl.PersistedVitaminImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<PersistedVitamin, Long>
		PERSISTED_VITAMIN_ID_ACCESSOR = new Accessor<PersistedVitamin, Long>() {

			@Override
			public Long get(PersistedVitamin persistedVitamin) {
				return persistedVitamin.getPersistedVitaminId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<PersistedVitamin> getTypeClass() {
				return PersistedVitamin.class;
			}

		};

	public java.util.List<VitaminDetail> getAllVitaminDetails();

	/**
	 * getSymptoms: Returns the list of symptom details.
	 *
	 * @return List
	 */
	public java.util.List<VitaminDetail> getSymptoms();

	/**
	 * getAttributes: Returns the list of attribute details.
	 *
	 * @return List
	 */
	public java.util.List<VitaminDetail> getAttributes();

	/**
	 * getProperties: Returns the list of property details.
	 *
	 * @return List
	 */
	public java.util.List<VitaminDetail> getProperties();

	/**
	 * getChemicalNames: Returns the list of chemical name details.
	 *
	 * @return List
	 */
	public java.util.List<VitaminDetail> getChemicalNames();

	/**
	 * getRisks: Returns the list of risk details.
	 *
	 * @return List
	 */
	public java.util.List<VitaminDetail> getRisks();

}