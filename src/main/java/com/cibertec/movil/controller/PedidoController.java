package com.cibertec.movil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.movil.entity.Pedido;
import com.cibertec.movil.service.PedidoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/url/pedido")
@RequiredArgsConstructor
public class PedidoController {

	@Autowired
    private PedidoService pedidoService;
	
	@GetMapping("/listar")
    public List<Pedido> listaTodo() {
        return pedidoService.findAll();
    }
	
	@GetMapping("/buscarPorId/{idPedido}")
    public Pedido pedidoPorId(@PathVariable Integer idPedido) {
        return pedidoService.findById(idPedido);
    }
	
	@PostMapping("/insertar")
	public Pedido insertar(@RequestBody Pedido pedido) {
		return pedidoService.insertar(pedido);
	}
}
