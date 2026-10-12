package webservices;

import entities.Module;
import entities.UniteEnseignement;
import metiers.ModuleBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.*;

@Path("/mb")
public class ModuleBesRestAPI {
    static ModuleBusiness mdb= new ModuleBusiness();

    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListMB() {
        return Response.status(200).entity(mdb.getAllModules()).build();
    }
    @Path("new")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response newMB(Module md) {
        if (mdb.addModule(md)){
            return Response.status(201).entity("ok").build();
        }
        return Response.status(400).entity("error").build();
    }

    @Path("/{mat}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMBByMat(@PathParam("mat") String mat) {
        return Response.status(200).entity(mdb.getModuleByMatricule(mat)).build();
    }
    @Path("/{mat}")
    @DELETE
    public Response deleteMB(@PathParam("mat") String mat) {
        if(mdb.deleteModule(mat)){
            return Response.status(200).entity("deleted").build();
        }
        else
            return Response.status(400).entity("not found").build();
    }
}
