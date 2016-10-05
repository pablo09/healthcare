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

    /**
     * In case when we absolutely want to create unidirectional 1:N mapping (which means with no @ManyToOne) with no @JoinTable
     * and 1-side (not the owner) must not be null we have to use @JoinColumn(..., nullable = false) on the owner side
     * and @Column(..., insertable = false, updateable = false) on the other side which will prevent JPA from updating entity
     * instead of deleting. If we skip that (nullable = false and both insertable = false, updateable = false) JPA repository
     * would set foreign key (here cartId) as null in subsequent UPDATE statement
     */
    @Column(name = "CART", insertable = false, updatable = false)
    private Long cartId;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
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

    public void removeFromCart() {
        cartId = null;
    }

}
