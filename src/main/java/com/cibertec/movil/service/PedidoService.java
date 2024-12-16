package com.cibertec.movil.service;

import java.util.List;

import com.cibertec.movil.entity.Pedido;

public interface PedidoService {
	List<Pedido> findAll();
	Pedido findById(Integer idPedido);
	Pedido insertar(Pedido pedido);
}
