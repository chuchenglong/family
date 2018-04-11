-- ------------------------------
-- 账单信息表
-- ------------------------------
drop table if exists t_bill_info;

create table t_bill_info(
  id int(10) not null auto_increment comment '密码id,主键' primary key,
  period varchar(50) not null comment '账单期数',
  bill_name varchar(50) not null comment '账单名称',
  purpose varchar(50) not null comment '账单用途',
  bill_type varchar(50) not null comment '正负',
  money decimal(10,4) not null comment '交易金额',
  creator varchar(50) not null comment '创建人',
  create_time timestamp not null comment '创建时间',
  updater varchar(50) not null comment '修改人',
  last_modify_time timestamp not null comment '最后修改时间'
) engine=innodb auto_increment=1000000001 default charset=utf8;
