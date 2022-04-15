package com.zhy.sort.service;

import java.util.List;

public interface ISortedService {

    <T extends Comparable<? super T>> List<T> addSortedData(List<T> originData);
}
