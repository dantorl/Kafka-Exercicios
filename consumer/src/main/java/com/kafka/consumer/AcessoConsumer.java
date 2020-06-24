package com.kafka.consumer;

import com.kafka.producer.Acesso;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class AcessoConsumer {
    @KafkaListener(topics = "spec2-daniel-torquato-1", groupId = "batman")
    public void receber(@Payload Acesso acesso) throws IOException {
        System.out.println("Recebi uma solicitação de acesso do " + acesso.getCliente() + " para porta " + acesso.getPorta());
        try {
            // O parametro é que indica se deve sobrescrever ou continua no
            // arquivo.
            FileWriter fw = new FileWriter("/home/a2/Documentos/Daniel Torquato - Itau/Kafka-Exercicio/AcessoConsumer.txt", true);
            BufferedWriter conexao = new BufferedWriter(fw);
            conexao.write(acesso.getCliente() + ";" + acesso.getPorta() + ";" + acesso.getAutorizado() + ";");
            conexao.newLine();
            conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
