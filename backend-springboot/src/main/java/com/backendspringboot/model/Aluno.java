//package com.veterinary_clinic_adm.register.model;
package com.model;

import javax.persistence.*;
import com.model.Turma;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "alunos")

public class Aluno{
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)

   @Column(name = "aluno_id")
   private Long aluno_id;

   @Column(name = "nome")
   private String nome;

   @Column(name = "nascimento")
   private Date nascimento;

   @Column(name = "idade")
   private Long idade;

   @Column(name = "sexo")
   private String sexo;

   // @OneToOne(cascade = CascadeType.ALL)
   //  @JoinTable(name = "emp_workstation", 
   //    joinColumns = 
   //      { @JoinColumn(name = "employee_id", referencedColumnName = "id") },
   //    inverseJoinColumns = 
   //      { @JoinColumn(name = "workstation_id", referencedColumnName = "id") })
  
   // @ManyToOne(cascade = CascadeType.ALL)
   // @JoinTable(name="tutor")
   // @JoinColumn(name = "tutor_id")
   
   private List<Turma> turmas;


//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "turma_id")
//    private Turma turmas;



   public Long getId() { return aluno_id; }
   
   public void setId(Long aluno_id) { this.aluno_id = aluno_id; }


   public String getNome() { return nome; }
   
   public void setNome(String nome) { this.nome = nome; }


   public Long getIdade() { return idade; }
   
   public void setIdade(Long idade) { this.idade = idade; }


   public Date getNascimento() { return nascimento; }
   
   public void setNascimento(Date nascimento) { this.nascimento = nascimento; }


   public String getSexo() { return sexo; }

   public void setSexo(String sexo) { this.sexo = sexo; }


   
   public List<Turma> getTurmas() { return turmas; }

   public void setTurmas(List<Turma> turmas) { this.turmas = turmas; }

}


