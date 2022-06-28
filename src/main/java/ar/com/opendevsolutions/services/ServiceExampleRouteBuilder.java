package ar.com.opendevsolutions.services;

import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import ar.com.opendevsolutions.MainRouteBuilder;

@Component
@EnableConfigurationProperties
public class ServiceExampleRouteBuilder extends MainRouteBuilder {

  @Override
  public void addRoutes() throws Exception {

	  from("direct:findAllEntityExample")
	  	.log("RestExample-FindAll: ${header.out}")
	  	/*
	  	 * if you like use a process in the midde of the router, you need to do this
	  	 * .process("simpleProcessor")
	  	 * simpleProcessor is the process defined in camel context
	  	 */
	  	.setBody().simple("${header.out}")
	  	.marshal().json(JsonLibrary.Jackson);
	  
	  from("direct:findEntityExampleById")
	  	.log("RestExample-FindById: ${body}")
	  	.marshal().json(JsonLibrary.Jackson);
  }

}
