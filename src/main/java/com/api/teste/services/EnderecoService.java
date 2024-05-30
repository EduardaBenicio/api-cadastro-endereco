package com.api.teste.services;

import com.api.teste.model.Endereco;
import com.api.teste.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EnderecoService {
    @Autowired
    EnderecoRepository enderecoRepository;

    public List<Endereco> findAll(){


        return enderecoRepository.findAll();
    }

    public Endereco save(Endereco endereco){

        return enderecoRepository.save(endereco);
    }

    public Endereco update(Endereco endereco){

        return enderecoRepository.save(endereco);
    }

    public Endereco findById(Long id){
        if(enderecoRepository.findById(id).isPresent()){
            return enderecoRepository.findById(id).get();
        }else{
            return null;
        }
    }

    //DELETE CLIENT
    public void  delete(Long id){
        enderecoRepository.deleteById(id);
    }
}
