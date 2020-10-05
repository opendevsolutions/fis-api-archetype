package ar.com.opendevsolutions.services;

import org.springframework.stereotype.Component;

@Component
public class RestExampleRouteBuilder extends ExampleRouteBuilder {

  @Override
  public void addRoutes() throws Exception {

	  from("direct:findAllEntityExample")
	  	.setBody().simple("[{}]")
	  	.log("RestExample-FindAll: ${body}");
	  
	  from("direct:findEntityExampleById")
	  	.setBody().simple("{}")
		.log("RestExample-FindById: ${body}");
  }

}
