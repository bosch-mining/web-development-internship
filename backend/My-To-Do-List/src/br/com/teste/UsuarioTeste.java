package br.com.teste;

import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.xstream.XStream;

import br.com.list.dao.ListDAO;
import br.com.list.modelo.ListTask;
import br.com.list.modelo.Task;
import junit.framework.Assert;

public class UsuarioTeste {
	
	
	private HttpServer server;
	private WebTarget target;
	private Client client;
	
	
    @Before	
    public void startaSeridor()	{
	server = Servidor.inicializaServidor();
	ClientConfig config = new ClientConfig();
	config.isRegistered(new LoggingFilter());
	this.client = ClientBuilder.newClient();
    target = client.target("http://localhost:8080");
	
	
   }

   @After
   public void mataServidor() {
   server.stop();
   }

	
	@Test
	public void testeBuscarUmListTaskEsperado() {
		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080");
		String conteudo = target.path("/listTasks/1").request().get(String.class);
		ListTask listTask = (ListTask) new XStream().fromXML(conteudo);
		Assert.assertEquals(1, listTask.getId());
		
		 
	}
	
	
	@Test
	public void testaQueBuscarUmListTaskTrasUmListTask() {
		String conteudo = target.path("/listTasks/1").request().get(String.class);
		ListTask fromXML = (ListTask) new XStream().fromXML(conteudo);
		Assert.assertEquals(1, fromXML.getId());
	}
	
	@Test
	public void testaQueSuportaListTask() {
		
		ListTask listTask= new ListTask();
		listTask.adiciona(new Task(2 ,"teste","teste"));
		listTask.setId(1);
		String xml = listTask.toXML();
		Entity<String> entity = Entity.entity(xml,MediaType.APPLICATION_XML);
		Response response = target.path("/tasks").request().post(entity);
		Assert.assertEquals(201,response.getStatus());
		
		
		
	}
		
	
	
}