//package com.veterinary_clinic_adm.register.model;
package com.model;


import javax.persistence.*;
import com.model.Aluno;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "turma")

public class Turma{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)

   @Column(name = "turma_id")
   private Long turma_id;

   @Column(name = "data_inicio")
   private Date data_inicio;

   @Column(name = "nome")
   private String nome;

   @Column(name = "horario")
   private String horario;

   @Column(name = "qnt_vagas")
   private Long qnt_vagas;

   @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "alunoTurma", 
      joinColumns = @JoinColumn(name = "aluno_id", referencedColumnName = "aluno_id"), 
      inverseJoinColumns = @JoinColumn(name = "turma_id", 
      referencedColumnName = "turma_id"))
   private List<Aluno> alunos;



//chaves
   public Long getTurmaId() { return turma_id; }

   public void setTurmaId(Long turma_id) { this.turma_id = turma_id; }



  public List<Aluno> getAlunos() { return alunos; }

  public void setAlunos(List<Aluno> alunos) { this.alunos = alunos; }



   public Date getDataInicio() { return data_inicio; }

   public void setDataInicio(Date data_inicio) { this.data_inicio = data_inicio; }


   public String getNome() { return nome; }

   public void setNome(String nome) { this.nome = nome; }


   public String getHorario() { return horario; }

   public void setHorario(String horario) { this.horario = horario; }


   public Long getQuantVagas() { return qnt_vagas; }

   public void setQuantVagas(Long qnt_vagas) { this.qnt_vagas = qnt_vagas; }

}


