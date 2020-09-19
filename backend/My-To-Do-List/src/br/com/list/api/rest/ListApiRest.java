package br.com.list.api.rest;

import java.net.URI;

import javax.ws.rs.Consumes;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.thoughtworks.xstream.XStream;

import br.com.list.dao.ListDAO;
import br.com.list.modelo.ListTask;
import br.com.list.modelo.Task;



@Path("listTasks")
public class ListApiRest {

	@Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String busca(@PathParam("id") long id) {
		ListTask listTask = new ListDAO().busca(id);
		return listTask.toXML();
	}
	
	@POST
    @Consumes(MediaType.APPLICATION_XML)
    public Response adiciona(String conteudo) {
		ListTask listTask = (ListTask) new XStream().fromXML(conteudo);
        new ListDAO().adiciona(listTask);
        URI uri = URI.create("/listTasks/" + listTask.getId());
        return Response.created(uri).build();
    }
	
	@Path("{id}/listTasks/{TaskId}")
	@DELETE
	public Response removeTask(@PathParam("id") long id, @PathParam("TaskId") long TaskId) {
		ListTask listTask = new ListDAO().busca(id);
		listTask.remove(TaskId);
		return Response.ok().build();
	}
	
	@Path("{id}/listTasks/{TaskId}")
	@PUT
	public Response alteraTask(String conteudo, @PathParam("id") long id, @PathParam("TaskId") long TaskId) {
		ListTask listTask = new ListDAO().busca(id);
		Task task = (Task) new XStream().fromXML(conteudo);
		listTask.troca(task);
		return Response.ok().build();
}
	
}