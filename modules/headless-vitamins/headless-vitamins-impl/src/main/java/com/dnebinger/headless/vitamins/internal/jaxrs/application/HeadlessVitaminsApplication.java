package com.dnebinger.headless.vitamins.internal.jaxrs.application;

import javax.annotation.Generated;

import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;

/**
 * @author Dave Nebinger
 * @generated
 */
@Component(
	property = {
		"osgi.jaxrs.application.base=/headless-vitamins",
		"osgi.jaxrs.extension.select=(osgi.jaxrs.name=Liferay.Vulcan)",
		"osgi.jaxrs.name=dnebinger.Headless.Vitamins"
	},
	service = Application.class
)
@Generated("")
public class HeadlessVitaminsApplication extends Application {
}