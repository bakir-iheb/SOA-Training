package webservices;

import entities.UniteEnseignement;
import metiers.UniteEnseignementBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
@Path("/ue")
public class UniteEnsRestApi {
    static UniteEnseignementBusiness helper = new UniteEnseignementBusiness();

    @Path("/list")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getlisteUe() {
        return Response.status(200).entity(helper.getListeUE()).build();
    }

    @Path("/add")
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.TEXT_PLAIN)
    public Response addUniteEnseignement(UniteEnseignement ue) {
        if (helper.addUniteEnseignement(ue)) {
            return Response.status(201).entity("success").build();
        } else {
            return Response.status(400).entity("erreur").build();
        }
    }


    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/{code}")

    public Response getUEBycode(@PathParam("code") int code) {
        return Response.status(200).entity(helper.getUEByCode(code)).build();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/")
    public Response getUEBysemestre(@QueryParam("semestre") int semestre) {
        return Response.status(200).entity(helper.getUEBySemestre(semestre)).build();
    }

    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("/{code}")

    public Response updateUEbyCode(@PathParam("code") int code, UniteEnseignement ue) {

        if (helper.updateUniteEnseignement(code, ue)) {
            return Response.status(200).entity("success").build();
        }
        else {
            return Response.status(404).entity("erreur").build();
        }
    }

    @DELETE
    @Path("/{code}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteUniteEnseignement(@PathParam("code") int code) {

        if (helper.deleteUniteEnseignement(code)) {
            return Response.status(200).entity("success").build();
        }
        else {
            return Response.status(404).entity("erreur").build();
        }
    }
}