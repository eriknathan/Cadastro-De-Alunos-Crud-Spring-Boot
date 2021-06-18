package com.squad6.projectcrud;

import com.squad6.projectcrud.model.User;
import com.squad6.projectcrud.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTests {

    @Autowired
    private UserRepository repo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateUser(){
        User user = new User();
        user.setNome("admin");
        user.setSenha("admin");
        user.setEmail("admin@admin.com");
        user.setAtivo(true);

        User savedUser = repo.save(user);

        User existUser = entityManager.find(User.class, savedUser.getId());
        assert(existUser.getNome().equals(user.getNome()));

    }

}
