package com.david.secondhand.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.david.secondhand.entities.ObjectToSell;
import com.david.secondhand.repositories.ObjectToSellRepository;

@Service
public class ObjectToSellService {
	
	@Autowired
	private ObjectToSellRepository objectToSellRepository;

	public List<ObjectToSell> getAllObjects() {
		return objectToSellRepository.findAll();
	}

}
