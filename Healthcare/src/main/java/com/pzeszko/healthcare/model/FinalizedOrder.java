package com.pzeszko.healthcare.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Pawel on 2016-10-02.
 */
@Entity
@Table(name = "FINALIZED_ORDER")
@Data
public class FinalizedOrder extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "BUYER")
    private User user;

    @Enumerated(EnumType.STRING)
    private State state = State.WAITING_FOR_PAYMENT;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "FINALIZED_ORDER")
    private List<BoughtMedicineOrder> medicines;

    @Column(name  = "SELL_DATE")
    private LocalDateTime sellDate;

    @AllArgsConstructor
    @Getter
    public enum State {
        WAITING_FOR_PAYMENT("WAITING_FOR_PAYMENT"),
        PREPEARING_FOR_SENDING("PREPEARING_FOR_SENDING"),
        SENT("SENT");

        private final String name;
    }

    public FinalizedOrder() {
        sellDate =  LocalDateTime.now();
    }
}
