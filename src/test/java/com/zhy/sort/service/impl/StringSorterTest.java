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

class StringSorterTest {

    @Test
    void sortAcceptsNull() {
        StringSorter sorter = new StringSorter(null);
        List<String> sortedData = sorter.sort(null);
        Assertions.assertIterableEquals(Collections.emptyList(), sortedData);
    }

    @Test
    void sortAcceptsEmptyList() {
        StringSorter sorter = new StringSorter(null);
        List<String> sortedData = sorter.sort(new ArrayList<>());
        Assertions.assertIterableEquals(Collections.emptyList(), sortedData);
    }

    @Test
    void sortAcceptsDecimalList() {
        SortRecordMapper sortRecordMapper = mock(SortRecordMapper.class);
        when(sortRecordMapper.insert(any(SortRecord.class))).thenReturn(1);
        StringSorter sorter = new StringSorter(sortRecordMapper);
        List<String> originData = CollUtil.newArrayList("g", "o", "o", "d");
        List<String> sortedData = sorter.sort(originData);
        List<String> expectedData = CollUtil.newArrayList("d", "g", "o", "o");
        Assertions.assertIterableEquals(expectedData, sortedData);
    }
}