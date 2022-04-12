package com.zhy.sort.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 字符串列表DTO
 *
 * @author zhihaoyu
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class StringListDTO extends ListDTO<String> implements Serializable {

    private static final long serialVersionUID = -1598048768683868129L;
}
