package br.com.professores.elo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.professores.elo.model.Pedido;
import br.com.professores.elo.repository.PedidoRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import java.util.Arrays;
//import br.com.professores.elo.model.Pedido;


@Controller
public class homeController {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping("/home")
	
	public String home(Model model) {
		
	List<Pedido> pedidos = pedidoRepository.findAll();
	model.addAttribute("pedidos", pedidos);
		
		return "home";
	}
	
}
