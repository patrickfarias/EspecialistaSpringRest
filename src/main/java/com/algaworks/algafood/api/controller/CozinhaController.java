package com.algaworks.algafood.api.controller;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cozinhas")
public class CozinhaController {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    @GetMapping
    //@GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public List<Cozinha> lista(){
        return cozinhaRepository.listar();
    }

    @GetMapping(value = "/{Id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Cozinha> buscar(@PathVariable("Id") Long id){
        Cozinha cozinha =  cozinhaRepository.buscar(id);

        if (cozinha != null){
            return ResponseEntity.ok(cozinha);
        }

        //return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.notFound().build();

    }

    @PostMapping
    public Cozinha adicionar(@RequestBody Cozinha cozinha){
       return cozinhaRepository.salvar(cozinha);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Cozinha> atualizar(@PathVariable("id") Long id, @RequestBody Cozinha cozinha){
        Cozinha cozinhaAtual = cozinhaRepository.buscar(id);

        if (cozinhaAtual != null) {
            BeanUtils.copyProperties(cozinha, cozinhaAtual, "id");
            cozinhaRepository.salvar(cozinhaAtual);
            return ResponseEntity.ok(cozinhaAtual);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Cozinha> remover(@PathVariable("id") Long id) {
       try {

           Cozinha cozinha = cozinhaRepository.buscar(id);


           if (cozinha != null) {
               cozinhaRepository.remover(cozinha);

               return ResponseEntity.noContent().build();
           }

           return ResponseEntity.notFound().build();
       } catch (DataIntegrityViolationException e ) {
           return ResponseEntity.status(HttpStatus.CONFLICT).build();
       }

    }
}
