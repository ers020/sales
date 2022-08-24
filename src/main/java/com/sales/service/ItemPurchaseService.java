package com.sales.service;

import com.sales.dao.model.ItemPurchase;
import com.sales.dao.model.mapper.ResourceMapper;
import com.sales.dao.repository.ItemPurchaseRepository;
import com.sales.model.dto.ItemPurchaseDto;
import com.sales.util.PageHeaderUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
public class ItemPurchaseService {

    private final ItemPurchaseRepository itemPurchaseRepository;
    private final ResourceMapper resourceMapper;

    public ItemPurchaseService(ItemPurchaseRepository itemPurchaseRepository, ResourceMapper resourceMapper) {
        this.itemPurchaseRepository = itemPurchaseRepository;
        this.resourceMapper = resourceMapper;
    }
    public List<ItemPurchaseDto> getAll() {
        List<ItemPurchase> itemPurchaseList = itemPurchaseRepository.findAll();
        return resourceMapper.convertToItemPurchaseDtoList(itemPurchaseList);
    }

    public List<ItemPurchaseDto> getAllPagination(
            final PageRequest pageRequest,
            final HttpServletResponse httpResponse
    ) {
        final Page<ItemPurchase> itemPurchasePage = itemPurchaseRepository.findAll(pageRequest);
        final List<ItemPurchaseDto> itemPurchaseDtoList = resourceMapper.convertToItemPurchaseDtoList(itemPurchasePage.getContent());

        PageHeaderUtil.updatePageHeader(httpResponse, itemPurchasePage, pageRequest);
        return itemPurchaseDtoList;
    }

    public ItemPurchaseDto create(ItemPurchaseDto save) {
        ItemPurchase itemPurchase = itemPurchaseRepository.save(new ItemPurchase(save));
        return resourceMapper.convertToItemPurchaseDto(itemPurchase);
    }
}
