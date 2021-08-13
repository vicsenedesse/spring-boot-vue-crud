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
      <h4>Listagem</h4>
      <ul class="list-group">
        <li class="list-group-item"
          :class="{ active: index == currentIndex }"
          v-for="(turma, index) in turmas"
          :key="index"
          @click="setActiveTurma(turma, index)"
        >
          {{ turma.nome }}
        </li>
      </ul>

      <button class="m-3 btn btn-sm btn-danger" @click="removeAllTurmas">
        Remover Todos
      </button>
    </div>
    <div class="col-md-6">
      <div v-if="currentTurma">
        <h4>Turma</h4>
        <div>
          <label><strong>Nome:</strong></label> {{ currentTurma.nome }}
        </div>
        <div>
          <label><strong>Horário:</strong></label> {{ currentTurma.horario }}
        </div>
        <div>
          <label><strong>Quantidade Vagas:</strong></label> {{ currentTurma.qnt_vagas }}
        </div>
        <div>
          <label><strong>Data Início:</strong></label> {{ currentTurma.data_inicio }}
        </div>
          <label><strong>Alunos:</strong></label> 
          <div v-for="(i) in currentTurma['alunos']" :key="i">
            Nome: {{i.nome}}, {{i.idade}}
          </div>

        <a class="btn btn-sm btn-success" style="margin-top:20px"
          :href=" '/turma/'+ currentTurma.id"
        >
          Editar
        </a>
      </div>
      <div v-else>
        <br />
        <p>Clique em uma Turma...</p>
      </div>
    </div>
  </div>
</template>

<script>
import TurmaDataService from "../services/TurmaDataService";

export default {
  name: "turma-list",
  data() {
    return {
      turmas: [],
      alunos: [],
      currentTurma: null,
      currentIndex: -1,
      title: ""
    };
  },
  methods: {
    retrieveTurmas() {
      TurmaDataService.getAll()
        .then(response => {
          this.turmas = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },

    refreshList() {
      this.retrieveTurmas();
      this.currentTurma = null;
      this.currentIndex = -1;
    },

    setActiveTurma(turma, index) {
      this.currentTurma = turma;
      this.currentIndex = index;
    },

    removeAllTurmas() {
      TurmaDataService.deleteAll()
        .then(response => {
          console.log(response.data);
          this.refreshList();
        })
        .catch(e => {
          console.log(e);
        });
    },
    
    searchTitle() {
      TurmaDataService.findByTitle(this.title)
        .then(response => {
          this.turmas = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },

  },
  mounted() {
    this.retrieveTurmas();
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