package com.example.day_05.response.impl;

import com.example.day_05.response.PageResponse;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PageResponseImpl<T> implements PageResponse<T> {
    List<T> data;
    int currentPage;
    int pageSize;

    @Override
    public int getCurrentPage() {
        return 0;
    }

    @Override
    public List getContent() {
        return List.of();
    }

    @Override
    public int getPageSize() {
        return 0;
    }

    @Override
    public int getTotalPages() {
        return 0;
    }

    @Override
    public int getTotalElements() {
        return 0;
    }
}
