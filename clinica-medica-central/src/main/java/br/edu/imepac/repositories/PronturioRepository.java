package br.edu.imepac.repositories;

import br.edu.imepac.models.Prontuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PronturioRepository extends JpaRepository<Prontuario, Long> {
}
