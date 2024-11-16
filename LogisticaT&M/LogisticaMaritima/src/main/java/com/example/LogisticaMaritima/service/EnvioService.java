package com.example.LogisticaMaritima.service;

import com.example.LogisticaMaritima.model.Envio;
import com.example.LogisticaMaritima.repository.EnvioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnvioService {

    @Autowired
    private EnvioRepository envioRepository;

    public List<Envio> obtenerAllEnvios(){
        return envioRepository.findAll();
    }

    public Envio guardarEnvio(Envio envio){
        return envioRepository.save(envio);
    }

    public Envio obtenerEnvioPorId(Long id){
        return envioRepository.findById(id).orElseThrow(() -> new RuntimeException("Envio no encontrado."));
    }

    public void borrarEnvio(Long id){
        Optional<Envio> envio = envioRepository.findById(id);
        if(envio.isPresent()){
            envioRepository.deleteById(id);
        }else{
            throw new RuntimeException("El envio con id "+id+" No fue encontrado");
        }
    }

    public Envio precioEnvio(Envio envio){
        envio.setPrecioEnvio(envio.getPrecioEnvio());

        double descuento=0;
        if(envio.getCantidadProducto()>10){
            descuento = envio.getPrecioEnvioFinal() * 0.3;
        }

        envio.setDescuentoEnvio(descuento);
        envio.setPrecioEnvioFinal(envio.getPrecioEnvio() - descuento);
        return envioRepository.save(envio);

    }

}
