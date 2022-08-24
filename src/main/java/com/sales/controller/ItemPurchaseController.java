package com.sales.controller;

import com.sales.annotation.SwaggerController;
import com.sales.model.dto.ItemPurchaseDto;
import com.sales.service.ItemPurchaseService;
import com.sales.util.PageUtil;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RequestMapping(value = "/item-purchase")
@SwaggerController
public class ItemPurchaseController {

    private final ItemPurchaseService itemPurchaseService;

    public ItemPurchaseController(ItemPurchaseService itemPurchaseService) {
        this.itemPurchaseService = itemPurchaseService;
    }

    @GetMapping(value = "/purchase-history")
    @ResponseBody
    public List<ItemPurchaseDto> getAll() {
        return itemPurchaseService.getAll();
    }

    @GetMapping(value = "/purchase-history-pagination")
    @ResponseBody
    public List<ItemPurchaseDto> getAllPagination(
            final @RequestParam(required = false) Integer page,
            final @RequestParam(required = false) Integer size,
            final HttpServletResponse httpResponse
    ) {
        final PageRequest pageRequest = PageUtil.createPageRequest(page, size);
        return itemPurchaseService.getAllPagination(pageRequest, httpResponse);
    }

    @PostMapping(value = "/create-item-purchase")
    @ResponseBody
    public ItemPurchaseDto create(
            final @RequestBody ItemPurchaseDto save
    ) {
        return itemPurchaseService.create(save);
    }

}
