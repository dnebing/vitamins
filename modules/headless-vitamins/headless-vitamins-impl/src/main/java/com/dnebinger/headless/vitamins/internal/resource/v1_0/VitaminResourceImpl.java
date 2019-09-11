package com.dnebinger.headless.vitamins.internal.resource.v1_0;

import com.dnebinger.headless.vitamins.dto.v1_0.Vitamin;
import com.dnebinger.headless.vitamins.internal.util.CreatorUtil;
import com.dnebinger.headless.vitamins.internal.odata.entity.v1_0.VitaminEntityModel;
import com.dnebinger.headless.vitamins.resource.v1_0.VitaminResource;

import com.dnebinger.vitamins.constants.PersistedVitaminType;
import com.dnebinger.vitamins.model.PersistedVitamin;
import com.dnebinger.vitamins.model.VitaminDetail;
import com.dnebinger.vitamins.service.PersistedVitaminService;
import com.liferay.headless.common.spi.service.context.ServiceContextUtil;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.search.filter.TermFilter;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.Accessor;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.liferay.portal.vulcan.resource.EntityModelResource;
import com.liferay.portal.vulcan.util.SearchUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.constraints.NotNull;
import javax.ws.rs.core.MultivaluedMap;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Dave Nebinger
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/vitamin.properties",
	scope = ServiceScope.PROTOTYPE, service = VitaminResource.class
)
public class VitaminResourceImpl extends BaseVitaminResourceImpl implements EntityModelResource {

	private VitaminEntityModel _vitaminEntityModel = new VitaminEntityModel();

	@Override
	public EntityModel getEntityModel(MultivaluedMap multivaluedMap) throws Exception {
		return _vitaminEntityModel;
	}

	@Override
	public Page<Vitamin> getVitaminsPage(String search, Filter filter, Pagination pagination, Sort[] sorts) throws Exception {
		return SearchUtil.search(
				booleanQuery -> {
					// does nothing, we just need the UnsafeConsumer<BooleanQuery, Exception> method
				},
				filter, PersistedVitamin.class, search, pagination,
				queryConfig -> queryConfig.setSelectedFieldNames(
						Field.ENTRY_CLASS_PK),
				searchContext -> searchContext.setCompanyId(
						contextCompany.getCompanyId()),
				document -> _toVitamin(
						_persistedVitaminService.getPersistedVitamin(
								GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)))),
				sorts);
	}

	@Override
	public void deleteVitamin(@NotNull String vitaminId) throws Exception {

		// super easy case, just pass through to the service layer.
		_persistedVitaminService.deletePersistedVitamin(vitaminId);
	}

	@Override
	public Vitamin getVitamin(@NotNull String vitaminId) throws Exception {
		// fetch the entity class...
		PersistedVitamin pv = _persistedVitaminService.getPersistedVitamin(vitaminId);

		return _toVitamin(pv);
	}

	@Override
	public Vitamin postVitamin(Vitamin v) throws Exception {
		PersistedVitamin pv = _persistedVitaminService.addPersistedVitamin(
				v.getId(), v.getName(), v.getGroup(), v.getDescription(), _toTypeCode(v.getType()), v.getArticleId(), v.getChemicalNames(),
				v.getProperties(), v.getAttributes(), v.getSymptoms(), v.getRisks(), _getServiceContext());

		return _toVitamin(pv);
	}

	@Override
	public Vitamin patchVitamin(@NotNull String vitaminId, Vitamin v) throws Exception {
		PersistedVitamin pv = _persistedVitaminService.patchPersistedVitamin(vitaminId,
				v.getId(), v.getName(), v.getGroup(), v.getDescription(), _toTypeCode(v.getType()), v.getArticleId(), v.getChemicalNames(),
				v.getProperties(), v.getAttributes(), v.getSymptoms(), v.getRisks(), _getServiceContext());

		return _toVitamin(pv);
	}

	@Override
	public Vitamin putVitamin(@NotNull String vitaminId, Vitamin v) throws Exception {
		PersistedVitamin pv = _persistedVitaminService.updatePersistedVitamin(vitaminId,
				v.getId(), v.getName(), v.getGroup(), v.getDescription(), _toTypeCode(v.getType()), v.getArticleId(), v.getChemicalNames(),
				v.getProperties(), v.getAttributes(), v.getSymptoms(), v.getRisks(), _getServiceContext());

		return _toVitamin(pv);
	}

	protected ServiceContext _getServiceContext() {
		ServiceContext serviceContext = ServiceContextUtil.createServiceContext(0, "anyone");
		serviceContext.setCompanyId(contextCompany.getCompanyId());

		// need the current user in the service context.
		// will get easier in newer version of the REST Builder plugin...
		// but for now, this is the only game in town.
		long userId = PrincipalThreadLocal.getUserId();

		serviceContext.setUserId(userId);

		return serviceContext;
	}

	protected int _toTypeCode(final Vitamin.Type type) {
		switch (type) {
			case VITAMIN: return PersistedVitaminType.VITAMIN;
			case MINERAL: return PersistedVitaminType.MINERAL;
		}

		return PersistedVitaminType.OTHER;
	}

	protected Vitamin _toVitamin(PersistedVitamin pv) throws Exception {
		return new Vitamin() {{
			creator = CreatorUtil.toCreator(_portal, _userLocalService.getUser(pv.getUserId()));
			articleId = pv.getArticleId();
			group = pv.getGroupName();
			description = pv.getDescription();
			id = pv.getSurrogateId();
			name = pv.getName();
			type = _toVitaminType(pv.getType());
			attributes = ListUtil.toArray(pv.getAttributes(), VALUE_ACCESSOR);
			chemicalNames = ListUtil.toArray(pv.getChemicalNames(), VALUE_ACCESSOR);
			properties = ListUtil.toArray(pv.getProperties(), VALUE_ACCESSOR);
			risks = ListUtil.toArray(pv.getRisks(), VALUE_ACCESSOR);
			symptoms = ListUtil.toArray(pv.getSymptoms(), VALUE_ACCESSOR);
		}};
	}

	protected Vitamin.Type _toVitaminType(int typeCode) {
		if (typeCode == PersistedVitaminType.VITAMIN) {
			return Vitamin.Type.VITAMIN;
		}
		if (typeCode == PersistedVitaminType.MINERAL) {
			return Vitamin.Type.MINERAL;
		}

		return Vitamin.Type.OTHER;
	}

	protected static final Accessor<VitaminDetail, String> VALUE_ACCESSOR = new Accessor<VitaminDetail, String>() {
		@Override
		public String get(VitaminDetail vd) {
			return vd.getValue();
		}
		@Override
		public Class<String> getAttributeClass() {
			return String.class;
		}
		@Override
		public Class<VitaminDetail> getTypeClass() {
			return VitaminDetail.class;
		}
	};

	@Reference
	private Portal _portal;

	@Reference
	private UserLocalService _userLocalService;

	@Reference
	private PersistedVitaminService _persistedVitaminService;

	private static final Logger _log = LoggerFactory.getLogger(VitaminResourceImpl.class);
}