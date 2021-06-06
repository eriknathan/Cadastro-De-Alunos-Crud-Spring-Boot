package com.squad6.projectcrud.service;

import com.squad6.projectcrud.interfaceservice.InfoAlunosInterfServ;
import com.squad6.projectcrud.model.Info_alunos;
import com.squad6.projectcrud.repository.InfoAlunosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InfoAlunosService implements InfoAlunosInterfServ {

    @Autowired
    private InfoAlunosRepository data;

    @Override
    public List<Info_alunos> listar() {
        return (List<Info_alunos>) data.findAll();
    }

    @Override
    public Optional<Info_alunos> listarPeloId(Integer matricula) {
        return (Optional<Info_alunos>) data.findById(matricula);
    }
}
