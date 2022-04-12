package com.zhy.sort;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 一个简单的排序服务，数据库使用H2，ORM使用mybatis-plus。
 *
 * @author zhihaoyu
 */
@SpringBootApplication
public class SortApplication {

    public static void main(String[] args) {
        SpringApplication.run(SortApplication.class, args);
    }

}
