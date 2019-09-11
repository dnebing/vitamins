package com.dnebinger.vitamins.internal.search.spi.model.query.contributor;

import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.search.query.QueryHelper;
import com.liferay.portal.search.spi.model.query.contributor.KeywordQueryContributor;
import com.liferay.portal.search.spi.model.query.contributor.helper.KeywordQueryContributorHelper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true,
		property = "indexer.class.name=com.dnebinger.vitamins.model.PersistedVitamin",
		service = KeywordQueryContributor.class
)
public class PersistedVitaminKeywordQueryContributor implements KeywordQueryContributor {
	@Override
	public void contribute(String keywords, BooleanQuery booleanQuery, KeywordQueryContributorHelper keywordQueryContributorHelper) {
		SearchContext searchContext =
				keywordQueryContributorHelper.getSearchContext();

		// description is already in there...
		queryHelper.addSearchTerm(
				booleanQuery, searchContext, Field.NAME, false);

		// we want to add the vTerm, the chemicalNames, the vitaminGroup,
		queryHelper.addSearchTerm(
				booleanQuery, searchContext, "vTerm", false);
		queryHelper.addSearchTerm(
				booleanQuery, searchContext, "chemicalNames", false);
		queryHelper.addSearchTerm(
				booleanQuery, searchContext, "vitaminGroup", false);
	}

	@Reference
	protected QueryHelper queryHelper;
}
