package br.com.vetornegocios.app.rest;

import br.com.vetornegocios.app.model.entity.Imovel;
import br.com.vetornegocios.app.model.repository.EnderecoRepository;
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

    private final ImovelRepository imovelRepository;

    private final EnderecoRepository enderecoRepository;

    @Autowired
    public ImovelController( ImovelRepository imovelRepository, EnderecoRepository enderecoRepository ) {
        this.imovelRepository = imovelRepository;
        this.enderecoRepository = enderecoRepository;
    }

    @GetMapping
    public List<Imovel> obterTodos(){
        return imovelRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Imovel salvar( @RequestBody @Valid Imovel imovel ){
        return imovelRepository.save(imovel);
    }

    @GetMapping("{id}")
    public Imovel acharPorId( @PathVariable Integer id ){
        return imovelRepository
                .findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Imovel não encontrado") );
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar( @PathVariable Integer id ){
        imovelRepository
            .findById(id)
            .map( imovel -> {
                imovelRepository.delete(imovel);
                return Void.TYPE;
            })
            .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Imovel não encontrado") );
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar( @PathVariable Integer id,
                           @RequestBody @Valid Imovel imovelAtualizado ) {
        imovelRepository
                .findById(id)
                .map( imovel -> {
                    imovel.setTitulo(imovelAtualizado.getTitulo());
                    imovel.setDescricao(imovelAtualizado.getDescricao());
                    imovel.setPreco(imovelAtualizado.getPreco());
                    imovel.setComissao(imovelAtualizado.getComissao());
                    imovel.setDormitorios(imovelAtualizado.getDormitorios());
                    imovel.setSuites(imovelAtualizado.getSuites());
                    imovel.setQuintal(imovelAtualizado.getQuintal());
                    imovel.setFrente(imovelAtualizado.getFrente());
                    imovel.setTamanho(imovelAtualizado.getTamanho());
                    imovel.setExtra(imovelAtualizado.getExtra());
                    return imovelRepository.save(imovel);
                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Imóvel não encontrado") );

        enderecoRepository
                .findById(imovelAtualizado.getEndereco().getId())
                .map( endereco -> {
                    endereco.setRua(imovelAtualizado.getEndereco().getRua());
                    endereco.setNumero(imovelAtualizado.getEndereco().getNumero());
                    endereco.setBairro(imovelAtualizado.getEndereco().getBairro());
                    endereco.setCidade(imovelAtualizado.getEndereco().getCidade());
                    endereco.setCep(imovelAtualizado.getEndereco().getCep());
                    return enderecoRepository.save(endereco);
                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereço não encontrado") );

    }
}
