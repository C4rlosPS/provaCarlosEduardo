package com.prova.carloseduardo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(VeiculoRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Veiculo("gol","axy",2014)));
            log.info("Preloading " + repository.save(new Veiculo("saveiro","axt",2000)));
        };
    }

}
