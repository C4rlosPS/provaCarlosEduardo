package com.prova.carloseduardo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class AcessorioController {

    private final AcessorioRepository repository;


    AcessorioController(AcessorioRepository repository) {
        this.repository = repository;
    }



    @GetMapping("/acessorios")
    List<Acessorio> all() {
        return repository.findAll();
    }


    @PostMapping("/acessorios")
    Acessorio novoAcessorio(@RequestBody Acessorio novoAcessorio) {
        return repository.save(novoAcessorio);
    }

    // Single item

    @GetMapping("/acessorios/{id}")
    Acessorio one(@PathVariable Long id) {

        return repository.findById(id).orElseThrow(() -> new VeiculoNotFoundException(id));
    }

    @PutMapping("/acessorios/{id}")
    Acessorio updateAcessory(@RequestBody Acessorio novoAcessorio, @PathVariable Long id) {

        return repository.findById(id)
                .map(acessorio -> {
                    acessorio.setNome( novoAcessorio.getNome());
                    return repository.save(acessorio);
                })
                .orElseGet(() -> {
                    return repository.save(novoAcessorio);
                });
    }

    @DeleteMapping("/acessorios/{id}")
    void deleteAcessory(@PathVariable Long id) {
        repository.deleteById(id);
    }
}