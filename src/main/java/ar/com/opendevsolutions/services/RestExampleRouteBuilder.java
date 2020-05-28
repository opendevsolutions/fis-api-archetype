package ar.com.opendevsolutions.services;

import org.apache.camel.Exchange;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

import ar.com.opendevsolutions.utils.Constants;

@Component
public class RestExampleRouteBuilder extends ExampleRouteBuilder {

  @Override
  public void addRoutes() throws Exception {

	  from("direct:findAllEntityExample")
		.setHeader(Exchange.HTTP_METHOD, constant(Constants.GET))	
		.setHeader(Exchange.HTTP_PATH, constant(Constants.EMPTY))
		.setHeader(Constants.ACCEPT, constant(Constants.APPLICATION_JSON))
		.setHeader(Constants.CONTENT_TYPE, constant(Constants.APPLICATION_JSON))
	  	.to("jetty:http://18.231.124.229:8080/client/?bridgeEndpoint=true")
	  	.log("RestExample-FindAll: ${body}");
	  
	  from("direct:findEntityExampleById")
		.setHeader(Exchange.HTTP_METHOD, constant(Constants.GET))
		.setHeader(Exchange.HTTP_PATH, constant(Constants.EMPTY))
		.setHeader(Constants.ACCEPT, constant(Constants.APPLICATION_JSON))
		.setHeader(Constants.CONTENT_TYPE, constant(Constants.APPLICATION_JSON))
		.to("jetty:http://18.231.124.229:8080/client/1?bridgeEndpoint=true")
		.log("RestExample-FindById: ${body}");
  }

}
