package hm.edu.order.service.service;

import hm.edu.order.service.dto.OrderDto;

public interface KafkaService {

    void sendMessage(OrderDto orderDto);
}
