package br.com.professores.elo.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import br.com.professores.elo.model.Pedido;
import br.com.professores.elo.model.StatusPedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	
	@Cacheable("books")
	List<Pedido> findByStatus(StatusPedido status, Pageable sort);
	
	@Query("select p from Pedido p join p.user u where u.username = :username")
	List<Pedido> findAllByUsuario(@Param("username")String username);

	@Query("select p from Pedido p join p.user u where u.username = :username and p.status = :status")
	List<Pedido> findByStatusEUsuario(@Param("status")StatusPedido status, @Param("username")String username);
	
	


	
	/*
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Pedido> recuperaTodosOsPedidos(){
		
		Query query = entityManager.createQuery("select p from Pedido p", Pedido.class);
		return query.getResultList();
	}*/
	
	
}
