package com.example.LogisticaMaritima.repository;

import com.example.LogisticaMaritima.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
