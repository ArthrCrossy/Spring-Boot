package br.com.professores.elo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
	private PedidoRepository pedidoRepository;
	
	@GetMapping
	public String home(Model model, Principal principal) {		
	
	Sort sort = Sort.by("id").descending();
	PageRequest paginacao = PageRequest.of(0, 5, sort);
		
	List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.ENTREGUE, paginacao);
	model.addAttribute("pedidos", pedidos);
		
		return "home";
	}
	
	
}
