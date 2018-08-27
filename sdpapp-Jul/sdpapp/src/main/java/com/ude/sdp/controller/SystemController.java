package com.ude.sdp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ude.sdp.dto.ResultDTO;
import com.ude.sdp.dto.UserAuthDTO;
import com.ude.sdp.dto.UserDTO;
import com.ude.sdp.service.SystemService;

@RestController
@RequestMapping("systemController")
public class SystemController {

	@Autowired
	SystemService service;
	
	
}
