package com.comresource.lunchapp.resources;

import com.comresource.lunchapp.models.Restaurants;
import com.comresource.lunchapp.PersistenceManager;
import com.comresource.lunchapp.models.Is_Open;
import com.comresource.lunchapp.models.SuggestHistory;
import static com.comresource.lunchapp.resources.InsertRestaurants.log;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
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
        Collection<?> results = crit.list();

        int currentSize = results.size();
        int randomNumber = (int)(Math.random() * currentSize + 1);
        int counter = 1;

        Iterator iterator = results.iterator();
        while(iterator.hasNext()){
            Restaurants currentRestaurant = (Restaurants)iterator.next();
            
            if(counter == randomNumber){
                String restaurantId = currentRestaurant.getRestaurantId();
                String name = currentRestaurant.getName();
                insertSuggestion(restaurantId,entityManager);
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
    
    public void insertSuggestion(String restaurantId,EntityManager entityManager) throws Exception {
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
