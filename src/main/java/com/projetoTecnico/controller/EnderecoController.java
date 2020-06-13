package com.projetoTecnico.controller;

import com.projetoTecnico.error.CustomErrorType;
import com.projetoTecnico.model.Endereco;
import com.projetoTecnico.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    private final EnderecoRepository enderecoDAO;
    @Autowired
    public EnderecoController(EnderecoRepository enderecoDAO) {
        this.enderecoDAO = enderecoDAO;
    }

    @GetMapping(path = "/lista")
    public ResponseEntity<?> listAll(){
        return new ResponseEntity<>(enderecoDAO.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getEnderecoById(@PathVariable("id") Long id){
        Optional<Endereco> endereco = enderecoDAO.findById(id);
        if(endereco == null){
            return new ResponseEntity<>(new CustomErrorType("Endereco não encontrado"), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(endereco, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody Endereco endereco){
        return new ResponseEntity<>(enderecoDAO.save(endereco), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Endereco endereco){
        enderecoDAO.save(endereco);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        enderecoDAO.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
