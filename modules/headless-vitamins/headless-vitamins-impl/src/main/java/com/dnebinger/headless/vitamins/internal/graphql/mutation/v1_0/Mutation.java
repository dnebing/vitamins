package com.dnebinger.headless.vitamins.internal.graphql.mutation.v1_0;

import com.dnebinger.headless.vitamins.dto.v1_0.Vitamin;
import com.dnebinger.headless.vitamins.resource.v1_0.VitaminResource;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.UriInfo;

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
	public Vitamin createVitamin(@GraphQLName("vitamin") Vitamin vitamin)
		throws Exception {

		return _applyComponentServiceObjects(
			_vitaminResourceComponentServiceObjects,
			this::_populateResourceContext,
			vitaminResource -> vitaminResource.postVitamin(vitamin));
	}

	@GraphQLField
	public boolean deleteVitamin(@GraphQLName("vitaminId") String vitaminId)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_vitaminResourceComponentServiceObjects,
			this::_populateResourceContext,
			vitaminResource -> vitaminResource.deleteVitamin(vitaminId));

		return true;
	}

	@GraphQLField
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

	@GraphQLField
	public Vitamin updateVitamin(
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

		vitaminResource.setContextAcceptLanguage(_acceptLanguage);
		vitaminResource.setContextCompany(_company);
		vitaminResource.setContextHttpServletRequest(_httpServletRequest);
		vitaminResource.setContextHttpServletResponse(_httpServletResponse);
		vitaminResource.setContextUriInfo(_uriInfo);
		vitaminResource.setContextUser(_user);
	}

	private static ComponentServiceObjects<VitaminResource>
		_vitaminResourceComponentServiceObjects;

	private AcceptLanguage _acceptLanguage;
	private Company _company;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private UriInfo _uriInfo;
	private User _user;

}