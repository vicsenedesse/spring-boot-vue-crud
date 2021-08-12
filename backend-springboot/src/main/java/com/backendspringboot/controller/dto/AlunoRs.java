
package com.controller.dto;

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

public class AlunoRs {

    private Long aluno_id;
    private String nome;
    private Date nascimento;
    private Long idade;
    private String sexo;


   private List<Turma> turmas;



   public static AlunoRs converter(Aluno t) {

       var aluno = new AlunoRs();

       aluno.setId(t.getId());
       aluno.setNascimento(t.getNascimento());
       aluno.setNome(t.getNome());
       aluno.setSexo(t.getSexo());
       aluno.setIdade(t.getIdade());

       aluno.setTurmas(t.getTurmas());


    
       return aluno;
   }


  public List<Turma> getTurmas() { return turmas; }

  public void setTurmas(List<Turma> turmas) { this.turmas = turmas; }


  public Long getId() { return aluno_id; }

  public void setId(Long aluno_id) { this.aluno_id = aluno_id; }





   public Date getNascimento() { return nascimento; }

   public void setNascimento(Date nascimento) { this.nascimento = nascimento; }


   public String getNome() { return nome; }

   public void setNome(String nome) { this.nome = nome; }


   public String getSexo() { return sexo; }

   public void setSexo(String sexo) { this.sexo = sexo; }


   public Long getIdade() { return idade; }

   public void setIdade(Long idade) { this.idade = idade; }

}