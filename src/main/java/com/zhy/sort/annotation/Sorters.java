package com.zhy.sort.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * 用来标识某个类是排序器的一个策略实现。
 * 排序器上下文{@link com.zhy.sort.context.SorterContext}根据此注解查找排序器实现。
 * 实现一个排序器需要添加此注解并实现{@link com.zhy.sort.service.Sorter}抽象类
 *
 * @author zhihaoyu
 */
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface Sorters {

    /**
     * 返回排序器的处理类型
     *
     * @return 排序器的处理类型
     */
    Class<?> value();
}
