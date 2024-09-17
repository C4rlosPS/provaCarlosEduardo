package com.prova.carloseduardo;

class AcessorioNotFoundException extends RuntimeException {

    AcessorioNotFoundException(Long id) {
        super("Could not find acessory " + id);
    }
}