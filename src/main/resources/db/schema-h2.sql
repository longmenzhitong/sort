DROP TABLE IF EXISTS sort_record;

CREATE TABLE sort_record
(
    id bigint(20) not null auto_increment comment '主键',
    origin_data varchar(2000) not null comment '原始数据',
    sorted_data varchar(2000) not null comment '有序数据',
    create_time timestamp not null comment '创建时间',
    PRIMARY KEY (id)
)