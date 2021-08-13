<template>
  <div class="list row">
    <div class="col-md-8">
      <div class="input-group mb-3">
        <input type="text" class="form-control" placeholder="Buscar por Nome"
          v-model="title"/>
        <div class="input-group-append">
          <button class="btn btn-outline-secondary" type="button"
            @click="searchTitle"
          >
            Search
          </button>
        </div>
      </div>
    </div>
    <div class="col-md-6">
      <h4>Listagem de Alunos</h4>
      <ul class="list-group">
        <li class="list-group-item"
          :class="{ active: index == currentIndex }"
          v-for="(aluno, index) in alunos"
          :key="index"
          @click="setActiveAluno(aluno, index)"
        >
          {{ aluno.nome }}
        </li>
      </ul>

      <button class="m-3 btn btn-sm btn-danger" @click="removeAllAlunos">
        Remover Todos
      </button>
    </div>
    <div class="col-md-6">
      <div v-if="currentAluno">
        <h4>Aluno</h4>
        <div>
          <label><strong>Nome:</strong></label> {{ currentAluno.nome }}
        </div>
        <div>
          <label><strong>Data de Nascimento:</strong></label> {{ currentAluno.nascimento }}
        </div>
        <div>
          <label><strong>Idade:</strong></label> {{ currentAluno.idade }}
        </div>
        <div>
          <label><strong>Email:</strong></label> {{ currentAluno.email }}
        </div>
        <div>
          <label><strong>Telefone:</strong></label> {{ currentAluno.telefone }}
        </div>
        <div>
          <label><strong>Sexo:</strong></label> {{ currentAluno.sexo }}
        </div>

        <a class="btn btn-sm btn-success" style="margin-top:20px"
          :href="'/aluno/' + currentAluno.id"
        >
          Editar
        </a>
      </div>
      <div v-else>
        <br />
        <p>Clique em um Aluno...</p>
      </div>
    </div>
  </div>
</template>

<script>
import AlunoDataService from "../services/AlunoDataService";

export default {
  name: "aluno-list",
  data() {
    return {
      alunos: [],
      currentAluno: null,
      currentIndex: -1,
      title: ""
    };
  },
  methods: {
    retrieveAlunos() {
      AlunoDataService.getAll()
        .then(response => {
          this.alunos = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },

    refreshList() {
      this.retrieveAlunos();
      this.currentAluno = null;
      this.currentIndex = -1;
    },

    setActiveAluno(aluno, index) {
      this.currentAluno = aluno;
      this.currentIndex = index;
    },

    removeAllAlunos() {
      AlunoDataService.deleteAll()
        .then(response => {
          console.log(response.data);
          this.refreshList();
        })
        .catch(e => {
          console.log(e);
        });
    },
    
    searchTitle() {
      AlunoDataService.findByTitle(this.title)
        .then(response => {
          this.alunos = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    }
  },
  mounted() {
    this.retrieveAlunos();
  }
};
</script>

<style>
.list {
  text-align: left;
  max-width: 750px;
  margin: auto;
}
</style>