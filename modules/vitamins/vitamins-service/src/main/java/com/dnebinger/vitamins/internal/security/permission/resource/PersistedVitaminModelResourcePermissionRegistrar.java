package com.dnebinger.vitamins.internal.security.permission.resource;

import com.dnebinger.vitamins.constants.VitaminConstants;
import com.dnebinger.vitamins.constants.VitaminPortletKeys;
import com.dnebinger.vitamins.model.PersistedVitamin;
import com.dnebinger.vitamins.service.PersistedVitaminLocalService;
import com.liferay.exportimport.kernel.staging.permission.StagingPermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermissionFactory;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.StagedModelPermissionLogic;
import com.liferay.portal.kernel.security.permission.resource.WorkflowedModelPermissionLogic;
import com.liferay.portal.kernel.util.HashMapDictionary;
import com.liferay.portal.kernel.workflow.permission.WorkflowPermission;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import java.util.Dictionary;

@Component(immediate = true)
public class PersistedVitaminModelResourcePermissionRegistrar {

	@Activate
	public void activate(BundleContext bundleContext) {
		Dictionary<String, Object> properties = new HashMapDictionary<>();

		properties.put("model.class.name", PersistedVitamin.class.getName());

		_serviceRegistration = bundleContext.registerService(
				ModelResourcePermission.class,
				ModelResourcePermissionFactory.create(
						PersistedVitamin.class, PersistedVitamin::getPersistedVitaminId,
						persistedVitaminLocalService::getPersistedVitamin, _portletResourcePermission,
						(modelResourcePermission, consumer) -> {
							// nothing really to consume
						}),
				properties);
	}

	@Deactivate
	public void deactivate() {
		_serviceRegistration.unregister();
	}

	@Reference
	private PersistedVitaminLocalService persistedVitaminLocalService;

	@Reference(target = "(resource.name=" + VitaminConstants.RESOURCE_NAME + ")")
	private PortletResourcePermission _portletResourcePermission;

	private ServiceRegistration<ModelResourcePermission> _serviceRegistration;
}
