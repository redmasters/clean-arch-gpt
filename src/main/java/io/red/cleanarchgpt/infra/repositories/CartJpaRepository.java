package io.red.cleanarchgpt.infra.repositories;

import io.red.cleanarchgpt.core.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartJpaRepository extends JpaRepository<Cart, Long>{
}
