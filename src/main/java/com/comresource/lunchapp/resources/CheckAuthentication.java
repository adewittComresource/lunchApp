
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/checkAuthentication")
public class CheckAuthentication {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String String() {
        String think = "think";
//pubic Response callinganythingiwant() throws Exception{
        // EntityManager enitityManager= PersistenceManager.getEntityManager();

        return think;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String WHYWHY() {
        String nonono = "nononono";

        return nonono;
    }

}
