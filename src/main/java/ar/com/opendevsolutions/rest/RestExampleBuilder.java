package ar.com.opendevsolutions.rest;

import org.springframework.stereotype.Component;

import ar.com.opendevsolutions.MainRouteBuilder;

@Component
public class RestExampleBuilder extends MainRouteBuilder {

	@Override
	protected void addRoutes() throws Exception {
			rest("/rest-entity-example")
			.description("Api Example")
				.get("/find-all")
				.produces("application/json")
				.description("Get All")
				.to("direct:findAllEntityExample");
	}

}
