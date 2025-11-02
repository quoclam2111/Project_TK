package com.teamforone.Project_TK.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "brands")
public class Brands {
    @Id
    @UuidGenerator
    @Column(name = "brand_id", columnDefinition = "CHAR(36)")
    private String brandID;

    @Column(name = "brand_name", nullable = false)
    private String brandName;
}
