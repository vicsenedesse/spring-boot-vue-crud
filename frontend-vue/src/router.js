import Vue from "vue";
import Router from "vue-router";

Vue.use(Router);

export default new Router({
  mode: "history",
  routes: [
    {
      path: "/",
      alias: "/aluno",
      name: "aluno",
      component: () => import("../src/components/ListAluno")
    },
    {
      path: "/aluno/:id",
      name: "aluno-details",
      component: () => import("./components/Aluno")
    },
    {
      path: "/add/aluno",
      name: "add-aluno",
      component: () => import("./components/AddAluno")
    },
    // {
    //   path: "/aluno/:id/turmas",
    //   name: "aluno-turmas",
    //   component: () => import("./components/Aluno")
    // },


    {
      path: "/turma",
      // alias: "/turma",
      name: "turma",
      component: () => import("../src/components/ListTurma")
    },
    {
      path: "/turma/:id",
      name: "turma-details",
      component: () => import("./components/Turma")
    },
    {
      path: "/add/turma",
      name: "add-turma",
      component: () => import("./components/AddTurma")
    },
    // {
    //   path: "/aluno-turma/:id/alunos",
    //   name: "turmas-aluno",
    //   component: () => import("./components/Turma")
    // },
  ]
});
