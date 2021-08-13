import http from "../http-common";

class TurmaDataService {
  getAll() {
    return http.get("/turma/");
  }

  get(id) {
    return http.get(`/turma/${id}`);
  }

  getAlunos(id) {
    return http.get(`/turma/${id}/alunos`);
  }

  create(data) {
    return http.post("/turma/", data);
  }

  update(id, data) {
    return http.put(`/turma/${id}`, data);
  }

  delete(id) {
    return http.delete(`/turma/${id}`);
  }

  deleteAll() {
    return http.delete(`/turma/`);
  }

  findByTitle(title) {
    return http.get(`/turma?nome=${title}`) || http.get(`/turma?qnt_vagas=${title}`) || http.get(`/turma?horario=${title}`);
  }
}

export default new TurmaDataService();