package com.zhy.sort.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.json.JSONUtil;
import com.zhy.sort.mapper.SortRecordMapper;
import com.zhy.sort.model.po.SortRecord;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * 抽象排序器提供基本的排序和保存排序记录的方法。
 *
 * @param <T> 排序器的处理类型
 * @author zhihaoyu
 */
@Slf4j
public abstract class Sorter<T extends Comparable<? super T>> {

    protected final SortRecordMapper sortRecordMapper;

    protected Sorter(SortRecordMapper sortRecordMapper) {
        this.sortRecordMapper = sortRecordMapper;
    }

    /**
     * 对原始数据列表进行排序，保存排序记录，并返回有序数据列表。
     * 排序过程不会改动原始数据列表。
     *
     * @param originData 原始数据列表
     * @return 有序数据列表
     */
    public List<T> sort(List<T> originData) {
        if (CollUtil.isEmpty(originData)) {
            return Collections.emptyList();
        }

        List<T> copyData = CollUtil.newArrayList(originData);
        Collections.sort(copyData);
        boolean saveSucceed = save(originData, copyData);
        if (!saveSucceed) {
            log.warn("Failed to save sort record, origin data: {}, sorted data: {}", originData, copyData);
        }
        return copyData;
    }

    /**
     * 以JSON格式将原始数据列表和有序数据列表保存到数据库
     *
     * @param originData 原始数据列表
     * @param sortedData 有序数据列表
     * @return 是否保存成功
     */
    protected boolean save(List<T> originData, List<T> sortedData) {
        return sortRecordMapper.insert(
                SortRecord.builder()
                        .originData(JSONUtil.toJsonStr(originData))
                        .sortedData(JSONUtil.toJsonStr(sortedData))
                        .createTime(new Date())
                        .build()
        ) > 0;
    }
}
