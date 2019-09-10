/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package henriperfoll.cetej8trabalhofinal.jsf;

import henriperfoll.cetej8trabalhofinal.DAO.DAOCliente;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import henriperfoll.cetej8trabalhofinal.entity.Cliente;
import java.util.ArrayList;

/**
 *
 * @author Henrique
 */
@Named(value = "jsfCliente")
@RequestScoped
public class JsfCliente {
    
    private int id;
    private String nome;

    public JsfCliente() {
    }

    public ArrayList<Cliente> carregarTodos() {
        return new DAOCliente().carregarTodos();
    }

    public void adicionar() {
        Cliente c = new Cliente();
        c.setId(id);
        c.setNome(nome);
        new DAOCliente().adicionar(c);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
