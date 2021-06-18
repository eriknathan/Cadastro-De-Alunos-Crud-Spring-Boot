package com.squad6.projectcrud.repository;

import com.squad6.projectcrud.model.Periodo;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface PeriodoRepository extends JpaRepository<Periodo, Integer> {
}
