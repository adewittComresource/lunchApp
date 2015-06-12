package com.comresource.lunchapp.resources;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

@Path("/checkAuthentication")
public class CheckAuthentication {
    String BASE_WEBSERVER = "http://localhost";
    String BASE_PORT = "8084";
    private static Client client;
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String go(String credentials, @Context HttpServletRequest httpRequest, @Context HttpServletResponse httpResponse) throws Exception {
        
        
        //Create Jersey Client
        client = Client.create();
        //Check if already logged in
        //Create a Session
        HttpSession session = httpRequest.getSession(true);
        String authenticated = (String) session.getAttribute("authenticated");
        
        String authResult = "passed";
        if (authenticated == null || authenticated.equals("false")) { //Not Authenticated
            //Get Username and password 
            //parse JSON object
             
            JSONObject openJSON = (JSONObject) JSONSerializer.toJSON(credentials);
            String loginUserName = (String) openJSON.get("userName");
            String clientPassword = openJSON.getString("password");         
                   
            if (loginUserName != null) {
                //Get properties for server port and authType
                 authResult = Authentication(loginUserName, clientPassword, session, httpResponse);

            } else {
                //redirect to index page
                RequestDispatcher page = httpRequest.getRequestDispatcher("/loginPage.jsp");
                page.forward(httpRequest, httpResponse);
            }
        } 
        return authResult;
    }

    public  String Authentication(String loginUserName, String clientPassword, HttpSession session, HttpServletResponse httpResponse) throws Exception {
        //Get HTTP session
        String usersURI = BASE_WEBSERVER + ":" + BASE_PORT + "/lunchApp/services/users";
        WebResource usersResource = client.resource(usersURI);
        //EntityId parameter
        MultivaluedMap queryParams = new MultivaluedMapImpl();
        queryParams.add("sortBy", "+userName");

        // Get Data Flow Params
        ClientResponse usersResponse = usersResource.queryParams(queryParams).accept("application/json").get(ClientResponse.class);
        //Turn Response to JSON object
        JSONArray usersJSON = (JSONArray) JSONSerializer.toJSON(usersResponse.getEntity(String.class));

        int usersJSONSize = usersJSON.size();
        
        for(int i = 0; i < usersJSONSize; i++){
            JSONObject userObject = usersJSON.getJSONObject(i);
            String serverUsername = userObject.getString("userName");
            String serverPassword = userObject.getString("password");
            
            if(serverUsername.equals(loginUserName) && serverPassword.equals(clientPassword)){
                session.setAttribute("authenticated", "true");
                return "passed";
            }
            
        }
        
        return "failed";
       
    }



    public static String checkAuthenticatedSession(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws ServletException, IOException {
        //get the session variable
        HttpSession session = httpRequest.getSession(true);
        String authenticated = (String) session.getAttribute("authenticated");
        String authed = "false";
        if ("false".equals(authenticated) || authenticated == null) {
            //redirect to login page
            httpResponse.sendRedirect("/lunchApp/loginPage.jsp");
        } else {
            authed = "true";
        }
        return authed;
    }
}
