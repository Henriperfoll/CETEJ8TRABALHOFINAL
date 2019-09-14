/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package henriperfoll.cetej8trabalhofinal.DAO;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import henriperfoll.cetej8trabalhofinal.entity.Cidade;
import java.util.ArrayList;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Henrique
 */
public class DAOCidade {

    public ArrayList<Cidade> carregaCidades() {
        DefaultClientConfig defaultClientConfig = new DefaultClientConfig();
        defaultClientConfig.getClasses().add(JacksonJsonProvider.class);
        Client client = Client.create(defaultClientConfig);
        WebResource resource = client.resource("http://maventest.herokuapp.com/mavenTest-1.0-SNAPSHOT/webresources/cidade");
        resource.type(MediaType.APPLICATION_JSON);
        Cidade[] cidades = resource.get(Cidade[].class);
        ArrayList<Cidade> listaCidades = new ArrayList();
        for (Cidade c : cidades) {
            listaCidades.add(c);
        }
        return listaCidades;
    }

    public Cidade carregaCidade(long id) {
        DefaultClientConfig defaultClientConfig = new DefaultClientConfig();
        defaultClientConfig.getClasses().add(JacksonJsonProvider.class);
        Client client = Client.create(defaultClientConfig);
        WebResource resource = client.resource("http://maventest.herokuapp.com/mavenTest-1.0-SNAPSHOT/webresources/cidade/" + id);
        resource.type(MediaType.APPLICATION_JSON);
        return resource.get(Cidade.class);
    }
}
