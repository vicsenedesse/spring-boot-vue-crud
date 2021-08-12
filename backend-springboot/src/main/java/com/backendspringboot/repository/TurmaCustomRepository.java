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

    public List<Turma> find(Long quant_vagas, String horario) {

        String query = "select P from Turma as P ";
        String condicao = "where";

        if(quant_vagas != null) {
            query += condicao + " P.quant_vagas = :quant_vagas";
            condicao = " and ";
        }

        if(horario != null) {
            query += condicao + " P.horario = :horario";
            condicao = " and ";
        }

        var q = em.createQuery(query, Turma.class);

        if(quant_vagas != null) {
            q.setParameter("quant_vagas", quant_vagas);
        }

        if(horario != null) {
            q.setParameter("horario", horario);
        }

        return q.getResultList();
    }

}