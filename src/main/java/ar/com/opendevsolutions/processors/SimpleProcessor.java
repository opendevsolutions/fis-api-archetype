package ar.com.opendevsolutions.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class SimpleProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		//Process example - init
		System.out.println("Router external - process");
		System.out.println("Body: " + exchange.getIn().getBody());
		System.out.println("Body: " + exchange.getIn().getHeader("someHeaderName"));
		System.out.println("Body: " + exchange.getProperty("somePropertyName"));
		//Process example - end
	}
}
