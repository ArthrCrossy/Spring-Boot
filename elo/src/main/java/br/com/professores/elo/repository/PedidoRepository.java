package br.com.professores.elo.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.professores.elo.model.Pedido;
import br.com.professores.elo.model.StatusPedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	List<Pedido> findByStatus(StatusPedido valueOf);


	
	/*
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Pedido> recuperaTodosOsPedidos(){
		
		Query query = entityManager.createQuery("select p from Pedido p", Pedido.class);
		return query.getResultList();
	}*/
	
	
}
