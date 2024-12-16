package com.cibertec.movil.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.movil.entity.Producto;
import com.cibertec.movil.entity.Proveedor;

import java.util.List;


public interface ProductoRepository extends JpaRepository<Producto,Integer> {
	List<Producto> findByProveedor(Proveedor proveedor);
}
