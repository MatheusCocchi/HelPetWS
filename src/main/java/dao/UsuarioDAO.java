package dao;

import model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO {
    Connection con;

    public UsuarioDAO(Connection con) {
        this.con = con;
    }

    public boolean inserirUsuario(Usuario user) {
        try {
            PreparedStatement preparedStatement = con
                    .prepareStatement("insert into usuario(nome, senha, email, endereco, numero, cep, bairro, cidade, telefone, sexo, idade, tipo, datacad, status) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1, user.getNome());
            preparedStatement.setString(2, user.getSenha());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getEndereco());
            preparedStatement.setInt(5, user.getNumero());
            preparedStatement.setString(6, user.getCep());
            preparedStatement.setString(7, user.getBairro());
            preparedStatement.setString(8, user.getCidade());
            preparedStatement.setString(9, user.getTelefone());
            preparedStatement.setString(10, user.getSexo());
            preparedStatement.setInt(11, user.getIdade());
            preparedStatement.setString(12, user.getTipo());
            preparedStatement.setString(13, user.getDatacad());
            preparedStatement.setInt(14, user.getStatus());
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Connect.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
            return false;
        }
    }

    public boolean atualizarUsuario(Usuario user) {
        try {
            PreparedStatement preparedStatement = con
                    .prepareStatement("update usuario " +
                            "set nome = ?, senha = ?, email = ?, endereco = ?, numero = ?, cep = ?, bairro = ?, cidade = ?, telefone = ?, sexo = ?, " +
                            "idade = ?, tipo = ?, datacad = ?, status = ?" +
                            " where codigo = ?");
            preparedStatement.setString(1, user.getNome());
            preparedStatement.setString(2, user.getSenha());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getEndereco());
            preparedStatement.setInt(5, user.getNumero());
            preparedStatement.setString(6, user.getCep());
            preparedStatement.setString(7, user.getBairro());
            preparedStatement.setString(8, user.getCidade());
            preparedStatement.setString(9, user.getTelefone());
            preparedStatement.setString(10, user.getSexo());
            preparedStatement.setInt(11, user.getIdade());
            preparedStatement.setString(12, user.getTipo());
            preparedStatement.setString(13, user.getDatacad());
            preparedStatement.setInt(14, user.getStatus());
            preparedStatement.setLong(15, user.getCodigo());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Connect.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
            return false;
        }
    }

    public Usuario login(String email, String senha) {
        Usuario user = null;
        try {

            PreparedStatement preparedStatement = con
                    .prepareStatement("select * from usuario where email = ? and senha = ? and status = 1");
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, senha);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                user = new Usuario();
                user.setCodigo(rs.getInt(1));
                user.setNome(rs.getString(2));
                user.setSenha(rs.getString(3));
                user.setEmail(rs.getString(4));
                user.setEndereco(rs.getString(5));
                user.setNumero(rs.getInt(6));
                user.setCep(rs.getString(7));
                user.setBairro(rs.getString(8));
                user.setCidade(rs.getString(9));
                user.setTelefone(rs.getString(10));
                user.setSexo(rs.getString(11));
                user.setIdade(rs.getInt(12));
                user.setTipo(rs.getString(13));
                user.setDatacad(rs.getString(14));
                user.setStatus(rs.getInt(15));
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Connect.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        }
        return user;
    }

    public List<Usuario> buscarPasseadores() {
        List<Usuario> users = new ArrayList<Usuario>();
        try {

            PreparedStatement preparedStatement = con
                    .prepareStatement("select * from usuario where tipo = 'Passeador' and status = 1");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Usuario user = new Usuario();
                user.setCodigo(rs.getInt(1));
                user.setNome(rs.getString(2));
                user.setSenha(rs.getString(3));
                user.setEmail(rs.getString(4));
                user.setEndereco(rs.getString(5));
                user.setNumero(rs.getInt(6));
                user.setCep(rs.getString(7));
                user.setBairro(rs.getString(8));
                user.setCidade(rs.getString(9));
                user.setTelefone(rs.getString(10));
                user.setSexo(rs.getString(11));
                user.setIdade(rs.getInt(12));
                user.setTipo(rs.getString(13));
                user.setDatacad(rs.getString(14));
                user.setStatus(rs.getInt(15));
                users.add(user);
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Connect.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        }
        return users;
    }

    public List<Usuario> buscarCuidadores() {
        List<Usuario> users = new ArrayList<Usuario>();
        try {

            PreparedStatement preparedStatement = con
                    .prepareStatement("select * from usuario where tipo = 'Cuidador' and status = 1");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Usuario user = new Usuario();
                user.setCodigo(rs.getInt(1));
                user.setNome(rs.getString(2));
                user.setSenha(rs.getString(3));
                user.setEmail(rs.getString(4));
                user.setEndereco(rs.getString(5));
                user.setNumero(rs.getInt(6));
                user.setCep(rs.getString(7));
                user.setBairro(rs.getString(8));
                user.setCidade(rs.getString(9));
                user.setTelefone(rs.getString(10));
                user.setSexo(rs.getString(11));
                user.setIdade(rs.getInt(12));
                user.setTipo(rs.getString(13));
                user.setDatacad(rs.getString(14));
                user.setStatus(rs.getInt(15));
                users.add(user);
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Connect.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        }
        return users;
    }
}
