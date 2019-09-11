package com.dnebinger.headless.vitamins.resource.v1_0;

import com.dnebinger.headless.vitamins.dto.v1_0.Vitamin;

import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import javax.annotation.Generated;

/**
 * To access this resource, run:
 *
 *     curl -u your@email.com:yourpassword -D - http://localhost:8080/o/headless-vitamins/v1.0
 *
 * @author Dave Nebinger
 * @generated
 */
@Generated("")
public interface VitaminResource {

	public Page<Vitamin> getVitaminsPage(
			String search, Filter filter, Pagination pagination, Sort[] sorts)
		throws Exception;

	public Vitamin postVitamin(Vitamin vitamin) throws Exception;

	public void deleteVitamin(String vitaminId) throws Exception;

	public Vitamin getVitamin(String vitaminId) throws Exception;

	public Vitamin patchVitamin(String vitaminId, Vitamin vitamin)
		throws Exception;

	public Vitamin putVitamin(String vitaminId, Vitamin vitamin)
		throws Exception;

	public void setContextCompany(Company contextCompany);

}