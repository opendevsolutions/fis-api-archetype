package ar.com.opendevsolutions.routers;

import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

@Component
public class RestExampleRouteBuilder extends ExampleRouteBuilder {

  @Override
  public void addRoutes() throws Exception {
	  // proxy de Rest
	  from("cxfrs:bean:restExampleServices?bindingStyle=SimpleConsumer")
	  .recipientList(simple("direct:${header.operationName}"));
	  
	  // metodo uno del restExampleServices
	  from("direct:findAllEntityExample")
	  	.to("mybatisMySQL:findAllEntityExample?statementType=SelectList&outputHeader=out")
	  	.log("RestExample-FindAll: ${header.out}")
	  	.setBody().simple("${header.out}")
	  	.marshal().json(JsonLibrary.Jackson);
	  
	  from("direct:findEntityExampleById")
	  	.to("mybatisMySQL:findEntityExampleById?statementType=SelectOne&inputHeader=id")
	  	.log("RestExample-FindById: ${body}")
	  	.marshal().json(JsonLibrary.Jackson);
  }

}
