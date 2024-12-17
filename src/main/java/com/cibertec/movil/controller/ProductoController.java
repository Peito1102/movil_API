package com.cibertec.movil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	@PostMapping("/insertar")
    public ResponseEntity<Producto> insertarProducto(@RequestBody Producto producto) {
       
        Producto nuevoProducto = productoService.insertarProducto(producto);
        return ResponseEntity.status(201).body(nuevoProducto);
    }


    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Integer id, @RequestBody Producto producto) {
     
        producto.setId(id);
        Producto productoActualizado = productoService.ActualizarProducto(producto);

        return ResponseEntity.ok(productoActualizado);
    }

 
    @DeleteMapping
    ("/eliminar/{id}")
    public ResponseEntity<String> eliminarProducto(@PathVariable Integer id) {
        productoService.eliminarProducto(id);
        return ResponseEntity.ok("Producto eliminado con éxito");
    }


    @GetMapping("/listarTodos")
    public List<Producto> listarTodosProductos() {
        return productoService.listarTodosProductos();
    }
    
    @GetMapping("/buscarPorNombre/{nombre}")
    public ResponseEntity<List<Producto>> buscarProductoPorNombre(@PathVariable String nombre) {
        List<Producto> productos = productoService.buscarProductoPorNombre(nombre);
        if (productos.isEmpty()) {
            return ResponseEntity.noContent().build(); 
        }
        return ResponseEntity.ok(productos);
    }
}
