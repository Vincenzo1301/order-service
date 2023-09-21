package hm.edu.order.service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @Column(name = "ORDER_ID", length = 16, unique = true, nullable = false)
    private UUID orderId = UUID.randomUUID();

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "AMOUNT", nullable = false)
    private int amount;

    public UUID getUserId() {
        return orderId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", email='" + email + '\'' +
                ", amount=" + amount +
                '}';
    }
}