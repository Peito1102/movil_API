package com.cibertec.movil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.movil.entity.Producto;
import com.cibertec.movil.service.ProductoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/url/producto")
@RequiredArgsConstructor
public class ProductoController {

	@Autowired
    private ProductoService productoService;
	
	@GetMapping("/listarPorProveedor/{idProveedor}")
    public List<Producto> listarPorProveedor(@PathVariable Integer idProveedor) {
        return productoService.findByProovedor(idProveedor);
    }
	
}
