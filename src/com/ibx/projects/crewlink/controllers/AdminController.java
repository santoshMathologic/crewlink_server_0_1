package com.ibx.projects.crewlink.controllers;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import com.ibx.projects.crewlink.models.ClassSubjectsTable;
import com.ibx.projects.crewlink.models.User;
import com.ibx.projects.crewlink.models.UserPlan;
import com.ibx.projects.crewlink.service.IService;
import com.ibx.projects.crewlink.serviceImpl.ServiceImpl;

@Path("/admin")


public class AdminController {
	private IService service = new ServiceImpl();
	public AdminController() {
		// TODO Auto-generated constructor stub
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response adminResponse() {

		List<ClassSubjectsTable> classSubjectsList = (List<ClassSubjectsTable>) service
				.loadList(" from ClassSubjectsTable");
		System.out.print("dasdasda" + classSubjectsList);
		

		GenericEntity<List<ClassSubjectsTable>> list = new GenericEntity<List<ClassSubjectsTable>>(classSubjectsList) {
		};
		return Response.ok(list).build();

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/users")
	public Response user() {

		List<User> usersList = (List<User>) service.loadList(" from User");

		GenericEntity<List<User>> list = new GenericEntity<List<User>>(usersList) {
		};
		return Response.ok(list).build();

	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/plans")
	public Response plans() {

		List<UserPlan> UserPlanList = (List<UserPlan>) service.loadList(" from UserPlan");

		GenericEntity<List<UserPlan>> list = new GenericEntity<List<UserPlan>>(UserPlanList) {
		};
		return Response.ok(list).build();

	}

}
