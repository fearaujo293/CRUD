package controller;



import java.util.List;
import controller.modelos;
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

import repositorio.livros;
import repositorio.livros.LivroRepository;

@RestController
@RequestMapping("/api/livros")
public class controlador {

    @Autowired
    private LivroRepository livroRepository;

    @GetMapping
    public List<livros> listarTodos() {
        return livroRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<livros> buscarPorId(@PathVariable Long id) {
        return livroRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public livros criar(@RequestBody livros livro) {
        return livroRepository.save(livro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<livros> atualizar(@PathVariable Long id, @RequestBody livros livroAtualizado) {
        return livroRepository.findById(id)
                .map(livroExistente -> {
                    livroExistente.setTitulo(livroAtualizado.getTitulo());
                    livroExistente.setAutor(livroAtualizado.getAutor());
                    livroExistente.setAno(livroAtualizado.getAno());
                    return ResponseEntity.ok(livroRepository.save(livroExistente));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletar(@PathVariable Long id) {
        return livroRepository.findById(id)
                .map(livro -> {
                    livroRepository.delete(livro);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
