package com.zhy.sort.service.impl;

import com.zhy.sort.annotation.Sorters;
import com.zhy.sort.mapper.SortRecordMapper;
import com.zhy.sort.service.Sorter;

/**
 * 整型排序器
 *
 * @author zhihaoyu
 * @since 2022/4/11 12:41
 */
@Sorters(Integer.class)
public class IntegerSorter extends Sorter<Integer> {

    public IntegerSorter(SortRecordMapper sortRecordMapper) {
        super(sortRecordMapper);
    }

}
