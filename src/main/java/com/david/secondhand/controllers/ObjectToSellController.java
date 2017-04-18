package com.david.secondhand.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.david.secondhand.entities.ObjectToSell;
import com.david.secondhand.services.ObjectToSellService;

@RestController
public class ObjectToSellController {
	
	@Autowired
	private ObjectToSellService objectToSellService;
	
	@RequestMapping(value="/objects/all", method=RequestMethod.GET)
	@ResponseBody
	public List<ObjectToSell> getAllObjects() {
		return objectToSellService.getAllObjects();
	}

}
