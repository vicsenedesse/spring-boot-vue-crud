<template>
  <div v-if="currentTurma" class="edit-form">
    <h4>Turma</h4>
    <form>
      <div class="form-group">
        <label for="title">Title</label>
        <input type="text" class="form-control" id="title"
          v-model="currentTurma.title"
        />
      </div>
      <div class="form-group">
        <label for="description">Description</label>
        <input type="text" class="form-control" id="description"
          v-model="currentTurma.description"
        />
      </div>

      <div class="form-group">
        <label><strong>Status:</strong></label>
        {{ currentTurma.published ? "Published" : "Pending" }}
      </div>
    </form>

    <button class="badge badge-primary mr-2"
      v-if="currentTurma.published"
      @click="updatePublished(false)"
    >
      UnPublish
    </button>
    <button v-else class="badge badge-primary mr-2"
      @click="updatePublished(true)"
    >
      Publish
    </button>

    <button class="badge badge-danger mr-2"
      @click="deleteTurma"
    >
      Delete
    </button>

    <button type="submit" class="badge badge-success"
      @click="updateTurma"
    >
      Update
    </button>
    <p>{{ message }}</p>
  </div>

  <div v-else>
    <br />
    <p>Please click on a Turma...</p>
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

    updatePublished(status) {
      var data = {
        id: this.currentTurma.id,
        title: this.currentTurma.title,
        description: this.currentTurma.description,
        published: status
      };

      TurmaDataService.update(this.currentTurma.id, data)
        .then(response => {
          this.currentTurma.published = status;
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