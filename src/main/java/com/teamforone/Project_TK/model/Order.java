package com.teamforone.Project_TK.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @UuidGenerator
    @Column(name = "order_id", columnDefinition = "CHAR(36)")
    private String orderID;

    @Column(name = "order_no", unique = true, length = 20)
    private String orderNo;

    @JoinColumn(name = "user_id", nullable = false, columnDefinition = "CHAR(36)")
    private String userID;

    @Column(name = "total_amount", precision = 10, scale = 2)
    private BigDecimal totalAmount;


    @Column(name = "payment_method", columnDefinition = "ENUM('cod','vnpay','momo','stripe')")
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", columnDefinition = "ENUM('PENDING','SHIPPED','DELIVERED','RETURNED','PAID','PROCESSING','CANCELLED') DEFAULT 'PENDING'")
    private OrderItemStatus status;

    @CreationTimestamp
    @Column(name = "created_at")
    private Date createdAt;


    public enum OrderItemStatus {
        PENDING,
        SHIPPED,
        DELIVERED,
        RETURNED,
        PAID,
        PROCESSING,
        CANCELLED;

        private static OrderItemStatus toEnum(String status) {
            for (OrderItemStatus item : values()) {
                if (item.toString().equalsIgnoreCase(status)) return item;
            }
            return null;
        }
    }

    public enum PaymentMethod {
        MOMO,
        VNPAY,
        STRIPE,
        COD;

        private static PaymentMethod toEnum(String value) {
            for(PaymentMethod method : PaymentMethod.values()){
                if (method.toString().equalsIgnoreCase(value)) return method;
            }
            return null;
        }
    }

}
