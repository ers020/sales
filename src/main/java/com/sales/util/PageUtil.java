package com.sales.util;

import lombok.experimental.UtilityClass;
import org.springframework.data.domain.PageRequest;

@UtilityClass
public class PageUtil {

    private static final int DEFAULT_PAGE_SIZE = 20;

    public static PageRequest createPageRequest() {
        return createPageRequest(null, null);
    }

    public static PageRequest createPageRequest(final Integer page, final Integer size) {
        return createPageRequest(page, size, DEFAULT_PAGE_SIZE);
    }

    public static PageRequest createPageRequest(
            final Integer page,
            final Integer size,
            final Integer defaultSize) {
        final int pg = page != null && page > 0 ? page - 1 : 0;
        final int sz = size != null && size > 0 ? size : defaultSize;
        return PageRequest.of(pg, sz);
    }
}
