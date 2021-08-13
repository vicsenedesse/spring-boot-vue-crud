<template>
  <div v-if="currentAluno" class="edit-form">
    <h4>Aluno</h4>
    <form>
      <div class="form-group">
        <label for="nome">Nome</label>
        <input type="text" class="form-control" id="nome"
          v-model="currentAluno.nome"
        />
      </div>

      <div class="form-group">
        <label for="idade">Idade</label>
        <input type="text" class="form-control" id="idade"
          v-model="currentAluno.idade"
        />
      </div>

      <div class="form-group">
        <label for="nascimento">Data de Nascimento</label>
        <input type="text" class="form-control" id="nascimento"
          v-model="currentAluno.nascimento"
        />
      </div>

      <div class="form-group">
        <label for="sexo">Sexo</label>
        <input type="text" class="form-control" id="sexo"
          v-model="currentAluno.sexo"
        />
      </div>

      <div class="form-group">
        <label for="telefone">Telefone</label>
        <input type="text" class="form-control" id="telefone"
          v-model="currentAluno.telefone"
        />
      </div>

      <div class="form-group">
        <label for="email">Email</label>
        <input type="text" class="form-control" id="email"
          v-model="currentAluno.email"
        />
      </div>

    </form>

    

    <button class="btn btn-danger mr-2" style="margin-top:15px; margin-right:10px"
      @click="deleteAluno"
    >
      Deletar
    </button>

    <button type="submit" class="btn btn-success" style="margin-top:15px"
      @click="updateAluno"
    >
      Editar
    </button>
    <p>{{ message }}</p>
  </div>

  <div v-else>
    <br />
    <p>Please click on a Aluno...</p>
  </div>
</template>

<script>
import AlunoDataService from "../services/AlunoDataService";

export default {
  name: "aluno",
  data() {
    return {
      currentAluno: null,
      message: ''
    };
  },
  methods: {
    getAluno(id) {
      AlunoDataService.get(id)
        .then(response => {
          this.currentAluno = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },

    updateAluno() {
      AlunoDataService.update(this.currentAluno.id, this.currentAluno)
        .then(response => {
          console.log(response.data);
          this.message = 'The Aluno was updated successfully!';
        })
        .catch(e => {
          console.log(e);
        });
    },

    deleteAluno() {
      AlunoDataService.delete(this.currentAluno.id)
        .then(response => {
          console.log(response.data);
          this.$router.push({ name: "aluno" });
        })
        .catch(e => {
          console.log(e);
        });
    }
  },
  mounted() {
    this.message = '';
    this.getAluno(this.$route.params.id);
  }
};
</script>

<style>
.edit-form {
  max-width: 300px;
  margin: auto;
}
</style>