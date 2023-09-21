package hm.edu.order.service.dto;

import org.springframework.lang.NonNull;

public record OrderDto(@NonNull String email, @NonNull int amount) {}