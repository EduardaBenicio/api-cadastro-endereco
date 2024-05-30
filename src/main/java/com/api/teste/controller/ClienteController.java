package com.api.teste.controller;

import com.api.teste.model.Cliente;
import com.api.teste.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody //RETURN JSON
//@CrossOrigin(originPatterns = "http://localhost/moduloRh/public/", allowCredentials = "true")
@RequestMapping(path = "/api/cliente")
public class ClienteController
{

    @Autowired
    ClienteService clienteService;

    @GetMapping(path = "/all")
    public ResponseEntity<List<Cliente>> listAll(){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.findAll());

    }
    //SAVE PAYMENT

    @PostMapping(path = "/save")
    public ResponseEntity<Cliente> save(@RequestBody Cliente cliente){

        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(cliente));
    }

    //FIND BY ID
    @GetMapping(path = "/{id}")
    public ResponseEntity<Cliente> find(@PathVariable Long id){

        Cliente cliente = clienteService.findById(id);

        if(cliente != null){
            return ResponseEntity.status(HttpStatus.OK).body(cliente);
        }else{
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable  Long id){
        if(clienteService.findById(id) != null){
            clienteService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("Cliente deletado com sucesso!");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente Não existe!");
        }
    }
}
