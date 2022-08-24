package com.sales.dao.model;

import com.sales.model.dto.ItemPurchaseDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "item_purchase_history")
@NoArgsConstructor
public class ItemPurchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_id", nullable = false)
    private Integer purchaseId;

    @Column(name = "item_id", nullable = false)
    private Integer itemId;

    @Column(name = "item_num", nullable = false)
    private Integer itemNum;

    @Column(name = "item_quantity_purchased", nullable = false)
    private Integer amountPurchased;

    @Column(name = "purchase_timestamp")
    private LocalDateTime purchaseTimestamp;

    public ItemPurchase(ItemPurchaseDto itemPurchaseDto) {
        this.itemId = itemPurchaseDto.getItemId();
        this.itemNum = itemPurchaseDto.getItemNum();
        this.amountPurchased = itemPurchaseDto.getAmountPurchased();
    }
}
