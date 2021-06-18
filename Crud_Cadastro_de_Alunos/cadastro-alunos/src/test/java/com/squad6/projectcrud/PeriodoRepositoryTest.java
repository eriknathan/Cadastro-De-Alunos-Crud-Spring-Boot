package com.squad6.projectcrud;

import com.squad6.projectcrud.model.Periodo;

import com.squad6.projectcrud.repository.PeriodoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class PeriodoRepositoryTest {

    @Autowired
    private PeriodoRepository repo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void TestCreatedPeriodo(){
        Periodo periodo = new Periodo();

        periodo.setPeriodo("Primeiro");

        Periodo savedPeriodo = repo.save(periodo);

        Periodo existPeriodo = entityManager.find(Periodo.class, savedPeriodo.getId());

        assert(existPeriodo.getPeriodo().equals(periodo.getPeriodo()));
    }

}
