/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package henriperfoll.cetej8trabalhofinal.jsf;

import henriperfoll.cetej8trabalhofinal.DAO.*;
import henriperfoll.cetej8trabalhofinal.entity.Cidade;
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
    private long codigoCidade;

    public JsfCliente() {
    }

    public ArrayList<Cliente> carregarTodos() {
        return new DAOCliente().carregarTodos();
    }
    
    public ArrayList<Cidade> carregarCidades(){
        new DAOCidade().carregaCidades();
        return new DAOCidade().getListaCidades();
    }

    public void adicionar() {
        Cliente c = new Cliente();
        c.setId(id);
        c.setNome(nome);
        c.setCidade(new DAOCidade().carregaCidade(this.codigoCidade));
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

    public long getCodigoCidade() {
        return codigoCidade;
    }

    public void setCodigoCidade(long codigoCidade) {
        this.codigoCidade = codigoCidade;
    }
    
    
}
