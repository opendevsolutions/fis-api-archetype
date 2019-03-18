package ar.com.opendevsolutions.routers;

import org.springframework.stereotype.Component;

@Component
public class RestExampleRouteBuilder extends ExampleRouteBuilder {

  @Override
  public void addRoutes() throws Exception {
	  from("cxfrs:bean:restExampleServices?bindingStyle=SimpleConsumer")
	  	.recipientList("direct:${header.operationName}");
	  
	  from("direct:findAll")
	  	.to("mybatisMySQL:getAll?statementType=SelectList&outputHeader=out")
	  	.log("RestExample-FindAll: ${header.out}");
  }

}
