package com.comresource.lunchapp.resources;

import com.comresource.lunchapp.models.Restaurants;
import com.comresource.lunchapp.PersistenceManager;
import com.comresource.lunchapp.models.SuggestHistory;
import static com.comresource.lunchapp.resources.InsertRestaurants.log;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import org.hibernate.Criteria;
import org.hibernate.Session;

// DOcs on Path annotation
// http://docs.oracle.com/cd/E19776-01/820-4867/6nga7f5nc/index.html
@Path("/pickRestaurants")
public class PickRestaurants {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() throws Exception {
        EntityManager entityManager = PersistenceManager.getEntityManager();
        ResponseBuilder builder;
        //Get Session to act as a factory for the Criteria Instance
        Session sess = entityManager.unwrap(Session.class);
        Criteria crit = sess.createCriteria(Restaurants.class);
        //Query for Results
        List results = new ArrayList();
        results = crit.list();

        Collections.shuffle(results);
        
        int maxValue = 3;
        int counter = 0;

        Iterator iterator = results.iterator();
        while (iterator.hasNext() && counter < 3) {
            Restaurants currentRestaurant = (Restaurants) iterator.next();
            if (counter <= maxValue) {
                String restaurantId = currentRestaurant.getRestaurantId();
                String name = currentRestaurant.getName();
                insertSuggestion(restaurantId, entityManager);
            }
            counter += 1;
        }

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

    public void insertSuggestion(String restaurantId, EntityManager entityManager) throws Exception {
        SuggestHistory currentSuggestion = new SuggestHistory();
        String suggestHistoryId = UUID.randomUUID().toString();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = new Date();

        currentSuggestion.setSuggestId(suggestHistoryId);
        currentSuggestion.setRestaurantId(restaurantId);
        currentSuggestion.setSuggestDate(currentDate);

        //Catch any insert errors and roll back the transaction
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(currentSuggestion);
            transaction.commit();
            entityManager.detach(currentSuggestion);
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
                System.out.println(e.getMessage());
                log.error(e.getMessage());
            }
        }
    }
}
