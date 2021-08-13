<template>
  <div id="app">
    <nav class="navbar navbar-expand navbar-dark bg-dark">
      <router-link to="/" class="navbar-brand"></router-link>
      <div class="navbar-nav mr-auto">
        <li class="nav-item">
          <router-link to="/aluno" class="nav-link" style="margin-right: 30px;">Alunos</router-link>
        </li>
        <li class="nav-item">
          <router-link to="/add/aluno" class="nav-link" style="margin-right: 30px;">Adicionar Alunos</router-link>
        </li>

        <li class="nav-item">
          <router-link to="/turma" class="nav-link" style="margin-right: 30px;">Turma</router-link>
        </li>

        <li class="nav-item">
          <router-link to="/add/turma" class="nav-link" >Adicionar Turmas</router-link>
        </li>

      </div>
    </nav>

    <div class="container mt-3">
      <router-view />
    </div>
  </div>
</template>

<script>
export default {
  name: "app"
};
</script>