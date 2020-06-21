package route;

//import com.google.gson.Gson;
import com.google.gson.Gson;
import dao.Connect;
import dao.UsuarioDAO;
import model.Usuario;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("users")
public class UsuarioRoute {
    @Path("/login")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String login(@QueryParam("email") String email, @QueryParam("senha") String pwd) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {

        Connect con = new Connect();
        UsuarioDAO usuarioDAO = new UsuarioDAO(con.createConnection());

        Usuario usuario = usuarioDAO.login(email, pwd);

        if (usuario != null) {
            Gson gson = new Gson();
            return gson.toJson(usuario);
//            return "OK - " + usuario.getNome();
        } else
            return "{\"success\":false}";
    }

    @Path("/inUser")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String novoUsuario(@QueryParam("jUsuario") String jUser) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {

        Connect con = new Connect();
        UsuarioDAO usuarioDAO = new UsuarioDAO(con.createConnection());

        Gson gson = new Gson();
        Usuario u = gson.fromJson(jUser, Usuario.class);
        if (usuarioDAO.inserirUsuario(u)) {
            return "{\"success\":true}";
        } else {
            return "{\"success\":false}";
        }
    }

    @Path("/upUser")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String atualizarUsuario(@QueryParam("jUsuario") String jUser) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {

        Connect con = new Connect();
        UsuarioDAO usuarioDAO = new UsuarioDAO(con.createConnection());

        Gson gson = new Gson();
        Usuario u = gson.fromJson(jUser, Usuario.class);
        if (usuarioDAO.atualizarUsuario(u)) {
            return "{\"success\":true}";
        } else {
            return "{\"success\":false}";
        }
    }

    @Path("/cuidadores")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String buscarCuidadores() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {

        Connect con = new Connect();
        UsuarioDAO usuarioDAO = new UsuarioDAO(con.createConnection());

        List<Usuario> usuarios = usuarioDAO.buscarCuidadores();

        if (usuarios != null) {
            Gson gson = new Gson();
            return gson.toJson(usuarios);
        } else
            return "{\"success\":false}";
    }

    @Path("/passeadores")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String buscarPasseadores() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {

        Connect con = new Connect();
        UsuarioDAO usuarioDAO = new UsuarioDAO(con.createConnection());

        List<Usuario> usuarios = usuarioDAO.buscarPasseadores();

        if (usuarios != null) {
            Gson gson = new Gson();
            return gson.toJson(usuarios);
        } else
            return "{\"success\":false}";
    }
}
