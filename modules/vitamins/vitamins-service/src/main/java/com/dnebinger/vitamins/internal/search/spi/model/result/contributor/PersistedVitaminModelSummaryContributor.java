package com.dnebinger.vitamins.internal.search.spi.model.result.contributor;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;
import org.osgi.service.component.annotations.Component;

import java.util.Locale;

@Component(
		immediate = true,
		property = "indexer.class.name=com.dnebinger.vitamins.model.PersistedVitamin",
		service = ModelSummaryContributor.class
)
public class PersistedVitaminModelSummaryContributor implements ModelSummaryContributor {

	@Override
	public Summary getSummary(
			Document document, Locale locale, String snippet) {

		Summary summary = new Summary(
				document.get(Field.NAME),
				document.get(Field.DESCRIPTION));

		summary.setMaxContentLength(200);

		return summary;
	}
}
