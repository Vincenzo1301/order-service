package hm.edu.order.service.resource;

import hm.edu.order.service.service.OrderService;
import hm.edu.order.service.resource.data.OrderDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderRestController {

    private final OrderService orderService;

    public OrderRestController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody OrderDto orderDto) {
        orderService.createOrder(orderDto);

        return new ResponseEntity<>(orderDto, HttpStatus.CREATED);
    }
}
