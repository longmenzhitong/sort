package com.zhy.sort.api;

import cn.hutool.core.collection.CollUtil;
import com.zhy.sort.context.SorterContext;
import com.zhy.sort.model.common.Result;
import com.zhy.sort.model.dto.DecimalListDTO;
import com.zhy.sort.model.dto.IntegerListDTO;
import com.zhy.sort.model.dto.StringListDTO;
import com.zhy.sort.service.Sorter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

/**
 * 排序Api
 *
 * @author zhihaoyu
 */
@Slf4j
@RestController
@RequestMapping("/v1/sorted")
public class SortedApi {

    /**
     * 保存排序后的整型列表
     *
     * @param dto 原始的整型列表
     * @return 排序后的整型列表
     */
    @PostMapping("/integer")
    public Result<IntegerListDTO> addSortedInteger(@RequestBody IntegerListDTO dto) {
        List<Integer> originIntegers = dto.getData();
        if (CollUtil.isEmpty(originIntegers)) {
            return Result.error(HttpStatus.NO_CONTENT.value(), "没有需要排序的数据");
        }

        Sorter<Integer> sorter = SorterContext.getSorter(Integer.class);
        if (sorter == null) {
            return Result.error(HttpStatus.NOT_IMPLEMENTED.value(), "不支持的数据类型");
        }

        dto.setData(sorter.sort(originIntegers));
        return Result.success(dto);
    }

    /**
     * 保存排序后的字符串列表
     *
     * @param dto 原始的字符串列表
     * @return 排序后的字符串列表
     */
    @PostMapping("/string")
    public Result<StringListDTO> addSortedString(@RequestBody StringListDTO dto) {
        List<String> originStrings = dto.getData();
        if (CollUtil.isEmpty(originStrings)) {
            return Result.error(HttpStatus.NO_CONTENT.value(), "没有需要排序的数据");
        }

        Sorter<String> sorter = SorterContext.getSorter(String.class);
        if (sorter == null) {
            return Result.error(HttpStatus.NOT_IMPLEMENTED.value(), "不支持的数据类型");
        }

        dto.setData(sorter.sort(originStrings));
        return Result.success(dto);
    }

    /**
     * 保存排序后的小数列表
     *
     * @param dto 原始的小数列表
     * @return 排序后的小数列表
     */
    @PostMapping("/decimal")
    public Result<DecimalListDTO> addSortedDecimal(@RequestBody DecimalListDTO dto) {
        List<BigDecimal> originDecimals = dto.getData();
        if (CollUtil.isEmpty(originDecimals)) {
            return Result.error(HttpStatus.NO_CONTENT.value(), "没有需要排序的数据");
        }

        Sorter<BigDecimal> sorter = SorterContext.getSorter(BigDecimal.class);
        if (sorter == null) {
            return Result.error(HttpStatus.NOT_IMPLEMENTED.value(), "不支持的数据类型");
        }

        dto.setData(sorter.sort(originDecimals));
        return Result.success(dto);
    }

}
