package com.example.LogisticaMaritima.controller;

import com.example.LogisticaMaritima.model.Cliente;
import com.example.LogisticaMaritima.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> obtenerAllClientes(){
        return clienteService.obtenerAllClientes();
    }

    @PostMapping
    public Cliente guardarCliente(@RequestBody Cliente cliente){
        return clienteService.guardarCliente(cliente);
    }

    @GetMapping
    public Cliente obtenerClientePorId(@PathVariable Long id){
        return clienteService.obtenerClientePorId(id);
    }

    @DeleteMapping
    public String borrarCliente(@PathVariable Long id){
        clienteService.borrarCliente(id);
        return "El cliente "+id+" se elimino correctamente.";
    }

}
