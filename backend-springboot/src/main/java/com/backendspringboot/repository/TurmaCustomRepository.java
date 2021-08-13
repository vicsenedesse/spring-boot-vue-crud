package com.repository;

import com.model.Turma;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class TurmaCustomRepository {

    private final EntityManager em;

    public TurmaCustomRepository(EntityManager em) {
        this.em = em;
    }

    public List<Turma> find(Long qnt_vagas, String horario) {

        String query = "select P from Turma as P ";
        String condicao = "where";

        if(qnt_vagas != null) {
            query += condicao + " P.qnt_vagas = :qnt_vagas";
            condicao = " and ";
        }

        if(horario != null) {
            query += condicao + " P.horario = :horario";
            condicao = " and ";
        }

        var q = em.createQuery(query, Turma.class);

        if(qnt_vagas != null) {
            q.setParameter("qnt_vagas", qnt_vagas);
        }

        if(horario != null) {
            q.setParameter("horario", horario);
        }

        return q.getResultList();
    }

}