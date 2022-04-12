package com.zhy.sort.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 小数列表DTO
 *
 * @author zhihaoyu
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DecimalListDTO extends ListDTO<BigDecimal> implements Serializable {

    private static final long serialVersionUID = -2557349699088751058L;
}
