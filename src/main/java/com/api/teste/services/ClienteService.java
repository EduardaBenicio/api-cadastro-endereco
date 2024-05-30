package com.api.teste.services;

import com.api.teste.model.Cliente;
import com.api.teste.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

    public List<Cliente> findAll(){

        return clienteRepository.findAll();
    }

    public Cliente save(Cliente cliente){

        return clienteRepository.save(cliente);
    }

    public Cliente update(Cliente cliente){

        return clienteRepository.save(cliente);
    }

    public Cliente findById(Long id){
        if(clienteRepository.findById(id).isPresent()){
            return clienteRepository.findById(id).get();
        }else{
            return null;
        }
    }

    //DELETE CLIENT
    public void  delete(Long id){
        clienteRepository.deleteById(id);
    }
}
