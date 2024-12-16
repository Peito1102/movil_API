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

}
