package com.pzeszko.healthcare.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pawel on 2016-09-22.
 */
@Entity
@Table(name = "CART")
@Data
public class  Cart extends BaseEntity {

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "CART", nullable = false)
    private List<MedicineOrder> medicineOrders = new ArrayList<>();

    public void addToCart(MedicineOrder order) {
        order.setCartId(this.getId());
        medicineOrders.add(order);
    }

    public void clearCart() {
        medicineOrders.stream().forEach(MedicineOrder::removeFromCart);
        medicineOrders.clear();
    }
}
