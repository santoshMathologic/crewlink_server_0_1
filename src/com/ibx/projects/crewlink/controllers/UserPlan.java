package com.ibx.projects.crewlink.controllers;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/userPlan")

public class UserPlan {

	public UserPlan() {
		// TODO Auto-generated constructor stub
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
    
	public Response savePlan(UserPlan userPlan)throws Exception {
		
	System.out.println(""+userPlan);

	
	return Response.ok("dasda").build();
	}

}
