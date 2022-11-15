package com.lhlibrary.backend.repository;

import com.lhlibrary.backend.entity.Leitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeitorRepository extends JpaRepository<Leitor, Long> {
    @Query("SELECT l FROM Leitor l WHERE lower(l.nome) like lower(concat('%', :filtro,'%')) or lower(l.cpf) like lower(concat('%', :filtro,'%'))")
    List<Leitor> findByNomeOrCpfContainingIgnoreCase(@Param("filtro") String filtro);
}
