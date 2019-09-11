package com.dnebinger.headless.vitamins.internal.resource.v1_0;

import com.dnebinger.headless.vitamins.dto.v1_0.Vitamin;
import com.dnebinger.headless.vitamins.resource.v1_0.VitaminResource;

import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.liferay.portal.vulcan.util.TransformUtil;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.annotation.Generated;

import javax.validation.constraints.NotNull;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 * @author Dave Nebinger
 * @generated
 */
@Generated("")
@Path("/v1.0")
public abstract class BaseVitaminResourceImpl implements VitaminResource {

	@Override
	@GET
	@Operation(
		description = "Retrieves the list of vitamins and minerals. Results can be paginated, filtered, searched, and sorted."
	)
	@Parameters(
		value = {
			@Parameter(in = ParameterIn.QUERY, name = "search"),
			@Parameter(in = ParameterIn.QUERY, name = "filter"),
			@Parameter(in = ParameterIn.QUERY, name = "page"),
			@Parameter(in = ParameterIn.QUERY, name = "pageSize"),
			@Parameter(in = ParameterIn.QUERY, name = "sort")
		}
	)
	@Path("/vitamins")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Vitamin")})
	public Page<Vitamin> getVitaminsPage(
			@Parameter(hidden = true) @QueryParam("search") String search,
			@Context Filter filter, @Context Pagination pagination,
			@Context Sort[] sorts)
		throws Exception {

		return Page.of(Collections.emptyList());
	}

	@Override
	@Consumes({"application/json", "application/xml"})
	@Operation(description = "Create a new vitamin/mineral.")
	@POST
	@Path("/vitamins")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Vitamin")})
	public Vitamin postVitamin(Vitamin vitamin) throws Exception {
		return new Vitamin();
	}

	@Override
	@DELETE
	@Operation(
		description = "Deletes the vitamin/mineral and returns a 204 if the operation succeeds."
	)
	@Parameters(value = {@Parameter(in = ParameterIn.PATH, name = "vitaminId")})
	@Path("/vitamins/{vitaminId}")
	@Produces("application/json")
	@Tags(value = {@Tag(name = "Vitamin")})
	public void deleteVitamin(
			@NotNull @Parameter(hidden = true) @PathParam("vitaminId") String
				vitaminId)
		throws Exception {
	}

	@Override
	@GET
	@Operation(description = "Retrieves the vitamin/mineral via its ID.")
	@Parameters(value = {@Parameter(in = ParameterIn.PATH, name = "vitaminId")})
	@Path("/vitamins/{vitaminId}")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Vitamin")})
	public Vitamin getVitamin(
			@NotNull @Parameter(hidden = true) @PathParam("vitaminId") String
				vitaminId)
		throws Exception {

		return new Vitamin();
	}

	@Override
	@Consumes({"application/json", "application/xml"})
	@Operation(
		description = "Replaces the vitamin/mineral with the information sent in the request body. Any missing fields are deleted, unless they are required."
	)
	@PATCH
	@Parameters(value = {@Parameter(in = ParameterIn.PATH, name = "vitaminId")})
	@Path("/vitamins/{vitaminId}")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Vitamin")})
	public Vitamin patchVitamin(
			@NotNull @Parameter(hidden = true) @PathParam("vitaminId") String
				vitaminId,
			Vitamin vitamin)
		throws Exception {

		Vitamin existingVitamin = getVitamin(vitaminId);

		if (vitamin.getArticleId() != null) {
			existingVitamin.setArticleId(vitamin.getArticleId());
		}

		if (vitamin.getAttributes() != null) {
			existingVitamin.setAttributes(vitamin.getAttributes());
		}

		if (vitamin.getChemicalNames() != null) {
			existingVitamin.setChemicalNames(vitamin.getChemicalNames());
		}

		if (vitamin.getDescription() != null) {
			existingVitamin.setDescription(vitamin.getDescription());
		}

		if (vitamin.getGroup() != null) {
			existingVitamin.setGroup(vitamin.getGroup());
		}

		if (vitamin.getName() != null) {
			existingVitamin.setName(vitamin.getName());
		}

		if (vitamin.getProperties() != null) {
			existingVitamin.setProperties(vitamin.getProperties());
		}

		if (vitamin.getRisks() != null) {
			existingVitamin.setRisks(vitamin.getRisks());
		}

		if (vitamin.getSymptoms() != null) {
			existingVitamin.setSymptoms(vitamin.getSymptoms());
		}

		if (vitamin.getType() != null) {
			existingVitamin.setType(vitamin.getType());
		}

		preparePatch(vitamin, existingVitamin);

		return putVitamin(vitaminId, existingVitamin);
	}

	@Override
	@Consumes({"application/json", "application/xml"})
	@Operation(
		description = "Replaces the vitamin/mineral with the information sent in the request body. Any missing fields are deleted, unless they are required."
	)
	@PUT
	@Parameters(value = {@Parameter(in = ParameterIn.PATH, name = "vitaminId")})
	@Path("/vitamins/{vitaminId}")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Vitamin")})
	public Vitamin putVitamin(
			@NotNull @Parameter(hidden = true) @PathParam("vitaminId") String
				vitaminId,
			Vitamin vitamin)
		throws Exception {

		return new Vitamin();
	}

	public void setContextCompany(Company contextCompany) {
		this.contextCompany = contextCompany;
	}

	protected void preparePatch(Vitamin vitamin, Vitamin existingVitamin) {
	}

	protected <T, R> List<R> transform(
		Collection<T> collection,
		UnsafeFunction<T, R, Exception> unsafeFunction) {

		return TransformUtil.transform(collection, unsafeFunction);
	}

	protected <T, R> R[] transform(
		T[] array, UnsafeFunction<T, R, Exception> unsafeFunction,
		Class<?> clazz) {

		return TransformUtil.transform(array, unsafeFunction, clazz);
	}

	protected <T, R> R[] transformToArray(
		Collection<T> collection,
		UnsafeFunction<T, R, Exception> unsafeFunction, Class<?> clazz) {

		return TransformUtil.transformToArray(
			collection, unsafeFunction, clazz);
	}

	protected <T, R> List<R> transformToList(
		T[] array, UnsafeFunction<T, R, Exception> unsafeFunction) {

		return TransformUtil.transformToList(array, unsafeFunction);
	}

	@Context
	protected AcceptLanguage contextAcceptLanguage;

	@Context
	protected Company contextCompany;

	@Context
	protected UriInfo contextUriInfo;

}