package com.sales.util;

import lombok.experimental.UtilityClass;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import javax.servlet.http.HttpServletResponse;

@UtilityClass
public class PageHeaderUtil {

    public static void updatePageHeader(
            final HttpServletResponse httpServletResponse,
            final Page<?> page,
            final PageRequest pageRequest
    ) {
        if(httpServletResponse == null)
            return;

        httpServletResponse.setIntHeader("page-count", page.getTotalPages());
        httpServletResponse.setIntHeader("page-number", pageRequest.getPageNumber() + 1);
        httpServletResponse.setIntHeader("page-size", pageRequest.getPageSize());
    }
}
