package com.zhy.sort.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.zhy.sort.mapper.SortRecordMapper;
import com.zhy.sort.model.po.SortRecord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

class DecimalSorterTest {

    @Test
    void sortAcceptsNull() {
        DecimalSorter sorter = new DecimalSorter(null);
        List<BigDecimal> sortedData = sorter.sort(null);
        Assertions.assertIterableEquals(Collections.emptyList(), sortedData);
    }

    @Test
    void sortAcceptsEmptyList() {
        DecimalSorter sorter = new DecimalSorter(null);
        List<BigDecimal> sortedData = sorter.sort(new ArrayList<>());
        Assertions.assertIterableEquals(Collections.emptyList(), sortedData);
    }

    @Test
    void sortAcceptsDecimalList() {
        SortRecordMapper sortRecordMapper = mock(SortRecordMapper.class);
        when(sortRecordMapper.insert(any(SortRecord.class))).thenReturn(1);
        DecimalSorter sorter = new DecimalSorter(sortRecordMapper);
        List<BigDecimal> originData = CollUtil.newArrayList(
                BigDecimal.valueOf(3.14),
                BigDecimal.valueOf(2),
                BigDecimal.valueOf(0.996)
        );
        List<BigDecimal> sortedData = sorter.sort(originData);
        List<BigDecimal> expectedData = CollUtil.newArrayList(
                BigDecimal.valueOf(0.996),
                BigDecimal.valueOf(2),
                BigDecimal.valueOf(3.14)
        );
        Assertions.assertIterableEquals(expectedData, sortedData);
    }
}