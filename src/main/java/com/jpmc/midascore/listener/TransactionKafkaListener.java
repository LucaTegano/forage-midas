// src/main/java/com/jpmc/midascore/listener/TransactionKafkaListener.java
package com.jpmc.midascore.listener;

import com.jpmc.midascore.foundation.Transaction; // Use your actual Transaction class path
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList; // Explicit import
import java.util.List; // Explicit import

@Component
public class TransactionKafkaListener {

    private static final Logger log = LoggerFactory.getLogger(TransactionKafkaListener.class);

    @Value("${general.kafka-topic}")
    private String kafkaTopic; // Not strictly needed in the class if only used in @KafkaListener, but fine for
                               // logging/visibility

    private final List<Transaction> receivedTransactions = new ArrayList<>();

    @KafkaListener(topics = "${general.kafka-topic}", groupId = "midas-core-group")
    public void listen(Transaction transaction) {
        log.info("Received transaction: {}", transaction);
        receivedTransactions.add(transaction);
    }

    public List<Transaction> getReceivedTransactions() {
        return receivedTransactions;
    }

    public void clearReceivedTransactions() {
        receivedTransactions.clear();
    }
}