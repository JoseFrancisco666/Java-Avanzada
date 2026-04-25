package com.tienda.ecommerce.repository;

import com.tienda.ecommerce.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}