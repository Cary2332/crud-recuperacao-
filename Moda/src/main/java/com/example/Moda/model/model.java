package com.example.Moda.model;

import com.example.Moda.dto.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "fashion")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class model {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	
	private Long id;
	private String tipo;
	private String marca;
	private Double preco;
	

public model(dto request){
	
	this.id = request.Id();
	this.marca = request.marca();
	this.preco = request.preco();
	this.tipo = request.tipo();
	
	
	
	
	
 }

}