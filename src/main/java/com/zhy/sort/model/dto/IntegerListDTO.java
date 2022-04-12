package com.zhy.sort.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 整型列表DTO
 *
 * @author zhihaoyu
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class IntegerListDTO extends ListDTO<Integer> implements Serializable {

    private static final long serialVersionUID = -4548317480259631938L;
}
