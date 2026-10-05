package webservices;

import metiers.UniteEnseignementBusiness;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/ue")

public class UniteEnsRestAPI {

    UniteEnseignementBusiness helper = new UniteEnseignementBusiness();

    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListUEs() {
        return Response.status(Response.Status.OK)
                .entity(helper.getListeUE())
                .build();
    }

}
