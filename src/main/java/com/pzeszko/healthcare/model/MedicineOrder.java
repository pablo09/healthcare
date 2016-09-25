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

    @Column(name = "CART")
    private Long cartId;

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "MEDICINE", nullable = false)
    private Medicine medicine;

    @NotNull
    @Column(name = "QUANTITY")
    private Integer quantity = 1;

    /**
     * Increases number of medicines in order
     * @param newItems Number of new items to add
     */
    public void increaseQuantity(int newItems) {
        quantity += newItems;
    }

}
