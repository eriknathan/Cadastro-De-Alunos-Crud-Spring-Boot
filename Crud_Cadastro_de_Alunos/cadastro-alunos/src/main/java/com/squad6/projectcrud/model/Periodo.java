package com.squad6.projectcrud.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "periodo")
public class Periodo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String periodo;

    @OneToMany(mappedBy = "periodo")
    private List <Info_alunos> alunos;

    public Periodo() {
    }

    public Periodo(int id, String periodo, List<Info_alunos> alunos) {
        this.id = id;
        this.periodo = periodo;
        this.alunos = alunos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public List<Info_alunos> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Info_alunos> alunos) {
        this.alunos = alunos;
    }
}
