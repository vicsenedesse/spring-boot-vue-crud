<template>
  <div class="submit-form">
    <div v-if="!submitted">
      <div class="form-group" style="margin-bottom: 20px; margin-top: 50px">
        <label for="nome">Nome</label>
        <input
          type="text"
          class="form-control"
          placeholder="Nome da Turma"
          id="nome"
          required
          v-model="turma.nome"
          name="nome"
        />
      </div>

      <div class="form-group" style="margin-bottom: 20px;">
        <label for="horario">Horário</label>
        <input
          class="form-control"
          id="horario"
          placeholder="hh:mm"
          required
          v-model="turma.horario"
          name="horario"
        />
      </div>

      <div class="form-group" style="margin-bottom: 20px;">
        <label for="qnt_vagas">Quantidade de Vagas</label>
        <input
          class="form-control"
          id="qnt_vagas"
          placeholder="Quantidade de Vagas"
          required
          v-model="turma.qnt_vagas"
          name="qnt_vagas"
        />
      </div>

      <div class="form-group" style="margin-bottom: 20px;">
        <label for="data_inicio">Data de Início</label>
        <input
          class="form-control"
          id="data_inicio"
          placeholder="dd/mm/aaaa"
          required
          v-model="turma.data_inicio"
          name="data_inicio"
        />
      </div>

      <button @click="saveTurma" class="btn btn-success">Submit</button>
    </div>

    <div v-else>
      <h4>You submitted successfully!</h4>
      <button class="btn btn-success" @click="newTurma">Add</button>
    </div>
  </div>
</template>

<script>
import TurmaDataService from "../services/TurmaDataService";

export default {
  name: "add-turma",
  data() {
    return {
      turma: {
        turma_id: null,
        nome: "",
        horario: "",
        qnt_vagas: null,
        data_inicio: null
      },
      submitted: false
    };
  },
  methods: {
    saveTurma() {
      var data = {
        nome: this.turma.nome,
        horario: this.turma.horario,
        data_inicio: this.turma.data_inicio,
        qnt_vagas: this.turma.quant_vagas,
      };

      TurmaDataService.create(data)
        .then(response => {
          this.turma.turma_id = response.data.turma_id;
          console.log(response.data);
          this.submitted = true;
        })
        .catch(e => {
          console.log(e);
        });
    },
    
    newTurma() {
      this.submitted = false;
      this.turma = {};
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