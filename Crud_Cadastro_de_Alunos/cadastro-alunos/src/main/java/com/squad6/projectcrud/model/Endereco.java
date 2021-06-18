package com.squad6.projectcrud.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Integer cep;
    private String uf;
    private String cidade;
    private String bairro;
    private String rua;
    private Integer numero;
    private String complemento;

    @OneToMany(mappedBy = "endereco", cascade= {CascadeType.ALL}, fetch=FetchType.EAGER)
    private List<Info_alunos> alunos;

    public Endereco() {
    }

    public Endereco(int id, Integer cep, String uf, String cidade, String bairro, String rua, Integer numero, String complemento, List<Info_alunos> alunos) {
        this.id = id;
        this.cep = cep;
        this.uf = uf;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.alunos = alunos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public List<Info_alunos> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Info_alunos> alunos) {
        this.alunos = alunos;
    }
}
