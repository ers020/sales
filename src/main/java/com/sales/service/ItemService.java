package com.sales.service;

import com.sales.dao.model.Item;
import com.sales.dao.model.mapper.ResourceMapper;
import com.sales.dao.repository.ItemRepository;
import com.sales.model.dto.ItemDto;
import com.sales.util.PageHeaderUtil;
import com.sales.util.PageUtil;
import ma.glasnost.orika.MapperFacade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private final ResourceMapper resourceMapper;

    public ItemService(ItemRepository itemRepository, ResourceMapper resourceMapper) {
        this.itemRepository = itemRepository;
        this.resourceMapper = resourceMapper;
    }

    public List<ItemDto> getAll() {
        List<Item> itemList = itemRepository.findAll();
        return resourceMapper.convertToItemDtoList(itemList);
    }

    public List<ItemDto> getAllPagination(
            final PageRequest pageRequest,
            final HttpServletResponse httpResponse
    ) {
        final Page<Item> itemPage = itemRepository.findAll(pageRequest);
        final List<ItemDto> itemDtoList = resourceMapper.convertToItemDtoList(itemPage.getContent());

        PageHeaderUtil.updatePageHeader(httpResponse, itemPage, pageRequest);
        return itemDtoList;
    }
}
