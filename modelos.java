package controller;
import java.util.Scanner;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
public class modelos {
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
	}
		
		 @Id
		
		    private Long id;

		    private String titulo;
		    private String autor;
		    private int ano;

		    // Getters e Setters

		    public Long getId() {
		        return id;
		    }

		    public void setId(Long id) {
		        this.id = id;
		    }

		    public String getTitulo() {
		        return titulo;
		    }

		    public void setTitulo(String titulo) {
		        this.titulo = titulo;
		    }

		    public String getAutor() {
		        return autor;
		    }

		    public void setAutor(String autor) {
		        this.autor = autor;
		    }

		    public int getAno() {
		        return ano;
		    }

		    public void setAno(int ano) {
		        this.ano = ano;
		    }
	
		
	}

