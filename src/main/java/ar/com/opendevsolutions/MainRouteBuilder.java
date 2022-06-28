package ar.com.opendevsolutions;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

/* insert in this class:
 * General configuration to the rest services
 */
@Component
public abstract class MainRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		/* insert in this method:
		 * General excelptions
		 */		
		restConfiguration()
			.apiContextPath("/api-doc")
			.apiProperty("api.title", "FUSE Archetype REST API")
			.apiProperty("api.version", "1.0")
			.apiProperty("cors", "true")
			.apiProperty("base.path", "api/")
			.apiProperty("api.path", "/")
			.apiProperty("host", "")
			.apiContextRouteId("doc-api")
			.component("servlet")
			.bindingMode(RestBindingMode.json);
		addRoutes();
		
	}
	
	protected abstract void addRoutes() throws Exception;
}
