package com.sap.netweaver.cloud.samples.springrest.srv;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import org.springframework.stereotype.Service;

/**
 * The {@link UserService} provides all services related to users.
 * 
 * @author Matthias Steiner
 * @version 1.0.0
 */
@Service("userService")
@Path("/users")
@Produces({ "application/json" })
public class UserService
{
	@Path("/user")
	@Produces("text/plain")
	@GET
	/**
	 * Returns the name of the currently logged-on user.
	 * 
	 * @param request The {@link HttpServletRequest} that is processed
	 * @return the name of the currently logged-on user
	 */
	public String getUserName(@Context HttpServletRequest request)
	{
		String retVal = null;
		
		retVal = (request.getUserPrincipal() != null) ? request.getUserPrincipal().getName() : "Guest";
		
		return retVal;
	}
}
