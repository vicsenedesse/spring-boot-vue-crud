//package com.veterinary_clinic_adm.register.repository;
package com.repository;

//import com.veterinary_clinic_adm.register.model.Tutor;
import com.model.Turma;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {

//    Turma findByTurmaId(Long Turma_id);

    List<Turma> findByNameContains(String nome);

}