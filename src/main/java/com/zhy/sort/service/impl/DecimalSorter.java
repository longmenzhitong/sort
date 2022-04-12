package com.zhy.sort.service.impl;

import com.zhy.sort.annotation.Sorters;
import com.zhy.sort.mapper.SortRecordMapper;
import com.zhy.sort.service.Sorter;

import java.math.BigDecimal;

/**
 * 小数排序器
 *
 * @author zhihaoyu
 */
@Sorters(BigDecimal.class)
public class DecimalSorter extends Sorter<BigDecimal> {

    public DecimalSorter(SortRecordMapper sortRecordMapper) {
        super(sortRecordMapper);
    }

}
