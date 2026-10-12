
package webservices;

import entities.UniteEnseignement;
import metiers.UniteEnseignementBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/ue")
public class UniteEnsRestAPI {
    private UniteEnseignementBusiness helper = new UniteEnseignementBusiness();

    // get List UEs
    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListUE() {
        return Response.status(200).entity(helper.getListeUE()).build();
    }

    @Path("/new")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response newUE(UniteEnseignement ue) {
        if (helper.addUniteEnseignement(ue)){
            return Response.status(201).entity("ok").build();
        }
        return Response.status(400).entity("error").build();
    }
    @Path("/{code}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUEBbyCode(@PathParam("code") int code) {
        return Response.status(200).entity(helper.getUEByCode(code)).build();
    }
    @Path("/")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUEBySemestre(@QueryParam("semestre") int semestre) {
        return Response.status(200).entity(helper.getUEBySemestre(semestre)).build();
    }
    @Path("/{code}")
    @DELETE
    public Response deleteUEByCode(@PathParam("code") int code) {
        if(helper.deleteUniteEnseignement(code)){
            return Response.status(200).entity("deleted").build();
        }
        else
            return Response.status(400).entity("not found").build();
    }
}