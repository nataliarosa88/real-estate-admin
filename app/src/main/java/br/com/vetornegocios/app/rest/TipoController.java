package br.com.vetornegocios.app.rest;

import br.com.vetornegocios.app.model.entity.Tipo;
import br.com.vetornegocios.app.model.repository.TipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tipos")
public class TipoController {

    private final TipoRepository repository;

    @Autowired
    public TipoController(TipoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Tipo> obterTodos(){
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Tipo salvar( @RequestBody @Valid Tipo tipo ){

        return repository.save(tipo);
    }

    @GetMapping("{id}")
    public Tipo acharPorId( @PathVariable Integer id ){
        return repository
                .findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tipo não encontrado") );
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar( @PathVariable Integer id ){
        repository
            .findById(id)
            .map( tipo -> {
                repository.delete(tipo);
                return Void.TYPE;
            })
            .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tipo não encontrado") );
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar( @PathVariable Integer id,
                           @RequestBody @Valid Tipo tipoAtualizado ) {
        repository
                .findById(id)
                .map( tipo -> {
                    tipo.setNome(tipoAtualizado.getNome());
                    return repository.save(tipo);
                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tipo não encontrado") );
    }
}
