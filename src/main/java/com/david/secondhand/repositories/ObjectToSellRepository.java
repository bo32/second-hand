package com.david.secondhand.repositories;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;

import com.david.secondhand.entities.ObjectToSell;

public interface ObjectToSellRepository extends JpaRepository<ObjectToSell, Long> {
	
	public Stream<ObjectToSell> findAllObjectsToSell();

}
