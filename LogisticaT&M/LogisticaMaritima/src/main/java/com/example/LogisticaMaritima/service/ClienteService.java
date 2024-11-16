package com.example.LogisticaMaritima.service;

import com.example.LogisticaMaritima.model.Cliente;
import com.example.LogisticaMaritima.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> obtenerAllClientes(){
        return clienteRepository.findAll();
    }

    public Cliente guardarCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Cliente obtenerClientePorId(Long id){
        return clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente/Usuario no encontrados."));
    }

    public void borrarCliente(Long id){
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if(cliente.isPresent()){
            clienteRepository.deleteById(id);
        }else{
            throw new RuntimeException("El ID" + id + "no se pudo encontrar");
        }
    }

}
