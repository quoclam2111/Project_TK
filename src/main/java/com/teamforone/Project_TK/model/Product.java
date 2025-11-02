package com.teamforone.Project_TK.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "products")
public class Product {
    @Id
    @UuidGenerator
    @Column(name = "product_id", columnDefinition = "CHAR(36)")
    private String id;

    @Column(name = "product_name", nullable = false)
    private String name;

    @Column(name = "slug", nullable = false, unique = true)
    private String slug;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

//    @ManyToOne
//    @JoinColumn(name = "brand_id", nullable = false)
//    private Brands brandId;
//
//    @ManyToOne
//    @JoinColumn(name = "category_id", nullable = false)
//    private Categories categoryId;

    @Column(name = "brand_id", nullable = false, columnDefinition = "CHAR(36)")
    private String brandId;

    @Column(name = "category_id", nullable = false, columnDefinition = "CHAR(36)")
    private String categoryId;

    @Column(name = "default_image", nullable = false)
    private String imageUrl;

    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "sale_price", precision = 10, scale = 2)
    private BigDecimal salePrice;

    @Column(name = "stock_quantity", nullable = false, columnDefinition = "INT DEFAULT 0")
    private int stockQuantity;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, columnDefinition = "ENUM('draft','published','archived') DEFAULT 'published'")
    private Status productStatus = Status.PUBLISHED;

    @CreationTimestamp
    @Column(name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;

    public enum Status {
        DRAFT,
        PUBLISHED,
        ARCHIVED;

        public static Status toEnum(String type) {
            for (Status item : values()) {
                if (item.toString().equalsIgnoreCase(type)) return item;
            }
            return null;
        }
    }
}
