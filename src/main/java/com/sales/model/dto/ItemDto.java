package com.sales.model.dto;

import io.swagger.models.auth.In;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ItemDto {

    private Integer id;
    private Integer itemNum;
    private String itemName;
    private BigDecimal itemCost;
    private Integer itemQuantity;

}
