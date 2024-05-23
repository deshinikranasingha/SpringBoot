package com.course_work.posSystem.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StockDto {
    private Long id;
    private List<Long> productIds;
}
