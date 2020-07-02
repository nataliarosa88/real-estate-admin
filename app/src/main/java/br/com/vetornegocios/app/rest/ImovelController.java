package br.com.vetornegocios.app.rest;

import br.com.vetornegocios.app.model.entity.Imovel;
import br.com.vetornegocios.app.model.entity.Proprietario;
import br.com.vetornegocios.app.model.entity.Tipo;
import br.com.vetornegocios.app.model.repository.EnderecoRepository;
import br.com.vetornegocios.app.model.repository.ImovelRepository;
import br.com.vetornegocios.app.model.repository.ProprietarioRepository;
import br.com.vetornegocios.app.model.repository.TipoRepository;
import br.com.vetornegocios.app.rest.dto.ImovelDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/imoveis")
@RequiredArgsConstructor
public class ImovelController {

    private final ImovelRepository imovelRepository;

    private final EnderecoRepository enderecoRepository;

    private final ProprietarioRepository proprietarioRepository;

    private final TipoRepository tipoRepository;

    @GetMapping
    public List<Imovel> obterTodos(){
        return imovelRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Imovel salvar(@RequestBody @Valid ImovelDTO dto){

        Integer proprietarioId = dto.getProprietario().getId();
        Integer tipoId = dto.getTipo().getId();

        Proprietario proprietario = proprietarioRepository
                        .findById(proprietarioId)
                        .orElseThrow(() ->
                                new ResponseStatusException(
                                        HttpStatus.BAD_REQUEST, "Proprietário inexistente"));

        Tipo tipo = tipoRepository
                .findById(tipoId)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.BAD_REQUEST, "Tipo inexistente"));

        return imovelRepository.save( Imovel.builder()
                .id(dto.getId())
                .banheiros(dto.getBanheiros())
                .comissao(dto.getComissao())
                .condominio(dto.getCondominio())
                .descricao(dto.getDescricao())
                .dormitorios(dto.getDormitorios())
                .endereco(dto.getEndereco())
                .extra(dto.getExtra())
                .frente(dto.getFrente())
                .preco(dto.getPreco())
                .quintal(dto.getQuintal())
                .suites(dto.getSuites())
                .tamanho(dto.getTamanho())
                .titulo(dto.getTitulo())
                .endereco(dto.getEndereco())
                .proprietario(proprietario)
                .tipo(tipo)
                .build());
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
    @ResponseStatus(HttpStatus.OK)
    public Imovel atualizar( @PathVariable Integer id,
                           @RequestBody @Valid Imovel imovelAtualizado ) {

        Proprietario proprietario = proprietarioRepository
                .findById(imovelAtualizado.getProprietario().getId())
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.BAD_REQUEST, "Proprietário inexistente"));

        Tipo tipo = tipoRepository
                .findById(imovelAtualizado.getTipo().getId())
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.BAD_REQUEST, "Tipo inexistente"));

       Imovel imovel = imovelRepository
                .findById(id)
                .map( i -> {
                    i.setTitulo(imovelAtualizado.getTitulo());
                    i.setDescricao(imovelAtualizado.getDescricao());
                    i.setPreco(imovelAtualizado.getPreco());
                    i.setComissao(imovelAtualizado.getComissao());
                    i.setCondominio(imovelAtualizado.getCondominio());
                    i.setDormitorios(imovelAtualizado.getDormitorios());
                    i.setSuites(imovelAtualizado.getSuites());
                    i.setBanheiros(imovelAtualizado.getBanheiros());
                    i.setQuintal(imovelAtualizado.getQuintal());
                    i.setFrente(imovelAtualizado.getFrente());
                    i.setTamanho(imovelAtualizado.getTamanho());
                    System.out.println(i.getTipo());
                    System.out.println(i.getProprietario());
                    System.out.println(imovelAtualizado.getTipo());
                    System.out.println(imovelAtualizado.getProprietario());
                    i.setTipo(tipo);
                    i.setProprietario(proprietario);
                    i.setExtra(imovelAtualizado.getExtra());
                    return imovelRepository.save(i);
                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Imóvel não encontrado") );

        enderecoRepository
                .findById(imovelAtualizado.getEndereco().getId())
                .map( e -> {
                    e.setRua(imovelAtualizado.getEndereco().getRua());
                    e.setNumero(imovelAtualizado.getEndereco().getNumero());
                    e.setBairro(imovelAtualizado.getEndereco().getBairro());
                    e.setCidade(imovelAtualizado.getEndereco().getCidade());
                    e.setCep(imovelAtualizado.getEndereco().getCep());
                    return enderecoRepository.save(e);
                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereço não encontrado") );

        return imovel;
    }
}
