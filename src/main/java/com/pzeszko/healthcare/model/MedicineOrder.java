package com.pzeszko.healthcare.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Pawel on 2016-09-22.
 */
@Entity
@Table(name = "MEDICINES_ORDER")
@Data
public class MedicineOrder extends BaseEntity {

    @NotNull
    @ManyToOne
    @JoinColumn(name = "CART", nullable = false)
    private Cart cart;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "MEDICINE", nullable = false)
    private Medicine medicine;

    @NotNull
    @Column(name = "NUMBER")
    private Integer number = 1;
}
