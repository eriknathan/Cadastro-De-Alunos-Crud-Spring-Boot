package com.squad6.projectcrud.repository;

import com.squad6.projectcrud.model.Info_alunos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface InfoAlunosRepository extends JpaRepository<Info_alunos, Integer> {

    List<Info_alunos> findByNomeContains(String nome);

}
