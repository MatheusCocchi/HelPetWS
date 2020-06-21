package route;

//import com.google.gson.Gson;
import com.google.gson.Gson;
import dao.AnimalDAO;
import dao.Connect;
import model.Animal;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("animal")
public class AnimalRoute {
    @Path("/inAnimal")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String novoAnimal(@QueryParam("jAnimal") String jAnimal) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {

        Connect con = new Connect();
        AnimalDAO animalDAO = new AnimalDAO(con.createConnection());

        Gson gson = new Gson();
        Animal a = gson.fromJson(jAnimal, Animal.class);
        if (animalDAO.inserirAnimal(a)) {
            return "{\"success\":true}";
        } else {
            return "{\"success\":false}";
        }
    }

    @Path("/upAnimal")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String atualizarAnimal(@QueryParam("jAnimal") String jAnimal) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {

        Connect con = new Connect();
        AnimalDAO animalDAO = new AnimalDAO(con.createConnection());

        Gson gson = new Gson();
        Animal a = gson.fromJson(jAnimal, Animal.class);
        if (animalDAO.atualizarAnimal(a)) {
            return "{\"success\":true}";
        } else {
            return "{\"success\":false}";
        }
    }

    @Path("/perdidos")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String buscarAnimaisPerdidos() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {

        Connect con = new Connect();
        AnimalDAO animalDAO = new AnimalDAO(con.createConnection());

        List<Animal> animais = animalDAO.buscarPerdidos();

        if (animais != null) {
            Gson gson = new Gson();
            return gson.toJson(animais);
        } else
            return "{\"success\":false}";
    }

    @Path("/adocao")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String buscarAnimaisAdocao() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {

        Connect con = new Connect();
        AnimalDAO animalDAO = new AnimalDAO(con.createConnection());

        List<Animal> animais = animalDAO.buscarAdocao();

        if (animais != null) {
            Gson gson = new Gson();
            return gson.toJson(animais);
        } else
            return "{\"success\":false}";
    }
}
