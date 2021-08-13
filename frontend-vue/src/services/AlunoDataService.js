import http from "../http-common";

class AlunoDataService {
  getAll() {
    return http.get("/aluno/");
  }

  get(id) {
    return http.get(`/aluno/${id}`);
  }

  getTurmas(id) {
    return http.get(`/aluno/${id}/turmas`);
  }

  create(data) {
    return http.post(`/aluno/`, data);
  }

  update(id, data) {
    return http.put(`/aluno/${id}`, data);
  }

  delete(id) {
    return http.delete(`/aluno/${id}`);
  }

  deleteAll() {
    return http.delete(`/aluno/`);
  }

  findByTitle(title) {
    return http.get(`/aluno?nome=${title}`) || http.get(`/aluno?idade=${title}`) || http.get(`/aluno?sexo=${title}`);
  }
}

export default new AlunoDataService();