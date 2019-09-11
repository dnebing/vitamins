package com.dnebinger.vitamins.internal.search.spi.model.index.contributor;

import com.dnebinger.vitamins.constants.PersistedVitaminType;
import com.dnebinger.vitamins.model.PersistedVitamin;
import com.dnebinger.vitamins.model.VitaminDetail;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import org.osgi.service.component.annotations.Component;

import java.util.List;

/**
 * class PersistedVitaminModelDocumentContributor: Grabs all of the fields that we want to contribute to our document
 * object.
 *
 * @author dnebinger
 */
@Component(
		immediate = true,
		property = "indexer.class.name=com.dnebinger.vitamins.model.PersistedVitamin",
		service = ModelDocumentContributor.class
)
public class PersistedVitaminModelDocumentContributor implements ModelDocumentContributor<PersistedVitamin> {
	@Override
	public void contribute(Document document, PersistedVitamin vitamin) {
		document.addText(Field.DESCRIPTION, vitamin.getDescription());
		document.addText(Field.NAME, vitamin.getName());

		String vType = "other";
		if (vitamin.getType() == PersistedVitaminType.MINERAL) {
			vType = "mineral";
		} else if (vitamin.getType() == PersistedVitaminType.VITAMIN) {
			vType = "vitamin";
		}

		document.addKeyword("vType", vType);

		document.addKeyword("vitaminGroup", vitamin.getGroupName());

		// we also want to support search by any of the chemical names.
		List<VitaminDetail> details = vitamin.getChemicalNames();

		if ((details != null) && (! details.isEmpty())) {
			String[] chemNames = new String[details.size()];


			for (int idx = 0; idx < details.size(); idx++) {
				chemNames[idx] = details.get(idx).getValue();
			}

			document.addKeywordSortable("chemicalName", chemNames);
		}
	}
}
