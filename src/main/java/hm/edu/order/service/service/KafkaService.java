package hm.edu.order.service.service;

import hm.edu.order.service.resource.data.OrderDto;

public interface KafkaService {

    void sendMessage(OrderDto orderDto);
}
