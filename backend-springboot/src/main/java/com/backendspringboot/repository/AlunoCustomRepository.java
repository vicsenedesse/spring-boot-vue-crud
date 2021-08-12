package com.repository;

import com.model.Aluno;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class AlunoCustomRepository {

    private final EntityManager em;

    public AlunoCustomRepository(EntityManager em) {
        this.em = em;
    }

    public List<Aluno> find(Long idade, String sexo) {

        String query = "select P from Aluno as P ";
        String condicao = "where";

        if(idade != null) {
            query += condicao + " P.idade = :idade";
            condicao = " and ";
        }

        if(sexo != null) {
            query += condicao + " P.sexo = :sexo";
            condicao = " and ";
        }

        var q = em.createQuery(query, Aluno.class);

        if(idade != null) {
            q.setParameter("idade", idade);
        }

        if(sexo != null) {
            q.setParameter("sexo", sexo);
        }

        return q.getResultList();
    }

}