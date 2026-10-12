package webservices;

import metiers.ModuleBusiness;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.*;

@Path("/mb")
public class ModuleBesRestAPI {
    private ModuleBusiness mdb= new ModuleBusiness();

    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListMB() {
        return Response.status(200).entity(mdb.getAllModules()).build();
    }

}
