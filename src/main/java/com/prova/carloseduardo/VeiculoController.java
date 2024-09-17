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
class VeiculoController {

    private final VeiculoRepository repository;


    VeiculoController(VeiculoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/veiculos")
    List<Veiculo> all() {
        return repository.findAll();
    }


    @PostMapping("/veiculos")
    Veiculo newVeicle(@RequestBody Veiculo novoVeiculo) {
        return repository.save(novoVeiculo);
    }


    @GetMapping("/veiculos/{id}")
    Veiculo one(@PathVariable Long id) {

        return repository.findById(id).orElseThrow(() -> new VeiculoNotFoundException(id));
    }

    @PutMapping("/veiculos/{id}")
    Veiculo replaceVeicule(@RequestBody Veiculo novoVeiculo, @PathVariable Long id) {

        return repository.findById(id)
                .map(veiculo -> {
                    veiculo.setModelo(novoVeiculo.getModelo());
                    veiculo.setPlaca(novoVeiculo.getPlaca());
                    veiculo.setAno(novoVeiculo.getAno());
                    return repository.save(veiculo);
                })
                .orElseGet(() -> {
                    return repository.save(novoVeiculo);
                });
    }

    @DeleteMapping("/veiculos/{id}")
    void deleteVeicle(@PathVariable Long id) {
        repository.deleteById(id);
    }
}