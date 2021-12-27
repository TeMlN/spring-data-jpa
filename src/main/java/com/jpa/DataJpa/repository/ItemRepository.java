package com.jpa.DataJpa.repository;

import com.jpa.DataJpa.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
