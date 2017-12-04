package com.boaglio.casadocodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boaglio.casadocodigo.domain.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
