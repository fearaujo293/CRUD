package controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import repositorio.livros;

public class livroRepository {

		@Repository
		public interface controller extends JpaRepository<livros, Long> {
		}

		}

	
		

		
		


