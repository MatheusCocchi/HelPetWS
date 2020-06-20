package dao;

import model.UsuarioTeste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioTesteDAO {

    Connection con;
    public UsuarioTesteDAO(Connection con){
        this.con = con;
    }

    public boolean insertUser(UsuarioTeste user) {
        try {
            PreparedStatement preparedStatement = con
                    .prepareStatement("insert into usuario(user, senha) values(?,?)");
            preparedStatement.setString(1, user.getUser());
            preparedStatement.setString(2, user.getSenha());
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Connect.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
            return false;
        }
    }

    public UsuarioTeste login(String login, String senha) {

        UsuarioTeste user = null;
        try {

            PreparedStatement preparedStatement = con
                    .prepareStatement("select * from usuario where user = ? and senha = ?");
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, senha);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                user = new UsuarioTeste();
                user.setIdusuario(rs.getInt(1));
                user.setUser(rs.getString(2));
                user.setSenha(rs.getString(3));
            }

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Connect.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        }
        return user;
    }
}
