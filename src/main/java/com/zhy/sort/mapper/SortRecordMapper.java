package com.zhy.sort.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhy.sort.model.po.SortRecord;
import org.apache.ibatis.annotations.Mapper;

/**
 * 排序记录持久层接口
 *
 * @author zhihaoyu
 */
@Mapper
public interface SortRecordMapper extends BaseMapper<SortRecord> {
}
