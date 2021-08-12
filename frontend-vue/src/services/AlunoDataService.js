import http from "../http-common";

class AlunoDataService {
  getAll() {
    return http.get("/aluno");
  }

  get(id) {
    return http.get(`/aluno/${id}`);
  }

  create(data) {
    return http.post("/aluno", data);
  }

  update(id, data) {
    return http.put(`/aluno/${id}`, data);
  }

  delete(id) {
    return http.delete(`/aluno/${id}`);
  }

  deleteAll() {
    return http.delete(`/aluno`);
  }

  findByTitle(title) {
    return http.get(`/aluno?title=${title}`);
  }
}

export default new AlunoDataService();