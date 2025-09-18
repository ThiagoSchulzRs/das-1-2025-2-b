package br.univille;

import com.azure.core.amqp.AmqpTransportType;
import com.azure.messaging.servicebus.ServiceBusClientBuilder;
import com.azure.messaging.servicebus.ServiceBusMessage;
import com.azure.messaging.servicebus.ServiceBusSenderClient;

public class Publisher {
    public static void main(String[] args) {
        var topicName = "topic-das1-b";
        var servidor = "sbdas12025a.servicebus.windows.net";

        String chave = System.getenv("CHAVE");

        // DefaultAzureCredential credential = new
        // DefaultAzureCredentialBuilder().build();

        ServiceBusSenderClient senderClient = new ServiceBusClientBuilder()
                .fullyQualifiedNamespace(servidor)
                .transportType(AmqpTransportType.AMQP_WEB_SOCKETS)
                // .credential(credential)
                .connectionString(chave)
                .sender()
                .topicName(topicName)
                .buildClient();

        senderClient.sendMessage(new ServiceBusMessage("Thiago: Eu quero cafééééé"));
    }
}
