
package com.mycompany.hmsrestweb;


import com.mycompany.dao.ProfileDao;
import com.mycompany.pojo.StaffPojo;
import java.net.URI;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 *
 * @author s
 */

  
@Path("/StaffProfile")
public class StaffProfileResource
{
    
    ProfileDao pd = new ProfileDao();
    
    @POST
    @Path("/getProfile")
    @Produces(MediaType.APPLICATION_JSON)
    public List<StaffPojo> getProfile()
    {
        return pd.getStaffProfile();
    }
   
}
