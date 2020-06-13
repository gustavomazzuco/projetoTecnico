package com.projetoTecnico.controller;

import com.projetoTecnico.error.CustomErrorType;
import com.projetoTecnico.model.Cliente;
import com.projetoTecnico.model.Endereco;
import com.projetoTecnico.repository.ClienteRepository;
import com.projetoTecnico.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteDAO;

    @GetMapping(path = "/lista")
    public List<Cliente> listAll(){
        return this.clienteDAO.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getClienteById(@PathVariable("id") Long id){
        Optional<Cliente> cliente =  clienteDAO.findById(id);
        if(cliente == null){
            return new ResponseEntity<>(new CustomErrorType("Cliente não encontrado"), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody Cliente cliente){
        return new ResponseEntity<>(clienteDAO.save(cliente), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Cliente cliente){
        clienteDAO.save(cliente);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        clienteDAO.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
