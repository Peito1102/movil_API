package com.cibertec.movil.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.movil.entity.Proveedor;
import com.cibertec.movil.repository.ProveedorRepository;

@Service
public class ProveedorServiceImpl implements ProveedorService{
	@Autowired
	private ProveedorRepository proveedorRepository;
	
	@Override
	public List<Proveedor> findAll() {
		return proveedorRepository.findAll();
	}
	
}
