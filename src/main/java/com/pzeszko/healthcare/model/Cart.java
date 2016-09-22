package com.pzeszko.healthcare.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Pawel on 2016-09-22.
 */
@Entity
@Table(name = "CART")
@Data
public class Cart extends BaseEntity {

    @OneToMany(mappedBy = "cart")
    private List<MedicineOrder> medicineOrders;
}
