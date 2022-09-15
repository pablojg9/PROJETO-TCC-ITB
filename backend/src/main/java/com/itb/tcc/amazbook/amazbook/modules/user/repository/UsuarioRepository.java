package com.itb.tcc.amazbook.amazbook.modules.user.repository;

import com.itb.tcc.amazbook.amazbook.modules.user.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    @Query("SELECT u from Usuario u where u.login = ?1")
    Usuario findUsuarioByLogin(String login);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "UPDATE usuario SET token = ?1 WHERE login = ?2")
    void updateTokenUser(String token, String login);
}
