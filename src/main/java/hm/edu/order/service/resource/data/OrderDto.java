package hm.edu.order.service.resource.data;

import org.springframework.lang.NonNull;

public record OrderDto(@NonNull String email, @NonNull int amount) {}