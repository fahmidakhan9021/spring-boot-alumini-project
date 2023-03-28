package edu.alumini.serviceImpl;

import java.util.List;
//import java.util.Optional;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.alumini.dto.AluminiDTO;
import edu.alumini.entity.Alumini;
//import edu.alumini.exception.UserNotFoundException;
import edu.alumini.repository.AluminiRepository;
import edu.alumini.service.AluminiService;


@Service
public class AluminiServiceImpl implements AluminiService 
{
	@Autowired
	private AluminiRepository aluminiRepository;

	@Override
	public List<Alumini> getAllAlumini() 
	{
		return aluminiRepository.findAll();
	}

	@Override
	public Alumini createAlumini(AluminiDTO aluminiDTO) 
	{
		Alumini alumini =Alumini.builder().name(aluminiDTO.getName()).phone(aluminiDTO.getPhone()).email(aluminiDTO.getEmail())
				.year(aluminiDTO.getYear()).address(aluminiDTO.getAddress()).build();
		
		return aluminiRepository.save(alumini);
		
	}

	@Override
	public Alumini updateAlumini(int id, AluminiDTO aluminiDTO)  
	{
		Optional <Alumini> adata= aluminiRepository.findById(id);
		if (adata.isPresent())
		{
			Alumini _alumini =aluminiRepository.findById(id).get();
			_alumini.setName(aluminiDTO.getName());
			_alumini.setPhone(aluminiDTO.getPhone());
			_alumini.setEmail(aluminiDTO.getEmail());
			_alumini.setYear(aluminiDTO.getYear());
			_alumini.setAddress(aluminiDTO.getAddress());
			
			return aluminiRepository.save(_alumini);
		}	
		else return null;
	}

	@Override
	public Alumini getAluminiById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Alumini> findByNameContaining(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Alumini> findByGraduationYear(String year) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteAlumini(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
