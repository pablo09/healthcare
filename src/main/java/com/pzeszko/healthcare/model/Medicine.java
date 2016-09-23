package com.pzeszko.healthcare.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Pawel on 2016-09-15.
 */
@Entity
@Table(name = "MEDICINE")
@Data
public class Medicine extends BaseEntity {

    private static final String noImageLocation = "\\img\\no-img.png";

    @NotEmpty
    @Column(length = 100)
    private String name;

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


    @NotEmpty
    private String description;

    private Integer quantity = 0;

    @Column(name = "IMAGE_DISK_LOCATION")
    private String imgLocation = noImageLocation;

    @AllArgsConstructor
    @Getter
    public enum Category {
        GENERAL("GENERAL"),
        PAINKILLERS("PAINKILLERS"),
        SUPPLEMENT("SUPPLEMENT"),
        COLD("COLD");

        private final String name;
    }

    /**
     * Is medicine available for purchase
     * @return True/False: Medicine is available for purchase/ Medicine is not available for purchase
     */
    public boolean isAvailable() {
        return quantity > 0;
    }
}
