package br.com.vetornegocios.app.rest;

import br.com.vetornegocios.app.model.entity.Imovel;
import br.com.vetornegocios.app.model.repository.ImovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/imoveis")
public class ImovelController {

    private final ImovelRepository repository;

    @Autowired
    public ImovelController(ImovelRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Imovel> obterTodos(){
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Imovel salvar( @RequestBody @Valid Imovel imovel ){
        return repository.save(imovel);
    }

    @GetMapping("{id}")
    public Imovel acharPorId( @PathVariable Integer id ){
        return repository
                .findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Imovel não encontrado") );
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar( @PathVariable Integer id ){
        repository
            .findById(id)
            .map( imovel -> {
                repository.delete(imovel);
                return Void.TYPE;
            })
            .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Imovel não encontrado") );
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar( @PathVariable Integer id,
                           @RequestBody @Valid Imovel imovelAtualizado ) {
        repository
                .findById(id)
                .map( imovel -> {
                    imovel.setTitulo(imovelAtualizado.getTitulo());
                    imovel.setDescricao(imovelAtualizado.getDescricao());
                    imovel.setTamanho(imovelAtualizado.getTamanho());
                    return repository.save(imovel);
                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Imovel não encontrado") );
    }
}
