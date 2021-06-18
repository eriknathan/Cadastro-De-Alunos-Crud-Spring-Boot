package com.squad6.projectcrud.service;

import com.squad6.projectcrud.interfaceservice.CursoInterfSer;
import com.squad6.projectcrud.model.Curso;
import com.squad6.projectcrud.model.Info_alunos;
import com.squad6.projectcrud.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService implements CursoInterfSer {

    @Autowired
    private CursoRepository data;

    @Override
    public List<Curso> listar() {
        return (List<Curso>) data.findAll();
    }
}
