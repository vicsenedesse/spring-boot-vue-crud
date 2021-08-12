CREATE DATABASE IF NOT EXISTS school;
USE school;


CREATE TABLE turma (
  turma_id INT AUTO_INCREMENT NOT NULL,
  data_inicio DATE NOT NULL,
  nome VARCHAR(80) NOT NULL,
  horario TIME NOT NULL,
  qnt_vagas INT NOT NULL,

  alunos INT NOT NULL,

  FOREIGN KEY (alunos) references alunos(aluno_id),

  PRIMARY KEY (turma_id)

);

CREATE TABLE alunos (
  aluno_id INT AUTO_INCREMENT NOT NULL,
  nome VARCHAR(50) NOT NULL,
  nascimento DATE NOT NULL,
  idade INT NOT NULL,
  sexo VARCHAR(1) NOT NULL,

  turmas INT NOT NULL,

  PRIMARY KEY (aluno_id),

  FOREIGN KEY (turmas) references turma(turma_id),

);
-- -- INSERT INTO dbclinic.tutor
INSERT INTO turma(turma_id, data_inicio, nome, horario, qnt_vagas) 
VALUES (1,'2021/09/24','Matemáticas e suas Tecnologias','14:30.0000000',21);

INSERT INTO turma(turma_id, data_inicio, nome, horario, qnt_vagas) 
VALUES (2,'2021/09/25','Linguagens e suas Tecnologias','15:30.0000000',30);

INSERT INTO turma(turma_id, data_inicio, nome, horario, qnt_vagas) 
VALUES (3,'2021/09/26','Ciências da Natureza e suas Tecnologias','13:30.0000000',40);

INSERT INTO turma(turma_id, data_inicio, nome, horario, qnt_vagas) 
VALUES (4,'2021/09/27','Ciências Humanas e Sociais Aplicadas','14:30.0000000',21);



-- INSERT INTO alunos(aluno_id, nome, nascimento, idade, sexo) 
-- VALUES (1,'Avril Lavigne','1984/09/27',36,'F');

-- INSERT INTO alunos(aluno_id, nome, nascimento, idade, sexo) 
-- VALUES (2,'Hayley Williams','1984/12/27',32,'F');

-- INSERT INTO alunos(aluno_id, nome, nascimento, idade, sexo) 
-- VALUES (3,'Alanis Morrisset','1974/06/01',47,'F');

-- INSERT INTO alunos(aluno_id, nome, nascimento, idade, sexo) 
-- VALUES (4,'Lauryn Hill','1975/05/26',46,'F');
