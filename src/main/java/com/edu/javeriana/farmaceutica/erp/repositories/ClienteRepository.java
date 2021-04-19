package com.edu.javeriana.farmaceutica.erp.repositories;

import java.util.List;
import java.util.Optional;

import com.edu.javeriana.farmaceutica.erp.etities.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    public Optional<Cliente> findByIdAndHabilitado(Long id, Boolean habilitado);

    public List<Cliente> findAllByHabilitado(Boolean habilitado);
}
