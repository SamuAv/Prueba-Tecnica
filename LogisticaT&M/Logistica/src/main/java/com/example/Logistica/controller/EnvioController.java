package com.example.Logistica.controller;

import com.example.Logistica.model.Envio;
import com.example.Logistica.service.EnvioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class EnvioController {

    @Autowired
    private EnvioService envioService;

    @GetMapping
    public List<Envio> obtenerAllEnvios(){
        return envioService.obtenerAllEnvios();
    }

    @PostMapping
    public Envio guardarEnvio(@RequestBody Envio envio){
        return envioService.guardarEnvio(envio);
    }

    @GetMapping
    public Envio obtenerEnvioPorId(@PathVariable Long id){
        return envioService.obtenerEnvioPorId(id);
    }

    @DeleteMapping
    public String borrarEnvio(@PathVariable Long id){
        envioService.borrarEnvio(id);
        return "El envio "+id+" Se elimino correctamente";
    }

}
