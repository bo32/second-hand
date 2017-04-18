package com.david.secondhand.controllers;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.david.secondhand.beans.ApiResponse;

@RestController
@EnableAutoConfiguration
public class HomeController {
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	@ResponseBody
    public ApiResponse home() {
        return new ApiResponse("Success", "Welcome home");
    }
	
	@RequestMapping(value="/", method=RequestMethod.GET)
    public ApiResponse root() {
		return home();
    }

}
