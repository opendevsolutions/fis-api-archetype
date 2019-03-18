package ar.com.opendevsolutions.routers;

import org.springframework.stereotype.Component;

import ar.com.opendevsolutions.utils.MyTransformer;

@Component
public class SimpleRouteBuilder extends ExampleRouteBuilder {

  @Override
  public void addRoutes() throws Exception {
	  /* Example with timer  
    from("timer:foo?period=2000").transform().method(MyTransformer.class).log("JAVA >>> ${body}");*/
  }

}
