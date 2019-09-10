/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package henriperfoll.cetej8trabalhofinal.DAO;

import henriperfoll.cetej8trabalhofinal.entity.Cliente;
import java.util.ArrayList;

/**
 *
 * @author Henrique
 */
public class DAOCliente {
    
    private static ArrayList<Cliente> listaClientes = new ArrayList<>();
    
    public ArrayList<Cliente> carregarTodos(){
        return this.listaClientes;
    }
    
    public void adicionar(Cliente cliente){
        this.listaClientes.add(cliente);
    }
    
    public void alterar(Cliente cliente){
        for(Cliente c : this.listaClientes){
            if(c.getId() == cliente.getId()){
                c.setNome(cliente.getNome());
            }
        }
    }
    
    public Cliente carregaPorId(long id){
        Cliente cliente = null;
        for (Cliente c : this.listaClientes){
            if(c.getId() == id){
                cliente = c;
            }
        }
        return cliente;
    }
    
    public void deleta(long id){
        Cliente c = this.carregaPorId(id);
        this.listaClientes.remove(c);
    }
}
