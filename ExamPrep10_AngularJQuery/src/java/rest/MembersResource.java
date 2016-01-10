/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.DataFactory;

/**
 * REST Web Service
 *
 * @author Bancho
 */
@Path("members")
public class MembersResource {

    @Context
    private UriInfo context;
    private DataFactory dataFactory;

    /**
     * Creates a new instance of MembersResource
     */
    public MembersResource() {
        dataFactory = new DataFactory();
    }

    
    @GET
    @Produces("application/json")
    public Response getMembers() {
        String members = dataFactory.getMembersAsJson();
        return Response.status(Response.Status.OK).entity(members).type(MediaType.APPLICATION_JSON).build();
    }

}
