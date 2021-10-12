package br.com.professores.elo.dto;

import br.com.professores.elo.model.Pedido;
import br.com.professores.elo.model.StatusPedido;

import javax.validation.constraints.NotBlank;



public class RequisicaoNovoPedido {
	
	@NotBlank()//NotBlank.requisicao
	private String nome;
	
	@NotBlank
	private String usuario;
	@NotBlank
	private String disciplina;
	
	private String email;
	
		
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
	
	public Pedido toPedido() {
		
		Pedido pedido = new Pedido();
		pedido.setNome(nome);
		pedido.setUsuario(usuario);
		pedido.setDisciplina(disciplina);
		pedido.setStatus(StatusPedido.AGUARDANDO);
		
		return pedido;
	}
	
}
