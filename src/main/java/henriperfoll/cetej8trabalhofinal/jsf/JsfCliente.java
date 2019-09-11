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
    
    public final static int ADICIONAR = 1;
    public final static int ALTERAR = 2;
    
    private long id;
    private String nome;
    private long codigoCidade;
    private int modo = ADICIONAR;
    private long idAlteracao;

    public JsfCliente() {
        if(modo == ADICIONAR)
            nextId();
    }
    
    private void nextId(){
        ArrayList<Cliente> lista = new DAOCliente().carregarTodos();
        if(lista.size() > 0){
            for(Cliente c : lista){
                id = c.getId()+1;
            }
        }else{
            id = 1;
        }
    }

    public ArrayList<Cliente> carregarTodos() {
        return new DAOCliente().carregarTodos();
    }
    
    public ArrayList<Cidade> carregarCidades(){
//        new DAOCidade().carregaCidades();
        return new DAOCidade().carregaCidades();
    }

    public void adicionar() {
        Cliente c = new Cliente();
        c.setId(id);
        c.setNome(nome);
        c.setCidade(new DAOCidade().carregaCidade(this.codigoCidade));
        new DAOCliente().adicionar(c);
        this.limparCampos();
    }
    
    public void limparCampos(){
        this.nextId();
        this.codigoCidade = new DAOCidade().carregaCidades().get(0).getCodigo();
        this.nome = "";
    }
    
    public void deletar(long id){
        new DAOCliente().deleta(id);
    }
    
    public void modoAlterar(long id){
        this.modo = ALTERAR;
        Cliente cliente = new DAOCliente().carregaPorId(id);
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.codigoCidade = cliente.getCidade().getCodigo();
        this.idAlteracao = this.id;
    }
    
    public void alterar(long id){
        this.modo = ADICIONAR;
        Cliente c = new Cliente();
        c.setCidade(new DAOCidade().carregaCidade(this.codigoCidade));
        c.setId(id);
        c.setNome(nome);
        new DAOCliente().alterar(c);        
        this.limparCampos();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public int getModo() {
        return modo;
    }

    public void setModo(int modo) {
        this.modo = modo;
    }

    public long getIdAlteracao() {
        return idAlteracao;
    }

    public void setIdAlteracao(long idAlteracao) {
        this.idAlteracao = idAlteracao;
    }
    
    
    
}
