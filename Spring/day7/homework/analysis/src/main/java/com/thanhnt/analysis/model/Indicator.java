package com.thanhnt.analysis.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Indicator {
    private Integer id;
    private String indicatorName;
    private String actualValue;
    private String defaultValue;
    private String unit;

}
