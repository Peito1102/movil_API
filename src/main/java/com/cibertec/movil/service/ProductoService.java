package com.cibertec.movil.service;

import java.util.List;

import com.cibertec.movil.entity.Producto;

public interface ProductoService {
	List<Producto> findByProovedor(Integer idProveedor);
	
}
