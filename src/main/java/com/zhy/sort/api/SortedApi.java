package com.zhy.sort.api;

import com.zhy.sort.model.common.Result;
import com.zhy.sort.model.dto.DecimalListDTO;
import com.zhy.sort.model.dto.IntegerListDTO;
import com.zhy.sort.model.dto.StringListDTO;
import com.zhy.sort.service.ISortedService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 排序Api
 *
 * @author zhihaoyu
 */
@Slf4j
@RestController
@RequestMapping("/v1/sorted")
public class SortedApi {

    @Resource
    private ISortedService iSortedService;

    /**
     * 保存排序后的整型列表
     *
     * @param dto 原始的整型列表
     * @return 排序后的整型列表
     */
    @PostMapping("/integer")
    public Result<IntegerListDTO> addSortedInteger(@RequestBody IntegerListDTO dto) {
        dto.setData(iSortedService.addSortedData(dto.getData()));
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
        dto.setData(iSortedService.addSortedData(dto.getData()));
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
        dto.setData(iSortedService.addSortedData(dto.getData()));
        return Result.success(dto);
    }

}
