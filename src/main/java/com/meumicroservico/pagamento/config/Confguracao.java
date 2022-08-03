package com.meumicroservico.pagamento.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Confguracao {
    //Criando o Bean do model mapper, para permitir sua injeção de dependencia nas services
    @Bean
    public ModelMapper obterModelMapper(){
        return new ModelMapper();
    }
}
