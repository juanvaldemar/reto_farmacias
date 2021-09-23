package com.valdemar.demo.model.entity;

import java.util.Date;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("Mate")
public class Mate {
	
	@Id
	private String id;
	private int primerNumero;
	private int segundoNumero;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaCreacion = new Date();

}


