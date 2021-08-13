<template>
  <div v-if="currentTurma" class="edit-form">
    <h4>Turma</h4>
    <form>
      <div class="form-group">
        <label for="nome">Nome</label>
        <input type="text" class="form-control" id="nome"
          v-model="currentTurma.nome"
        />
      </div>

      <div class="form-group">
        <label for="horario">Horário</label>
        <input type="text" class="form-control" id="horario"
          v-model="currentTurma.horario"
        />
      </div>

      <div class="form-group">
        <label for="qnt_vagas">Quantidade de Vagas</label>
        <input type="text" class="form-control" id="qnt_vagas"
          v-model="currentTurma.qnt_vagas"
        />
      </div>

      <div class="form-group">
        <label for="data_inicio">Data de Início</label>
        <input type="text" class="form-control" id="data_inicio"
          v-model="currentTurma.data_inicio"
        />
      </div>


      <!-- <div class="form-group">
        <label for="alunos">Alunos</label>
        <input type="text" class="form-control" id="alunos"
          v-model="currentTurma.alunos"
        />
      </div> -->

      
    </form>

   
    <button class="btn btn-danger mr-2" style="margin-top:15px; margin-right:10px"
      @click="deleteTurma"
    >
      Delete
    </button>

    <button type="submit" class="btn btn-success" style="margin-top:15px"
      @click="updateTurma"
    >
      Update
    </button>
    <p>{{ message }}</p>
  </div>

  <div v-else>
    <br />
    <p>Clique em uma Turma...</p>
  </div>
</template>

<script>
import TurmaDataService from "../services/TurmaDataService";

export default {
  name: "turma",
  data() {
    return {
      currentTurma: null,
      message: ''
    };
  },
  methods: {
    getTurma(id) {
      TurmaDataService.get(id)
        .then(response => {
          this.currentTurma = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },

    

    updateTurma() {
      TurmaDataService.update(this.currentTurma.id, this.currentTurma)
        .then(response => {
          console.log(response.data);
          this.message = 'The Turma was updated successfully!';
        })
        .catch(e => {
          console.log(e);
        });
    },

    deleteTurma() {
      TurmaDataService.delete(this.currentTurma.id)
        .then(response => {
          console.log(response.data);
          this.$router.push({ name: "turma" });
        })
        .catch(e => {
          console.log(e);
        });
    }
  },
  mounted() {
    this.message = '';
    this.getTurma(this.$route.params.id);
  }
};
</script>

<style>
.edit-form {
  max-width: 300px;
  margin: auto;
}
</style>