package com.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AcessoController {

    @Autowired
    private AcessoProducer acessoProducer;

    @PostMapping("/acesso/{cliente}/{porta}")
    public Acesso create(@PathVariable String cliente,@PathVariable String porta) {
        return acessoProducer.enviarAoKafka(cliente, porta);
    }
}
