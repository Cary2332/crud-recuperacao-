package com.example.Moda.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Moda.dto.dto;
import com.example.Moda.model.model;
import com.example.Moda.repository.repository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("moda")
public class Controller {

	
	@Autowired
	repository repo;
	@GetMapping 
	public ResponseEntity<?>Getmoda(){
	List<model> Lista = repo.findAll();
	return ResponseEntity.ok(Lista);
	}

	
	@PostMapping
	public ResponseEntity<?> Postmoda (@RequestBody @Valid dto fashion){
	model newmoda = new model(fashion);
	System.out.println(fashion);
	repo.save(newmoda );
	return ResponseEntity.ok().build();
	
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<?> Updatemoda(@PathVariable ("id") Long id, @RequestBody  @Valid dto modadto){
		Optional<model> optionalmoda = repo.findById(id);
		
		if (optionalmoda.isPresent()) {
		model moda = optionalmoda.get();
		moda.setMarca(modadto.marca());
		moda.setTipo(modadto.tipo());
		moda.setPreco(modadto.preco());
			repo.save(moda);
			return ResponseEntity.ok(moda);
			
		}else {
			return ResponseEntity.notFound().build();
			
		
  }
	
	}
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> Deletemoda(@PathVariable Long id) {
       repo.deleteById(id);
	return ResponseEntity.noContent().build();
	
	}
	
}
