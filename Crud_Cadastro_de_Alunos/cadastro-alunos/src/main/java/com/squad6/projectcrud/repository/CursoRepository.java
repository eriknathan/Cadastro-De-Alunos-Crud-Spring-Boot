package com.squad6.projectcrud.repository;

import com.squad6.projectcrud.model.Curso;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends CrudRepository<Curso, Integer> {
}
