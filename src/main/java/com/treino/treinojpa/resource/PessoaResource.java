package com.treino.treinojpa.resource;

import com.google.gson.Gson;
import com.treino.treinojpa.model.Pessoa;
import com.treino.treinojpa.repository.CidadeRepository;
import com.treino.treinojpa.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;

@RestController
@RequestMapping("v1/pessoa")
public class PessoaResource  {
    @Autowired
    PessoaRepository pr;
    @Autowired
    CidadeRepository cr;
    @GetMapping
    public ResponseEntity<?> listaPessoa(){
        return new ResponseEntity<>(pr.findAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> inserirPessoa(@RequestBody Pessoa p){
        pr.save(p);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }
    @GetMapping("/cidades")
    public ResponseEntity<?> listaCidade(){
        return new ResponseEntity<>(cr.findAll(), HttpStatus.OK);
    }
}
