//package com.veterinary_clinic_adm.register.controller;
package com.controller;


import com.controller.dto.AlunoRq;
import com.controller.dto.AlunoRs;

import com.model.Aluno;

import com.repository.AlunoCustomRepository;
import com.repository.AlunoRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/aluno") @CrossOrigin(origins = "http://localhost:4200")
public class AlunoController {

    private final AlunoRepository alunoRepository;
    private final AlunoCustomRepository alunoCustomRepository;

    public AlunoController(AlunoRepository alunoRepository, AlunoCustomRepository alunoCustomRepository) {
        this.alunoRepository = alunoRepository;
        this.alunoCustomRepository = alunoCustomRepository;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/") 
    public List<AlunoRs> findAll() {
        var alunos = alunoRepository.findAll();
        return alunos
                .stream()
                .map(AlunoRs::converter)
                .collect(Collectors.toList());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{aluno_id}") 
    public AlunoRs findByAlunoId(@PathVariable("aluno_id") Long aluno_id) {
        var aluno = alunoRepository.getOne(aluno_id);
        return AlunoRs.converter(aluno);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/") 
    public ResponseEntity<?> savePerson(@RequestBody AlunoRq aluno) {
        var a = new Aluno();
        a.setId(aluno.getId());
        a.setNome(aluno.getNome());
        a.setIdade(aluno.getIdade());
        a.setNascimento(aluno.getNascimento());
        a.setTurmas(aluno.getTurmas());
        a.setSexo(aluno.getSexo());
        
        alunoRepository.save(a);
        return ResponseEntity.ok("Sucesso!");

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/{aluno_id}") 
    public void updatePerson(@PathVariable("aluno_id") Long aluno_id, @RequestBody AlunoRq aluno) throws Exception {
        var a = alunoRepository.findById(aluno_id);

        if (a.isPresent()) {
            var alunoSave = a.get();
            alunoSave.setNome(aluno.getNome());
            alunoSave.setIdade(aluno.getIdade());
            alunoSave.setNascimento(aluno.getNascimento());
            alunoSave.setSexo(aluno.getSexo());
            alunoSave.setTurmas(aluno.getTurmas());
            alunoRepository.save(alunoSave);
        } else {
            throw new Exception("Aluno Não encontrado");
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/filter") 
    public List<AlunoRs> findAlunoByName(@RequestParam("nome") String nome) {
        return this.alunoRepository.findByNameContains(nome)
                .stream()
                .map(AlunoRs::converter)
                .collect(Collectors.toList());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/filter/custom") 
    public List<AlunoRs> findAlunoByCustom(
            @RequestParam(value = "idade", required = false) Long idade,
            @RequestParam(value = "sexo", required = false) String sexo
    ) {
        return this.alunoCustomRepository.find(idade, sexo)
                .stream()
                .map(AlunoRs::converter)
                .collect(Collectors.toList());
    }

}