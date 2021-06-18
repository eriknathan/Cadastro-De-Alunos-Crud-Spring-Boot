package com.squad6.projectcrud.interfaceservice;

import com.squad6.projectcrud.model.Info_alunos;

import java.util.List;
import java.util.Optional;


public interface InfoAlunosInterfServ {

    public List<Info_alunos> listar();
    public Optional<Info_alunos> listarPeloId(Integer matricula);

}
