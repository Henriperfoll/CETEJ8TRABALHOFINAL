/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package henriperfoll.cetej8trabalhofinal.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Henrique
 */
@XmlRootElement(name="Cliente")
public class Cliente implements java.io.Serializable{
    
    private long id;
    private String nome;
    private Cidade cidade;

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

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
    
    
}
