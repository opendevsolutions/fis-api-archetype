package ar.com.opendevsolutions.rest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.camel.CamelContext;
import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.apache.camel.test.spring.CamelSpringBootRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.databind.ObjectMapper;

import ar.com.opendevsolutions.Application;

@RunWith(CamelSpringBootRunner.class)     
@SpringBootTest(classes = Application.class)
public class RestExampleServiceTest extends CamelTestSupport {
 
	@Autowired
	private CamelContext context;     
	@Autowired     
	private ProducerTemplate template;
	
	@Test
	public void findAllEntityExampleTest() throws Exception {   
		
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> map = new HashMap<>();
		Set<Map<String, Object>> expectedResponse = new HashSet<Map<String, Object>>();
		map.put("id", 1);
		expectedResponse.add(map);
		
		Object out = template.sendBody("direct:findAllEntityExample", ExchangePattern.InOut, "");
		
		Set<?> jsonResponse = objectMapper.readValue(
				(context.getTypeConverter().convertTo(String.class, out))
				, Set.class);
		
		assertCollectionSize(jsonResponse, 1);
		assertEquals(expectedResponse, jsonResponse);
	}
	
	@Test
	public void findEntityExampleByIdTest() throws Exception {   
		
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> headers = new HashMap<>();
		Map<String, Object> espectedMap = new HashMap<>();
		espectedMap.put("id", 1);
		
		headers.put("id", 1);
		Object out = template.sendBodyAndHeaders("direct:findEntityExampleById", ExchangePattern.InOut, "", headers);
		Map<?, ?> responseMap = objectMapper.readValue(
				(context.getTypeConverter().convertTo(String.class, out)
						), Map.class);
		
		assertEquals(responseMap, espectedMap);
	}
}
