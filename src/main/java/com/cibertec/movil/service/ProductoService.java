package com.cibertec.movil.service;

import java.util.List;

import com.cibertec.movil.entity.Producto;

public interface ProductoService {
	List<Producto> findByProovedor(Integer idProveedor);
	public Producto insertarProducto(Producto producto);
	public Producto ActualizarProducto(Producto producto);
	void eliminarProducto(Integer idProducto);
    List<Producto> listarTodosProductos();
    List<Producto> buscarProductoPorNombre(String nombre);
	
}
