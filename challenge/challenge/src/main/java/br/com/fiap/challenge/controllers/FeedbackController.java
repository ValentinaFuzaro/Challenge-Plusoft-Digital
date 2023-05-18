package br.com.fiap.challenge.controllers;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.challenge.exception.RestNotFoundException;
import br.com.fiap.challenge.models.Feedback;
import br.com.fiap.challenge.models.Usuario;
import br.com.fiap.challenge.models.RestError;
import br.com.fiap.challenge.repository.FeedbackRepository;
import br.com.fiap.challenge.repository.UsuarioRepository;
import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/feedbacks")
public class FeedbackController {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired // IoD IoC
    FeedbackRepository repository;

    @GetMapping
    public List<Feedback> index(){
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Feedback> create(@RequestBody @Valid Feedback feedback){
        log.info("cadastrando Feedback: " + feedback);
        repository.save(feedback);
        return ResponseEntity.status(HttpStatus.CREATED).body(feedback);
    }

    @GetMapping("{id}")
    public ResponseEntity<Feedback> show(@PathVariable Long id){
        log.info("buscando feedback com id " + id);
        return ResponseEntity.ok(getFeedback(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Feedback> destroy(@PathVariable Long id){
        log.info("apagando feedback com id " + id);
        repository.delete(getFeedback(id));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Feedback> update(@PathVariable Long id, @RequestBody @Valid Feedback feedback){
        log.info("alterando feedback com id " + id);
        getFeedback(id);
        Feedback.setId(id);
        repository.save(feedback);
        return ResponseEntity.ok(feedback);
    }

    private Feedback getFeedback(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.FORBIDDEN, "Feedback não encontrada"));
    }

}