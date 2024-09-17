package com.prova.carloseduardo;

class VeiculoNotFoundException extends RuntimeException {

    VeiculoNotFoundException(Long id) {
        super("Could not find acessory " + id);
    }
}
