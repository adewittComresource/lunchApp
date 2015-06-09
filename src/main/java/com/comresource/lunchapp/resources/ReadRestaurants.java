package com.comresource.lunchapp.resources;

import com.comresource.lunchapp.models.Restaurants;
import com.comresource.lunchapp.PersistenceManager;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import org.hibernate.Criteria;
import org.hibernate.Session;
 
@Path("/restaurants")
public class ReadRestaurants {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() throws Exception {
        EntityManager entityManager = PersistenceManager.getEntityManager();
        ResponseBuilder builder;
        //Query the database with hibernate
        Session sess = entityManager.unwrap(Session.class);
        Criteria crit = sess.createCriteria(Restaurants.class);

        //Query for Results
        Collection<?> results = crit.list();
        //Send Results to user
        if (results != null) {
            entityManager.detach(results);
        }
        builder = Response.ok(results);
        if (builder == null) {
            throw new Exception("builder == null");
        }
        CacheControl cacheControl = new CacheControl();
        cacheControl.setNoCache(true);
        return builder.cacheControl(cacheControl).build();
    }    
}