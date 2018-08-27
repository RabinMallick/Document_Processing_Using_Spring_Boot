package com.ude.sdp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ude.sdp.model.Reference;
import com.ude.sdp.repository.ReferenceRepository;

@RestController
public class ReferenceController {
	@Autowired
	ReferenceRepository refRepo;
	
	@RequestMapping("/find_all_ref")
	public List<Reference> findALl(){
		return refRepo.findAll();
	}
	
	@RequestMapping("/save_ref")
	public void saveRef() {
		Reference ref = new Reference();
		ref.setTitle("Title");
		ref.setYear("2018");
		refRepo.save(ref);
	}
}
