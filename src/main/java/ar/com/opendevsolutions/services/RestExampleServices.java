package ar.com.opendevsolutions.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/rest-entity-example")
public class RestExampleServices {
    
	@Path("/find-all")
    @GET
    @Consumes({MediaType.APPLICATION_JSON})
    public Object findAllEntityExample() {
    	return null;
    }
	
	@Path("/find-by-id/{id}")
    @GET
    @Consumes({MediaType.APPLICATION_JSON})
    public Object findEntityExampleById(){
    	return null;
    }

}
