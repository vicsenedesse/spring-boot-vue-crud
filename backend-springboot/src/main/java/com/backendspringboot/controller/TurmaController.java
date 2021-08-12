package com.controller;


import com.controller.dto.TurmaRq;
import com.controller.dto.TurmaRs;

import com.model.Turma;

import com.repository.TurmaCustomRepository;
import com.repository.TurmaRepository;

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
@RequestMapping("/api/turma") @CrossOrigin(origins = "http://localhost:4200")
public class TurmaController {

    private final TurmaRepository turmaRepository;
    private final TurmaCustomRepository turmaCustomRepository;

    public TurmaController(TurmaRepository turmaRepository, TurmaCustomRepository turmaCustomRepository) {
        this.turmaRepository = turmaRepository;
        this.turmaCustomRepository = turmaCustomRepository;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/") 
    public List<TurmaRs> findAll() {
        var turmas = turmaRepository.findAll();
        return turmas
                .stream()
                .map(TurmaRs::converter)
                .collect(Collectors.toList());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{turma_id}") 
    public TurmaRs findByTurmaId(@PathVariable("turma_id") Long turma_id) {
        var turma = turmaRepository.getOne(turma_id);
        return TurmaRs.converter(turma);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/") 
    public ResponseEntity<?> savePerson(@RequestBody TurmaRq turma) {
        var a = new Turma();
        a.setTurmaId(turma.getTurmaId());
        a.setNome(turma.getNome());
        a.setHorario(turma.getHorario());
        a.setDataInicio(turma.getDataInicio());
        a.setAlunos(turma.getAlunos());
        
        turmaRepository.save(a);
        return ResponseEntity.ok("Sucesso!");
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/{turma_id}") 
    public void updatePerson(@PathVariable("turma_id") Long turma_id, @RequestBody TurmaRq turma) throws Exception {
        var a = turmaRepository.findById(turma_id);

        if (a.isPresent()) {
            var turmaSave = a.get();
            turmaSave.setNome(turma.getNome());
            turmaSave.setHorario(turma.getHorario());
            turmaSave.setDataInicio(turma.getDataInicio());
            turmaSave.setQuantVagas(turma.getQuantVagas());
            turmaSave.setAlunos(turma.getAlunos());
            turmaRepository.save(turmaSave);
        } else {
            throw new Exception("Turma Não encontrado");
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/filter") 
    public List<TurmaRs> findTurmaByName(@RequestParam("nome") String nome) {
        return this.turmaRepository.findByNameContains(nome)
                .stream()
                .map(TurmaRs::converter)
                .collect(Collectors.toList());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/filter/custom") 
    public List<TurmaRs> findTurmaByCustom(
            @RequestParam(value = "quant_vagas", required = false) Long quant_vagas,
            @RequestParam(value = "horario", required = false) String horario
    ) {
        return this.turmaCustomRepository.find(quant_vagas, horario)
                .stream()
                .map(TurmaRs::converter)
                .collect(Collectors.toList());
    }

}