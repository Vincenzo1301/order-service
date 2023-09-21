package hm.edu.order.service.service;

import hm.edu.order.service.resource.data.OrderDto;

public interface OrderService {

    void createOrder(OrderDto orderDto);
}
