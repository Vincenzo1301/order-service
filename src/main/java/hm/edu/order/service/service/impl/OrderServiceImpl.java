package hm.edu.order.service.service.impl;

import hm.edu.order.service.model.Order;
import hm.edu.order.service.persistence.OrderRepository;
import hm.edu.order.service.dto.OrderDto;
import hm.edu.order.service.service.KafkaService;
import hm.edu.order.service.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final KafkaService kafkaService;

    public OrderServiceImpl(OrderRepository orderRepository, KafkaService kafkaService) {
        this.orderRepository = orderRepository;
        this.kafkaService = kafkaService;
    }

    @Override
    public void createOrder(OrderDto orderDto) {
        String email = orderDto.email();
        int amount = orderDto.amount();

        Order order = new Order();
        order.setEmail(email);
        order.setAmount(amount);

        orderRepository.save(order);
        kafkaService.sendMessage(orderDto);
    }
}
