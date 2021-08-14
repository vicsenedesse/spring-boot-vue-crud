CREATE DATABASE IF NOT EXISTS school;
USE school;


CREATE TABLE turma (
  turma_id INT AUTO_INCREMENT NOT NULL,
  data_inicio DATE NOT NULL,
  nome VARCHAR(80) NOT NULL,
  horario TIME NOT NULL,
  qnt_vagas INT NOT NULL,

  alunos INT,

  -- FOREIGN KEY (alunos) references alunos(aluno_id),

  PRIMARY KEY (turma_id)

);

CREATE TABLE aluno (
  aluno_id INT AUTO_INCREMENT NOT NULL,
  nome VARCHAR(50) NOT NULL,
  nascimento DATE NOT NULL,
  idade INT NOT NULL,
  sexo VARCHAR(1) NOT NULL,
  telefone VARCHAR(14) NOT NULL,
  email VARCHAR(50) NOT NULL,

  turmas INT,

  PRIMARY KEY (aluno_id)

  -- FOREIGN KEY (turmas) references turma(turma_id),
);

CREATE TABLE alunoTurma(
  aluno_id INT NOT NULL,
  turma_id INT NOT NULL,

  FOREIGN KEY (aluno_id) references aluno(aluno_id),
  FOREIGN KEY (turma_id) references turma(turma_id),
  UNIQUE (aluno_id, turma_id)
);


INSERT INTO turma(turma_id, data_inicio, nome, horario, qnt_vagas) 
VALUES (1,'2021/09/24','Matemáticas e suas Tecnologias','14:30.0000000',21);

INSERT INTO turma(turma_id, data_inicio, nome, horario, qnt_vagas) 
VALUES (2,'2021/09/25','Linguagens e suas Tecnologias','15:30.0000000',30);

INSERT INTO turma(turma_id, data_inicio, nome, horario, qnt_vagas) 
VALUES (3,'2021/09/26','Ciências da Natureza e suas Tecnologias','13:30.0000000',40);

INSERT INTO turma(turma_id, data_inicio, nome, horario, qnt_vagas) 
VALUES (4,'2021/09/27','Ciências Humanas e Sociais Aplicadas','14:30.0000000',21);



INSERT INTO aluno(aluno_id, nome, nascimento, idade, sexo, telefone, email) 
VALUES (1,'Avril Lavigne','1984/09/27',36,'F', '(99)99999-9991' ,'email1@gmail.com');

INSERT INTO aluno(aluno_id, nome, nascimento, idade, sexo, telefone, email) 
VALUES (2,'Hayley Williams','1984/12/27',32,'F', '(99)99999-9992' ,'email2@gmail.com');

INSERT INTO aluno(aluno_id, nome, nascimento, idade, sexo, telefone, email) 
VALUES (3,'Alanis Morrisset','1974/06/01',47,'F', '(99)99999-9993' ,'email3@gmail.com');

INSERT INTO aluno(aluno_id, nome, nascimento, idade, sexo, telefone, email) 
VALUES (4,'Lauryn Hill','1975/05/26',46,'F', '(99)99999-9994' ,'email4@gmail.com');



INSERT INTO alunoTurma(turma_id, aluno_id)
VALUES (1,2);

INSERT INTO alunoTurma(turma_id, aluno_id)
VALUES (1,4);

INSERT INTO alunoTurma(turma_id, aluno_id)
VALUES (1,3);

INSERT INTO alunoTurma(turma_id, aluno_id)
VALUES (2,2);

INSERT INTO alunoTurma(turma_id, aluno_id)
VALUES (2,1);

INSERT INTO alunoTurma(turma_id, aluno_id)
VALUES (3,3);

INSERT INTO alunoTurma(turma_id, aluno_id)
VALUES (4,1);