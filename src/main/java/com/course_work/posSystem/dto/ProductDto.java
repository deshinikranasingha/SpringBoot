package com.course_work.posSystem.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class ProductDto {

    private Long id;
    private String name;
    private Double price;
    private Integer quantity;
    private Long categoryId;

}
