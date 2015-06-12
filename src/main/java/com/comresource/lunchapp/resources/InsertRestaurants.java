/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comresource.lunchapp.resources;

import com.comresource.lunchapp.PersistenceManager;
import com.comresource.lunchapp.models.Is_Open;
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
    //POST METHOD
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
        
        //Catch any insert errors and roll back the transaction
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            //Insert the Restaurant Instance 
            //http://docs.oracle.com/javaee/6/api/javax/persistence/EntityManager.html#persist(java.lang.Object)
            entityManager.persist(restaurants);
            //http://docs.oracle.com/javaee/6/api/javax/persistence/EntityTransaction.html#commit()
            transaction.commit();
            //Remove the given entity from the persistence context
            //http://docs.oracle.com/javaee/6/api/javax/persistence/EntityManager.html#detach(java.lang.Object)
            entityManager.detach(restaurants);
            builder = Response.ok(restaurants);
            if (builder == null) {
                throw new Exception("builder == null");
            }
            
            EntityTransaction transactionIsOpen = entityManager.getTransaction();
            transactionIsOpen.begin();
            //Create new instance of IS_OPEN 
            Is_Open isOpen = new Is_Open();
            //Generate GUID
            final String openId = UUID.randomUUID().toString();
            //Add Values to Is_Open
            isOpen.setOpenId(openId);
            isOpen.setRestaurantId(id);
            isOpen.setMonday(1);
            isOpen.setTuesday(1);
            isOpen.setWednesday(1);
            isOpen.setThursday(1);
            isOpen.setFriday(1);
            isOpen.setSaturday(1);
            isOpen.setSunday(1);
            entityManager.persist(isOpen);
            
            transactionIsOpen.commit();
            
            entityManager.detach(isOpen);
            
            
            
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
