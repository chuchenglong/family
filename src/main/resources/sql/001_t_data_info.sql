-- ------------------------------
-- 数据字典信息表
-- ------------------------------
drop table if exists t_data_info;

create table t_data_info(
  id int(10) not null auto_increment comment '数据字典id,主键' primary key,
  parent_code varchar(50) not null comment '父节点ID',
  data_code varchar(50) not null comment 'CODE',
  data_name varchar(50) not null comment '名称',
  display varchar(50) not null comment '显示名称',
  description varchar(300) default null comment '描述',
  creator varchar(50) not null comment '创建人',
  create_time timestamp not null comment '创建时间',
  updater varchar(50) not null comment '修改人',
  last_modify_time timestamp not null comment '最后修改时间'
) engine=innodb auto_increment=1000000001 default charset=utf8;