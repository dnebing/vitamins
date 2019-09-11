package com.dnebinger.headless.vitamins.internal.graphql.query.v1_0;

import com.dnebinger.headless.vitamins.dto.v1_0.Vitamin;
import com.dnebinger.headless.vitamins.resource.v1_0.VitaminResource;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import graphql.annotations.annotationTypes.GraphQLField;
import graphql.annotations.annotationTypes.GraphQLInvokeDetached;
import graphql.annotations.annotationTypes.GraphQLName;

import java.util.Collection;

import javax.annotation.Generated;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author Dave Nebinger
 * @generated
 */
@Generated("")
public class Query {

	public static void setVitaminResourceComponentServiceObjects(
		ComponentServiceObjects<VitaminResource>
			vitaminResourceComponentServiceObjects) {

		_vitaminResourceComponentServiceObjects =
			vitaminResourceComponentServiceObjects;
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Collection<Vitamin> getVitaminsPage(
			@GraphQLName("search") String search,
			@GraphQLName("filter") Filter filter,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page, @GraphQLName("sorts") Sort[] sorts)
		throws Exception {

		return _applyComponentServiceObjects(
			_vitaminResourceComponentServiceObjects,
			this::_populateResourceContext,
			vitaminResource -> {
				Page paginationPage = vitaminResource.getVitaminsPage(
					search, filter, Pagination.of(pageSize, page), sorts);

				return paginationPage.getItems();
			});
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Vitamin getVitamin(@GraphQLName("vitaminId") String vitaminId)
		throws Exception {

		return _applyComponentServiceObjects(
			_vitaminResourceComponentServiceObjects,
			this::_populateResourceContext,
			vitaminResource -> vitaminResource.getVitamin(vitaminId));
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

	private void _populateResourceContext(VitaminResource vitaminResource)
		throws Exception {

		vitaminResource.setContextCompany(
			CompanyLocalServiceUtil.getCompany(
				CompanyThreadLocal.getCompanyId()));
	}

	private static ComponentServiceObjects<VitaminResource>
		_vitaminResourceComponentServiceObjects;

}