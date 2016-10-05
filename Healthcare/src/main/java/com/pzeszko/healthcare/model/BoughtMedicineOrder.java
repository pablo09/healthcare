package com.pzeszko.healthcare.model;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Pawel on 2016-10-02.
 */
@Entity
@Table(name = "BOUGHT_MEDICINE_ORDER")
@Data
public class BoughtMedicineOrder extends BaseEntity {

    @NotEmpty
    @Column(length = 100)
    private String name;

    @NotEmpty
    private String description;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Category category;

    @NotNull
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "denomination", column = @Column(name = "price")),
            @AttributeOverride(name = "currencyCode", column = @Column(name = "price_currency", length = 3))
    })
    private Money price;

    private Integer quantity;




}
