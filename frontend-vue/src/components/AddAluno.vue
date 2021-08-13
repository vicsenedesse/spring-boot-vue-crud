<template>
  <div class="submit-form">
    <div v-if="!submitted">
      <div class="form-group" style="margin-bottom: 20px; margin-top: 50px">
        <label for="nome">Nome</label>
        <input
          type="text"
          class="form-control"
          id="nome"
          placeholder="Nome"
          required
          v-model="aluno.nome"
          name="nome"
        />
      </div>

      <div class="form-group" style="margin-bottom: 20px">
        <label for="nascimento">Data de Nascimento</label>
        <input
          class="form-control"
          id="nascimento"
          placeholder="dd/mm/aaaa"
          required
          v-model="aluno.nascimento"
          name="nascimento"
        />
      </div>

      <div class="form-group" style="margin-bottom: 20px">
        <label for="idade">Idade</label>
        <input
          class="form-control"
          placeholder="Idade"
          id="idade"
          required
          v-model="aluno.idade"
          name="idade"
        />
      </div>

      <div class="form-group" style="margin-bottom: 20px">
        <label for="sexo">Sexo</label>
        <input
          class="form-control"
          placeholder="F/M"
          id="sexo"
          required
          v-model="aluno.sexo"
          name="sexo"
        />
      </div>

      <div class="form-group" style="margin-bottom: 20px">
        <label for="telefone">Telefone</label>
        <input
          class="form-control"
          id="telefone"
          placeholder="(99)99999-9999"
          required
          v-model="aluno.telefone"
          name="telefone"
        />
      </div>

      <div class="form-group" style="margin-bottom: 20px">
        <label for="email">Email</label>
        <input
          class="form-control"
          id="email"
          placeholder="email@gmail.com"
          required
          v-model="aluno.email"
          name="email"
        />
      </div>

      <button @click="saveAluno" class="btn btn-success">Submit</button>
    </div>

    <div v-else>
      <h4>You submitted successfully!</h4>
      <button class="btn btn-success" @click="newAluno">Add</button>
    </div>
  </div>
</template>

<script>
import AlunoDataService from "../services/AlunoDataService";

export default {
  name: "add-aluno",
  data() {
    return {
      aluno: {
        aluno_id: null,
        nome: "",
        nascimento: "",
        sexo: "",
        email: "",
        telefone: "",
        idade: null,
        published: false
      },
      submitted: false
    };
  },
  methods: {
    saveAluno() {
      var data = {
        nome: this.aluno.nome,
        nascimento: this.aluno.nascimento,
        idade: this.aluno.idade,
        sexo: this.aluno.sexo,
        telefone: this.aluno.telefone,
        email: this.aluno.email,
      };

      AlunoDataService.create(data)
        .then(response => {
          this.aluno.aluno_id = response.data.aluno_id;
          console.log(response.data);
          this.submitted = true;
        })
        .catch(e => {
          console.log(e);
        });
    },
    
    newAluno() {
      this.submitted = false;
      this.aluno = {};
    }
  }
};
</script>

<style>
.submit-form {
  max-width: 300px;
  margin: auto;
}
</style>