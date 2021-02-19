package br.com.primeirocrudspring.springbootcommsql.repository;

import br.com.primeirocrudspring.springbootcommsql.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
