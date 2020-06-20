package model;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.sql.Date;

@JsonSerialize
public class Animal {

    private long codigo;
    private String nome;
    private String especie;
    private String porte;
    private String raca;
    private String sexo;
    private String qualidade1;
    private String qualidade2;
    private String qualidade3;
    private String observacao;
    private int idade;
    private byte[] foto1;
    private byte[] foto2;
    private byte[] foto3;
    private String latitude;
    private String longitude;
    private int status;
    private Date datacad;
    private String tipo;
    private Usuario codusuario;

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getQualidade1() {
        return qualidade1;
    }

    public void setQualidade1(String qualidade1) {
        this.qualidade1 = qualidade1;
    }

    public String getQualidade2() {
        return qualidade2;
    }

    public void setQualidade2(String qualidade2) {
        this.qualidade2 = qualidade2;
    }

    public String getQualidade3() {
        return qualidade3;
    }

    public void setQualidade3(String qualidade3) {
        this.qualidade3 = qualidade3;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public byte[] getFoto1() {
        return foto1;
    }

    public void setFoto1(byte[] foto1) {
        this.foto1 = foto1;
    }

    public byte[] getFoto2() {
        return foto2;
    }

    public void setFoto2(byte[] foto2) {
        this.foto2 = foto2;
    }

    public byte[] getFoto3() {
        return foto3;
    }

    public void setFoto3(byte[] foto3) {
        this.foto3 = foto3;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getDatacad() {
        return datacad;
    }

    public void setDatacad(Date datacad) {
        this.datacad = datacad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Usuario getCodusuario() {
        return codusuario;
    }

    public void setCodusuario(Usuario codusuario) {
        this.codusuario = codusuario;
    }
}
