package com.pzeszko.healthcare.model;

import javax.persistence.*;
/**
 * Created by Pawel on 2016-09-15.
 */
@Entity
@Table
public class Medicine {

    @Id
    @Column(name = "ID", unique = true, nullable = false, precision = 10, scale = 0)
    private Long id;
}
