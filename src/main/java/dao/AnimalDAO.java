package dao;


import model.Animal;
import model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AnimalDAO {
    Connection con;

    public AnimalDAO(Connection con) {
        this.con = con;
    }

    public boolean inserirAnimal(Animal animal) {
        try {
            PreparedStatement preparedStatement = con
                    .prepareStatement("insert into animal(nome, especie, porte, raca, sexo, qualidade1, qualidade2, qualidade3, observacao, idade," +
                            " foto1, foto2, foto3, latitude, longitude, status, datacad, tipo, codusuario) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1, animal.getNome());
            preparedStatement.setString(2, animal.getEspecie());
            preparedStatement.setString(3, animal.getPorte());
            preparedStatement.setString(4, animal.getRaca());
            preparedStatement.setString(5, animal.getSexo());
            preparedStatement.setString(6, animal.getQualidade1());
            preparedStatement.setString(7, animal.getQualidade2());
            preparedStatement.setString(8, animal.getQualidade3());
            preparedStatement.setString(9, animal.getObservacao());
            preparedStatement.setInt(10, animal.getIdade());
            preparedStatement.setBytes(11, animal.getFoto1());
            preparedStatement.setBytes(12, animal.getFoto2());
            preparedStatement.setBytes(13, animal.getFoto3());
            preparedStatement.setString(14, animal.getLatitude());
            preparedStatement.setString(15, animal.getLongitude());
            preparedStatement.setInt(16, animal.getStatus());
            preparedStatement.setString(17, animal.getDatacad());
            preparedStatement.setString(18, animal.getTipo());
            preparedStatement.setLong(19, animal.getCodusuario().getCodigo());
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Connect.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
            return false;
        }
    }

    public boolean atualizarAnimal(Animal animal) {
        try {
            PreparedStatement preparedStatement = con
                    .prepareStatement("update usuario " +
                            "set nome = ?, especie = ?, porte = ?, raca = ?, sexo = ?, qualidade1 = ?, qualidade2 = ?, qualidade3 = ?, observacao = ?," +
                            " idade = ?, foto1 = ?, foto2 = ?, foto3 = ?, latitude = ?, longitude = ?, status = ?, datacad = ?, tipo = ?, codusuario = ?" +
                            " where codigo = ?");
            preparedStatement.setString(1, animal.getNome());
            preparedStatement.setString(2, animal.getEspecie());
            preparedStatement.setString(3, animal.getPorte());
            preparedStatement.setString(4, animal.getRaca());
            preparedStatement.setString(5, animal.getSexo());
            preparedStatement.setString(6, animal.getQualidade1());
            preparedStatement.setString(7, animal.getQualidade2());
            preparedStatement.setString(8, animal.getQualidade3());
            preparedStatement.setString(9, animal.getObservacao());
            preparedStatement.setInt(10, animal.getIdade());
            preparedStatement.setBytes(11, animal.getFoto1());
            preparedStatement.setBytes(12, animal.getFoto2());
            preparedStatement.setBytes(13, animal.getFoto3());
            preparedStatement.setString(14, animal.getLatitude());
            preparedStatement.setString(15, animal.getLongitude());
            preparedStatement.setInt(16, animal.getStatus());
            preparedStatement.setString(17, animal.getDatacad());
            preparedStatement.setString(18, animal.getTipo());
            preparedStatement.setLong(19, animal.getCodusuario().getCodigo());
            preparedStatement.setLong(20, animal.getCodigo());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Connect.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
            return false;
        }
    }

    public List<Animal> buscarPerdidos() {
        List<Animal> animais = new ArrayList<Animal>();
        try {
            PreparedStatement preparedStatement = con
                    .prepareStatement("SELECT a.codigo, a.nome, a.especie, a.porte, a.raca, a.sexo, a.qualidade1, a.qualidade2, a.qualidade3, a.observacao, a.idade, a.foto1, a.foto2, a.foto3, " +
                            "a.latitude, a.longitude, a.status, a.datacad, a.tipo, u.codigo, u.nome, u.senha, u.email, u.endereco, u.numero, u.cep, u.bairro, u.cidade, u.telefone, " +
                            "u.sexo, u.idade, u.tipo, u.datacad, u.status " +
                            "FROM animal as a " +
                            "INNER JOIN usuario as u ON a.codusuario = u.codigo " +
                            "WHERE a.tipo = 'Perdido' AND a.status = 1 AND u.status = 1");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                Animal animal = new Animal();
                animal.setCodigo(rs.getLong("a.codigo"));
                animal.setNome(rs.getString("a.nome"));
                animal.setEspecie(rs.getString("a.especie"));
                animal.setPorte(rs.getString("a.porte"));
                animal.setRaca(rs.getString("a.raca"));
                animal.setSexo(rs.getString("a.sexo"));
                animal.setQualidade1(rs.getString("a.qualidade1"));
                animal.setQualidade2(rs.getString("a.qualidade2"));
                animal.setQualidade3(rs.getString("a.qualidade3"));
                animal.setObservacao(rs.getString("a.observacao"));
                animal.setIdade(rs.getInt("a.idade"));
                animal.setFoto1(rs.getBytes("a.foto1"));
                animal.setFoto2(rs.getBytes("a.foto2"));
                animal.setFoto3(rs.getBytes("a.foto3"));
                animal.setLatitude(rs.getString("a.latitude"));
                animal.setLongitude(rs.getString("a.longitude"));
                animal.setStatus(rs.getInt("a.status"));
                animal.setDatacad(rs.getString("a.datacad"));
                animal.setTipo(rs.getString("a.tipo"));

                Usuario user = new Usuario();
                user.setCodigo(rs.getInt("u.codigo"));
                user.setNome(rs.getString("u.nome"));
                user.setSenha(rs.getString("u.senha"));
                user.setEmail(rs.getString("u.email"));
                user.setEndereco(rs.getString("u.endereco"));
                user.setNumero(rs.getInt("u.numero"));
                user.setCep(rs.getString("u.cep"));
                user.setBairro(rs.getString("u.bairro"));
                user.setCidade(rs.getString("u.cidade"));
                user.setTelefone(rs.getString("u.telefone"));
                user.setSexo(rs.getString("u.sexo"));
                user.setIdade(rs.getInt("u.idade"));
                user.setTipo(rs.getString("u.tipo"));
                user.setDatacad(rs.getString("u.datacad"));
                user.setStatus(rs.getInt("u.status"));

                animal.setCodusuario(user);
                animais.add(animal);
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Connect.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        }
        return animais;
    }

    public List<Animal> buscarAdocao() {
        List<Animal> animais = new ArrayList<Animal>();
        try {
            PreparedStatement preparedStatement = con
                    .prepareStatement("SELECT a.codigo, a.nome, a.especie, a.porte, a.raca, a.sexo, a.qualidade1, a.qualidade2, a.qualidade3, a.observacao, a.idade, a.foto1, a.foto2, a.foto3, " +
                            "a.latitude, a.longitude, a.status, a.datacad, a.tipo, u.codigo, u.nome, u.senha, u.email, u.endereco, u.numero, u.cep, u.bairro, u.cidade, u.telefone, " +
                            "u.sexo, u.idade, u.tipo, u.datacad, u.status " +
                            "FROM animal as a " +
                            "INNER JOIN usuario as u ON a.codusuario = u.codigo " +
                            "WHERE a.tipo = 'Adotar' AND a.status = 1 AND u.status = 1");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Animal animal = new Animal();
                animal.setCodigo(rs.getLong("a.codigo"));
                animal.setNome(rs.getString("a.nome"));
                animal.setEspecie(rs.getString("a.especie"));
                animal.setPorte(rs.getString("a.porte"));
                animal.setRaca(rs.getString("a.raca"));
                animal.setSexo(rs.getString("a.sexo"));
                animal.setQualidade1(rs.getString("a.qualidade1"));
                animal.setQualidade2(rs.getString("a.qualidade2"));
                animal.setQualidade3(rs.getString("a.qualidade3"));
                animal.setObservacao(rs.getString("a.observacao"));
                animal.setIdade(rs.getInt("a.idade"));
                animal.setFoto1(rs.getBytes("a.foto1"));
                animal.setFoto2(rs.getBytes("a.foto2"));
                animal.setFoto3(rs.getBytes("a.foto3"));
                animal.setLatitude(rs.getString("a.latitude"));
                animal.setLongitude(rs.getString("a.longitude"));
                animal.setStatus(rs.getInt("a.status"));
                animal.setDatacad(rs.getString("a.datacad"));
                animal.setTipo(rs.getString("a.tipo"));

                Usuario user = new Usuario();
                user.setCodigo(rs.getInt("u.codigo"));
                user.setNome(rs.getString("u.nome"));
                user.setSenha(rs.getString("u.senha"));
                user.setEmail(rs.getString("u.email"));
                user.setEndereco(rs.getString("u.endereco"));
                user.setNumero(rs.getInt("u.numero"));
                user.setCep(rs.getString("u.cep"));
                user.setBairro(rs.getString("u.bairro"));
                user.setCidade(rs.getString("u.cidade"));
                user.setTelefone(rs.getString("u.telefone"));
                user.setSexo(rs.getString("u.sexo"));
                user.setIdade(rs.getInt("u.idade"));
                user.setTipo(rs.getString("u.tipo"));
                user.setDatacad(rs.getString("u.datacad"));
                user.setStatus(rs.getInt("u.status"));

                animal.setCodusuario(user);
                animais.add(animal);
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Connect.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        }
        return animais;
    }
}
