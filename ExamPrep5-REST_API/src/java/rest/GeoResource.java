/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import entity.City;
import entity.Country;
import facade.WorldFacade;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Bancho
 */
@Path("world")
public class GeoResource {

    @Context
    private UriInfo context;
    private WorldFacade wf;
    private Gson gson;

    /**
     * Creates a new instance of GeoResource
     */
    public GeoResource() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WORLD_REST_APIPU");
        wf = new WorldFacade(emf);
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @GET
    @Produces("application/json")
    @Path("countries")
    public Response getCountries() {
        JsonArray countries = new JsonArray();
        for (Country c : wf.getCountries()) {
            try{
                JsonObject country = new JsonObject();

                country.addProperty("code", c.getCode());
                country.addProperty("name", c.getName());
                country.addProperty("continent", c.getContinent());
                country.addProperty("capital", c.getCapital());

                countries.add(country);
            }catch(NullPointerException ex){
                //fuck you then
            }
        }
        return Response.status(Response.Status.OK).entity(gson.toJson(countries)).type(MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Produces("application/json")
    @Path("countries/{minPop}")
    public Response getCountriesByMinPop(@PathParam("minPop") String minPop) {
        int minPopl = Integer.parseInt(minPop);
        JsonArray countries = new JsonArray();
        for (Country c : wf.getCountries(minPopl)) {
            try{
                JsonObject country = new JsonObject();

                country.addProperty("code", c.getCode());
                country.addProperty("name", c.getName());
                country.addProperty("continent", c.getContinent());
                country.addProperty("capital", c.getCapital());

                countries.add(country);
            }catch(NullPointerException ex){
                //fuck you then
            }
        }
        return Response.status(Response.Status.OK).entity(gson.toJson(countries)).type(MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Produces("application/json")
    @Path("countries/{code}/cities")
    public Response getCities(@PathParam("code") String code) {
        JsonArray cities = new JsonArray();
        for (City c : wf.getCities(code)) {
            try{
                JsonObject city = new JsonObject();

                city.addProperty("name", c.getName());
                city.addProperty("population", c.getPopulation());

                cities.add(city);
            }catch(NullPointerException ex){
                //fuck you then
            }
        }
        return Response.status(Response.Status.OK).entity(gson.toJson(cities)).type(MediaType.APPLICATION_JSON).build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @Path("city")
    public Response addCity(String json) {
        City city = gson.fromJson(json, City.class);
        city = wf.addCity(city);
        String newCityJson = gson.toJson(city);
        return Response.status(Response.Status.OK).entity(newCityJson).type(MediaType.APPLICATION_JSON).build();
    }
}
