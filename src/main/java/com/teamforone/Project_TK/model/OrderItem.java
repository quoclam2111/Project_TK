package com.teamforone.Project_TK.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_items")
public class OrderItem {
    @Id
    @UuidGenerator
    @Column(name = "order_item_id", columnDefinition = "CHAR(36)")
    private String orderItemID;

    @JoinColumn(name = "order_id", nullable = false, columnDefinition = "CHAR(36)")
    private String order;

    @JoinColumn(name = "variant_id", nullable = false, columnDefinition = "CHAR(36)")
    private String variantsId;

    @Column(name = "quantity", columnDefinition = "INT DEFAULT 1 CHECK (quantity > 0)")
    private Integer quantity;

    @Column(name = "subtotal", precision = 10, scale = 2)
    private BigDecimal subTotal;
}
