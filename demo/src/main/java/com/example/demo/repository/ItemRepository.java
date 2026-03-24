package com.example.demo.repository;

import com.example.demo.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Da a acceso a los datos
@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {
    
}