package com.sales.dao.model.mapper;

import com.sales.dao.model.Item;
import com.sales.dao.model.ItemPurchase;
import com.sales.model.dto.ItemDto;
import com.sales.model.dto.ItemPurchaseDto;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ResourceMapper {

    private final MapperFacade mapperFacade;

    public ResourceMapper(MapperFacade mapperFacade) {
        this.mapperFacade = mapperFacade;
    }

    public <T extends Collection<ItemDto>> List<ItemDto> convertToItemDtoList(final List<Item> itemList) {
        return itemList.stream().map(this::convertToItemDto).collect(Collectors.toList());
    }

    public ItemDto convertToItemDto(Item item) {
        return mapperFacade.map(item, ItemDto.class);
    }

    public <T extends Collection<ItemPurchaseDto>> List<ItemPurchaseDto> convertToItemPurchaseDtoList(
            List<ItemPurchase> itemPurchaseList) {
        return itemPurchaseList.stream().map(this::convertToItemPurchaseDto).collect(Collectors.toList());
    }

    public ItemPurchaseDto convertToItemPurchaseDto(ItemPurchase itemPurchase) {
        return mapperFacade.map(itemPurchase, ItemPurchaseDto.class);
    }
}
