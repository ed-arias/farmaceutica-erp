package com.edu.javeriana.farmaceutica.erp.controllers;

import java.util.List;

import com.edu.javeriana.farmaceutica.erp.etities.Cliente;
import com.edu.javeriana.farmaceutica.erp.services.ClienteService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/erp")
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping("/clientes")
    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente) {
        return new ResponseEntity<>(clienteService.registrarCliente(cliente), HttpStatus.OK);
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<Cliente> obtenerCliente(@PathVariable Long id, @RequestParam Boolean habilitado) throws Exception {
        return new ResponseEntity<>(clienteService.obtenerCliente(id, habilitado), HttpStatus.OK);
    }

    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> obtenerListaClientes(@RequestParam Boolean habilitado) {
        return new ResponseEntity<>(clienteService.obtenerListaClientes(habilitado), HttpStatus.OK);
    }

    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<Cliente> desabilitarCliente(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(clienteService.desabilitarCliente(id), HttpStatus.OK);
    }

}
