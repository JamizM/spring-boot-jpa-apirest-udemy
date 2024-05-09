package br.com.jamiz.domain.repository;

import br.com.jamiz.domain.entity.Cliente;
import br.com.jamiz.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface Pedidos extends JpaRepository<Pedido, Integer> {
    //conseguir pedidos de cliente
    List<Pedido> findByCliente(Cliente cliente);

    @Query("select p from Pedido p left join fetch p.itens where p.id = :id")
    Optional<Pedido> findByIdFetchItens(Integer id);
}
