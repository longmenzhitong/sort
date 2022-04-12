package com.zhy.sort.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 排序记录PO
 *
 * @author zhihaoyu
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SortRecord {

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 原始数据
     */
    private String originData;
    /**
     * 有序数据
     */
    private String sortedData;
    /**
     * 创建时间
     */
    private Date createTime;
}
