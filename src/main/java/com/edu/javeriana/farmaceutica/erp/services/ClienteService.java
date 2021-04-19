package com.edu.javeriana.farmaceutica.erp.services;

import java.util.List;

import com.edu.javeriana.farmaceutica.erp.etities.Cliente;
import com.edu.javeriana.farmaceutica.erp.repositories.ClienteRepository;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClienteService {
    
    private final ClienteRepository  clienteRepository;

    public Cliente obtenerCliente(Long id, Boolean habilitado) throws Exception{
        return clienteRepository.findByIdAndHabilitado(id, habilitado).orElseThrow(() -> new Exception("Clilente no existe con id:" + id));
    }

    public List<Cliente> obtenerListaClientes(Boolean habilitado){
        return clienteRepository.findAllByHabilitado(habilitado);
    }

    public Cliente registrarCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Cliente desabilitarCliente(Long id) throws Exception{
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new Exception("Clilente no existe con id:" + id));
        cliente.setHabilitado(true);
        return clienteRepository.save(cliente);
    }
}
