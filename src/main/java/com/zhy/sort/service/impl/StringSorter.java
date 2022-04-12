package com.zhy.sort.service.impl;

import com.zhy.sort.annotation.Sorters;
import com.zhy.sort.mapper.SortRecordMapper;
import com.zhy.sort.service.Sorter;

/**
 * 字符串排序器
 *
 * @author zhihaoyu
 */
@Sorters(String.class)
public class StringSorter extends Sorter<String> {

    public StringSorter(SortRecordMapper sortRecordMapper) {
        super(sortRecordMapper);
    }

}
