package br.com.restful;

import br.com.cl.dao.CityDAO;
import br.com.restful.entities.Campos;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * Example resource class hosted at the URI path "/myresource"
 */
@Path("/")
public class MyResource {

    /**
     * Method processing HTTP GET requests, producing " text/plain" MIME media
     * type.
     *
     * @param city
     * @return String that will be send back as a response of type "text/plain".
     */
    @GET
    @Produces("text/plain")
    @Path("{city}")
    public String getFields(@PathParam("city") String city) {
        CityDAO dao = new CityDAO();
        List<Campos> fieldsByCity = dao.getFieldsByCity(city);

        StringBuilder fieldsTxt = new StringBuilder("Foram encontrandos os seguintes campos:\n");
        for (Campos field : fieldsByCity) {
            fieldsTxt.append(field.getName()).append("\n");
        }
        return fieldsTxt.toString();
    }
}
