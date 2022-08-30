package com.sales.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ItemPurchaseDto {
    private Integer purchaseId;
    private Integer itemId;
    private Integer itemNum;
    private Integer amountPurchased;
    private LocalDateTime purchaseTimestamp;
}
