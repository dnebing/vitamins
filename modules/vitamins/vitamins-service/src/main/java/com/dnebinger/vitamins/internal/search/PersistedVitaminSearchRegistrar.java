package com.dnebinger.vitamins.internal.search;

import com.dnebinger.vitamins.model.PersistedVitamin;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.registrar.ModelSearchRegistrarHelper;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;
import com.liferay.portal.search.spi.model.result.contributor.ModelVisibilityContributor;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = {PersistedVitaminSearchRegistrar.class})
public class PersistedVitaminSearchRegistrar {
	@Activate
	protected void activate(BundleContext bundleContext) {
		_serviceRegistration = modelSearchRegistrarHelper.register(
				PersistedVitamin.class, bundleContext,
				modelSearchDefinition -> {
					modelSearchDefinition.setDefaultSelectedFieldNames(
							Field.COMPANY_ID,
							Field.ENTRY_CLASS_NAME, Field.ENTRY_CLASS_PK,
							Field.GROUP_ID, Field.SCOPE_GROUP_ID,
							Field.UID, Field.NAME, Field.DESCRIPTION, "chemicalNames");
					//modelSearchDefinition.setDefaultSelectedLocalizedFieldNames(
					//		Field.CONTENT, Field.TITLE);
					modelSearchDefinition.setModelIndexWriteContributor(
							modelIndexWriterContributor);
					modelSearchDefinition.setModelSummaryContributor(
							modelSummaryContributor);
					//modelSearchDefinition.setModelVisibilityContributor(
					//		modelVisibilityContributor);
				});
	}

	@Deactivate
	protected void deactivate() {
		_serviceRegistration.unregister();
	}

	@Reference(
			target = "(indexer.class.name=com.dnebinger.vitamins.model.PersistedVitamin)"
	)
	protected ModelIndexerWriterContributor<PersistedVitamin>
			modelIndexWriterContributor;

	@Reference
	protected ModelSearchRegistrarHelper modelSearchRegistrarHelper;

	@Reference(
			target = "(indexer.class.name=com.dnebinger.vitamins.model.PersistedVitamin)"
	)
	protected ModelSummaryContributor modelSummaryContributor;

	/*
	@Reference(
			target = "(indexer.class.name=com.dnebinger.vitamins.model.PersistedVitamin)"
	)
	protected ModelVisibilityContributor modelVisibilityContributor;
	*/

	private ServiceRegistration<?> _serviceRegistration;
}
