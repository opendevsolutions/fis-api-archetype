package ar.com.opendevsolutions.services;

import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

@Component
public class RestExampleRouteBuilder extends ExampleRouteBuilder {

  @Override
  public void addRoutes() throws Exception {

	  from("direct:findAllEntityExample")
	  	.to("mybatisMySQL:findAllEntityExample?statementType=SelectList&outputHeader=out")
	  	.log("RestExample-FindAll: ${header.out}")
	  	/*
	  	 * if you like use a process in the midde of the router, you need to do this
	  	 * .process("simpleProcessor")
	  	 * simpleProcessor is the process defined in camel context
	  	 */
	  	.setBody().simple("${header.out}")
	  	.marshal().json(JsonLibrary.Jackson);
	  
	  from("direct:findEntityExampleById")
	  	.to("mybatisMySQL:findEntityExampleById?statementType=SelectOne&inputHeader=id")
	  	.log("RestExample-FindById: ${body}")
	  	.marshal().json(JsonLibrary.Jackson);
  }

}
