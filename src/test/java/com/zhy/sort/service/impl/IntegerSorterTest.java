package com.zhy.sort.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.zhy.sort.mapper.SortRecordMapper;
import com.zhy.sort.model.po.SortRecord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

class IntegerSorterTest {

    @Test
    void sortAcceptsNull() {
        IntegerSorter sorter = new IntegerSorter(null);
        List<Integer> sortedData = sorter.sort(null);
        Assertions.assertIterableEquals(Collections.emptyList(), sortedData);
    }

    @Test
    void sortAcceptsEmptyList() {
        IntegerSorter sorter = new IntegerSorter(null);
        List<Integer> sortedData = sorter.sort(new ArrayList<>());
        Assertions.assertIterableEquals(Collections.emptyList(), sortedData);
    }

    @Test
    void sortAcceptsDecimalList() {
        SortRecordMapper sortRecordMapper = mock(SortRecordMapper.class);
        when(sortRecordMapper.insert(any(SortRecord.class))).thenReturn(1);
        IntegerSorter sorter = new IntegerSorter(sortRecordMapper);
        List<Integer> originData = CollUtil.newArrayList(3, 1, 4, 1, 5, 9, 2, 6);
        List<Integer> sortedData = sorter.sort(originData);
        List<Integer> expectedData = CollUtil.newArrayList(1, 1, 2, 3, 4, 5, 6, 9);
        Assertions.assertIterableEquals(expectedData, sortedData);
    }
}