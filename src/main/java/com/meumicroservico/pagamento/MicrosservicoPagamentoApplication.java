package com.meumicroservico.pagamento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/*
Esse seria um cliente do Service Discovery, logo, todos os Microsservices
(vulgo APIs --' ), precisam ser indicadas com a anotação @EurekaClient
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class MicrosservicoPagamentoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicrosservicoPagamentoApplication.class, args);
    }

}
