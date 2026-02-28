package com.cfs.student_api.dto;

import java.util.List;

public class PaginationResponseDTO {
    private List<StudentResponseDTO> data;
    private int pageNumber;
    private int pageSize;
    private Long totalElements;
    private int totalPages;
    private boolean last;

    public PaginationResponseDTO(List<StudentResponseDTO> data, int pageNumber, int pageSize, Long totalElements, int totalPages, boolean last) {
        this.data = data;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.last = last;
    }

    public List<StudentResponseDTO> getData() {
        return data;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public Long getTotalElements() {
        return totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public boolean isLast() {
        return last;
    }
}
