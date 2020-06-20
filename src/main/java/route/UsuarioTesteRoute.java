package route;

import dao.Connect;
import dao.UsuarioTesteDAO;
import model.UsuarioTeste;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;

@Path("users")
public class UsuarioTesteRoute {

    @Path("/login")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String login(@QueryParam("login") String login, @QueryParam("password") String pwd) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {

        UsuarioTesteDAO uDao = new UsuarioTesteDAO(new Connect().createConnection());
        UsuarioTeste u = uDao.login(login, pwd);

        if (u != null)
            return u.toString();
        else
            return "{\"success\":false}";
    }

    @Path("/create")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String create(@QueryParam("login") String login, @QueryParam("password") String pwd) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {

        UsuarioTesteDAO uDao = new UsuarioTesteDAO(new Connect().createConnection());
        UsuarioTeste u = new UsuarioTeste();
        u.setUser(login);
        u.setSenha(pwd);
        if (uDao.insertUser(u)) {
            return "{\"success\":true}";
        } else {
            return "{\"success\":false}";
        }
    }

    @Path("/test")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String funcTest(@QueryParam("param1") String param) {
        return param;
    }
}
