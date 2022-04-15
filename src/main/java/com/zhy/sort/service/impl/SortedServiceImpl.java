package com.zhy.sort.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.zhy.sort.context.SorterContext;
import com.zhy.sort.service.ISortedService;
import com.zhy.sort.service.Sorter;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class SortedServiceImpl implements ISortedService {

    @Override
    @SuppressWarnings("unchecked")
    public <T extends Comparable<? super T>> List<T> addSortedData(List<T> originData) {
        if (CollUtil.isEmpty(originData)) {
            return Collections.emptyList();
        }

        Class<T> cls = (Class<T>) originData.get(0).getClass();
        Sorter<T> sorter = SorterContext.getSorter(cls);
        return sorter.sort(originData);
    }
}
