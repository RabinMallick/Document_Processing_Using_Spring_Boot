package com.ude.sdp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ude.sdp.dto.ResultDTO;
import com.ude.sdp.dto.UserAuthDTO;
import com.ude.sdp.service.SystemService;

@RestController
@RequestMapping("/loginController/")
@CrossOrigin
public class LoginController {

	@Autowired
	private SystemService service;

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public ResponseEntity<ResultDTO> logout(@RequestBody UserAuthDTO userAuthDTO) {
		ResultDTO dto = null;
		try {
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<ResultDTO>(dto, HttpStatus.OK);
	}
	

	
}
