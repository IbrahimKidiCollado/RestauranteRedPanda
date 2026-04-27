package com.redpanda.restaurante.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.redpanda.restaurante.entity.LineaPedido;

public interface LineaPedidoRepository  extends JpaRepository<LineaPedido, Long> {

    
} 