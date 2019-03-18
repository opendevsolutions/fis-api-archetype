package ar.com.opendevsolutions.routers;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/* insert in this class:
 * General configuration to the rest services
 */
@Component
public abstract class ExampleRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		/* insert in this method:
		 * General excelptions
		 */
		addRoutes();
	}
	
		
	protected abstract void addRoutes() throws Exception;
}
