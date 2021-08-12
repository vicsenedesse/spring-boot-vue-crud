//package com.veterinary_clinic_adm.register.controller.dto;
//import com.veterinary_clinic_adm.register.model.Tutor;
//import com.veterinary_clinic_adm.register.model.Animal;

package com.controller.dto;
//import com.model.Address;

import com.model.Turma;
import com.model.Aluno;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

public class TurmaRs {

    private Long turma_id;
    private Date data_inicial;
    private String nome;
    private String horario;
    private Long qnt_vagas;


   private List<Aluno> alunos;



   public static TurmaRs converter(Turma t) {

       var turma = new TurmaRs();

       turma.setTurmaId(t.getTurmaId());
       turma.setDataInicio(t.getDataInicio());
       turma.setNome(t.getNome());
       turma.setHorario(t.getHorario());
       turma.setQuantVagas(t.getQuantVagas());

       turma.setAlunos(t.getAlunos());


    
       return turma;
   }


  public List<Aluno> getAlunos() { return alunos; }

  public void setAlunos(List<Aluno> alunos) { this.alunos = alunos; }


  public Long getTurmaId() { return turma_id; }

  public void setTurmaId(Long turma_id) { this.turma_id = turma_id; }





   public Date getDataInicio() { return data_inicial; }

   public void setDataInicio(Date data_inicial) { this.data_inicial = data_inicial; }


   public String getNome() { return nome; }

   public void setNome(String nome) { this.nome = nome; }


   public String getHorario() { return horario; }

   public void setHorario(String horario) { this.horario = horario; }


   public Long getQuantVagas() { return qnt_vagas; }

   public void setQuantVagas(Long qnt_vagas) { this.qnt_vagas = qnt_vagas; }

}