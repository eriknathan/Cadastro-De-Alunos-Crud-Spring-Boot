package com.squad6.projectcrud.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "info_alunos")
public class Info_alunos {

    public String Format(String c, boolean mascara){
        if (mascara){
            return (c.substring(0,3) + "." + c.substring(3,5) + "." + c.substring(5,8) + "-" + c.substring(8,10));
        } else{
            c = c.replace(".","");
            c = c.replace("-","");
            return c;
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer matricula;

    private String cpf;
    private String email;
    private String nome;
    private String sexo;
    private Date data_nasc;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "periodo_id")
    private Periodo periodo;

    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    public Info_alunos() {
        super();
    }

    public Info_alunos(Integer matricula, String cpf, String email, String nome, String sexo, Date data_nasc, Curso curso, Periodo periodo, Endereco endereco) {
        this.matricula = matricula;
        this.cpf = cpf;
        this.email = email;
        this.nome = nome;
        this.sexo = sexo;
        this.data_nasc = data_nasc;
        this.curso = curso;
        this.periodo = periodo;
        this.endereco = endereco;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = this.Format(cpf, false);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(Date data_nasc) {
        this.data_nasc = data_nasc;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}

