package com.cibertec.movil.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.movil.entity.Producto;
import com.cibertec.movil.entity.Proveedor;
import com.cibertec.movil.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {
	@Autowired
	private ProductoRepository productoRepository;

	@Override
	public List<Producto> findByProovedor(Integer idProveedor) {
		Proveedor proveedor = new Proveedor();
		proveedor.setId(idProveedor);
		return productoRepository.findByProveedor(proveedor);
	}

	@Override
	public Producto insertarProducto(Producto producto) {
		return productoRepository.save(producto);
	
	}

	@Override
	public Producto ActualizarProducto(Producto producto) {
		Producto productoExistente = productoRepository.findById(producto.getId())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + producto.getId()));

        productoExistente.setNombre(producto.getNombre());
        productoExistente.setDescripcion(producto.getDescripcion());
        productoExistente.setImagen(producto.getImagen());
        productoExistente.setStock(producto.getStock());
        productoExistente.setPrecioVenta(producto.getPrecioVenta());
        productoExistente.setPrecioCosto(producto.getPrecioCosto());
        productoExistente.setProveedor(producto.getProveedor());

        return productoRepository.save(productoExistente);
	}

	@Override
	public void eliminarProducto(Integer idProducto) {
		Producto producto = productoRepository.findById(idProducto)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + idProducto));

        productoRepository.delete(producto);
		
	}

	@Override
	public List<Producto> listarTodosProductos() {
		return productoRepository.findAll();
	}

	@Override
	public List<Producto> buscarProductoPorNombre(String nombre) {
		return productoRepository.findByNombreStartingWithIgnoreCase(nombre);
	}

}
