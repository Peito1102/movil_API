package com.cibertec.movil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.movil.entity.Proveedor;
import com.cibertec.movil.service.ProveedorService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/url/proveedor")
@RequiredArgsConstructor
public class ProveedorController {
	@Autowired
    private ProveedorService proveedorService;
	
	@GetMapping("/listar")
    public List<Proveedor> listaTodo() {
        return proveedorService.findAll();
    }

}
