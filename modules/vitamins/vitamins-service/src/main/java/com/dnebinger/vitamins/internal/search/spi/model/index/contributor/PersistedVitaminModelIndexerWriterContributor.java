package com.dnebinger.vitamins.internal.search.spi.model.index.contributor;

import com.dnebinger.vitamins.model.PersistedVitamin;
import com.dnebinger.vitamins.service.PersistedVitaminLocalService;
import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.IndexerWriterMode;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Date;

@Component(
		immediate = true,
		property = "indexer.class.name=com.dnebinger.vitamins.model.PersistedVitamin",
		service = ModelIndexerWriterContributor.class
)
public class PersistedVitaminModelIndexerWriterContributor implements ModelIndexerWriterContributor<PersistedVitamin> {
	@Override
	public void customize(BatchIndexingActionable batchIndexingActionable, ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {
		// we don't need to customize the batchIndexingActionable guy, just use as is.

		batchIndexingActionable.setPerformActionMethod((PersistedVitamin vitamin) -> {
			Document document = modelIndexerWriterDocumentHelper.getDocument(vitamin);

			batchIndexingActionable.addDocuments(document);
		});
	}

	@Override
	public BatchIndexingActionable getBatchIndexingActionable() {
		return _dynamicQueryBatchIndexingActionableFactory.getBatchIndexingActionable(persistedVitaminLocalService.getIndexableActionableDynamicQuery());
	}

	@Override
	public long getCompanyId(PersistedVitamin vitamin) {
		return vitamin.getCompanyId();
	}

	@Override
	public IndexerWriterMode getIndexerWriterMode(PersistedVitamin vitamin) {
		return IndexerWriterMode.UPDATE;
	}

	@Reference
	private PersistedVitaminLocalService persistedVitaminLocalService;

	@Reference
	private DynamicQueryBatchIndexingActionableFactory _dynamicQueryBatchIndexingActionableFactory;
}
