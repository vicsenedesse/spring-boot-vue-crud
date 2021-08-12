<template>
  <div v-if="currentAluno" class="edit-form">
    <h4>Aluno</h4>
    <form>
      <div class="form-group">
        <label for="title">Title</label>
        <input type="text" class="form-control" id="title"
          v-model="currentAluno.title"
        />
      </div>
      <div class="form-group">
        <label for="description">Description</label>
        <input type="text" class="form-control" id="description"
          v-model="currentAluno.description"
        />
      </div>

      <div class="form-group">
        <label><strong>Status:</strong></label>
        {{ currentAluno.published ? "Published" : "Pending" }}
      </div>
    </form>

    <button class="badge badge-primary mr-2"
      v-if="currentAluno.published"
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
      @click="deleteAluno"
    >
      Delete
    </button>

    <button type="submit" class="badge badge-success"
      @click="updateAluno"
    >
      Update
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

    updatePublished(status) {
      var data = {
        id: this.currentAluno.id,
        title: this.currentAluno.title,
        description: this.currentAluno.description,
        published: status
      };

      AlunoDataService.update(this.currentAluno.id, data)
        .then(response => {
          this.currentAluno.published = status;
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