package com.cibertec.movil.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.movil.entity.DetallePedido;
import com.cibertec.movil.entity.Pedido;
import com.cibertec.movil.repository.PedidoRepository;

@Service
public class PedidoServiceImpl implements PedidoService {
	@Autowired
	private PedidoRepository pedidoRepository;

	@Override
	public List<Pedido> findAll() {
		return pedidoRepository.findAll();
	}

	@Override
	public Pedido findById(Integer idPedido) {
		return pedidoRepository.findById(idPedido).orElseThrow();
	}
	
	@Override
	public Pedido insertar(Pedido pedido) {
		List<DetallePedido> listaDP = pedido.getDetallesPedido();
		pedido.setDetallesPedido(null);
		pedido.setFechaCreacion(new Date());
		pedido.setEstado(0);
		Pedido pedidoRegistrado = pedidoRepository.save(pedido);
		listaDP.forEach(dp -> {
			dp.setPedido(pedidoRegistrado);
		});
		pedidoRegistrado.setDetallesPedido(listaDP);
		return pedidoRepository.save(pedidoRegistrado);
	}
	
}
