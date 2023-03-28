package edu.alumini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.alumini.dto.AluminiDTO;
import edu.alumini.entity.Alumini;
import edu.alumini.service.AluminiService;


@RestController
public class AluminiController 
{
	@Autowired
	private AluminiService aluminiService;
	
	// Getting all existing alumini
	
	@GetMapping("/stud")
	public List<Alumini> fetchAllDepartment()
	{
		return aluminiService.getAllAlumini();
	}
	
	//Get a single Alumini by Id
	
	@GetMapping("/stud/{sid}")
	public Alumini getAlumini(@PathVariable int id)
	{
		return aluminiService.getAluminiById(id);
	}
	
	//Creating new Alumini
	
	@PostMapping("/stud")
	public Alumini createAlumini(AluminiDTO aluminiDTO)
	{
		return aluminiService.createAlumini(aluminiDTO);
	}
	
//	// Update a Alumini

	@PutMapping("/Alumini/{id}")
	public Alumini updateAlumini(@PathVariable int id, @RequestBody AluminiDTO aluminiDTO)
	//public Alumini updateAlumini(@PathVariable String id, @RequestBody Alumini Alumini) 
	{
		return aluminiService.updateAlumini(id, aluminiDTO);
	}

	//Deleting a Alumini record
	@DeleteMapping( "/Alumini/{id}")
	public String deleteAlumini(@PathVariable int id)
	{
		return aluminiService.deleteAlumini(id);
	}


}









//create a new Alumini
//	@PostMapping(value = "/Alumini")
//	public Alumini create(@RequestBody Alumini Alumini) {
//		return AluminiService.createAlumini(Alumini);
//
//	}

