package com.zhy.sort.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 列表DTO
 *
 * @author zhihaoyu
 */
@Data
@NoArgsConstructor
public class ListDTO<T> implements Serializable {

    private static final long serialVersionUID = -796591019208842069L;

    private List<T> data;
}
