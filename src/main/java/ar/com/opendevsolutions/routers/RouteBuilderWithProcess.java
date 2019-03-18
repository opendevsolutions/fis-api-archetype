package ar.com.opendevsolutions.routers;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class RouteBuilderWithProcess extends ExampleRouteBuilder {

  Processor myProcess = new Processor() {
	  public void process(Exchange exchange) {
		//Process example - init
		System.out.println("Router - process");
		System.out.println("Body: " + exchange.getIn().getBody());
		System.out.println("Body: " + exchange.getIn().getHeader("someHeaderName"));
		System.out.println("Body: " + exchange.getProperty("somePropertyName"));
		//Process example - end	
	  }
  };

  @Override
  protected void addRoutes() throws Exception {

	from("timer:foo?period=2000").process(myProcess);
    //OR
    from("timer:foo?period=2000").process(new Processor(){
    	public void process(Exchange exchange) {
    		//Process example - init
    		System.out.println("Router internal - process");
    		System.out.println("Body: " + exchange.getIn().getBody());
			System.out.println("Body: " + exchange.getIn().getHeader("someHeaderName"));
			System.out.println("Body: " + exchange.getProperty("somePropertyName"));
			//Process example - end	
    	}
    });
  }

}
