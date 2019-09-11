package com.dnebinger.headless.vitamins.internal.graphql.mutation.v1_0;

import com.dnebinger.headless.vitamins.dto.v1_0.Vitamin;
import com.dnebinger.headless.vitamins.resource.v1_0.VitaminResource;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;

import graphql.annotations.annotationTypes.GraphQLField;
import graphql.annotations.annotationTypes.GraphQLInvokeDetached;
import graphql.annotations.annotationTypes.GraphQLName;

import javax.annotation.Generated;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author Dave Nebinger
 * @generated
 */
@Generated("")
public class Mutation {

	public static void setVitaminResourceComponentServiceObjects(
		ComponentServiceObjects<VitaminResource>
			vitaminResourceComponentServiceObjects) {

		_vitaminResourceComponentServiceObjects =
			vitaminResourceComponentServiceObjects;
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Vitamin postVitamin(@GraphQLName("vitamin") Vitamin vitamin)
		throws Exception {

		return _applyComponentServiceObjects(
			_vitaminResourceComponentServiceObjects,
			this::_populateResourceContext,
			vitaminResource -> vitaminResource.postVitamin(vitamin));
	}

	@GraphQLInvokeDetached
	public void deleteVitamin(@GraphQLName("vitaminId") String vitaminId)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_vitaminResourceComponentServiceObjects,
			this::_populateResourceContext,
			vitaminResource -> vitaminResource.deleteVitamin(vitaminId));
	}

	@GraphQLInvokeDetached
	public Vitamin patchVitamin(
			@GraphQLName("vitaminId") String vitaminId,
			@GraphQLName("vitamin") Vitamin vitamin)
		throws Exception {

		return _applyComponentServiceObjects(
			_vitaminResourceComponentServiceObjects,
			this::_populateResourceContext,
			vitaminResource -> vitaminResource.patchVitamin(
				vitaminId, vitamin));
	}

	@GraphQLInvokeDetached
	public Vitamin putVitamin(
			@GraphQLName("vitaminId") String vitaminId,
			@GraphQLName("vitamin") Vitamin vitamin)
		throws Exception {

		return _applyComponentServiceObjects(
			_vitaminResourceComponentServiceObjects,
			this::_populateResourceContext,
			vitaminResource -> vitaminResource.putVitamin(vitaminId, vitamin));
	}

	private <T, R, E1 extends Throwable, E2 extends Throwable> R
			_applyComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeFunction<T, R, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			return unsafeFunction.apply(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private <T, E1 extends Throwable, E2 extends Throwable> void
			_applyVoidComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeConsumer<T, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			unsafeFunction.accept(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private void _populateResourceContext(VitaminResource vitaminResource)
		throws Exception {

		vitaminResource.setContextCompany(
			CompanyLocalServiceUtil.getCompany(
				CompanyThreadLocal.getCompanyId()));
	}

	private static ComponentServiceObjects<VitaminResource>
		_vitaminResourceComponentServiceObjects;

}