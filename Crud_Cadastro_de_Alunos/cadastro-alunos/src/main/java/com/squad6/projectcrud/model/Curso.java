package com.squad6.projectcrud.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;

    @OneToMany(mappedBy = "curso")
    private List <Info_alunos> alunos;

    public Curso() {
    }

    public Curso(int id, String nome, List<Info_alunos> alunos) {
        this.id = id;
        this.nome = nome;
        this.alunos = alunos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Info_alunos> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Info_alunos> alunos) {
        this.alunos = alunos;
    }
}
