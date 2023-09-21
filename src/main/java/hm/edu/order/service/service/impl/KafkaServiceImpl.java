package hm.edu.order.service.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hm.edu.order.service.dto.OrderDto;
import hm.edu.order.service.service.KafkaService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaServiceImpl implements KafkaService {

    @Value(value = "${spring.kafka.order.topic}")
    private String topicName;

    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaServiceImpl(ObjectMapper objectMapper, KafkaTemplate<String, String> kafkaTemplate) {
        this.objectMapper = objectMapper;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendMessage(OrderDto orderDto) {
        String msg = null;
        try {
            msg = objectMapper.writeValueAsString(orderDto);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to serialize message to JSON for Kafka publishing. Original error: " + e.getMessage(), e);
        }

        kafkaTemplate.send(topicName, msg);
    }
}
