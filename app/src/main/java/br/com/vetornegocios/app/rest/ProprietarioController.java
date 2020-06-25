package br.com.vetornegocios.app.rest;

import br.com.vetornegocios.app.model.entity.Proprietario;
import br.com.vetornegocios.app.model.repository.ProprietarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/proprietarios")
public class ProprietarioController {

    private final ProprietarioRepository repository;

    @Autowired
    public ProprietarioController(ProprietarioRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Proprietario> obterTodos(){
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Proprietario salvar( @RequestBody @Valid Proprietario proprietario ){
        return repository.save(proprietario);
    }

    @GetMapping("{id}")
    public Proprietario acharPorId( @PathVariable Integer id ){
        return repository
                .findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Proprietario não encontrado") );
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar( @PathVariable Integer id ){
        repository
            .findById(id)
            .map( proprietario -> {
                repository.delete(proprietario);
                return Void.TYPE;
            })
            .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Proprietario não encontrado") );
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar( @PathVariable Integer id,
                           @RequestBody @Valid Proprietario proprietarioAtualizado ) {
        repository
                .findById(id)
                .map( proprietario -> {
                    proprietario.setNome(proprietarioAtualizado.getNome());
                    proprietario.setEmail(proprietarioAtualizado.getEmail());
                    proprietario.setTelefone(proprietarioAtualizado.getTelefone());
                    proprietario.setCelular(proprietarioAtualizado.getCelular());
                    return repository.save(proprietario);
                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Proprietario não encontrado") );
    }
}
