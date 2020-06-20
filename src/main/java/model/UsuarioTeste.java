package model;

import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize
public class UsuarioTeste {
    long idusuario;
    String user;
    String senha;

    public long getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(long idusuario) {
        this.idusuario = idusuario;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "{" +
                "\"idusuario\":" + idusuario +
                ", \"user\":\"" + user + "\"" +
                ", \"senha\":\"" + senha + "\"" +
                "}";
    }
}