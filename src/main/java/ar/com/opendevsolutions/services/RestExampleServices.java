package ar.com.opendevsolutions.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/rest-example")
public class RestExampleServices {
    
	//@RequestMapping(value = "/find-all", method= RequestMethod.GET, produces = "application/json")
	@Path("/find-all")
    @GET
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Object findAll(String body) {
    	return null;
    }

}
