<template>
  <div class="submit-form">
    <div v-if="!submitted">
      <div class="form-group">
        <label for="title">Title</label>
        <input
          type="text"
          class="form-control"
          id="title"
          required
          v-model="aluno.title"
          name="title"
        />
      </div>

      <div class="form-group">
        <label for="description">Description</label>
        <input
          class="form-control"
          id="description"
          required
          v-model="aluno.description"
          name="description"
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
        id: null,
        title: "",
        description: "",
        published: false
      },
      submitted: false
    };
  },
  methods: {
    saveAluno() {
      var data = {
        title: this.aluno.title,
        description: this.aluno.description
      };

      AlunoDataService.create(data)
        .then(response => {
          this.aluno.id = response.data.id;
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