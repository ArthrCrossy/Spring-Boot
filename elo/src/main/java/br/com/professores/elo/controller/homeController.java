package br.com.professores.elo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.professores.elo.model.Pedido;
import br.com.professores.elo.model.StatusPedido;
import br.com.professores.elo.repository.PedidoRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import java.security.Principal;
import java.util.Arrays;
//import br.com.professores.elo.model.Pedido;


@Controller
@RequestMapping("home")
public class homeController {
	
	@Autowired
	private PedidoRepository repository;
	
	@GetMapping
	public String home(Model model, Principal principal) {		
	//List<Pedido> pedidos = repository.findAll();
		List<Pedido> pedidos = repository.findAllByUsuario(principal.getName());
	model.addAttribute("pedidos", pedidos);
		
		return "home";
	}
	
	@GetMapping("/{status}")
	public String porStatus(@PathVariable("status") String status, Model model) {
		List<Pedido> pedidos = repository.findByStatus(StatusPedido.valueOf(status.toUpperCase()));
		model.addAttribute("pedidos", pedidos);
		model.addAttribute("status", status);
		return "home"; 
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/home";
	}
	
}
