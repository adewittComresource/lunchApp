package com.comresource.lunchapp.resources;

import com.comresource.lunchapp.PersistenceManager;
import com.comresource.lunchapp.models.VSuggestProfile;
import static java.lang.System.console;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

@Path("/restaurantgraphinfo")
public class RestaurantGraphInfo {

    @GET
    @Produces({"application/json"})
    @Consumes({"application/json"})
    public Response getAll(@Context HttpServletRequest httpRequest)
            throws Exception {
        HttpSession session = httpRequest.getSession(true);
        EntityManager entityManager = PersistenceManager.getEntityManager();
        Session sess = (Session) entityManager.unwrap(Session.class);
        //DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String testingUserName = (String)session.getAttribute("userName");
        Criteria crit;
        crit = sess.createCriteria(VSuggestProfile.class).add(Restrictions.conjunction()
                .add(
                    Restrictions.disjunction()
                        .add(Restrictions.eq("userName", testingUserName))
                        .add(Restrictions.isNull("userName"))
                )
                .add(Restrictions.eq("suggestDate", date))).addOrder(Order.desc("userName"));
        
        //Only get the first 3 rows
//        crit.setFirstResult(0).setMaxResults(3);
        
        Collection<?> results = crit.list();
        if (results != null) {
            entityManager.detach(results);
        }
        Response.ResponseBuilder builder = Response.ok(results);
        if (builder == null) {
            throw new Exception("builder == null");
        }
        CacheControl cacheControl = new CacheControl();
        cacheControl.setNoCache(true);
        return builder.cacheControl(cacheControl).build();
    }
}
