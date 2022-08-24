package com.sales.controller;

import com.sales.annotation.SwaggerController;
import com.sales.model.dto.ItemDto;
import com.sales.service.ItemService;
import com.sales.util.PageUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RequestMapping(value = "/item")
@SwaggerController
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping(value = "/get-all")
    @ResponseBody
    public List<ItemDto> getAll() {
        return itemService.getAll();
    }

    @GetMapping(value = "/get-all-pagination")
    @ResponseBody
    public List<ItemDto> getAllPagination(
            final @RequestParam(required = false) Integer page,
            final @RequestParam(required = false) Integer size,
            final HttpServletResponse httpResponse
    ) {
        final PageRequest pageRequest = PageUtil.createPageRequest(page, size);
        return itemService.getAllPagination(pageRequest, httpResponse);
    }
}
