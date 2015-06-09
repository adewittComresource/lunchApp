/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comresource.lunchapp.resources;

import com.comresource.lunchapp.PersistenceManager;
import com.comresource.lunchapp.models.Restaurants;
import java.util.UUID;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

@Path("/insertRestaurants")
public class InsertRestaurants {
    //Insert into Database
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Restaurants restaurants) throws Exception {
        EntityManager entityManager = PersistenceManager.getEntityManager();
        ResponseBuilder builder = null;
        //Create the GUID for the new Restaurant
        //Generate GUID
        final String id = UUID.randomUUID().toString();
        restaurants.setRestaurantId(id);
        
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(restaurants);
            transaction.commit();
            entityManager.detach(restaurants);
            builder = Response.ok(restaurants);
            if (builder == null) {
                throw new Exception("builder == null");
            }
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
        }
        CacheControl cacheControl = new CacheControl();
        cacheControl.setNoCache(true);

        if (builder == null) {
            throw new Exception("builder == null");
        }
        return builder.cacheControl(cacheControl).build();
    }
}
