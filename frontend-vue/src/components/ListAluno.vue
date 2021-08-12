<template>
  <div class="list row">
    <div class="col-md-8">
      <div class="input-group mb-3">
        <input type="text" class="form-control" placeholder="Search by title"
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
      <h4>Alunos List</h4>
      <ul class="list-group">
        <li class="list-group-item"
          :class="{ active: index == currentIndex }"
          v-for="(aluno, index) in alunos"
          :key="index"
          @click="setActiveAluno(aluno, index)"
        >
          {{ aluno.title }}
        </li>
      </ul>

      <button class="m-3 btn btn-sm btn-danger" @click="removeAllAlunos">
        Remove All
      </button>
    </div>
    <div class="col-md-6">
      <div v-if="currentAluno">
        <h4>Aluno</h4>
        <div>
          <label><strong>Title:</strong></label> {{ currentAluno.title }}
        </div>
        <div>
          <label><strong>Description:</strong></label> {{ currentAluno.description }}
        </div>
        <div>
          <label><strong>Status:</strong></label> {{ currentAluno.published ? "Published" : "Pending" }}
        </div>

        <a class="badge badge-warning"
          :href="'/aluno/' + currentAluno.id"
        >
          Edit
        </a>
      </div>
      <div v-else>
        <br />
        <p>Please click on a Aluno...</p>
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
      currentTutorial: null,
      currentIndex: -1,
      title: ""
    };
  },
  methods: {
    retrieveTutorials() {
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