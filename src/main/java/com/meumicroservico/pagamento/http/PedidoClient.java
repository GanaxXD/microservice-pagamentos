package com.meumicroservico.pagamento.http;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//Preciso indicar o nome do microsserviço que eu quero me comunicar
@FeignClient("--")
public interface PedidoClient {
    @RequestMapping(method = RequestMethod.PUT, value = "/pedidos/{id}/pago")
    public void atualizaPagamento(@PathVariable Long id);
}
