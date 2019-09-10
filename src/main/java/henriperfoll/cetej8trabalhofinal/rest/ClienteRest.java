/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package henriperfoll.cetej8trabalhofinal.rest;

import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import henriperfoll.cetej8trabalhofinal.entity.Cliente;
import henriperfoll.cetej8trabalhofinal.DAO.DAOCliente;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;

/**
 *
 * @author Henrique
 */
@Path("cliente")
public class ClienteRest {
    
    @Context
    private UriInfo context;
    
    public ClienteRest() {
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Cliente> get(){
        return new DAOCliente().carregarTodos();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Cliente get(@PathParam("id") long id){
        return new DAOCliente().carregaPorId(id);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}/{nome}")
    public void post(@PathParam("id") long id, @PathParam("nome") String nome){
        Cliente c = new Cliente();
        c.setId(id);
        c.setNome(nome);
        new DAOCliente().adicionar(c);
    }
    
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public void delete(@PathParam("id") long id){
        new DAOCliente().deleta(id);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}/{nome}")
    public void put(@PathParam("id") long id,@PathParam("nome") String nome){
        Cliente c = new DAOCliente().carregaPorId(id);
        c.setNome(nome);
        new DAOCliente().alterar(c);
    }
    
}
