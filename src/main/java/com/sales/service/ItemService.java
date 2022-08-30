package com.sales.service;

import com.sales.dao.model.Item;
import com.sales.dao.model.mapper.ResourceMapper;
import com.sales.dao.repository.ItemRepository;
import com.sales.model.dto.ItemDto;
import com.sales.util.PageHeaderUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

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


    public ItemDto getById(Integer id, HttpServletResponse httpResponse) throws Exception {
        final Optional<Item> optional = itemRepository.findById(id);
        final Item item = getItem(id, optional);
        return resourceMapper.convertToItemDto(item);
    }

    private Item getItem(Integer id, Optional<Item> optional) throws Exception {
        if(optional.isEmpty()) {
            final String msg =String.format("Id %d does not exist.", id);
            throw new Exception(msg);
        }
        return optional.get();
    }
}
