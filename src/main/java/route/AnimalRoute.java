package route;

import com.google.gson.Gson;
import dao.AnimalDAO;
import dao.Connect;
import dao.UsuarioDAO;
import model.Animal;
import model.Usuario;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

@Path("animais")
public class AnimalRoute {
    @Path("/novo")
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

    @Path("/atualizar")
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
