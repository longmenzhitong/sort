package com.zhy.sort.context;

import com.zhy.sort.annotation.Sorters;
import com.zhy.sort.service.Sorter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.target.SingletonTargetSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 用来保存排序器处理类型与排序器的映射，仅对外开放根据处理类型获取排序器的方法。
 * 根据{@link com.zhy.sort.annotation.Sorters}注解自动装载所有排序器实现。
 *
 * @author zhihaoyu
 */
@Slf4j
@Configuration
public class SorterContext {

    @Resource
    private ApplicationContext applicationContext;

    private final static Map<Class<?>, Sorter<?>> CONTEXT = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {
        applicationContext.getBeansWithAnnotation(Sorters.class).forEach((clsName, cls) -> {
            try {
                load(clsName, cls);
                log.info("Succeed to load {}", clsName);
            } catch (Exception e) {
                log.error("Error occurred when loading sorter context", e);
            }
        });
    }

    private void load(String clsName, Object cls) {
        Object bean = applicationContext.getBean(clsName);
        Class<?> clsType;
        Sorter<?> sorter;
        if (bean instanceof Advised) {
            Advised advised = (Advised) applicationContext.getBean(clsName);
            SingletonTargetSource source = (SingletonTargetSource) advised.getTargetSource();
            sorter = (Sorter<?>) source.getTarget();
            if (sorter == null) {
                throw new IllegalStateException("sorter must not be null");
            }
            clsType = sorter.getClass().getAnnotation(Sorters.class).value();
        } else {
            clsType = cls.getClass().getAnnotation(Sorters.class).value();
            sorter = (Sorter<?>) cls;
        }
        CONTEXT.put(clsType, sorter);
    }

    @SuppressWarnings("unchecked")
    public static <T extends Comparable<? super T>> Sorter<T> getSorter(Class<T> cls) {
        return (Sorter<T>) CONTEXT.get(cls);
    }
}
