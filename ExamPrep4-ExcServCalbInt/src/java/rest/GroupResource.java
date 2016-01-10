/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import conn.SiteChecker;
import entity.Group;
import java.util.concurrent.ExecutionException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 * REST Web Service
 *
 * @author Bancho
 */
@Path("groups")
public class GroupResource {

    @Context
    private UriInfo context;
    private SiteChecker sc;
    private Gson gson;

    /**
     * Creates a new instance of GroupResource
     */
    public GroupResource() {
        sc = new SiteChecker();
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    /**
     * Retrieves representation of an instance of rest.GroupResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public Response getGroups() throws InterruptedException, ExecutionException {
        JsonArray groupsJson = new JsonArray();
        for (Group group : sc.getAllGroupsInfo()) {
            groupsJson.add(new JsonParser().parse(gson.toJson(group)));
        }
        return Response.status(Status.OK).type(MediaType.APPLICATION_JSON).entity(groupsJson.toString()).build();
    }

}
