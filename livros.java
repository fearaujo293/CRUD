package repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public class livros {

	@Repository
	public interface LivroRepository extends JpaRepository<livros,Long> {
	
		 
	}

	  private String titulo;
	    private String autor;
	    private int ano;
	
	public String getTitulo() {
        return getTitulo();
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
