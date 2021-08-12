//package com.veterinary_clinic_adm.register.repository;
package com.repository;

//import com.veterinary_clinic_adm.register.model.Tutor;
import com.model.Aluno;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

//    Aluno findByAlunoId(Long Aluno_id);

    List<Aluno> findByNameContains(String nome);

}