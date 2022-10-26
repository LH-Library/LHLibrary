package com.lhlibrary.backend.repository;

import com.lhlibrary.backend.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

    @Query("SELECT l FROM Livro l WHERE lower(l.titulo) like lower(concat('%', :filtro,'%')) or lower(l.autor) like lower(concat('%', :filtro,'%'))")
    List<Livro> findByTituloOrAutorContainingIgnoreCase(@Param("filtro") String filtro);
}
