package com.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AcessoProducer {
    @Autowired
    private KafkaTemplate<String, Acesso> producer;


    public Acesso enviarAoKafka(String cliente, String porta) {
        Acesso acesso = new Acesso();

        acesso.setCliente(cliente);
        acesso.setPorta(porta);

        Random random = new Random();
        acesso.setAutorizado(random.nextBoolean());

        producer.send("spec2-daniel-torquato-1", acesso);

        return acesso;
    }
}
