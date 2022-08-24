package com.sales.dao.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "item_sample_data")
public class Item {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "item_num", nullable = false)
    private Integer itemNum;

    @Column(name = "item_name", nullable = false)
    private String itemName;

    @Column(name = "item_cost", nullable = false)
    private BigDecimal itemCost;

    @Column(name = "item_quantity", nullable = false)
    private Integer itemQuantity;

}
